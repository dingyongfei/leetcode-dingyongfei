class Solution {
	public int maxPoints(int[][] points) {
		if (points.length == 0 || points[0].length == 0) {
			return 0;
		}
		int res = 0;
		Map<String, Integer> map = new HashMap<String, Integer>();

		for (int i = 0; i < points.length; i++) {
			int max = 0;
			int overlap = 0;
			map.clear();
			for (int j = i + 1; j < points.length; j++) {    //注：j直接从 i+1 开始遍历计算, 因为i之前的所有点与i之间的斜率 已经在之前....计算过了。
				int x = points[j][0] - points[i][0];
				int y = points[j][1] - points[i][1];
				if (x == 0 && y == 0) {
					overlap++;
					continue;
				}
				int gcd = findGCD(x, y);
				if (gcd != 0) {
					x /= gcd;
					y /= gcd;
				}
				String key = x + "_" + y;
				if (map.containsKey(key)) {
					map.put(key, map.get(key) + 1);
				} else {
					map.put(key, 1);
				}
				max = Math.max(max, map.get(key));
			}
			res = Math.max(res, max + overlap + 1);
		}
		return res;
	}

	//欧几里得在其《几何原本》中提出的欧几里得算法, 又称为辗转相除法。
//具体做法为：如果q和r分别是m除以n的商和余数,即 m = n * q + r , 那么 m 和 n 的最大公约数等于n 和 r 的最大公约数, 详细证明略。
	private int findGCD(int a, int b) {                 //zcy 一行代码求两个数的最大公约数
		if (b == 0)
			return a;
		return findGCD(b, a % b);
	}
}
