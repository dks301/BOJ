package dataStructure;

import java.util.LinkedList;
/*
 * 1.Explain briefly what it is/why it is necessary
 * 2.How it works
 * 3.How it is implemented
 * 4.When it is good, when it is bad
 * 5.What people do to improve it
 */
public class Linked_List {
	/*
	 * 1. 비상 연락망처럼 다음 데이터의 주소값만 링크로 이어진 리스트, 배열의 문제점(중간 삽입/삭제 문제)을 해결하기 위해
	 * 2. 값과 다음 노드의 주소값을 가지고 있어 처음부터 다음노드의 주소값으로 순차적으로 access
	 */
	
	// 3.
	
	public static void main(String[] args) throws Exception  {
		LinkedList<Node> ll = new LinkedList<>();
		
	}
	
	public static class _LinkedList<T> {
		Node n;
		
		public _LinkedList() {
			
		}
		
		public void add(T t) {
			
		}
	}
	
	public static class Node {
		int val;
		Node next;
		
		private Node() {
			val = 0;
			next = null;
		}
	}
}
