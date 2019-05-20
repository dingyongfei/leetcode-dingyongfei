//1. 如果矩阵第一行和第一列的所有元素都记到matrix[0][0]上，画图可知，其他行和列都不会，（即第一行和第一列的所有值根据matrix[0][0]来判断），那么第一行和第一列中只要有一个值为0，它们两个上面的都会变成0。但实际上第一行和第一列的值是相互独立的，所以将第一列的值记到另一个单独的变量col1(初始值=1)中去！
//2. 注意，本题中赋和取col1变量和内层for循环的顺序是一定不能颠倒的，否则结果是矩阵中所有元素都变成0！！！
class Solution {
	public void setZeroes(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0
				|| (matrix.length == 1) && matrix[0].length == 1) {
			return;
		}
		
		int row = matrix.length;
		int col = matrix[0].length;
		int col0 = 1;

		for (int i = 0; i < row; i++) {              //先从左上角至右下角遍历
			if (matrix[i][0] == 0) // 注意，这两处的判断一定要注意放在第二层for循环的外面，且和第二个for循环的前后位置不能颠倒（本题和顺序是强烈相关的！！！）
				col0 = 0;
			for (int j = 1; j < col; j++) { // 注意，j要从 1开始，否则会将第一列的值记入matrix[0][0]!
				if (matrix[i][j] == 0) {
					matrix[i][0] = matrix[0][j] = 0;
				}
			}
		}

		for (int i = row - 1; i >= 0; i--) {       //后从右下角向左上角遍历
			for (int j = col - 1; j >= 1; j--) { // 协同地注意，j要终止于 1，
				if (matrix[0][j] == 0 || matrix[i][0] == 0) { // 否则会将matrix[0][0]的值作为第一列的判断依据！
					matrix[i][j] = 0;
				}
			}
			if (col0 == 0) // 注意，这两处的判断一定要注意放在第二层for循环的外面，且和第二个for循环的前后位置不能颠倒（本题和顺序是强烈相关的！！！）
				matrix[i][0] = 0;
		}
	}
}


//方法二
class Solution {
	public void setZeroes(int[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;
		boolean r = false;
		boolean c = false;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] == 0) {
					if (i == 0)
						// if(matrix[0][j]==0) --------->错误的写法！
						r = true;
					if (j == 0)
						// if(matrix[i][0]==0) --------->错误的写法！
						c = true;
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}

		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				if (matrix[0][j] == 0 || matrix[i][0] == 0) {
					matrix[i][j] = 0;
				}
			}
		}

		if (r) {
			for (int j = 0; j < col; j++) {
				matrix[0][j] = 0;
			}
		}
		if (c) {
			for (int i = 0; i < row; i++) {
				matrix[i][0] = 0;
			}
		}
	}
}
