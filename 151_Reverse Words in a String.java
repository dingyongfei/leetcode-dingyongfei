class Solution {
	public String reverseWords(String str) {
		if (str.isEmpty() || str.trim().equals("")) {          //必须要加上str.trim().equals("")，否则程序后面会出现 “StringIndexOutOfBoundsException”!!
			return "";
		}
		char[] c = str.toCharArray();
		reverse(c, 0, c.length - 1);
		int s = 0;
		int e = 0;

		while (e < str.length()) {                          //记住此处写法
			while (e < str.length() && c[e] == ' ') {
				e++;
			}
			s = e;
			while (e < str.length() && c[e] != ' ') {
				e++;
			}
			reverse(c, s, e - 1);
		}

		String[] res = String.valueOf(c).split(" ");
		StringBuilder pre = new StringBuilder();
		for (String s1 : res) {
			if (!s1.equals("")) {
				pre.append(" " + s1);
			}
		}
		return pre.toString().substring(1);
	}

	private void reverse(char[] c, int s, int e) {
		while (s <= e) {
			char tmp = c[s];
			c[s] = c[e];
			c[e] = tmp;
			s++;
			e--;
		}
	}
}
