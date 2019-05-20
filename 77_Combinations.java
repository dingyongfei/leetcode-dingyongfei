class Solution {
	List<List<Integer>> al = new ArrayList<List<Integer>>();
	List<Integer> list = new ArrayList<>();

	public List<List<Integer>> combine(int n, int k) {
		if (n < 1 || k < 1) {
			return al;
		}
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = i + 1;
		}
		process(nums, 0, 0, k);
		return al;
	}

	public void process(int[] nums, int index, int level, int k) {
		if (level == k) {
			al.add(new ArrayList<Integer>(list));
		}
		for (int i = index; i < nums.length; i++) {
			list.add(nums[i]);
			process(nums, i + 1, level + 1, k);
			list.remove(list.size() - 1);
		}
	}
}
