class Solution {
	public TreeNode buildTree(int[] in, int[] pos) {
		if (in == null || pos == null) {
			return null;
		}
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < in.length; i++) {
			map.put(in[i], i);
		}
		TreeNode root = process(pos, 0, pos.length - 1, in, 0, in.length - 1, map);
		return root;
	}

	public TreeNode process(int[] pos, int sPos, int ePos, int[] in, int sIn, int eIn, Map<Integer, Integer> map) {
		if (sPos > ePos || sIn > eIn) {
			return null;
		}
		TreeNode root = new TreeNode(pos[ePos]);
		int i = map.get(pos[ePos]);

		root.left = process(pos, sPos, ePos - eIn + i - 1, in, sIn, i - 1, map);
		root.right = process(pos, ePos - eIn + i, ePos - 1, in, i + 1, eIn, map);
		return root;
	}
}
//小结：二叉树的 先序 + 中序 和 后序 + 中序 序列组合都可以重建出二叉树，唯独 “先序 + 后序 ”是不可以的。
