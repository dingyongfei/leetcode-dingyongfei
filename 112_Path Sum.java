class Solution {
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		sum -= root.val;
		if (sum == 0 && root.left == null && root.right == null) {             //Fuck！！！！啊！必须要保证是叶子节点（加上” && root.left == null && root.right == null “！！）（因为是路径！！！）
			return true;
		}
		return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
	}
}
