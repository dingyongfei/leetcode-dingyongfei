class Solution {
	public void nextPermutation(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}
		int i = 0;
		for (i = nums.length - 1; i >= 1; i--) {
			if (nums[i] > nums[i - 1]) {
				for (int j = i; j < nums.length; j++) {
					while (j < nums.length && nums[j] > nums[i - 1]) {
						j++;
					}
					int tmp = nums[j - 1];
					nums[j - 1] = nums[i - 1];
					nums[i - 1] = tmp;
					swap(nums, i, nums.length - 1); // 注意，在循环里交换，交换完直接return！
					return;
				}
			}
		}
		swap(nums, 0, nums.length - 1); // 特殊情况，完全倒序的情况，那只能将整个数组从头到尾交换一遍
	}

	public void swap(int[] nums, int s, int e) {
		while (s <= e) {
			int tmp = nums[s];
			nums[s] = nums[e];
			nums[e] = tmp;
			s++;
			e--;
		}
	}

}
