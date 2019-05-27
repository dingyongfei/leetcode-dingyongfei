// 题168 & 171重要小结: 和 字符串-> 整数 以及 整数 -> 字符串 的思想一模一样, 不同的是每次余数都要相应地加 1 和减 1！
// 对应于题168。是题目168的相反过程。对应地，每次余数都 +1
class Solution {
	public int titleToNumber(String str) {
		if (str == null || str.equals("")) {
			return 0;
		}
		char[] c = str.toCharArray();
		int res = 0;
		for (int i = 0; i < c.length; i++) {
			res = res * 26 + c[i] - 'A' + 1;           // 每次余数都 +1
		}
		return res;
	}
}
//看，整个过程 和” 字符串和整数之间的相互转化 “是非常类似的， 区别就是该题相当于”26进制”的数字，而普通的字符串和整数之间的相互转化题是10进制。
