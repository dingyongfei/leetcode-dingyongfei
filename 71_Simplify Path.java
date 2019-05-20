//使用栈来做
class Solution {
	public String simplifyPath(String path) {
		Deque<String> stack = new LinkedList<String>(); // 使用Deque结构作为栈，直接从栈尾弹出元素，以顺序地连接成路径字符串！

		Set<String> set = new HashSet<String>(Arrays.asList("", ".", "..")); // 注意，这里的简便写法。也可以写成
		// 注意，String类型的数组split操作完成后，在数组中会留下 ""(注意，不是" "!!!!!!)，一定要排除这种情况！！！！！
		String[] str = path.split("/"); // Arrays.asList(new String[]{"", ".", ".."});
		for (String s : str) {
			if (!stack.isEmpty() && s.equals("..")) {
				stack.pop();
			} else if (!set.contains(s)) {
				stack.push(s);
			}
		}
		if (stack.isEmpty()) { // 注意，这里需要判空，以决定当栈为空时需不需要直接返回"/"！！！
			return "/";
		}
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append("/" + stack.pollLast());
		}
		return sb.toString();
	}
}
