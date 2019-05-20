class Solution {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
			return false;
		}
		int row = matrix.length;
		int col = matrix[0].length;
		int l = 0;
		int r = row * col - 1;
		while (l <= r) {
			int mid = (r - l) / 2 + l;
			if (target == matrix[mid / col][mid % col]) {      //注意, “ / ”和 “ % ”都是和col做运算，而不是和row做运算!
				return true;
			} else if (target < matrix[mid / col][mid % col]) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return false;
	}
}
