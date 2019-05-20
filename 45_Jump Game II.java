class Solution {
	public int jump(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int pos = nums.length - 1;
		int count = 0;
		while (pos > 0) {
			for (int i = 0; i < pos; i++) { // 注意，本题的思想是从尾到头找离当前点最远可达的点。实际扫描是从头向后扫描到第一个比当前点最大的点即可！！！！
				if (nums[i] >= pos - i) { // 跳还是从尾到头跳
					count++;
					pos = i;

				}
			}
		}
		return count;
	}
}
