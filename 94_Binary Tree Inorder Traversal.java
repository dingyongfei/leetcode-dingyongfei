class Solution {
	List<Integer> list = new ArrayList<Integer>();

	public List<Integer> inorderTraversal(TreeNode root) {
		if (root == null) {
			return list;
		}

		inorderTraversal(root.left);
		list.add(root.val);
		inorderTraversal(root.right);
	}
}

class Solution {
	List<Integer> list = new ArrayList<Integer>();
	public List<Integer> inorderTraversal(TreeNode root) {
		if (root != null) {
			Stack<TreeNode> stack = new Stack<TreeNode>();
			while (!stack.isEmpty() || root != null) {
				if (root != null) {
					stack.push(root);
					root = root.left;
				} else {
					root = stack.pop();
					list.add(root.val);
					root = root.right;
				}
			}
		}
		return list;
	}
}
