//方法一. 根据二叉树水平遍历稍加改写.
class Solution {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> al = new ArrayList<List<Integer>>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();

		TreeNode last = root;
		TreeNode nLast = null;
		if (root == null) {
			return al;
		}
		queue.add(root);
		List<Integer> list = new ArrayList<Integer>();
		while (!queue.isEmpty()) {
			root = queue.poll();
			list.add(root.val);
			if (root.left != null) {
				queue.offer(root.left);
				nLast = root.left;
			}
			if (root.right != null) {
				queue.offer(root.right);
				nLast = root.right;
			}
			if (last == root) {
				al.add(list);
				last = nLast;
				list = new ArrayList<Integer>();
			}
		}
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		int tmp = al.size();              //fuck that! man. 必须先设置一个临时变量tmp（tmp = al.size()）才能做下面的for循环，因为al的size()在循环中是不断改变的！！
		for (int i = 0; i < tmp; i++) {
			res.add(al.remove(al.size() - 1));
		}
		return res;
	}
}

//方法二. 递归简单版
class Solution {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> list = new LinkedList<List<Integer>>();
		addLevel(list, root, 0);
		return list;
	}

	public void addLevel(List<List<Integer>> list, TreeNode root, int level) {
		if (root == null) {
			return;
		}
		if (level == list.size()) {
			list.add(0, new LinkedList<Integer>());            //本题的主要技巧点
		}
		addLevel(list, root.left, level + 1);
		addLevel(list, root.right, level + 1);
		list.get(list.size() - level - 1).add(root.val);
	}
}
