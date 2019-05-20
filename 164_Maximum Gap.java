//利用桶排序的思想（不是直接进行桶排序）
//最大差值 只可能来自于 某个非空桶的最小值 减去 前一个非空桶的最大值。
class Solution {
	public int maximumGap(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int len = nums.length;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < nums.length; i++) {           //1. 找出整个数组中的最大值max和最小中min。
			min = Math.min(min, nums[i]);
			max = Math.max(max, nums[i]);
		}

		if (min == max)
			return 0;

		boolean[] hasNum = new boolean[len + 1];
		int[] maxs = new int[len + 1];
		int[] mins = new int[len + 1];
		int index = 0;

		for (int i = 0; i < len; i++) {
			index = bucket(nums[i], len, min, max);          // 计算桶号。

			mins[index] = hasNum[index] ? Math.min(mins[index], nums[i]) : nums[i];  
                                                              //2. 用两个数组分别保存每个桶中的最大值和最小值   
			maxs[index] = hasNum[index] ? Math.max(maxs[index], nums[i]) : nums[i];
			hasNum[index] = true;
		}

		int res = 0;
		int lastMax = 0;
		int i = 0;

		while (i <= len) {                                // 3. 找到第一个不为空的桶
			if (hasNum[i++]) {
				lastMax = maxs[i - 1];
				break;
			}
		}

		for (; i <= len; i++) {                         //4. 最大差值 为 某个空桶的最小值 减去 上一步中找出的非空桶的最大值
			if (hasNum[i]) {
				res = Math.max(res, mins[i] - lastMax);
				lastMax = maxs[i];                     //5. 循环更新lastMax。
			}
		}
		return res;
	}

	private int bucket(long num, long len, long min, long max) { // 使用long类型, 防止乘法时溢出
		return (int) ((num - min) * len / (max - min));
	}
}
