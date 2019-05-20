class Solution {
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> listAll = new LinkedList<>();
		if (nums == null | nums.length < 3) {
			return listAll;
		}

		Arrays.sort(nums); // 注意类似双指针的题目都要先排序！！
		for (int i = 0; i < nums.length; i++) {
			int l = i + 1;
			int r = nums.length - 1;
			int value = 0 - nums[i]; // 先固定一个变量，类似题目也是如此
			while (l < r) {
				if ((nums[l] + nums[r]) < value) {
					l++;
				} else if (nums[l] + nums[r] > value) {
					r--;
				} else {
					LinkedList<Integer> list = new LinkedList<>();
					while ((l + 1) < nums.length && nums[l] == nums[l + 1]) { // ---------注意此处数组下标越界的处理
						l++;
					}
					while ((r - 1) >= 0 && nums[r] == nums[r - 1]) { // ---------注意此处数组下标越界的处理
						r--;
					}
					while ((i + 1) < nums.length && nums[i] == nums[i + 1]) { // ---------注意此处数组下标越界的处理
						i++;
					}
					list.add(nums[i]);
					list.add(nums[l]);
					list.add(nums[r]);
					listAll.add(list);
					l++;
					r--;
				}
			}
		}
		return listAll;
	}
}
