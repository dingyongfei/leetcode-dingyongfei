class Solution {
	public boolean isHappy(int n) {
		if (n <= 0) {
			return false;
		}
		if (n == 1) {
			return true;
		}
		int res = 0;
		int tmp = n;
		Set<Integer> set = new HashSet<Integer>();
		while (set.add(tmp)) {                    // 补：本题另一种写法 while(true) 循环外不能写return 语句 ！
			res = 0;
			while (tmp != 0) {
				res += (tmp % 10) * (tmp % 10);
				tmp = tmp / 10;
			}
if (res == 1) {
				return true;
			}
			tmp = res;
		}
		return false;
	}
}
