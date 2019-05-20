class Solution {
	public static boolean isPalindrome(int x) {
		String str = String.valueOf(x);
		int len = str.length();
		if (str == null || str.length() == 0) {
			return true;
		}
		int i = 0;
		int j = len - 1;
		while (i <= j) {
			if (str.charAt(i) != str.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
}
