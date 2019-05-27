class MyStack {
	private Queue<Integer> queue;
	private Queue<Integer> help;

	public MyStack() {
		this.queue = new LinkedList<Integer>();
		this.help = new LinkedList<Integer>();
	}

	public void push(int x) {
		queue.add(x); // 注：本题中所有操作只需在“ queue “上进行即可! 因为queue和help在所有操作的最后都互换好了!
	}

	public int pop() {
		if (queue.isEmpty()) {
			throw new RuntimeException("Stack is empty!");
		}
		while (queue.size() != 1) {
			help.add(queue.poll());
		}
		int res = queue.poll();
		swap();
		return res;
	}

	public int top() {
		if (queue.isEmpty()) {
			throw new RuntimeException("Stack is empty!");
		}
		while (queue.size() != 1) {
			help.add(queue.poll());
		}
		int res = queue.poll();
		help.add(res);
		swap();
		return res;
	}

	public boolean empty() {
		return queue.isEmpty();
	}

	public void swap() {
		Queue<Integer> tmp = queue;                     //注意，这里的写法.
		queue = help;
		help = tmp;
	}
}
