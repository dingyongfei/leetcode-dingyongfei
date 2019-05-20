class Solution {
	public int numDistinct(String s, String t) {               //本题中，s和t的关系是”包含与被包含”， 所以dp中有 2 种情况
		if (s.isEmpty() || t.isEmpty()) {
			return 0;
		}
		char[] c = s.toCharArray();
		char[] d = t.toCharArray();
		int row = c.length + 1;
		int col = d.length + 1;
		int[][] dp = new int[row][col];

		dp[0][0] = 1;                   //空串显然可以包含空串

		for (int i = 1; i < row; i++) {
			dp[i][0] = 1;
		}
		for (int j = 1; j < col; j++) {
			dp[0][j] = 0;
		}

		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				dp[i][j] = dp[i - 1][j];
				if (c[i - 1] == d[j - 1]) {
					dp[i][j] += dp[i - 1][j - 1];
				}
			}
		}
		return dp[row - 1][col - 1];
	}
}
