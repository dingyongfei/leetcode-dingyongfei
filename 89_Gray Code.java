class Solution {
	public List<Integer> grayCode(int n) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(0);
		for (int i = 0; i < n; i++) {
			int size = list.size();
			for (int j = size - 1; j >= 0; j--) { // 注意，这里从后往前计算下一个grayCode。并将其加入到list中去.
				int num = (list.get(j)) | (1 << i);
				list.add(num);
			}
		}
		return list;
	}
}
