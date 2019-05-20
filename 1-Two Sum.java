class Solution {
	public static int[] twoSum1(int[] nums, int target) {
		if (nums == null || nums.length < 2) {
			return new int[] { -1, -1 };
		}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			int value = target - nums[i];
			if (map.containsKey(value)) {
				return new int[] { map.get(value), i };
			}
			map.put(nums[i], i);
		}
		throw new IllegalArgumentException("No two sum Solution!");
	}

	public static int[] twoSum2(int[] nums, int target) {
		if (nums == null || nums.length < 2) {
			return new int[] { -1, -1 };
		}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		for (int i = 1; i < nums.length; i++) {
			int value = target - nums[i];
			if (map.containsKey(value) && map.get(value) != i) {
				return new int[] { i, map.get(value) };
			}
		}
		throw new IllegalArgumentException("No two sum Solution!");
	}
}
