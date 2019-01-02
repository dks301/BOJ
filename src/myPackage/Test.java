package myPackage;

import java.util.TreeSet;

public class Test {
	public static void main(String[] args) {
		TreeSet<Integer> d = new TreeSet<Integer>();
		for (int i = 10; i >= 1; i--) {
			d.add(i);
		}
		for (int x : d) {
			System.out.println(x + " ");
		}
	}
}
