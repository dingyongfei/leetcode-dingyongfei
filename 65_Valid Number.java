class Solution {
	public boolean isNumber(String str) {
		str = str.trim();
		if (str == null || str.length() == 0) {
			return false;
		}
		char[] c = str.toCharArray();
		int len = str.length();
		int j = 0;
		for (j = 0; j < str.length(); j++) {
			if ('0' <= c[j] && c[j] <= '9')
				break;
		}
		if (j == str.length()) {
			return false;
		}
		// 标记符号、小数点、e是否出现过
		boolean sign = false, decimal = false, hasE = false;
		for (int i = 0; i < len; i++) {
			if (c[i] == 'e' || c[i] == 'E') {
				if (i == 0 || i == len - 1)
					return false; // e后面一定要接数字 前面也一定要接数字
				if (i - 1 == 0 && (c[i - 1] > '9' || c[i - 1] < '0')) { // e前面可能只出现了一个小数点且是第一位
					return false;
				}
				if (i + 1 == str.length() - 1 && (c[i + 1] > '9' || c[i + 1] < '0')) { // e后面可能出现: 1."正负号+数字“- >true; 2.
																						// 只有一个正负号且是最后一位->false
					return false;
				}
				if (hasE)
					return false; // 不能同时存在两个e
				hasE = true;
			} else if (c[i] == '+' || c[i] == '-') {
				// 第二次出现+-符号，则必须紧接在e之后
				if (sign && c[i - 1] != 'e')
					return false;
				// 第一次出现+-符号，且不是在字符串开头，则也必须紧接在e之后
				if (!sign && i > 0 && c[i - 1] != 'e')
					return false;
				sign = true;
			} else if (c[i] == '.') {
				// e后面不能接小数点，小数点不能出现两次
				if (hasE || decimal)
					return false;
				decimal = true;
			} else if (c[i] < '0' || c[i] > '9') // 不合法字符
				return false;
		}
		str = c.toString();
		return true;
	}
}
