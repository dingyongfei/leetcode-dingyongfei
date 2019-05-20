class Solution {
	public static int maxArea(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}
		int l = 0;
		int r = height.length - 1;
		int max = Integer.MIN_VALUE;
		while (l < r) {
			if (height[l] < height[r]) {
				max = Math.max(max, height[l] * (r - l));
				l++;
			} else {
				max = Math.max(max, height[r] * (r - l));
				r--;
			}
		}
		return max;
	}
}
