class Solution {
	public int reverse(int x) {
		int res = 0;
		int tmp = x;
		if (x < 0) {
			tmp = -x;
		}
		while (tmp != 0) {
			int mo = tmp % 10;
			int res1 = res * 10 + mo;
			if ((res1 - mo) / 10 != res) {
				return 0;
			}
			res = res1;
			tmp /= 10;
		}
		return x < 0 ? -res : res;
	}
}
