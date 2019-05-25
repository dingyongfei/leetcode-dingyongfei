class Solution {
	public boolean containsDuplicate(int[] nums) {
		if (nums == null || nums.length == 0) {
			return false;
		}
		if (nums.length == 1) {
			return false;
		}
		Set<Integer> set = new HashSet<Integer>();
		for (int n : nums) {
			if (!set.add(n)) {
				return true;
			}
		}
		return false;
	}
}
