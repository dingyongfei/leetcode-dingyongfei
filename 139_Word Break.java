//和题 132 的解题思路相似，对照着看!
//方法一
class Solution {
	public boolean wordBreak(String str, List<String> dict) {
		Set<String> set = new HashSet<String>();
		boolean[] f = new boolean[str.length() + 1];
		f[0] = true;
		// 因为f[0] = true, 所以i要从1开始。
		for (int i = 1; i <= str.length(); i++) {
			for (int j = 0; j <= i; j++) {
				if (f[j] && dict.contains(str.substring(j, i))) {
					f[i] = true;
					break;
				}
			}
		}
		return f[str.length()];
	}
}

//方法二（理解更为直观一点的做法）
// dp[i] means: whether the string ending with s.charAt(i)element can be split.
……
