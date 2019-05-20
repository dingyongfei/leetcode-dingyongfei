class Solution {

	List<List<Integer>> al = new ArrayList<>();
	List<Integer> list = new ArrayList<>();

	public List<List<Integer>> combinationSum(int[] nums, int target) {
		if (nums == null || nums.length == 0 || target < 0) {
			return al;
		}
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
		for (int i = index; i < nums.length; i++) { // 注意，这里一定要从“i=index”而不能从”i=0”开始，否则递归搜索结果中就会出现重复值！！
			list.add(nums[i]);
			process(nums, i, target - nums[i]);
			list.remove(list.size() - 1);
		}
	}
}
