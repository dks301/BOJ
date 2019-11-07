package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 문자열 폭발
 * 문자열이 폭발 문자열을 포함하고 있는 경우에, 모든 폭발 문자열이 폭발
 * 이후 남은 문자열을 순서대로 이어붙여 새로운 문자열을 만든다.
 * 새로 생긴 문자열에 폭발 문자열이 포함되어 있을 수 도 있다.
 * 문자열에 폭발 문자열이 없을때까지 반복
 * 
 * 입력
 * 첫째줄: 1이상 1,000,000이하 길이의 문자열
 * 둘째줄: 폭발 문자열  1이상 36이하 길이
 * 두 문자열은 모두 알파벳 대소문자 or 숫자 0~9로 이루어짐
 * 
 * 출력
 * 폭발이 끝난 후 남는 문자열 출력 남아있는 문자가 없으면 "FRULA"출력
 */
public class BOJ9935 {
	private static char[] bomb;
	private static int len;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		bomb = br.readLine().toCharArray();
		len = bomb.length;
		
		String ans = solution(str);
		if (ans.equals("")) {
			System.out.println("FRULA");
		} else {
			System.out.println(ans);
		}
	}
	
	public static String solution(String cryptogram) {
		LinkedList cryptoList = new LinkedList();
		char[] cryptos = cryptogram.toCharArray();
		
		for (int i = 0; i < cryptos.length; i++) {
			cryptoList.add(new Node(cryptos[i]));
			System.out.println(cryptoList.toString());
		}

		return cryptoList.toString();
	}
	
	public static class LinkedList {
		Node head, tail;
		
		public LinkedList() {
			head = new Node('*');
			tail = null;
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
				n.next = null;
				tail = n.clone();
				
			} else {
				if (n.val == bomb[len - 1]) {
					if (check(tail.clone())) {
						for (int i = 0; i < len - 2; i++) {
							tail = tail.prev;
						}
						tail.prev.next = null;
						
					} else {
						Node temp = tail.clone();
						temp.next = n;
						n.prev = temp;
						tail = n.clone();
						
					}
					
				} else {
					Node temp = tail.clone();
					temp.next = n;
					n.prev = temp;
					tail = n.clone();
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
		
		public boolean check(Node a) {
			for (int i = len - 2; i >= 0; i--) {
				if (a.val == bomb[i]) {
					a = a.prev;
				} else {
					return false;
				}
			}
			return true;
		}
	}
	
	public static class Node {
		char val;
		Node prev, next;
		
		public Node(char val) {
			this.val = val;
			prev = next = null;
		}
		
		public Node clone() {
			Node n = new Node(this.val);
			n.prev = prev;
			n.next = next;
			
			return n;
		}
	}
}
