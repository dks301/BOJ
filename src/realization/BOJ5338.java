package realization;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
 * 마크로소프트 로고
 * 마이크로소프트 로고 출력
 *               _.-;;-._
 *        '-..-'|   ||   |
 *        '-..-'|_.-;;-._|
 *        '-..-'|   ||   |
 *        '-..-'|_.-''-._|
 */
public class BOJ5338 {
	private static final String NEW_LINE = "\n";
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("       _.-;;-._").append(NEW_LINE);
		sb.append("'-..-'|   ||   |").append(NEW_LINE);
		sb.append("'-..-'|_.-;;-._|").append(NEW_LINE);
		sb.append("'-..-'|   ||   |").append(NEW_LINE);
		sb.append("'-..-'|_.-''-._|");
		System.out.print(sb);
	}
}
