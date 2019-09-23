package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class L1 {
	private static int m, c;
	private static int[] mes;
	private static Queue<Message>[] q;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());

		c = Integer.parseInt(st.nextToken());
		q = new Queue[c];
		for (int i = 0; i < c; i++) {
			q[i] = new LinkedList<>();
		}

		mes = new int[m];
		for (int i = 0; i < m; i++) {
			mes[i] = Integer.parseInt(br.readLine());
		}

		int ans = 0;
		int mIdx = 0;
		while (!allClear()) {
			ans++;
			if (mIdx < m) {
				for (int i = 0; i < c; i++) {
					if (q[i].isEmpty()) {
						q[i].add(new Message(mIdx, mes[mIdx]));
						mIdx++;
					}
				}
			}

			for (int i = 0; i < c; i++) {
				if (!q[i].isEmpty()) {
					Message doing = q[i].peek();
					if (doing.time == 1) {
						q[i].remove();
						if (mIdx < m) {
							q[i].add(new Message(mIdx, mes[mIdx]));
							mIdx++;
						}
					}
					doing.time--;
					mes[doing.idx]--;
				}
			}
		}
		System.out.println(ans);
	}

	public static boolean allClear() {
		for (int i = 0; i < m; i++) {
			if (mes[i] != 0) {
				return false;
			}
		}
		return true;
	}

	public static class Message {
		int idx, time;

		public Message(int idx, int time) {
			this.idx = idx;
			this.time = time;
		}
	}
}
