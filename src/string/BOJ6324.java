package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * URLs
 * < protocol > "://" < host > [ ":" < port > ] [ "/" < path > ]
 * < protocol > is always one of http, ftp or gopher.
 * < host > is a string consisting of alphabetic (a-z, A-Z) or numeric (0-9) characters and points (.).
 * < port > is a positive integer, smaller than 65536.
 * < path > is a string that contains no spaces.
 */
public class BOJ6324 {
	private static final String URL_NUM = "URL #";
	private static final String PROTOCOL = "Protocol = ";
	private static final String HOST = "Host     = ";
	private static final String PORT = "Port     = ";
	private static final String PATH = "Path     = ";
	private static final String DEFAULT = "<default>";
	private static final String NEW_LINE = "\n";

	private static final String DELIM_PROTOCOL = "://";
	private static final String DELIM_PORT = ":";
	private static final String DELIM_PATH = "/";

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		int cnt = 1;
		while (n-- > 0) {
			sb.append(URL_NUM).append(cnt++).append(NEW_LINE);

			String[] url = br.readLine().split(DELIM_PROTOCOL, -1);
			sb.append(PROTOCOL).append(url[0]).append(NEW_LINE);

			String temp = "";
			for (int i = 1; i < url.length; i++) {
				temp += url[i];
				if (i != url.length - 1) {
					temp += DELIM_PROTOCOL;
				}
			}
			String[] url2 = temp.split(DELIM_PORT, -1);
			String[] url3;

			switch (url2.length) {
			case 1:
				url3 = url2[0].split(DELIM_PATH, -1);
				sb.append(HOST).append(url3[0]).append(NEW_LINE);
				sb.append(PORT).append(DEFAULT).append(NEW_LINE);
				sb.append(PATH);

				if (url3.length == 1) {
					sb.append(DEFAULT).append(NEW_LINE);
				} else {
					for (int i = 1; i < url3.length; i++) {
						sb.append(url3[i]);
						if (i != url3.length - 1) {
							sb.append(DELIM_PATH);
						}
					}
					sb.append(NEW_LINE);
				}
				break;

			default:
				temp = "";

				sb.append(HOST);
				String[] tempUrl = url2[0].split(DELIM_PATH, -1);
				sb.append(tempUrl[0]).append(NEW_LINE);

				if (tempUrl.length > 1) {
					temp += DELIM_PATH;
					for (int i = 1; i < tempUrl.length; i++) {
						temp += tempUrl[i];
						if (i != tempUrl.length - 1) {
							temp += DELIM_PATH;
						}
					}
					temp += DELIM_PORT;
				}

				for (int i = 1; i < url2.length; i++) {
					temp += url2[i];
					if (i != url2.length - 1) {
						temp += DELIM_PORT;
					}
				}

				url3 = temp.split(DELIM_PATH, -1);
				sb.append(PORT);
				if (url3[0].length() == 0) {
					sb.append(DEFAULT).append(NEW_LINE);
				} else {
					sb.append(url3[0]).append(NEW_LINE);
				}
				sb.append(PATH);
				if (url3.length == 1) {
					sb.append(DEFAULT).append(NEW_LINE);
				} else {
					for (int i = 1; i < url3.length; i++) {
						sb.append(url3[i]);
						if (i != url3.length - 1) {
							sb.append(DELIM_PATH);
						}
					}
					sb.append(NEW_LINE);
				}
				break;
			}

			sb.append(NEW_LINE);
		}
		System.out.print(sb);
	}
}
