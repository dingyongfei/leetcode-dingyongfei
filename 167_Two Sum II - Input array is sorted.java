class Solution {
	public int[] twoSum(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return new int[] { -1, -1 };
		}
		int l = 0, r = nums.length - 1;
		while (l < r) {
			if (nums[l] + nums[r] == target) {
				return new int[] { l + 1, r + 1 };
			} else if (nums[l] + nums[r] < target) {
				l++;
			} else {
				r--;
			}
		}
		return new int[] { -1, -1 };
	}
}
