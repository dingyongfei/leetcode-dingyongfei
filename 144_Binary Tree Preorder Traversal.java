class Solution {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return list;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.add(root);
		while (!stack.isEmpty()) {
			root = stack.pop();
			list.add(root.val);

			if (root.right != null) {
				stack.push(root.right);
			}

			if (root.left != null) {
				stack.push(root.left);
			}
		}
		return list;
	}
}
