package realization;

public class BOJ4673 {
	private static final String NEW_LINE = "\n";
	
	public static void main(String[] args) throws Exception {
		boolean[] isSelf = new boolean[10001];
		for (int i = 1; i <= 10000; i++) {
			int dn = i;
			int j = i;
			do {
				dn += (j % 10);
				j /= 10;
			} while ((j / 10 != 0 && j % 10 == 0) || j % 10 != 0);
			
			if (dn <= 10000)
				isSelf[dn] = true;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= 10000; i++) {
			if (!isSelf[i])
				sb.append(i).append(NEW_LINE);
		}
		System.out.println(sb.toString());
	}
}
