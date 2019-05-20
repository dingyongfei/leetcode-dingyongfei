class Solution {
	public int strStr(String s, String p) {
		if (p.isEmpty()) {
			return 0;
		}
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == p.charAt(0)) {
				int a = i;
				int b = 0;
				while (b < p.length() && a < s.length() && s.charAt(a) == p.charAt(b)) { // 1注意，判断不等于比等于好处理得多！ 2.
																							// 注意这里的判断数组下标越界！
					a++;
					b++;
				}
				if (b == p.length()) {
					return i;
				}
			}
		}
		return -1;
	}
}
