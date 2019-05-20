class Solution {
	public static int threeSumClosest(int[] nums, int target) {
		if (nums == null | nums.length < 3) {
			return Integer.MIN_VALUE;
		}
		int abs = Integer.MAX_VALUE;
		int res = 0;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			int l = i + 1;
			int r = nums.length - 1;
			int value = target - nums[i];
			while (l < r) {
				int sum = nums[l] + nums[r];
				if (Math.abs(sum - value) <= abs) {
					res = sum + nums[i];
					abs = Math.min(abs, Math.abs(sum - value)); // -------注意，使用的是Math.abs()函数
				}
				if (sum < value) {
					l++;
				} else if (sum > value) {
					r--;
				} else {
					return res;
				}
			}
		}
		return res;
	}
}
