class Solution {
//双指针，前后指针。1. 开始时从right指针走 ---> 2. 遇到满足条件的停下，left指针向右缩，缩不动时记下结果，更新最小值，且left++ ---> 3. 最后right++，准备继续下一轮的移动
	public String minWindow(String s, String t) {
		if (s == null || t == null || s.length() < t.length()) {
			return "";
		}
		char[] chs1 = s.toCharArray();
		char[] chs2 = t.toCharArray();
		int[] map = new int[256];
		for (char c : chs2) {
			map[c]++;
		}
		int left = 0;
		int right = 0;
		int match = chs2.length;
		int min = Integer.MAX_VALUE;
		int l = left;
		int r = right;
		boolean flag = false;
		while (right != chs1.length) {
			map[chs1[right]]--;
			if (map[chs1[right]] >= 0) {
				match--;
			}
			if (match == 0) {
				while (map[chs1[left]] < 0) {
					map[chs1[left++]]++;
				}
				/*
				 * while(map[chs1[left++]]<0) {       //Fuck,man!!!!!!!  错误的写法，数组下标越界异常！(11题遇到了同样的错误)
				 * 	   map[chs1[left]]++;             
				 * }
				 */
				if (right - left + 1 < min) {
					l = left;
					r = right;
					min = right - left + 1;
					flag = true;
				}
				match++;
				map[chs1[left++]]++;     // 至此，关于位置right结尾的情况下的最短窗口子串己经找到。同时从left位置开始的最短窗口子串也是
										// chs1[left.right］。所以，之后如果更小的窗口子串也一定不会从left的位置开始，而是从left之后的位置(即left++)开始。
			}
			right++;
		}
		if (!flag)
			return "";
		else
			return s.substring(l, r + 1);
	}
}
