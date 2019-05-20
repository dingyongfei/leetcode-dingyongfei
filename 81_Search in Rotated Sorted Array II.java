// 比33题    33. Search in Rotated Sorted Array   多了一个边界判断条件：就是当nums[mid] = nums[e]时, 要做到e = e - 1 ，以保证跳过重复元素?（类似于剑指题 6）
class Solution {
	public boolean search(int[] nums, int t) {
		if (nums == null || nums.length == 0) {
			return false;
		}
		int s = 0;
		int e = nums.length - 1;
		while (s <= e) {
			int mid = (e - s) / 2 + s;
			if (nums[mid] == t) {
				return true;
			}
			// 右有序
			if (nums[mid] < nums[e]) {
				if (t <= nums[e] && t > nums[mid]) {
					s = mid + 1;
				} else {
					e = mid - 1;
				}
			// 左有序
			} else if (nums[mid] > nums[e]){
				if (t >= nums[s] && t < nums[mid]) {
					e = mid - 1;
				} else {
					s = mid + 1;
				}
			} else {
                e = e - 1;           //此时不好判断目标元素在mid的左边还是右边，这时只好一个一个试.
            	}
		}
		return false;
	}
}
