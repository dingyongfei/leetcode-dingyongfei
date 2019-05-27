// Boyer-Moore投票算法
// 和题169相似
// if...else if...else...
class Solution {
	public List<Integer> majorityElement(int[] nums) {
		List<Integer> list = new ArrayList<Integer>();
		if (nums == null || nums.length == 0) {
			return list;
		}
		int n1 = nums[0];
		int n2 = nums[0];
		int count1 = 0;
		int count2 = 0;
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			if (nums[i] == n1) {
				count1++;
			} else if (nums[i] == n2) {
				count2++;
			} else if (count1 == 0) {
				n1 = nums[i];
				count1 = 1;
			} else if (count2 == 0) {
				n2 = nums[i];
				count2 = 1;
			} else {
				count1--;
				count2--;
			}
		}

		// verify
		count1 = 0;
		count2 = 0;
		for (int num : nums) {
			if (n1 == num) {
				count1++;
			} else if (n2 == num) {
				count2++;
			}
		}

		if (count1 > len / 3) {
			list.add(n1);
		}
		if (count2 > len / 3) {
			list.add(n2);
		}
		return list;
	}
}
