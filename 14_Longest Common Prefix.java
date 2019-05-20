class Solution {
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		int count = 0;
		boolean flag = true;
		StringBuilder sb = new StringBuilder();
		char tmp = ' ';
		while (flag) { // 注意，要设置一个标志位以退出循环
			if (count < strs[0].length()) { // 可以有strs[0].length()这种写法，表示一个字符数组中的字符串的长度
				tmp = strs[0].charAt(count);
			} else {
				flag = false;
				return sb.toString();
			}
			for (int i = 1; i < strs.length; i++) {
				if (count >= strs[i].length() || tmp != strs[i].charAt(count)) {
					flag = false;
					return sb.toString();
				}
			}
			count++;
			sb.append(String.valueOf(tmp));
		}
		return sb.toString();
	}
}
