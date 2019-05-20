class Solution {
	public int[] plusOne(int[] digits) {
		if (digits == null || digits.length == 0) {
			return new int[] { 1 };
		}
		int n = digits.length;
		for (int i = n - 1; i >= 0; i--) {
			if (digits[i] < 9) {
				digits[i] += 1;
				return digits;
			}
			digits[i] = 0;
		}
		int[] newArr = new int[n + 1];
		newArr[0] = 1;
		return newArr;
	}
}
