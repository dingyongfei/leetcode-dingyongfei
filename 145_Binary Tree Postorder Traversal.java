class Solution {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return list;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Stack<TreeNode> help = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.isEmpty()) {
			root = stack.pop();
			help.push(root);
			if (root.left != null) {
				stack.push(root.left);
			}
			if (root.right != null) {
				stack.push(root.right);
			}
		}
		while (!help.isEmpty()) {
			list.add(help.pop().val);
		}
		return list;
	}
}
