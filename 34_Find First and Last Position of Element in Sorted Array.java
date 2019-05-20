class Solution {
	public int[] searchRange(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return new int[] { -1, -1 };
		}
		int s = 0;
		int e = nums.length - 1;
		int left = leftSearch(nums, k, s, e);
		int right = rightSearch(nums, k, s, e);
		int[] res = new int[] { left, right };

		return res;
	}

	private int leftSearch(int[] nums, int k, int s, int e) {
		while (s <= e) {
			int mid = (e - s) / 2 + s;
			if (nums[mid] > k) {
				e = mid - 1;
			} else if (nums[mid] < k) {
				s = mid + 1;
			} else if (mid - 1 >= 0 && nums[mid] == nums[mid - 1]) {
				e = mid - 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

	private int rightSearch(int[] nums, int k, int s, int e) {
		while (s <= e) {
			int mid = (e - s) / 2 + s;
			if (nums[mid] > k) {
				e = mid - 1;
			} else if (nums[mid] < k) {
				s = mid + 1;
			} else if (mid + 1 < nums.length && nums[mid] == nums[mid + 1]) {
				s = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
}
