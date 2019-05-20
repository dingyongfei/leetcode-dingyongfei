//和子数组最大和一样，还是两个变量
//统一写成以下格式（和 229. Majority Element II 一样的格式）
class Solution {
	public int majorityElement(int[] nums) {
		int n = nums.length;
		if (n == 0)
			return 0;
		int num = nums[0];
int cnt = 0;
		for (int i = 0; i < nums.length; i++) {
			if (num == nums[i])
				cnt++;
			else if (cnt == 0) {
				num = nums[i];
				cnt = 1;
			} else
				cnt--;

		}

		//verify
		cnt = 0;
		for (int i = 0; i < nums.length; i++) {
			if (num == nums[i])
				cnt++;
			if (cnt * 2 > n)
				return num;
		}
		return 0;
	}
}
