class Solution {
	public int trap(int[] arr) {
		if (arr == null || arr.length < 3) {
			return 0;
		}
		int res = 0;
		for (int i = 1; i < arr.length - 1; i++) {
			int leftMax = Integer.MIN_VALUE;
			int rightMax = Integer.MIN_VALUE;
			for (int l = 0; l < i; l++) {
				leftMax = Math.max(leftMax, arr[l]);
			}
			for (int r = arr.length - 1; r > i; r--) {
				rightMax = Math.max(rightMax, arr[r]);
			}
			res += Math.max(0, Math.min(leftMax, rightMax) - arr[i]);
		}
		return res;
	}
}
