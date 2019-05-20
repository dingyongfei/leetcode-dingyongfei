/**    I think the key idea is count how many 5's are in the factorial.
So first we add n/5.
Wait, we are missing 5X5, 2X5X5..., so we add n/25 (why not count as two 5's for each , because one is already counted in n/5).
Wait, we are missing 5X5X5, 2X5X5X5..., so we add n/125.
Thus, count = n/5 + n/25 + n/125 + ... + 0     */

class Solution {
	public int trailingZeroes(int n) {
		int cnt = 0;
		while (n > 0) {
			cnt += (n = n / 5);
		}
		return cnt;
	}
}


class Solution {
	public int trailingZeroes(int n) {
		if (n == 0) {
			return 0;
		}
		int cnt = 0;
		cnt += trailingZeroes(n / 5) + n / 5;
		return cnt;
	}
}
