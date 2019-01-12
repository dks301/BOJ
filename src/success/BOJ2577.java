package success;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ2577 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		
		int count[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		
		char[] result = String.valueOf(A * B * C).toCharArray();
		for (int i = 0; i < result.length; i++) {
			switch(result[i]) {
			case '0':
				count[0]++;
				break;
			case '1':
				count[1]++;
				break;
			case '2':
				count[2]++;
				break;
			case '3':
				count[3]++;
				break;
			case '4':
				count[4]++;
				break;
			case '5':
				count[5]++;
				break;
			case '6':
				count[6]++;
				break;
			case '7':
				count[7]++;
				break;
			case '8':
				count[8]++;
				break;
			case '9':
				count[9]++;
				break;
			default:
				System.out.println("error: switch out of bound!");
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			sb.append(count[i] + "\n");
		}
		System.out.println(sb.toString());
	}
}
