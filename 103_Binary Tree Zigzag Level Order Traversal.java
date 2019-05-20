class Solution {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

		Stack<TreeNode> s1 = new Stack<TreeNode>();
		Stack<TreeNode> s2 = new Stack<TreeNode>();
		List<List<Integer>> al = new ArrayList<>();

		if (root == null) {
			return al;
		}

		int layer = 1;
		s1.push(root); // 最外面先push，本题另一种方法用Deque做，也是先push，“最外面先push" ---这非常重要。
		while (!s1.isEmpty() || !s2.isEmpty()) {
			if (layer % 2 != 0) {
				List<Integer> list = new ArrayList<Integer>();
				while (!s1.isEmpty()) {
					root = s1.pop();
					list.add(root.val);
					if (root.left != null) {
						s2.push(root.left);
					}
					if (root.right != null) {
						s2.push(root.right);
					}

				}
				al.add(list);
				layer++;                         //这两行都在 while 循环的外面，否则 “Time Limit Exceeded ”！！

			} else {
				List<Integer> list = new ArrayList<Integer>();
				while (!s2.isEmpty()) {
					root = s2.pop();
					list.add(root.val);
					if (root.right != null) {
						s1.push(root.right);
					}
					if (root.left != null) {
						s1.push(root.left);
					}
				}
				al.add(list);
				layer++;
			}
		}
		return al;
	}
}
