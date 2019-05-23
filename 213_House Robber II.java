// 既然是环形，我们就将问题分为两个子问题来考虑：
// Subproblem 1: rob house 1 ~ 8
// Subproblem 2: rob house 2 ~ 9
// 将两个子问题中的最大值返回即可。

// 写法一
class Solution {
	public int rob(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {              // “  House Robber II
 ” 问题中数组中只有一个元素时, 需要做特殊处理 !!
			return nums[0];                 // 第5题也是相似的base case, 可以对比一下.
		}
		int len = nums.length;
		return Math.max(process(nums, 0, len - 1), process(nums, 1, len));
	}

	private int process(int[] nums, int s, int e) {
		int pre = 0;
		int cur = 0;
		int tmp = 0;
		for (int i = s; i < e; i++) {
			tmp = cur;
			cur = Math.max(cur, pre + nums[i]);
			pre = tmp;
		}
		return cur;
	}
}

(或
class Solution {
	public int rob(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		int len = nums.length;
		return Math.max(process(nums, 0, len - 1), process(nums, 1, len));
	}

	public int process(int[] nums, int s, int e) {
		int pre = 0;
		int cur = nums[s];
		int tmp = 0;
		for (int i = s + 1; i < e; i++) {
			tmp = cur;
			cur = Math.max(cur, pre + nums[i]);
			pre = tmp;
		}
		return cur;
	}
}
)

// 写法二
class Solution {
	public int rob(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {              // “  House Robber II
 ” 问题中数组中只有一个元素时, 需要做特殊处理 !!
			return nums[0];
		}
		int len = nums.length;
		int[] dp = new int[len];
		return Math.max(process(nums, dp, 0), process(nums, dp, 1));
	}

	public int process(int[] nums, int[] dp, int s) {
		dp[0] = 0;
		dp[1] = nums[s];
		for (int i = 1; i < dp.length - 1; i++) {
			int num = nums[i + s];
			dp[i + 1] = Math.max(dp[i], dp[i - 1] + num);
		}
		return dp[dp.length - 1];
	}
}
