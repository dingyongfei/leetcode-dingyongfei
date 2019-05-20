class Solution {
	public static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

	public List<String> letterCombinations(String digits) {
		List<String> list = new LinkedList<String>();
		if (digits == null || digits.length() == 0) {
			return list;
		}

		combine("", digits, 0, list);
		return list;
	}

	public void combine(String prefix, String digits, int i, List<String> list) {
		if (i == digits.length()) {
			list.add(prefix);
			return;
		}
		String goal = KEYS[digits.charAt(i) - '0'];

		for (int j = 0; j < goal.length(); j++) {
			combine(prefix + goal.charAt(j), digits, i + 1, list);
		}
	}
}
