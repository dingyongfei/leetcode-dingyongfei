// 方法一
// 1. 如果数组中有两个出现了奇数次的数, 最终的eO一定不等于0; 2. 那么肯定能在32位整数eO上找到一个不等于0的bit位. 假设第k位不等于0.eO在第k位不等于0, 说明a和b的第k位肯定一个是1另一个是0.
// 简便的写法:
class Solution {
	public int[] singleNumber(int[] nums) {
		int eO = 0, eOhasOne = 0;
		for (int curNum : nums) {
			eO ^= curNum;
		}

		// 注意此处的写法!
		int rightOne = eO & (~eO + 1);                // “ ~ “ 是取反操作
		for (int cur : nums) {
			if ((cur & rightOne) != 0) {                // 注意，这里只能写 “ != 0 “, 不能错写成 “ == 1 “ !!! 
				eOhasOne ^= cur;                         // eOhasOne是答案的其中之一.
			}
		}
		return new int[] { eOhasOne, eO ^ eOhasOne };   // 则eO ^ eOhasOne是另一个答案.
	}
}



// 方法二
// 找到两个数字不同的那一位,同时根据这一位做数组的划分
// 位运算符号^，相同为0， 不同为1.
public class Solution  {
	public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
		if (array == null || array.length < 2) 
			return;
		int temp = 0;
		for (int i = 0; i < array.length; i++) 
			temp ^= array[i];
		int indexOf1 = findFirstBitls(temp);
		for (int i = 0; i < array.length; i++) {
			if (isBit(array[i], indexOf1)) 
				num1[0] ^= array[i];
			else 
				num2[0] ^= array[i];
		}
	}
	
	public int findFirstBitls(int num) {
		int indexBit = 0;
		while(((num & 1) == 0) && (indexBit) < 8 * 4) {
			num = num >> 1;                     // -----不能写成num >>= 1;
			++indexBit;
		}
		return indexBit;
	}
	
	public boolean isBit(int num, int indexBit) {
		num = num >> indexBit;
		return (num & 1) == 1;
	}
}



