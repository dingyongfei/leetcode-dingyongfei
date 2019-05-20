// 先整体 -> 再局部翻转数组
class Solution {
	public void rotate(int[] nums, int k) {
		if (nums == null || nums.length == 0 (|| nums.length == 1 )|| k <= 0) {
			return;
		}
		int len = nums.length;
		k %= len;               // 计算k%len !! 且只能这样写，不能写做swap(nums, 0, (k-1)%len) !否则结果错误！！
		swap(nums, 0, len - 1);
		swap(nums, 0, k - 1);
		swap(nums, k, len - 1);
	}

	private void swap(int[] nums, int s, int e) {
		while (s <= e) {
			int tmp = nums[s];
			nums[s] = nums[e];
			nums[e] = tmp;
			s++;
			e--;
		}
	}
}
