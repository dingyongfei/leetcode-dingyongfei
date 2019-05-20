//二叉树的水平遍历即可解决。
class Solution {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		TreeNode last = root;
		TreeNode nLast = null;
		if (root == null) {
			return res;
		}
		queue.offer(root);
		while (!queue.isEmpty()) {
			root = queue.poll();
			if (root.left != null) {
				queue.offer(root.left);
				nLast = root.left;
			}
			if (root.right != null) {
				queue.offer(root.right);
				nLast = root.right;
			}
			if (root == last) {
				res.add(root.val);
				last = nLast;
			}
		}
		return res;
	}
}
