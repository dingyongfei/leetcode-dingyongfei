class Solution {
	List<List<Integer>> al = new ArrayList<List<Integer>>();
	List<Integer> list = new ArrayList<Integer>();

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		if (nums == null || nums.length == 0) {
			return al;
		}

		Arrays.sort(nums);
		process(nums, 0);
		return al;
	}

	public void process(int[] nums, int index) {
		al.add(new ArrayList<Integer>(list));
		for (int i = index; i < nums.length; i++) {
			if (i > index && nums[i] == nums[i - 1]) {
				continue;
			}
			list.add(nums[i]);
			process(nums, i + 1);
			list.remove(list.size() - 1);
		}
	}
}
