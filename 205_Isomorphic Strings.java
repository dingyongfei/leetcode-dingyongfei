//方法一, 两个Hash表，双射。
class Solution {
	public boolean isIsomorphic(String s, String t) {
		Map<Character, Character> m1 = new HashMap<Character, Character>();
		Map<Character, Character> m2 = new HashMap<Character, Character>();
		char[] c1 = s.toCharArray();
		char[] c2 = t.toCharArray();
		if (c1.length != c2.length) {
			return false;
		}
		for (int i = 0; i < c1.length; i++) {

			if (!m1.containsKey(c1[i])) {
				m1.put(c1[i], c2[i]);
			} else {
				if (m1.get(c1[i]) != c2[i]) {
					return false;
				}
			}

			if (!m2.containsKey(c2[i])) {
				m2.put(c2[i], c1[i]);
			} else {
				if (m2.get(c2[i]) != c1[i]) {
					return false;
				}
			}

		}
		return true;	
	}
}

//方法二, 非常简单的版本!!
class Solution {
	public boolean isIsomorphic(String s, String t) { 
		int[] m1 = new int[256];
		int[] m2 = new int[256];
		int len = s.length();
		for (int i = 0; i < len; i++) {
			if (m1[s.charAt(i)] != m2[t.charAt(i)]) // 看一看！ 字符串s和t中没有加入过m1和m2的字符对应的值都为 0（利用数组中元素的初始值为0）， 依然可以进行比较！非常棒的处理！
				return false;
			m1[s.charAt(i)] = i + 1;
			m2[t.charAt(i)] = i + 1;
		}
		return true;
	}
}
