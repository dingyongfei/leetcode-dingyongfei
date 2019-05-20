class Solution {
	List<Integer> list = new ArrayList<Integer>();

	public List<Integer> spiralOrder(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) { // 注意这里的写法
			return list;
		}
		int tr = 0;
		int tc = 0;
		int dr = matrix.length - 1;
		int dc = matrix[0].length - 1;
		while (tr <= dr && tc <= dc) {
			print(matrix, tr++, tc++, dr--, dc--);
		}
		return list;
	}

	public void print(int[][] m, int tr, int tc, int dr, int dc) {
		if (tr == dr) {
			for (int i = tc; i <= dc; i++) {
				list.add(m[tr][i]);
			}
		} else if (tc == dc) {
			for (int i = tr; i <= dr; i++) {
				list.add(m[i][tc]);
			}
		} else {
			int cr = tr;
			int cc = tc;
			while (cc != dc) {
				list.add(m[tr][cc]);
				cc++;
			}
			while (cr != dr) {
				list.add(m[cr][dc]);
				cr++;
			}
			while (cc != tc) {
				list.add(m[dr][cc]);
				cc--;
			}
			while (cr != tr) {
				list.add(m[cr][tc]);
				cr--;
			}
		}
	}
}
