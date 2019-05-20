class Solution {
	public void solve(char[][] board) {
		if (board.length == 0 || board[0].length == 0) {
			return;
		}
		if (board.length < 3 || board[0].length < 3) {
			return;
		}
		int m = board.length;
		int n = board[0].length;
		for (int i = 0; i < m; i++) {
			if (board[i][0] == 'O')
				helper(board, i, 0);
			if (board[i][n - 1] == 'O')
				helper(board, i, n - 1);
		}
		for (int j = 1; j < n - 1; j++) {
			if (board[0][j] == 'O')
				helper(board, 0, j);
			if (board[m - 1][j] == 'O')
				helper(board, m - 1, j);
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'O')
					board[i][j] = 'X';
				if (board[i][j] == '*')
					board[i][j] = 'O';
			}
		}
	}

	public void helper(char[][] board, int i, int j) {
		if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1 || board[i][j] != 'O') {
			return;
		}
		board[i][j] = '*';
		helper(board, i + 1, j);                 //infect感染函数
		helper(board, i - 1, j);
		helper(board, i, j + 1);
		helper(board, i, j - 1);
	}
}
