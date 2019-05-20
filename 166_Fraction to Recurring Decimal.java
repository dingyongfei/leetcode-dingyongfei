//本题重点总结：
//1. Map<Long, Integer> 的 key 记录的是每一位小数; value 记录的是每一位小数出现在整个StringBuilder中的位置 !!!
//2. 两处判断 “ n == 0 ” !
class Solution {
	public String fractionToDecimal(int numerator, int denominator) {
		if (numerator == 0 || denominator == 0) {
			return "0";
		}
		StringBuilder sb = new StringBuilder();

//特别注意, 本题先取符号位, 后面所有的数(包括整数和小数都统一用绝对值处理), 这样的方法十分方便!!! 否则处理会比较棘手!!

		String sign = (numerator > 0) ^ (denominator > 0) ? "-" : "";
		sb.append(sign);

		//注意！用long类型是防止溢出：当numerator或denominator为Integer.MIN_VALUE时， 进行abs操作会溢出，所以这里一定用long类型！！
		long n = Math.abs((long) numerator);
		long d = Math.abs((long) denominator);

		//处理整数部分
		sb.append(n / d);
		n %= d;
		if (n == 0) {                      //第一处” n == 0 ”判断
			return sb.toString();
		}
		sb.append(".");

		//用map保存小数部分的每一个数。开始时map中记录的是小数部分的第一个小数（每一次余数*10， 再求余）出现的位置，所以，一旦后面第二次出现了和第一位小数相同的小数，跳出循环，将“(”和“)”分别插入sb即可。
		Map<Long, Integer> map = new HashMap<Long, Integer>();

		//开始处理小数部分
		while (n != 0) {                // (第二处” n == 0 ” 判断)-----> 这里必须写作” n!=0 ”, 否则类似如下的test case是不能通过的 ：！！ ‘

			map.put(n, sb.length());

			//每一次余数 *10, 再求余 !!!
			n *= 10;
			sb.append(n / d);
			n %= d;
			if (map.containsKey(n)) {
				sb.insert(map.get(n), "(");
				sb.append(")");
				break;
			}
		}
		return sb.toString();
	}
}
