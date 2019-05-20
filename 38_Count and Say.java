class Solution {
	public String countAndSay(int n) {
		if (n <= 0) {
			return "";
		}
		int i = 1;
		String res = "1";
		while (i < n) {
			String tmp = "";
			for (int j = 0; j < res.length(); j++) {
				int num = countNums(res.substring(j));
				tmp = tmp + num + res.charAt(j);
				j = num + j - 1; // 因为有for循环的j++, 所以这里最后要-1.
			}
			i++;
			res = tmp;
		}
		return res;
	}

	private int countNums(String str) {
		int i = 1;
		while (i < str.length() && str.charAt(i) == str.charAt(0)) {
			i++;
		}
		return i;
	}
}
