class Solution {
	public int removeDuplicates(int[] nums) {
		int count = 0;
		if (nums == null || nums.length == 0) {
			return 0;
		}
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == nums[i + 1]) {
				count++;
			} else {
				nums[i + 1 - count] = nums[i + 1];
			}
		}
		return nums.length - count;
	}
}

class Solution {
	public int removeDuplicates(int[] nums) {

		if (nums == null || nums.length == 0) {
			return 0;
		}
		int k = 1; // 即 第一个元素就是数组原来的第一个元素
		int i = 1;
		for (; i < nums.length; i++) {
			if (nums[i] != nums[k - 1]) { // 注意，这里是“nums[i]!=nums[k-1]”，这样就可以适应于“重复数多于1”的其他题目了。
				nums[k++] = nums[i];
			}
		}
		return k;
	}
}
