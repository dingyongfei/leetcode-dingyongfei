// 本题bs递归函数需要3个参数: 
1.当前节点root; 
2.当前节点所在的层数level;            // level永远和当前节点相关联
3.整棵完全二叉树的层数h.
class Solution {
	public int countNodes(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return bs(root, 1, mostLeftLevel(root, 1));    // level从1开始, 指的是当前节点所在的层数.
	}

	public int bs(TreeNode root, int level, int h) {
		if (level == h) {                //注意，本题中总是拿高度做比较！
			return 1;
		}
		if (mostLeftLevel(root.right, level + 1) == h) {
			// 没写出来, 注意这里的 2的次方 的写法 !!! 
			return (1 << (h - level)) + bs(root.right, level + 1, h);
		} else {
			return (1 << (h - level - 1)) + bs(root.left, level + 1, h);
		}
	}

	public int mostLeftLevel(TreeNode root, int level) {
		while (root != null) {
			level++;
			root = root.left;
		}
		return level - 1;
	}
}
