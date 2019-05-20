class Solution {
	public int romanToInt(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		char[] chs = s.toCharArray();
		int res = 0;
		int i = 0;
		int j = 1; // 设置两个变量，从头到尾扫描，这样处理起来非常方便
		for (i = 0; j < chs.length; i++, j++) {
			if (map.get(chs[i]) >= map.get(chs[j])) { // 注意，是">="号
				res += map.get(chs[i]);
			} else {
				res -= map.get(chs[i]);
			}
		}
		res += map.get(chs[i]);
		return res;
	}
}
