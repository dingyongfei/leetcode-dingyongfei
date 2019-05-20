//注意，dp[i][j]表示的是将str1[0...i-1]编辑成str2[0...j-1]的最小代价！
class Solution {
	public int minDistance(String word1, String word2) {
		if (word1 == null || word2 == null) {
			return 0;
		}
		/*
		 * if(word1==null) { return word2.length(); } if(word2==null) { return
		 * word1.length(); }
		 */
		char[] c1 = word1.toCharArray();
		char[] c2 = word2.toCharArray();
		int row = c1.length + 1;
		int col = c2.length + 1;
		int[][] dp = new int[row][col];
		// dp[0][0] = 0; //注意，也可以不初始化dp[0][0]，因为数组元素的初始值就是0 ~~~~~~~~
		for (int i = 1; i < row; i++) {
			dp[i][0] = i;
		}
		for (int j = 1; j < col; j++) {
			dp[0][j] = j;
		}
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				if (c1[i - 1] == c2[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				}
				dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
				dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
			}
		}
		return dp[row - 1][col - 1];
	}
}
