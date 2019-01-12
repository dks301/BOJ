package success;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class BSIS_A {
	public static void main(String[] args) throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write("ÆÄÀÌÆÃ!!");
		bw.flush();
		bw.close();
	}
}
