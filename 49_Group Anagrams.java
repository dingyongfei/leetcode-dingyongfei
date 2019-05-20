class Solution {
	List<List<String>> al = new ArrayList<>();

	public List<List<String>> groupAnagrams(String[] strs) {
		if (strs == null || strs.length == 0) {
			return al;
		}
		HashMap<String, List<String>> map = new HashMap<>();
		for (String s : strs) {
			char[] c = s.toCharArray();
			Arrays.sort(c);
			String key = String.valueOf(c);
			if (!map.containsKey(key)) {
				List<String> list = new ArrayList<>();
				list.add(s);
				map.put(key, list);
			} else {
				map.get(key).add(s); // 注意，只能写成map.get(key).add(s), 不能写成map.put(key, map.get(key).add(s)) !!!
										// 因为add()方法返回值类型是boolean类型的! 不能出现在map里！！
			}
		}
		/*
		 * 注：也可以写成： return new ArrayList<List<String>>(map.values());
		 * 注：不可以写成ArrayList<ArrayList<String>>
		 */
		for (Map.Entry<String, List<String>> set : map.entrySet()) {
			al.add(set.getValue());
		}
		return al;
	}
}
