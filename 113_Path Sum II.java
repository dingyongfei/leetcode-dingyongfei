class Solution {
	List<List<Integer>> al = new ArrayList<List<Integer>>();
	List<Integer> list = new ArrayList<Integer>();

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		if (root == null) {
			return al;
		}
		list.add(root.val);
		sum -= root.val;
		if (sum == 0 && root.left == null && root.right == null) {
			al.add(new ArrayList<Integer>(list));
		}
		pathSum(root.left, sum);
		pathSum(root.right, sum);
		list.remove(list.size() - 1);
		return al;
	}
}
