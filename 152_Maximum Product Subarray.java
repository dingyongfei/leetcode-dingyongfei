class Solution {
	public int maxProduct(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int max = nums[0];
		int min = nums[0];
		int res = nums[0];
		int maxEnd = 0;
		int minEnd = 0;
		for (int i = 1; i < nums.length; ++i) {      // 每一个i都代表每一个子数组必须以i位置结尾，然后在循环中，求所有这些子数组的最大累乘积。
			maxEnd = max * nums[i];                  // 临时变量maxEnd
			minEnd = min * nums[i];                  // 临时变量minEnd
			max = Math.max(Math.max(maxEnd, minEnd), nums[i]);    // 最大累乘积可能来自于：1. 以i-1位置结尾的子数组最大值乘以nums[i]; 2.
													      // i-1位置的最小值乘以nums[i]; 3. nums[i]单独一个元素
			min = Math.min(Math.min(maxEnd, minEnd), nums[i]);    // 以上三者之间取最大的即为当前位置的最大值。同理，当前位置的最小值也是同理。
			res = Math.max(res, max);
		}
		return res;
	}
}
