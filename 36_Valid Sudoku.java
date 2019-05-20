class Solution {
	public boolean isValidSudoku(char[][] board) {
		HashSet<String> set = new HashSet<String>();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				char num = board[i][j];
				if (num != '.') {
					if (!set.add(String.valueOf(num) + "row" + i) || !set.add(String.valueOf(num) + "col" + j)
							|| !set.add(String.valueOf(num) + "block" + i / 3 + j / 3)) {
						return false;
					}
				}
			}
		}
		return true;
	}
}
