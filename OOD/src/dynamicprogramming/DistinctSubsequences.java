package dynamicprogramming;

public class DistinctSubsequences {
	public int numDistinct(String s, String t) {
		int m = t.length(), n = s.length();
		if (m > n)
			return 0;
		if (m == n) {
			return s.equals(t) ? 1 : 0;
		}

		boolean[][] dp = new boolean[m][n];
		for (int i = 0; i < n; i++) {
			dp[0][i] = s.charAt(i) == t.charAt(0);
		}

		for (int i = 1; i < m; i++) {
			for (int j = i; j < n; j++) {
				dp[i][j] = t.charAt(i) == s.charAt(j)
						&& dp[i - 1][j - 1] || dp[i][j - 1];
			}
		}
		for(int i = 0; i < m; i++)
		{
			for(int j = 0; j < n; j++)
				System.out.printf("%b ", dp[i][j]);
			System.out.println();
		}

		return numDistinct(dp, 0, 0);
	}

	private int numDistinct(boolean[][] dp, int i, int j) {
		System.out.println("i:" + i + " j:" + j);
		if (i > dp.length)
			return 0;
		if (i == dp.length - 1) {
			int n = 0;
			for (int k = j; k < dp[0].length; k++) {
				if (dp[i][k])
					n++;
			}
			//System.out.println("n: " + n);
			return n;
		}
		int num = 0;
		for (int k = j; k < dp[0].length; k++) {
			if (dp[i][k]) {
				num += numDistinct(dp, i + 1, k + 1);
			}
		}
		//System.out.println("num: " + num);
		return num;
	}
}
