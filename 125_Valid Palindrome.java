class Solution {
	public boolean isPalindrome(String str) {
		if (str == null || str.length() == 0) {
			return true;
		}
		char[] c = str.toCharArray();
		int i = 0;
		int j = str.length() - 1;
		while (i < j) {
			if (!Character.isLetterOrDigit(c[i])) {
				i++;
				continue;                            //注意，要continue! 同下
			}

			if (!Character.isLetterOrDigit(c[j])) {
				j--;
				continue;
			}

			if (Character.toLowerCase(c[i]) != Character.toLowerCase(c[j]))
				return false;
			i++;
			j--;

		}
		return true;
	}
}
