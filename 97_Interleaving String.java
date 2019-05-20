//dp[i][j]的值代表aim[0...i+j-1]能否被str1[0...i-1]和str2[0...j-1]交错组成。
class Solution {
	public boolean isInterleave(String str1, String str2, String str3) {
		if (str1 == null || str2 == null || str3 == null) {
			return false;
		}
		char[] c1 = str1.toCharArray();
		char[] c2 = str2.toCharArray();
		char[] c3 = str3.toCharArray();
		if ((c1.length + c2.length) != c3.length) {
			return false;
		}
		int row = c1.length + 1;
		int col = c2.length + 1;
		boolean[][] dp = new boolean[row][col];
		dp[0][0] = true;
		// 类似于“最长公共子序列”的初始化
//最长公共子序列：写法有些类似。
/**
public int[][] getdp(char[] str1, char[] str2) {
		int[][] dp = new int[str1.length][str2.length];
		dp[0][0] = str1[0] == str2[0] ? 1 : 0;
		for (int i = 1; i < str1.length; i++) {
			dp[i][0] = Math.max(dp[i - 1][0], str1[i] == str2[0] ? 1 : 0);
		}
		for (int j = 1; j < str2.length; j++) {
			dp[0][j] = Math.max(dp[0][j - 1], str1[0] == str2[j] ? 1 : 0);
		}

		for (int i = 1; i < str1.length; i++) {
			for (int j = 1; j < str2.length; j++) {
				dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				if (str1[i] == str2[j]) {
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1]);
				}
			}
		}
		return dp;
	}
*/
		for (int i = 1; i < row; i++) {
			if (c1[i - 1] != c3[i - 1]) {
				break;
			}
			dp[i][0] = true;
		}

		for (int j = 1; j < col; j++) {
			if (c2[j - 1] != c3[j - 1]) {
				break;
			}
			dp[0][j] = true;
		}

		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				if ((dp[i - 1][j] == true && c1[i - 1] == c3[i + j - 1])|| 
					(dp[i][j - 1] == true && c2[j - 1] == c3[i + j - 1])) {
					dp[i][j] = true;
				}
			}
		}
		return dp[row - 1][col - 1];
	}
}
