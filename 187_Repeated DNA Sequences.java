//和剑指offer “45. 扑克牌顺子” 类似。(节省空间的思想)
//本题可以和第3题对照着看。
//If we store string, we need 8 bytes. If we use 2 bits for each character, we still need 4 bytes, so we reduce half space.
// 本题重要小结 : 想办法将字符串转换成二进制(bitmap思想), 以节省空间 !!

//Excellent solution !!!   (推荐！)
//List 和 Set 之间的相互转换，见第 71 题
class Solution {
	public List<String> findRepeatedDnaSequences(String str) {
		Set<String> words = new HashSet<String>();
		Set<String> doubleWords = new HashSet<String>();

		for (int i = 0; i + 9 < str.length(); i++) {
			String sub = str.substring(i, i + 10);
			if (!words.add(sub)) {
				doubleWords.add(sub);
			}
		}
		return new ArrayList<String>(doubleWords);
	}
}

//self writing 用HashMap判断重复，比较复杂
/*
class Solution {
	public List<String> findRepeatedDnaSequences(String str) {
		List<String> res = new ArrayList<>();
		char[] map = new char[26];
		// 因为只有4种碱基，所以用2位二进制数可以表示所有的碱基！！
		map['A' - 'A'] = 0; // 0 0
		map['C' - 'A'] = 1; // 0 1
		map['G' - 'A'] = 2; // 1 0
		map['T' - 'A'] = 3; // 1 1

		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		for (int i = 0; i < str.length() - 9; i++) {
			int v = 0;
			for (int j = i; j < i + 10; j++) {
				v <<= 2;                                // 注意这两行code的顺序 !!
				v |= map[str.charAt(j) - 'A'];          
			}

			if (!m.containsKey(v)) {
				m.put(v, 1);
			} else {
				m.put(v, m.get(v) + 1);
			}
		}

		int tmp = 3;
		for (Map.Entry<Integer, Integer> set : m.entrySet()) {
			if (set.getValue() > 1) {
				int key = set.getKey();
				int cnt = 10;
				StringBuilder sb = new StringBuilder();
				while (cnt > 0) {
					if ((key & tmp) == 0)
						sb.append("A");
					else if ((key & tmp) == 1)
						sb.append("C");
					else if ((key & tmp) == 2)
						sb.append("G");
					else if ((key & tmp) == 3)
						sb.append("T");
					key >>= 2;
					cnt--;
				}
				sb.reverse();
				res.add(sb.toString());
			}
		}
		return res;
	}
}
*/

/*
//和剑指offer“45. 扑克牌顺子 ”类似
//用2个HashSet添加子串，做到了不重复添加子串！！
class Solution {
	public List<String> findRepeatedDnaSequences(String str) {
		Set<Integer> words = new HashSet<>(); 
		Set<Integer> doubleWords = new HashSet<>();            // 两个HashSet添加子串, 实现了不重复地添加结果 !!
		List<String> res = new ArrayList<>();
		char[] map = new char[26];

		// 因为只有4种碱基，所以用2位二进制数可以表示所有的碱基！！
		// map['A' - 'A'] = 0;
		map['C' - 'A'] = 1;
		map['G' - 'A'] = 2;
		map['T' - 'A'] = 3;

		for (int i = 0; i < str.length() - 9; i++) {
			int v = 0;
			for (int j = i; j < i + 10; j++) {
				v <<= 2;                                 // 注意这两行code的顺序 !!
				v |= map[str.charAt(j) - 'A'];          // 类似于剑指offer第45题“ 扑克牌顺子 ”
			}
			if (!words.add(v) && doubleWords.add(v)) {  // 防止重复添加相同的子串到结果中(仔细想想这行code中的逻辑)
                && ： 短路与，可能只会检查一个。
				res.add(str.substring(i, i + 10));
			}
		}
		return res;
	}
}
*/

