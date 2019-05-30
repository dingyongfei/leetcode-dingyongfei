// 前序遍历
class Solution {
	List<String> list = new ArrayList<String>();

	public List<String> binaryTreePaths(TreeNode root) {
		if (root == null) {
			return list;
		}
		process(root, "");
		return list;
	}

	public void process(TreeNode root, String str) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			str += root.val;
			list.add(str);
			return;
		} else {
			str += root.val + "->";
		}

		process(root.left, str);
		process(root.right, str);
	}
}
