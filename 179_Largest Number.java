// 本题注意结果中前置0的处理.
// 写法一
class Solution {
	public String largestNumber(int[] nums) {
		if (nums == null || nums.length == 0) {
			return "";
		}
		int len = nums.length;
		String s = "";
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int num : nums) {
			list.add(num);
		}

		Collections.sort(list, new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				String s1 = o1 + "" + o2;
				String s2 = o2 + "" + o1;
				return s2.compareTo(s1);
			}
		});

		if (list.get(0) == 0) {                  //注意，要加上这一行code, 否则无法通过leetcode上如下测试用例：
			return "0";
		}
		for (int num : list) {
			s += num;
		}
		return s;
	}
}

// 写法二
class Solution {
	public String largestNumber(int[] nums) {
		if (nums == null || nums.length == 0) {
			return "";
		}
		int len = nums.length;
		String[] str = new String[len];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {
			str[i] = String.valueOf(nums[i]);
		}
		Arrays.sort(str, new Comparator<String>() {
			public int compare(String s1, String s2) {
				String c1 = s1 + s2;
				String c2 = s2 + s1;
				return c2.compareTo(c1);
			}
		});

		if (str[0].equals("0")) {
			return "0";
		}

		for (int i = 0; i < len; i++) {
			sb.append(str[i]);
		}
		return sb.toString();
	}
}
