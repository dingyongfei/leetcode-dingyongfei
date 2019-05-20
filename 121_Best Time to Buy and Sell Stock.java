class Solution {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int len = prices.length;
		int low = Integer.MAX_VALUE;
		int res = 0;
		for (int i = 0; i < len; i++) {
			low = Math.min(low, prices[i]);                     //每一次循环都记录当前出现过的最小值，并更新当前的利润
			res = Math.max(res, prices[i] - low);
		}
		return res;
	}
}
