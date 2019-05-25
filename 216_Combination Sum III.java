class Solution {
	List<List<Integer>> al = new ArrayList<>();
	List<Integer> list = new ArrayList<>();

	public List<List<Integer>> combinationSum3(int k, int n) {
		if (n <= 0 || k <= 0) {
			return al;
		}
		process(1, n, k);
		return al;
	}

	public void process(int index, int target, int k) {
		if (list.size() > k || target < 0) {                   // 用list.size() (不是直接用k判断)判断是否需要在递归中返回。    //起到剪枝的作用, 返回更快。
			return;
		}
		if (target == 0 && list.size() == k) {
			al.add(new ArrayList<Integer>(list));
			return;
		}
		for (int i = index; i <= 9; i++) {
			list.add(i);
			process(i + 1, target - i, k);
			list.remove(list.size() - 1);
		}
	}
}
