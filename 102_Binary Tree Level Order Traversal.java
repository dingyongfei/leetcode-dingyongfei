/**  三点注意：
1. nLast随时等于最新加入的节点
2. last == root ?
3. last = nLast
*/

//方法一
class Solution {
	public List<List<Integer>> levelOrder(TreeNode root) {
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
		return al;
	}
}

//方法二
//同理, 和题 102 相同的解法
class Solution {
	
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
		addLevel(list, root, 0);
		return list;
	}

	public void addLevel(List<List<Integer>> list, TreeNode root, int level) {
		if (root == null) {
			return;
		}
		if (level == list.size()) {
			list.add(new LinkedList<Integer>());            //本题的主要技巧点
		}
		addLevel(list, root.left, level + 1);
		addLevel(list, root.right, level + 1);
		list.get(level).add(root.val);
    }
}
