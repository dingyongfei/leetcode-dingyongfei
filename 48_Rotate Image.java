class Solution {
	public void rotate(int[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0) {
			return;
		}
		int s = 0;
		int e = matrix.length - 1;
		while (s < e) {
			int[] tmp = matrix[s];
			matrix[s++] = matrix[e];
			matrix[e--] = tmp;
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = i; j < matrix[0].length; j++) { // 如图，本题先轴对称翻转 行， 再以"i=j"为对称轴翻转。
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = tmp;
			}
		}
	}
}
