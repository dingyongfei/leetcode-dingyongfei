// Integer.valueOf() & Integer.parseInt() !：valueOf(String) returns a new Integer() object whereas parseInt(String) returns a primitive int.
/**
Java中的 split  函数是用于按指定字符（串）或正则去分割某个字符串，结果以字符串数组形式返回；
对于分割的字符(串)，通常是常见，普通的，没什么问题；
但是对某些特殊字符，如果字符(串)正好是正则的一部分，则需要转义才能使用，
这些字符有 | , + , * , ^ , $ , / , | , [ , ] , ( , ) , - , . , \等, 
因它们是正则表达式中的一部分, 所以如果想用该字符本身, 这些字符需要进行转义才能表示它本身；          
*/

class Solution {
	public int compareVersion(String version1, String version2) {
		String[] s1 = version1.split("\\.");
		String[] s2 = version2.split("\\.");

		int len = Math.max(s1.length, s2.length);
		for (int i = 0; i < len; i++) {
			Integer o1 = i < s1.length ? Integer.valueOf(s1[i]) : 0;  //-------> clever writing! 
			Integer o2 = i < s2.length ? Integer.parseInt(s2[i]) : 0;
			int compare = o1.compareTo(o2);              //在方法 compareTo 中，o1和o2的类型只能为” Integer ”型, 不能为 int !！
			if (compare != 0) {                         //compare == 0 时继续比较.
				return compare;
			}
		}
		return 0;
	}
}
