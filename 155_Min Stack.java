class MinStack {
	private Stack<Integer> dataStack;
	private Stack<Integer> minStack;

	public MinStack() {
		dataStack = new Stack<Integer>();
		minStack = new Stack<Integer>();
	}

	public void push(int x) {
		dataStack.push(x);
		if (minStack.isEmpty() || minStack.peek() > x) {          //写错的地方
			minStack.push(x);
		} else {
			minStack.push(minStack.peek());
		}
	}

	public void pop() {
		minStack.pop();            // 注意，要同步pop() minStack中的元素。
		dataStack.pop();
	}

	public int top() {
		return dataStack.peek();
	}

	public int getMin() {
		return minStack.peek();
	}
} 
