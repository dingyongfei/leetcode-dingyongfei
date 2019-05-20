//Just to let you know that Java has the operator ">>>" to perform logical right shifts, but because the logical and arithmetic left-shift operations are identical, there is no "<<<" operator in Java. For those of you who are confused.

//小结: 无需多想, i 从 0 ~ 31 共32 位数直接转即可 !!
class Solution {
	// you need treat n as an unsigned value
	public int reverseBits(int n) {
		int res = 0;
		for (int i = 0; i < 32; i++) {          // 共有32位
			int end = n & 1;
			//重点: 先移位, 再标记 !
			res <<= 1;                       // 依然是注意这两行code的顺序.
			res |= end;            
			n >>= 1;
		}
		return res;
	}
}
