class Solution {
	public double myPow(double base, int n) {
		double res = 1, cur = base;
		int exponent;
		if (n > 0) {
			exponent = n;
		} else if (n < 0) {
			if (base == 0)
				throw new RuntimeException("分母不能为0");
			if (n == Integer.MIN_VALUE) {
				exponent = -(n + 1);
			} else {
				exponent = -n;
			}
		} else { // n==0
			return 1; // 0的0次方
		}
		while (exponent != 0) {
			if ((exponent & 1) == 1)
				res *= cur;
			cur *= cur;
			exponent >>= 1;
		}
		if (n == Integer.MIN_VALUE) {
			return 1 / res * (1 / base);
		}
		return n >= 0 ? res : (1 / res);
	}
}
