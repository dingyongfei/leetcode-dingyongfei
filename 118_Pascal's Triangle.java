//二项式定理
class Solution {
	public List<List<Integer>> generate(int row) {
		List<List<Integer>> al = new ArrayList<>();

		for (int i = 0; i < row; i++) {
			List<Integer> list = new ArrayList<Integer>();
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i) {
					list.add(1);
				} else {          //注意，if语句无返回，一定要写 else !!!
					int a = al.get(i - 1).get(j - 1);
					int b = al.get(i - 1).get(j);
					list.add(a + b);
				}
			}
			al.add(list);
		}
		return al;
	}
}
