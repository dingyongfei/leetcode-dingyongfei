class Solution {
	boolean res = true;

	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		getDepth(root);
		return res;
	}

	public int getDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = getDepth(root.left);
		int right = getDepth(root.right);
		if (Math.abs(left - right) > 1) {
			res = false;
		}
		return left > right ? left + 1 : right + 1;
	}
}

