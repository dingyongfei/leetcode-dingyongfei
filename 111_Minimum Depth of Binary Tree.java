//任意一个节点左（右）子树如果为空，则在递归的过程中必须要转而递归它的右（左）子树！！
class Solution {
	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = minDepth(root.left);
		int right = minDepth(root.right);
		//注意, 主要是注意一条链这种情况.
		return ((left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1);
	}
}
