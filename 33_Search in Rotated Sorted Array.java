class Solution {
	public int search(int[] nums, int t) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int s = 0;
		int e = nums.length - 1;
		while (s <= e) {
			int mid = (e - s) / 2 + s;
			if (nums[mid] == t) {
				return mid;
			}
			// 右有序
			if (nums[mid] < nums[e]) {
				if (t <= nums[e] && t > nums[mid]) {
					s = mid + 1;
				} else {
					e = mid - 1;
				}
				// 左有序
			} else {
				if (t >= nums[s] && t < nums[mid]) {
					e = mid - 1;
				} else {
					s = mid + 1;
				}
			}

		}
		return -1;
	}
}
