// 思路: 将重合的矩形上、下、左、右分别确定好即可。
class Solution {
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int left = Math.max(A, E);
		int right = Math.max(Math.min(C, G), left);
		int up = Math.min(D, H);
		int down = Math.min(Math.max(B, F), up);
		return (C - A) * (D - B) + (G - E) * (H - F) – (right - left) * (up - down);
	}
}
