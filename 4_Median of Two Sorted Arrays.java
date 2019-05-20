class Solution {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if (nums1.length == 0 && nums2.length == 0) {
			return Double.MIN_VALUE;
		}
		int len1 = nums1.length;
		int len2 = nums2.length;
		int[] help = new int[len1 + len2];
		Merge(nums1, nums2, help, len1, len2);
		if (help.length % 2 == 1) {
			return help[(help.length - 1) / 2];
		} else {
			return (help[(help.length - 1) / 2] + help[(help.length + 1) / 2]) / 2.0;
		}
	}

	public void Merge(int[] nums1, int[] nums2, int[] help, int len1, int len2) {
		int p1 = 0;
		int p2 = 0;
		int i = 0;
		while (p1 < len1 && p2 < len2) {
			help[i++] = nums1[p1] < nums2[p2] ? nums1[p1++] : nums2[p2++];
		}
		while (p1 < len1) {
			help[i++] = nums1[p1++];
		}
		while (p2 < len2) {
			help[i++] = nums2[p2++];
		}
	}
}
