class Solution {
	List<List<Integer>> al = new ArrayList<>();
	List<Integer> list = new ArrayList<>();

	public List<List<Integer>> combinationSum2(int[] nums, int target) {
		if (nums == null || nums.length == 0 || target < 0) {
			return al;
		}
		Arrays.sort(nums);
		process(nums, 0, target);
		return al;
	}

	public void process(int[] nums, int index, int target) {
		if (target < 0) {
			return;
		}
		if (target == 0) {
			al.add(new ArrayList<>(list));
		}
		for (int i = index; i < nums.length; i++) {
			if (i > index && nums[i] == nums[i - 1]) { // 说明在之前的递归中，nums[i-1]已经加入过list中计算过
				continue;
			}

			list.add(nums[i]);
			process(nums, i + 1, target - nums[i]);
			list.remove(list.size() - 1);
		}

	}
}
