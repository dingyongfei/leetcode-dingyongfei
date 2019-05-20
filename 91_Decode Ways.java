// 如果str只由字符’1’和字符’2’组成， 比如” 12121121212122 ”, 那么就可以使用矩阵乘法的方法将时间复杂度优化为O(logN)。 因为str[i]都可以单独转换成字母, str[i.. i+1]也都可以一起转换成字母, 此时一定有 p(i)=p(i+1)+p(i+2)。总之, 可以使用矩阵乘法的前提是递归表达式不会发生转移。
// 和题 198相似，重点都是要注意临界值的处理!!
class Solution {
	public int numDecodings(String str) {
		if (str == null || str.equals("")) {
			return 0;
		}
		char[] chs = str.toCharArray();
		int cur = chs[chs.length - 1] == '0' ? 0 : 1;
		int pre = 1;                   //注意这里的技巧，将pre初始值，即(i == chs.length)时的值设为1!
		int tmp = 0;
		for (int i = chs.length - 2; i >= 0; i--) {
			if (chs[i] == '0') {
				pre = cur;
				cur = 0;
			} else {
				tmp = cur;
				if ((chs[i] - '0') * 10 + chs[i + 1] - '0' < 27) {
						cur += pre;                              //分析：cur = cur + pre, “cur“相当于” process(chs, i+1) ”（pre相当于process(chs, i+2)），本方法采用了类似于Fibonacci数列求解的过程，从后往前递推着计算，最终求得结果。
				}
				pre = tmp;
			}
		}
		return cur;
	}
}

/*
//暴力递归方法：
class Solution {
	public int numDecodings(String str) {
		if (str == null || str.equals("")) {
			return 0;
		}
		char[] chs = str.toCharArray();
		return process(chs, 0);
	}

	public int process(char[] chs, int i) {
		int res = 0;
		if (i == chs.length) {
			return 1;
		}
		if (chs[i] == '0') {
			return 0;
		}
		res += process(chs, i + 1);
		if (i + 1 < chs.length && (chs[i] - '0') * 10 + chs[i + 1] - '0' < 27) {
			res += process(chs, i + 2);
		}
		return res;
	}
}
*/
