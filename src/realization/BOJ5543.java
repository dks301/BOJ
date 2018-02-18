package realization;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ5543 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int burger = Integer.parseInt(br.readLine());
		int val;
		
		for (int i = 0; i < 2; i++) {
			val = Integer.parseInt(br.readLine());
			if (burger > val)
				burger = val;
		}
		
		int coca = Integer.parseInt(br.readLine());
		int cidar = Integer.parseInt(br.readLine());
		br.close();
		
		System.out.println(burger + coca > burger + cidar ? burger + cidar - 50 : burger + coca - 50);
		
	}
}
