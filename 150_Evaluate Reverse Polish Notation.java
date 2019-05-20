//和 “ 20. Valid Parentheses ”题类似。可以自己做对比
class Solution {
	public int evalRPN(String[] tokens) {
		int a = 0;
		int b = 0;
		Stack<Integer> stack = new Stack<Integer>();

		for (String s : tokens) {
			if (s.equals("+")) {
				a = stack.pop();
				b = stack.pop();
				stack.add(a + b);
			} else if (s.equals("-")) {
				b = stack.pop();                      //先出栈的放右边，后出栈的放左边!
				a = stack.pop();
				stack.add(a - b);
			} else if (s.equals("*")) {
				a = stack.pop();
				b = stack.pop();
				stack.add(a * b);
			} else if (s.equals("/")) { 
				b = stack.pop();                 //注意这两处的栈中元素弹出顺序，  是相反的！！
				a = stack.pop();
				stack.add(a / b);
			} else {
				stack.add(Integer.valueOf(s));
			}
		}
		return stack.pop();          // 不需要类型转化，因为stack是Integer类型
	}
}
