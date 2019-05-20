class Solution {
	public List<TreeNode> generateTrees(int n) {
		if (n <= 0) { // 注意特殊值的处理
			return new LinkedList<TreeNode>();
		}
		return generate(1, n);
	}

	public List<TreeNode> generate(int start, int end) {
		List<TreeNode> list = new LinkedList<TreeNode>();
		if (start > end) {
			list.add(null);
			return list;
		}

		for (int i = start; i <= end; i++) {
			/* TreeNode root = new TreeNode(i); */
			List<TreeNode> lSub = generate(start, i - 1);
			List<TreeNode> rSub = generate(i + 1, end);
			for (TreeNode l : lSub) {
				for (TreeNode r : rSub) {
					TreeNode root = new TreeNode(i); // 注：这一行如果放在这里而不放在上面的话，就可以避免不同结构之间的额互相交叉，即可以不需要下面的cloneTree的拷贝新树的函数。
					root.left = l;
					root.right = r;
					list.add(root);
				}
			}
		}
		return list;
	}
    
    /*
    public TreeNode cloneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode res = new TreeNode(root.val);
        res.left = cloneTree(root.left);
        res.right = cloneTree(root.right);
        return res;
    }
    */
}
