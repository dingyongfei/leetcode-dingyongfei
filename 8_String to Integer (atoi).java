class Solution {
	public int myAtoi(String str) {

		if (str == null || str.length() == 0) {
			return 0;
		}
		str = str.trim();
		int len = str.length();
		int i = 0;
		int ans = 0;
		int sign = 1;
		if (i < len && (str.charAt(i) == '-' || str.charAt(i) == '+')) { // 注意，这里要做下标越界判断的处理
			sign = str.charAt(i++) == '+' ? 1 : -1;
		}
		for (; i < len; i++) {
			int tmp = str.charAt(i) - '0';
			if (tmp < 0 || tmp > 9) {
				break;
			}
			if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && Integer.MAX_VALUE % 10 < tmp)) {
				return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			} else {
				ans = ans * 10 + tmp;
			}
		}
		return sign * ans;
	}
}
