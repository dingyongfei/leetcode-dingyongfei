//特别注意，本题一定是用自下而上的dp来得到答案的 !! (因为题目中求的是能到达右下角的最小血量，如果从上向下dp的话不能保证题目的要求 ?)
//dp[i][j]的含义是如果骑士要走上位置(i, j)， 并且从该位置选一条最优的路径， 最后走到右下角， 骑士起码应该具备的血量。

// 关键的code:
// dp[i][j] = Math.min(Math.max(1, dp[i + 1][j] - m[i][j]), 
			    Math.max(1, dp[i][j + 1] - m[i][j]));
class Solution {
	public int calculateMinimumHP(int[][] m) {
		if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
			return 1;
		}
		int row = m.length;
		int col = m[0].length;

		int[][] dp = new int[row][col];

		dp[row - 1][col - 1] = m[row - 1][col - 1] > 0 ? 1 : -m[row - 1][col - 1] + 1;

		for (int i = row - 2; i >= 0; i--) {
			dp[i][col - 1] = Math.max(1, dp[i + 1][col - 1] - m[i][col - 1]);
		}
		for (int j = col - 2; j >= 0; j--) {
			dp[row - 1][j] = Math.max(1, dp[row - 1][j + 1] - m[row - 1][j]);
		}

		for (int i = row - 2; i >= 0; i--) {
			for (int j = col - 2; j >= 0; j--) {
				dp[i][j] = Math.min(Math.max(1, dp[i + 1][j] - m[i][j]), 
								 Math.max(1, dp[i][j + 1] - m[i][j]));
			}
		}
		return dp[0][0];
	}
}
