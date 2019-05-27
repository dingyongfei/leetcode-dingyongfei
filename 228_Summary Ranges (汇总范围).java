// 真是非常简洁的写法! 
// for...while...
class Solution {
	public List<String> summaryRanges(int[] nums) {
		int len = nums.length;
		List<String> list = new ArrayList<String>(len);
// 从下标0开始, 从头到尾扫描一遍数组即可.
		for (int i = 0; i < len; i++) {
			// 新建一个临时变量num, 并且使 num = nums[i].
			int num = nums[i];
			while (i + 1 < len && nums[i] + 1 == nums[i + 1]) {
				i++;
			}
			if (num != nums[i]) {
				list.add(num + "->" + nums[i]);
			} else {
				list.add("" + nums[i]);
			}
		}
		return list;
	}
}

// self
class Solution {
	public List<String> summaryRanges(int[] nums) {
		List<String> list = new ArrayList<String>();
		if (nums == null || nums.length == 0) {
			return list;
		}
		int i = 0;
		int j = 1;
		while (i < nums.length) {
			int tmp = i;
			while (j < nums.length && nums[tmp] + 1 == nums[j]) {
				j++;
				tmp++;
			}
			if (tmp == i) {
				list.add(String.valueOf(nums[i]));
				i++;
				j++;
			} else {
				String str = String.valueOf(nums[i]);
				str = str + "-" + ">";
				str += String.valueOf(nums[j - 1]);
				list.add(str);
				i = j;
				j++;
			}
		}
		return list;
	}
}
