// Solution 1
// 用位运算解决
class Solution {
	public int missingNumber(int[] nums) {
		int res = nums.length;                    // 注意res的初始值为数组的长度 !
		for (int i = 0; i < nums.length; i++) {
			res ^= i ^ nums[i];
		}
		return res;
	}
}
// Solution 2 
class Solution {
	public int missingNumber(int[] nums) {
		int sum = nums.length;               // 注意，sum的初始值依然为nums.length.
		for (int i = 0; i < nums.length; i++) {
			sum += i;
			sum -= nums[i];
		}
		return sum;
	}
}
