class Solution {
	List<List<Integer>> al = new ArrayList<>();

	public List<List<Integer>> permute(int[] nums) {
		if (nums == null || nums.length == 0) {
			return al;
		}
		process(nums, 0);
		return al;
	}

	public void process(int[] nums, int i) {
		if (i == nums.length) {
			List<Integer> list = new ArrayList<>();
			for (int c : nums) { // 注意，这里不能使用Arrays.asList(nums)方法添加，否则链表中的list元素全部都是重复值！！！！
				list.add(c);
			}
			al.add(list);
			return;
		}
		for (int j = i; j < nums.length; j++) {
			swap(nums, i, j);
			process(nums, i + 1);
			swap(nums, i, j);
		}
	}

	public void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
