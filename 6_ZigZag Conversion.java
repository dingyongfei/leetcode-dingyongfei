class Solution {
	public String convert(String s, int numRows) {
		char[] c = s.toCharArray();
		int len = s.length();
		StringBuffer[] sb = new StringBuffer[numRows]; // 注意，此题全部用StringBuffer()进行操作，很方便处理
		for (int i = 0; i < sb.length; i++) {
			sb[i] = new StringBuffer();
		}

		int i = 0;
		while (i < len) {
			for (int index = 0; index < numRows && i < len; index++) {
				sb[index].append(c[i++]);
			}
			for (int index = numRows - 2; index >= 1 && i < len; index--) {
				sb[index].append(c[i++]);
			}
		}

		for (int index = 1; index < numRows; index++) {
			sb[0].append(sb[index]);
		}
		return sb[0].toString();
	}
}
