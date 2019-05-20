//依然是改写一个基本的二叉树中序遍历
class Solution {
	TreeNode first = null;
	TreeNode last = null;

	public void recoverTree(TreeNode root) {
		if (root == null) {
			return;
		}
		getErrTreeNodes(root);
		int tmp = first.val;
		first.val = last.val;
		last.val = tmp;
	}

	public void getErrTreeNodes(TreeNode root) {
		if (root != null) {
			Stack<TreeNode> stack = new Stack<TreeNode>();
			TreeNode pre = null;
			while (!stack.isEmpty() || root != null) {
				if (root != null) {
					stack.push(root);
					root = root.left;
				} else {
					root = stack.pop();
					if (pre != null && pre.val > root.val) {
						first = first == null ? pre : first;
						last = root;
					}
					pre = root;
					root = root.right;
				}
			}
		}
	}
}
