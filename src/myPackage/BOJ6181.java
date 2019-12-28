package myPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ6181 {
	private static int M;
	private static int D;
	private static List<Graph> graphs;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		graphs = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			Node node = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			boolean isAreadyInGraph = false;
			boolean isDuplicate = false;
			List<Graph> tempGraphs = new ArrayList<>();
			
			for (Graph g : graphs) {
				if (g.canInclude(node) && !isAreadyInGraph) {
					isAreadyInGraph = true;
					tempGraphs.add(g);
				} else if (g.canInclude(node) && isAreadyInGraph) {
					isDuplicate = true;
					tempGraphs.add(g);
				}
			}
			
			if (!isAreadyInGraph) {
				graphs.add(new Graph(node));
			} else if (isDuplicate) {
				Graph newGraph = new Graph(node);
				
				for (Graph g : tempGraphs) {
					newGraph.addGraph(g);
					graphs.remove(g);
				}
				graphs.add(newGraph);
			}
		}
		
		int maxGraphSize = 0;
		for (Graph g : graphs) {
			if (maxGraphSize < g.size()) {
				maxGraphSize = g.size();
			}
		}
		
		System.out.println(graphs.size() + " " + maxGraphSize);
	}

	public static class Node {
		private int row;
		private int col;

		public Node(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	public static class Graph {
		private List<Node> nodes;
		private int minRow, maxRow;
		private int minCol, maxCol;

		public Graph(Node head) {
			nodes = new ArrayList<>();
			nodes.add(head);
			minRow = head.row;
			maxRow = head.row;
			minCol = head.col;
			maxCol = head.col;
		}
		
		public int size() {
			return nodes.size();
		}

		public void addGraph(Graph g) {
			for (Node n : g.nodes) {
				this.nodes.add(n);
			}
		}
		
		public void addNode(Node n) {
			nodes.add(n);
			if (n.row < minRow) {
				minRow = n.row;
			}
			if (n.row > maxRow) {
				maxRow = n.row;
			}
			if (n.col < minCol) {
				minCol = n.col;
			}
			if (n.col > maxCol) {
				maxCol = n.col;
			}
		}

		public boolean canInclude(Node n) {
			if (isNotInclude(n)) {
				return false;
			}

			for (Node next : nodes) {
				int distance = Math.abs(n.row - next.row) + Math.abs(n.col - next.col);
				if (distance <= D) {
					return true;
				}
			}

			return false;
		}

		private boolean isNotInclude(Node n) {
			return (Math.abs(n.row - minRow) > D) && (Math.abs(n.row - maxRow) > D) && (Math.abs(n.col - minCol) > D)
					&& (Math.abs(n.col - maxCol) > D);
		}
	}
}
