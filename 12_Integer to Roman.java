class Solution {
	public String intToRoman(int num) {
		if (num < 1 || num > 3999) {
			return "";
		}

		StringBuilder sb = new StringBuilder();
		String[] roman = new String[] { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
		int[] values = new int[] { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		for (int i = 0; i < values.length; i++) {
			while (num >= values[i]) {        // 类似于栈混洗
				num -= values[i]; 
				sb.append(roman[i]);
			}
			if (num == 0) {
				break;
			}
		}
		return sb.toString();
	}
}
