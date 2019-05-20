class Solution {
	int res = 0;

	public int sumNumbers(TreeNode root) {
		if (root == null)
			return 0;
		process(root, 0);
		return res;
	}

	public void process(TreeNode root, int sum) {
		if (root == null)
			return;
		sum = sum * 10 + root.val;
		if (root.left == null && root.right == null) {
			res += sum;
		}
		process(root.left, sum);
		process(root.right, sum);
	}
}
