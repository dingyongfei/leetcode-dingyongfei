class Solution {
	private int low;
	private int max;

	public String longestPalindrome(String s) {
		int len = s.length();
		if (len < 2) { // 注意，只有一个字符时，在本题中定要注意特殊处理, 否则：
			return s;

		}
		for (int i = 0; i < len - 1; i++) {
			expand(s, i, i);
			expand(s, i, i + 1);
		}
		return s.substring(low, low + max);
	}

	private void expand(String s, int l, int r) {
		while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
			l--;
			r++;
		}
		if (max < r - l - 1) {
			max = r - l - 1;
			low = l + 1;
		}
	}
}
