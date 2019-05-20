class Solution {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[][] dp = new int[m][n];
		dp[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;
		if (dp[0][0] == 0) {
			return 0;
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (obstacleGrid[i][j] == 1) {
					dp[i][j] = 0;
				} else if (i == 0) {
					if (j > 0)
						dp[0][j] = dp[0][j - 1];
				} else if (j == 0) { // 注意这里两处的dp左上方边界条件的处理。
					if (i > 0)
						dp[i][0] = dp[i - 1][0];
				} else {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}
			}
		}
		return dp[m - 1][n - 1];
	}
}

//方法二。参考了zuochengyun Chapter 4 ”最长公共子序列”
class Solution {
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[][] dp = new int[m][n];
		dp[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;
		if (dp[0][0] == 0) {
			return 0;
		}
		for (int i = 1; i < m; i++) {
			dp[i][0] = Math.min(dp[i - 1][0], obstacleGrid[i][0] == 0 ? 1 : 0);
		}

		for (int j = 1; j < n; j++) {
			dp[0][j] = Math.min(dp[0][j - 1], obstacleGrid[0][j] == 0 ? 1 : 0);
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (obstacleGrid[i][j] == 1) { // 注意，这里也一定要判断obstacleGrid[i][j] == 1 ！！
					dp[i][j] = 0;
				} else {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}
			}
		}
		return dp[m - 1][n - 1];
	}
}
