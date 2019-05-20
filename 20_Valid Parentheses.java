class Solution {
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		char[] chs = s.toCharArray();
		for (char c : chs) {
			if (c == '(') {
				stack.push(')');
			} else if (c == '[') {
				stack.push(']');
			} else if (c == '{') {
				stack.push('}');
			} else {
				if (!stack.isEmpty() && c == stack.peek()) {
					stack.pop();
				} else {
					stack.push(c); // 注：这里有个if...else...结构
				}
			}
		}
		return stack.isEmpty();
	}
}
