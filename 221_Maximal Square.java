// 处理后的dp方法。非常简便
class Solution {
	public int maximalSquare(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
			return 0;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] dp = new int[m + 1][n + 1];

		int maxEdge = 0;                            // 直接将maxEdge的值设为0即可 !
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (matrix[i - 1][j - 1] == '1') {
					dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
					maxEdge = Math.max(maxEdge, dp[i][j]);
				}
			}
		}
		return maxEdge * maxEdge;
	}
}



// 方法一. 和题目 “85. Maximal Rectangle” 一样，只不过本题要处理成正方形。
/*
class Solution {
	public int maximalSquare(char[][] map) {
		if (map == null || map.length == 0 || map[0].length == 0) {
			return 0;

		}
		int maxArea = 0;
		int[] height = new int[map[0].length];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				height[j] = map[i][j] == '0' ? 0 : height[j] + 1;
			}
			maxArea = Math.max(maxRectFromBottom(height), maxArea);
		}
		return maxArea;
	}

	public int maxRectFromBottom(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}
		int maxArea = 0;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < height.length; i++) {
			while (!stack.isEmpty() && height[i] <= height[stack.peek()]) {
				int j = stack.pop();
				int k = stack.isEmpty() ? -1 : stack.peek();
				int curArea = (height[j] > (i - k - 1) ? (i - k - 1) * (i - k - 1) : height[j] * height[j]);
				maxArea = Math.max(maxArea, curArea);
			}
			stack.push(i);
		}
		while (!stack.isEmpty()) {
			int j = stack.pop();
			int k = stack.isEmpty() ? -1 : stack.peek();
			int i = height.length;
			int curArea = (height[j] > (i - k - 1) ? (i - k - 1) * (i - k - 1) : height[j] * height[j]);
			maxArea = Math.max(maxArea, curArea);
		}
		return maxArea;
	}
}
*/

// 方法二. dp (easy solution !!)
// dp[i][j] represent the edge length of the largest square ENDING at position (i, j).
// 求出矩阵中必须以每一个位置结尾的最大正方形边长, 再用dp求解即可。
// 可以看到, 将dp矩阵的长度和宽度设为m和n的话，边界条件的处理麻烦！所以我们将dp矩阵的长度和宽度设为m + 1 和 n + 1，类似于字符串动态规划类题目的处理，则dp[i][j]代表的是以矩阵元素matrix[i-1][j-1]位置结尾的情况下最大正方形的边长！ 这样一来dp矩阵的处理变得非常简单！！

/** 处理前
class Solution {
	public int maximalSquare(char[][] matrix) {
		if (matrix.length == 0)
			return 0;
		int m = matrix.length, n = matrix[0].length;
		int[][] dp = new int[m][n];

		dp[0][0] = matrix[0][0] == '0' ? 0 : 1;

		for (int i = 1; i < m; i++) {
			dp[i][0] = matrix[i][0] == '0' ? 0 : 1;
		}
		for (int j = 1; j < n; j++) {
			dp[0][j] = matrix[0][j] == '0' ? 0 : 1;
		}
		int maxEdge = 1;
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][j] == '1') {
					dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
					maxEdge = Math.max(maxEdge, dp[i][j]);
				}
			}
		}

		for (char[] chs : matrix) {
			for (char num : chs) {
				if (num == '1') {
					return maxEdge * maxEdge;
				}
			}
		}

		return 0;
	}
}
*/
