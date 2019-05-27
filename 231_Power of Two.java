// Power of 2 means only one bit of n is '1', so use the trick n & (n - 1) == 0 to judge whether that is the case
class Solution {
	public boolean isPowerOfTwo(int n) {
		if (n <= 0) {                       // 注意, base case.
			return false;
		}
		return (n & (n - 1)) == 0;
	}
}

// 和剑指offer ” 11.输入一个整数，输出该二进制中表示1的个数。其中负数用补码表示。” 很相似.
class Solution {
	public int NumberOf1(int n) {
		int count = 0;
		while (n != 0) {
			count++;
			n = n & (n - 1);
		}
		return count;
	}
}
