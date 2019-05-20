class Solution {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int buy1 = Integer.MAX_VALUE;
		int sell1 = 0;
		int buy2 = Integer.MAX_VALUE;
		int sell2 = 0;
		for (int p : prices) {
			buy1 = Math.min(buy1, p);
			sell1 = Math.max(sell1, p - buy1);
			buy2 = Math.min(buy2, p - sell1);
			sell2 = Math.max(sell2, p - buy2);
		}
		return sell2;
	}
}
