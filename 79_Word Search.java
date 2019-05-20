class Solution {
	public boolean exist(char[][] board, String word) {
		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[0].length; j++) {
				if (exist(board, i, j, word, 0))
					return true;
			}
		return false;
	}

	private boolean exist(char[][] board, int i, int j, String word, int ind) {
		if (ind == word.length())
			return true;
		if (i > board.length - 1 || i < 0 || j < 0 || j > board[0].length - 1 || board[i][j] != word.charAt(ind))
			return false;
		board[i][j] = '*'; // 代表现在已经访问过board[i][j]了
		boolean result = exist(board, i - 1, j, word, ind + 1) || // 因为这里的这四个递归函数调用后，可能会返回之前经过的节点。
				exist(board, i, j - 1, word, ind + 1) || // 所以每次递归调用前，都将当前节点的值标记为“*”（即board[i][j]='*'），如果递归遍历回该节点时，
				exist(board, i, j + 1, word, ind + 1) || // 会直接在函数中第二个if语句中返回false(因为 ‘*’ !=
															// word.charAt(ind))，本层递归调用结束后，将标记的节点再置为原来
				exist(board, i + 1, j, word, ind + 1); // 的值，返回上一层并继续上一层的其他递归。
		board[i][j] = word.charAt(ind); // 因为到这一步board[i][j]肯定等于word.charAt(idx) （否则会在exist方法的第二个if里返回false），所以可以直接这样写

		return result;
	}
}
