//或者写成如下的形式：（比较方便，下一题也是直接增设一个节点  “TreeNode pre = null”）
class Solution {
	public boolean isValidBST(TreeNode root) {
		TreeNode pre = null;
		if (root != null) {
			Stack<TreeNode> stack = new Stack<TreeNode>();
			while (!stack.isEmpty() || root != null) {
				if (root != null) {
					stack.push(root);
					root = root.left;
				} else {
					root = stack.pop();
					if (pre != null && root.val <= pre.val) {
						return false;
					}
					pre = root;
					root = root.right;
				}
			}
		}
		return true;
	}
}
