
// 本题可以和 69题 对照着看 !
class Solution {
	public int countPrimes(int n) {
		boolean[] notPrime = new boolean[n];
		int count = 0;
		for (int i = 2; i < n; i++) {
			if (notPrime[i] == false) {
				count++;
				for (int j = 2; i * j < n; j++) {   // 注意，这里的j一定要从j = 2开始 !!! 如果写成j从j = i开始的话，在for循环中的i * j < n条件中可能会造成溢出，即i * j > Integer.MAX_VALUE, 造成结果错误！
					notPrime[i * j] = true;
				}
			}
		}
		return count;
	}
}

//或者直接这样写 !!
class Solution {
	public int countPrimes(int n) {
		boolean[] notPrime = new boolean[n + 1];       //注意, 可能到达n, 所以数组长度设为n + 1 !!
		int count = 0;
		for (int i = 2; i < n; i++) {
			if (!notPrime[i]) {
				count++;
				for (int j = i; j <= n / i; j++) {     //注意, 是 “ <= ” !
					notPrime[i * j] = true;
				}
			}
		}
		return count;
	}
}
