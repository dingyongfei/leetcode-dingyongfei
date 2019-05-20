class Solution {
	List<List<Integer>> al = new ArrayList<>();

	public List<List<Integer>> permuteUnique(int[] nums) {
		if (nums == null || nums.length == 0) {
			return al;
		}
		process(nums, 0);
		return al;
	}

	public void process(int[] nums, int i) {
		if (i == nums.length) {
			List<Integer> list = new ArrayList<>();
			for (int c : nums) {
				list.add(c);
			}
			al.add(list);
			return;
		}

		HashSet<Integer> set = new HashSet<Integer>();
		for (int j = i; j < nums.length; j++) {
			if (!set.contains(nums[j])) {
				set.add(nums[j]);
				swap(nums, i, j);
				process(nums, i + 1);
				swap(nums, i, j);
			}
		}
	}

	public void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
