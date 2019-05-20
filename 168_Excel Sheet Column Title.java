// 题168 & 171重要小结: 和 字符串-> 整数 以及 整数 -> 字符串 的思想一模一样, 不同的是每次余数都要相应地加 1 和减 1！
// 类似于 “ 字符串转整数 “，不同的是每次余数都 -1
class Solution {
	public String convertToTitle(int n) {
		if (n < 1) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		while (n > 0) {
			n--;                 // 每次余数都 -1
			sb.append((char) ('A' + n % 26));
			n /= 26;
		}
		sb.reverse();
		return sb.toString();
	}
}
