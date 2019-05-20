class Solution {
	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		return comRoot(root.left, root.right);
	}

	public boolean comRoot(TreeNode left, TreeNode right) {
		if (left == null || right == null) {
			return left == right;
		}
		if (left.val != right.val) {
			return false;
		}
		return comRoot(left.left, right.right) && comRoot(left.right, right.left);
	}
}

//迭代（层次遍历）
class Solution {
	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();

		queue.add(root.left);
		queue.add(root.right);

		while (!queue.isEmpty()) {
			TreeNode left = queue.poll();
			TreeNode right = queue.poll();
			if (left == null && right == null) {      //注意这行的写法，这里（left==null&&right==null）是要跳过的!!
				continue;
			}
			if (left == null || right == null || left.val != right.val) {
				return false;
			}
			queue.add(left.left);
			queue.add(right.right);
			queue.add(right.left);
			queue.add(left.right);
		}
		return true;
	}
}
