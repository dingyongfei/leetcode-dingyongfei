//给定范围[m，n]: 其中0 <= m <= n <= 2147483647, 返回此范围内所有数字的按位与, 包括端值。
//即找到 m~n 范围内公共前缀都为 1的最右位置

// 解决方法: 先从右向左右移找到第一位二进制不同的位; 再左移回去(即从该位开始尾部都变为0)。
class Solution {
	public int rangeBitwiseAnd(int m, int n) {
		int i = 0;                     // i means we have how many bits are 0 on the right.
		while (m != n) {
			m >>= 1;
			n >>= 1;
			i++;
		}
		return m << i;
	}
}
