package realization;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ5554 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int homeToSchool = Integer.parseInt(br.readLine());
		int schoolToPc = Integer.parseInt(br.readLine());
		int pcToAca = Integer.parseInt(br.readLine());
		int AcaToHome = Integer.parseInt(br.readLine());
		br.close();
		
		System.out.print((homeToSchool + schoolToPc + pcToAca + AcaToHome) / 60 + "\n" + (homeToSchool + schoolToPc + pcToAca + AcaToHome) % 60);
	}
}
