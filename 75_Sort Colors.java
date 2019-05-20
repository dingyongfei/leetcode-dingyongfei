// NetherlandsFlags问题
class Solution {
	public void sortColors(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}
		int len = nums.length;
		int p = 1;
		int l = 0;
		int r = nums.length - 1;
		partition(nums, l, r, p);
	}

	public void partition(int[] nums, int l, int r, int p) {
		int less = l - 1;
		int more = r + 1;
		while (l < more) {
			if (nums[l] < p) {
				swap(nums, ++less, l++);
			} else if (nums[l] > p) {
				swap(nums, --more, l);
			} else {
				l++;
			}
		}
	}

	public void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
