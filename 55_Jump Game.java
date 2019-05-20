class Solution {
	public boolean canJump(int[] nums) {
		if (nums == null || nums.length <= 1) {
			return true;
		}
		int max = 0;
		for (int i = 0; i < nums.length; i++) { // 贪心算法：扫描数组，记录每一处能到达的最远位置即(i + nums[i])，记作max。每一步更新max，如果当前的下标值
			if (i > max) { // 大于max,返回false。否则继续。循环结束没有return false的话，return true。
				return false;
			}
			max = Math.max(max, i + nums[i]); // 即当前下标值加当前下标对应的元素值
		}
		return true;
	}
}
