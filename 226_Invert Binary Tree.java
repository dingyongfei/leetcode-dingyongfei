class Solution {
	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode tmp = root.left;
		root.left = root.right;                      // 整个过程为先序遍历。（用后序遍历也行）
		root.right = tmp;
		invertTree(root.left);
		invertTree(root.right);
		return root;
	}
}
