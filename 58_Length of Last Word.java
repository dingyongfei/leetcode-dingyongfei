class Solution {
	public int lengthOfLastWord(String s) {
		if (s.isEmpty() || s.trim().equals("")) {
			return 0;
		}
		String[] str = s.split(" ");
		int len = str.length;
		return str[len - 1].length();
	}
}
