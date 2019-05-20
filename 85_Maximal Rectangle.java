//单调栈题目
//以矩阵的每一行为底的情况下，找到其中内部都是1的最大的长方形。
//类似于剑指offer“21. 判断是否是栈混洗”！！！
//数组中所有元素都加入到单调栈中并处理结算好后，栈中可能会剩余一些数组元素，需要继续处理！
class Solution {
	public int maximalRectangle(char[][] map) {
		if (map == null || map.length == 0 || map[0] == null || map[0].length == 0) {
			return 0;
		}		
int maxArea = 0;
		int[] height = new int[map[0].length];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				height[j] = map[i][j] == '0' ? 0 : height[j] + 1;
			}
			maxArea = Math.max(maxRectFromBottom(height), maxArea);
		}
		return maxArea;
	}

	public int maxRectFromBottom(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}		
int maxArea = 0;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < height.length; i++) {
			while (!stack.isEmpty() && height[i] <= height[stack.peek()]) {
				int j = stack.pop();
				int k = stack.isEmpty() ? -1 : stack.peek();
				int curArea = (i - k - 1) * height[j];
				maxArea = Math.max(maxArea, curArea);
			}
			stack.push(i);
		}
		while (!stack.isEmpty()) {
			int j = stack.pop();
			int k = stack.isEmpty() ? -1 : stack.peek();
			int curArea = (height.length - k - 1) * height[j];
			maxArea = Math.max(maxArea, curArea);
		}
		return maxArea;
	}
}
