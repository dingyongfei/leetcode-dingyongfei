//zuochengyun  chapter5 回文最小分割数
// dp[i]的含义是子串str[i..len-1]至少需要切割几次，才能把str[i.. len-1]全部切成回文子串。那么，dp[O]就是最后的结果。
//假设j位置处在i与len-1位置之间（i＜=j＜len)，如果str[i..j]是回文串，那么dp[i]的值可能是dp[j+1]+1
// 让j在i到len-1位置上枚举，那么所有可能情况中的最小值就是dp[i]的值，即dp[i]= Min { dp[j+ 1]+ 1 (i<=j<len，且str[i..j]必须是回文串)}。
// 在计算dp数组的过程中，位置i是从右向左依次计算的。而对每一个i来说，又依次从i位置向右枚举所有的位置j(i<=j<len)，以此来决策出dp[i］的值。所以对p[i][j]来说，p[i+1][j-1]值一定已经计算过。
class Solution {
	public int minCut(String str) {
		if (str == null || str.equals("")) {
			return 0;
		}
		char[] chs = str.toCharArray();
		int len = chs.length;
		int[] dp = new int[len + 1];
		dp[len] = -1;
		boolean[][] p = new boolean[len][len];
		//因为dp[len] = -1, 所以i要从len – 1开始。
		for (int i = len - 1; i >= 0; i--) {
			dp[i] = Integer.MAX_VALUE;
			for (int j = i; j < len; j++) {
				if (chs[i] == chs[j] && (j - i < 2 || p[i + 1][j - 1])) {
					p[i][j] = true;
					dp[i] = Math.min(dp[i], dp[j + 1] + 1);
				}
			}
		}
		return dp[0];
	}
}
