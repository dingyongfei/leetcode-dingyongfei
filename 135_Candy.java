//zuochengyun chapter 9 分糖果问题
// 1. 数组中所有元素都设为1 
// 2. 先从左向右扫描，如果右边元素比左边相邻的大，则candies[i] = (candies[i - 1] + 1) 
// 3. 再从右向左扫描，如果左边元素比右边相邻的大，则candies[i] = candies[i + 1] + 1) 
//4. 关于左右两边”交界”处的问题，则和zcy chapter9中的分糖果问题一样处理，即“左坡和右坡坡度取较大的那边的值”，即” candies[i] = Math.max(candies[i], (candies[i + 1] + 1)) “

//excellent solution !!
//此解决方案也适用于数组中含有重复元素的情形!!
class Solution {
	public int candy(int[] ratings) {
		int[] candies = new int[ratings.length];
		/* Arrays.fill(candies, 1); */

		//initail
		for (int i = 0; i < candies.length; i++) {
			candies[i] = 1;
		}

		for (int i = 1; i < candies.length; i++) {
			if (ratings[i] > ratings[i - 1])
				candies[i] = candies[i - 1] + 1;
		}

		for (int i = candies.length - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1])
				candies[i] = Math.max(candies[i], candies[i + 1] + 1);
		}

		int res = 0;
		for (int c : candies) {
			res += c;
		}
		return res;
	}
}
