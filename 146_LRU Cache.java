// map中的key是key, value是双向链表中的节点Node<K, V> , 双向链表中的Node既含有key, 也含有value
//一张表的效率会比两张表快一些（因为Hash表的常数项比较大）

//本题重要小结：
//1. 每个有关于添加、删除的操作都要调整尾节点（this.tail）
//2. 每个涉及到添加的操作都是” 先连接节点，再调整尾指针 ” ; 每个涉及到删除的操作都是” 先调整头（尾）指针，再连接节点 ”
//3. moveNodeToTail(Node node) 方法分三种情况讨论; 
//4. addNode(Node newNode) 方法和 removeHead() 方法对称, 都是分两种情况讨论。

class LRUCache {
	private HashMap<Integer, Node> keyNodeMap;
	// private HashMap<Node<V>, K> nodeKeyMap;
	private NodeDoubleLinkedList nodeList;
	private int capacity;

	public LRUCache(int capacity) {
		if (capacity < 1) {
			throw new RuntimeException("should be more than 0.");
		}
		this.keyNodeMap = new HashMap<Integer, Node>();
		// this.nodeKeyMap = new HashMap<Node<V>, K>();
		this.nodeList = new NodeDoubleLinkedList();
		this.capacity = capacity;
	}

	public int get(int key) {
		if (this.keyNodeMap.containsKey(key)) {
			Node res = this.keyNodeMap.get(key);
			this.nodeList.moveNodeToTail(res);
			return res.value;
		}
		return -1;
	}

	public void put(int key, int value) {
		if (this.keyNodeMap.containsKey(key)) {
			Node node = this.keyNodeMap.get(key);
			node.value = value;
			this.nodeList.moveNodeToTail(node);
		} else {
			Node newNode = new Node(key, value);
			this.keyNodeMap.put(key, newNode);
			// this.nodeKeyMap.put(newNode, key);
			this.nodeList.addNode(newNode);
			if (this.keyNodeMap.size() == this.capacity + 1) {
				this.removeMostUnusedCache();
			}
		}
	}

	private void removeMostUnusedCache() {
		Node removeNode = this.nodeList.removeHead();
		// K removeKey = this.nodeKeyMap.get(removeNode);
		int removeKey = removeNode.key;
		// this.nodeKeyMap.remove(removeNode);
		this.keyNodeMap.remove(removeKey);
	}

	public static class Node {
		public int key;
		public int value;
		public Node last;
		public Node next;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	public static class NodeDoubleLinkedList {
		private Node head;
		private Node tail;

		public NodeDoubleLinkedList() {
			this.head = null;
			this.tail = null;
		}

		// 先连接节点，再调整尾指针
		public void addNode(Node newNode) {
			if (newNode == null) {
				return;
			}
			if (this.head == null) {
				this.head = newNode;
				this.tail = newNode;
			} else {
				this.tail.next = newNode;
				newNode.last = this.tail;
				this.tail = newNode;
			}
		}

		// 分情况讨论:1. 尾 ; 2. 头; 3. 一般情况
		// 先调整头（尾）指针，再连接节点
		public void moveNodeToTail(Node node) {
			if (this.tail == node) {
				return;
			}
			if (this.head == node) {
				this.head = node.next;
				this.head.last = null;
			} else {
				node.last.next = node.next;
				node.next.last = node.last;
			}
			node.last = this.tail;
			node.next = null;
			this.tail.next = node;
			this.tail = node;
		}

		public Node removeHead() {
			/*
			 * if (this.head == null) { return null; }
			 */
			Node res = this.head;
			if (this.head == this.tail) { 
				this.head = null;
				this.tail = null;
			} else {
				this.head = res.next;
				res.next = null;
				this.head.last = null;
			}
			return res;
		}
	}
}
