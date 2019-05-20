//same with question 91
//方法一
//根据dp改成的解决方案：
//yes!!!!!!!!
class Solution {
	public int rob(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		int pre = 0;
		int cur = nums[0];
		int tmp = 0;
		for (int i = 1; i < nums.length; i++) {
			tmp = cur;
			cur = Math.max(cur, pre + nums[i]);
			pre = tmp;
		}
		return cur;
	}
}

//方法二
// dp. 和题 91 的思路一模一样!!
// dp[i] 代表 0 ~ i – 1 位置已经偷过, i ~ N 没有偷过的最多钱数量. （所以, 两题的共同点就是都要注意临界值的处理!!）
class Solution {
	public int rob(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int[] dp = new int[nums.length + 1];
		dp[0] = 0;
		dp[1] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			int num = nums[i];
			dp[i + 1] = Math.max(dp[i], dp[i - 1] + num);
		}
		return dp[nums.length];
	}
}
