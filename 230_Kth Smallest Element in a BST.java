class Solution {
	int cnt = 0;
	TreeNode res = null;

	public int kthSmallest(TreeNode root, int k) {
		if (root == null) {
			return 0;
		}
		kthSmallest(root.left, k);
		cnt++;
		if (cnt == k) {
			res = root;
		}
		kthSmallest(root.right, k);
		return res == null ? 0 : res.val;
	}
}

class Solution {
	int index = 0; // 计数器

	TreeNode KthNode(TreeNode root, int k) {
		if (root == null) {
			return null;
		}
		TreeNode node = KthNode(root.left, k);
		if (node != null)
			return node;
		index++;
		if (index == k)
			return root;
		node = KthNode(root.right, k);
		if (node != null)
			return node;
		return node;
	}
}
