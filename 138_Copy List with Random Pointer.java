// 方法一
class Solution {
	public Node copyRandomList(Node head) {
		HashMap<Node, Node> map = new HashMap<Node, Node>();
		Node cur = head;
		while (cur != null) {
			map.put(cur, new Node(cur.val));
			cur = cur.next;
		}

		cur = head;

		while (cur != null) {
			map.get(cur).next = map.get(cur.next);
			map.get(cur).random = map.get(cur.random);
			cur = cur.next;
		}

		return map.get(head);
	}
}

// 方法二
class Solution {
	public Node copyRandomList(Node head) {
		if (head == null) {
			return null;
		}

		Node cur = head;
		Node next = null;

		while (cur != null) {
			next = cur.next;
			cur.next = new Node(cur.val);
			cur.next.next = next;
			cur = next;
		}

		cur = head;

		while (cur != null) {
			cur.next.random = cur.random == null ? null : cur.random.next;
			cur = cur.next.next;
		}

		Node res = head.next;
		Node curCopy = null;       //设置一个curCopy节点，表示复制链表的当前节点。

		cur = head;

		while (cur != null) {
			next = cur.next.next;
			curCopy = cur.next;
			cur.next = next;
			curCopy.next = next != null ? next.next : null;
			cur = next;
		}
		return res;
	}
}

