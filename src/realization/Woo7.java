package realization;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Woo7 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String in = br.readLine();
		System.out.println(solution(in));
	}
	
	public static String solution(String cryptogram) {
		LinkedList cryptoList = new LinkedList();
		char[] cryptos = cryptogram.toCharArray();
		
		for (int i = 0; i < cryptos.length; i++) {
			cryptoList.add(new Node(cryptos[i]));
		}

		return cryptoList.toString();
	}
	
	public static class LinkedList {
		Node head;
		
		public LinkedList() {
			head = new Node('*');
		}
		
		@Override
		public String toString() {
			String result = "";
			Node n = head.clone();
			if (isEmpty()) {
				return result;
				
			} else {
				while (n.next != null) {
					n = n.next;
					result += n.val;
				}
				return result;
			}
		}
		
		public void add(Node n) {
			if (this.isEmpty()) {
				head.next = n;
				n.prev = head;
			} else {
				Node last = searchLast();
				if (check(n, last)) {
					last.prev.next = null;
					
				} else {
					last.next = n;
					n.prev = last;
				}
			}
		}
		
		public boolean isEmpty() {
			if (head.next == null) {
				return true;
			}
			
			return false;
		}
		
		public Node searchLast() {
			Node n = head.clone();
			
			while (n.next != null) {
				n = n.next;
			}
			
			return n;
		}
		
		public boolean check(Node a, Node b) {
			if (a.val == b.val) {
				return true;
			}
			return false;
		}
	}
	
	public static class Node {
		char val;
		Node prev, next;
		
		public Node(char val) {
			this.val = val;
		}
		
		public Node clone() {
			Node n = new Node(this.val);
			n.prev = prev;
			n.next = next;
			
			return n;
		}
	}
}
