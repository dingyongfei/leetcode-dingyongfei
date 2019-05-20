class Solution {
	public String multiply(String num1, String num2) {
		if (num1.isEmpty() || num2.isEmpty()) {
			return "";
		}

		int len1 = num1.length();
		int len2 = num2.length();
		int[] res = new int[len1 + len2];

		// 从后往前计算并累加每一位的和
		for (int i = len1 - 1; i >= 0; i--) {
			for (int j = len2 - 1; j >= 0; j--) {
				int d1 = num1.charAt(i) - '0';
				int d2 = num2.charAt(j) - '0';
				res[i + j + 1] += d1 * d2; // 必须是i + j + 1 !!
			}
		}

		// 从后往前计算进位
		int carry = 0;
		for (int i = res.length - 1; i >= 0; i--) {
			int sum = res[i] + carry;
			carry = sum / 10;
			res[i] = sum % 10;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = res[0] == 0 ? 1 : 0; i < res.length; i++) {
			if (res[0] == 0 && res[1] == 0) { // 注意标红这一块，for循环和第一个if判断（如结果是2048，所以只能是->res[0]==0&&res[1]==0）只能这么写。
				return "0";
			}
			sb.append(res[i]);
		}
		return sb.toString();
	}

}
