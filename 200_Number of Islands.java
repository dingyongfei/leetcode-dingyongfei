class Solution {
	public int numIslands(char[][] m) {
//注意，本题base case判断必须要如下这样写，否则测试用例不能通过！！如图：
 
		if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
			return 0;
		}
		int N = m.length;
		int M = m[0].length;
		int res = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (m[i][j] == '1') {
					res++;
					infect(m, i, j, N, M);
				}
			}
		}
		return res;
	}

	public void infect(char[][] m, int i, int j, int N, int M) {
		if (i < 0 || i >= N || j < 0 || j >= M || m[i][j] != '1') {
			return;
		}
		m[i][j] = '2';
		infect(m, i + 1, j, N, M);
		infect(m, i - 1, j, N, M);
		infect(m, i, j + 1, N, M);
		infect(m, i, j - 1, N, M);
	}
}
