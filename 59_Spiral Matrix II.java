class Solution {
    int count = 0;
    public int[][] generateMatrix(int n) {
        int tR = 0;
		int tC = 0;
		int dR = n-1;
		int dC = n-1;
        int[][] matrix = new int[n][n];
		while (tR <= dR && tC <= dC) {
			insert(matrix, tR++, tC++, dR--, dC--);
		}
        return matrix;
	}

	public void insert(int[][] m, int tR, int tC, int dR, int dC) {
		if (tR == dR) { 
			for (int i = tC; i <= dC; i++) {
                count++;
                m[tR][i] = count;
			}
		} else if (tC == dC) { 
			for (int i = tR; i <= dR; i++) {
                count++;
                m[i][tC] = count;
			}
		} else { 
			int curC = tC;
			int curR = tR;
			while (curC != dC) {
                count++;
                m[tR][curC] = count;
				curC++;
			}
			while (curR != dR) {
                count++;
                m[curR][dC] = count;
				curR++;
			}
			while (curC != tC) {
                count++;
                m[dR][curC] = count;
				curC--;
			}
			while (curR != tR) {
                count++;
                m[curR][tC] = count;
				curR--;
			}
		}
    }
}

