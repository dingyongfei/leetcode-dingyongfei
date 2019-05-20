// 二分法
class Solution {
	public int mySqrt(int x) {
		if (x == 0 || x == 1) {
			return x;
		}
		int left = 1;
		int right = x;
		while (left <= right) { // 注意，要写成"<="!
			int mid = ((right - left) >> 1) + left;
			if (mid == x / mid) { // 注：不写成mid*mid是因为mid*mid的结果可能会溢出。
				return mid;
			} else if (mid < x / mid) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return right; // 注意最后这里，最终的结果总是返回"right"。
	}
}
