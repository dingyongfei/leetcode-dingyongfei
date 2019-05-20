class Solution {
	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		TreeNode root = process(nums, 0, nums.length - 1);
		return root;
	}

	public TreeNode process(int[] nums, int s, int e) {
		if (s > e) {
			return null;
		}
		int mid = ((e - s) >> 1) + s;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = process(nums, s, mid - 1);
		root.right = process(nums, mid + 1, e);
		return root;
	}
}
