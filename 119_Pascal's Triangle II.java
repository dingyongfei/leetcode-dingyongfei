class Solution {
	public List<Integer> getRow(int row) {
		row = row + 1; // row = row + 1,因为题目中 “Note that the row index starts from 0.”
		List<Integer> list = new ArrayList<Integer>();
		int[] arr = new int[row];
		for (int i = 0; i < row; i++) {
			for (int j = i; j >= 0; j--) { // 注意，要从后往前且只能从后往前覆盖！计算生成新数组，以避免数组元素的覆盖！！
				if (j == 0 || j == i) {
					arr[j] = 1;
				} else {
					arr[j] = arr[j] + arr[j - 1];
				}
			}
		}
		for (int a : arr) {
			list.add(a);
		}
		return list;
	}
}
