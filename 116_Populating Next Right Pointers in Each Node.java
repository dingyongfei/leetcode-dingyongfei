//和剑指题“ 58.实现一个函数，用来判断一棵对称的。”非常类似   （注意题目中的条件： 是一棵满二叉树）
class Solution {
	public Node connect(Node root) {
		if (root == null)
			return root;
		connectNodes(root.left, root.right);
		return root;
	}

	public void connectNodes(Node node1, Node node2) {
		if (node1 == null || node2 == null) {
			return;
		}
		
		node1.next = node2;

		connectNodes(node1.right, node2.left);
		connectNodes(node1.left, node1.right);
		connectNodes(node2.left, node2.right);
	}
}

//方法二 （brilliant solution）
class Solution {
	public Node connect(Node root) {
		if (root == null) {
			return null;
		}
		Node pre = root;
		Node cur = null;

		while (pre.left != null) {
			cur = pre;
			while (cur != null) {
				cur.left.next = cur.right;
				if (cur.next != null)
					cur.right.next = cur.next.left;
				cur = cur.next;
			}
			pre = pre.left;
		}
		return root;
	}
}
