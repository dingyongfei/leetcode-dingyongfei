class Solution {
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int len = s.length();
		int max = Integer.MIN_VALUE;
		char[] c = s.toCharArray();
		for (int i = 0; i < len; i++) {
			HashSet<Character> set = new HashSet<Character>();
			int count = 1;
			set.add(c[i]);
			for (int j = i + 1; j < len; j++) {
				if (!set.contains(c[j])) {
					set.add(c[j]);
					count++;
				} else {
					break;
				}
			}
			max = Math.max(max, count);
			// i = i+1; //注意，这里不能再更新i了
		}
		return max;
	}
}
