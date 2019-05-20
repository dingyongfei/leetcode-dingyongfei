class Solution {
	public int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int k = 0;
		int i = 0;
		int j = 1;
		while (i < nums.length) {
			nums[k++] = nums[i];
			while (j < nums.length && nums[i] == nums[j]) {
				j++;
			}
			if (j - i >= 2) {
				i = j - 2;
			}
			i++;
		}
		return k;
	}
}

//方法二（ 简单 ）
class Solution {
	public int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int k = 2;                 //即 第一个元素就是数组原来的第一个元素
		int i = 2;
		for (; i < nums.length; i++) {
			if (nums[i] != nums[k - 2]) {
				nums[k++] = nums[i];
			}
		}
		return k;
	}
}

