//方法一：我们把整个过程看作是一个构造链表的过程。
class Solution {
	public ListNode removeElements(ListNode head, int val) {
		if (head == null) {
			return head;
		}
		while (head != null && head.val == val) {           // 首先删除链表开头所有等于val的节点
			head = head.next;
		}
		if (head == null) {
			return null;
		}
		ListNode rHead = head;
		ListNode cur = head;
		while (cur != null) {
			cur = cur.next;
			if (cur != null && cur.val == val) {
				continue;
			}
			head.next = cur;
			head = cur;                                // 少写了这一步！
		}
		return rHead;
	}
}

//方法二
//方法二和83题极其相似！！！一定对比着看！
class Solution {
	public ListNode removeElements(ListNode head, int val) {
		if (head == null) {
			return head;
		}
		while (head != null && head.val == val) {          //首先删除链表开头所有等于val的节点
			head = head.next;
		}
		if (head == null) {
			return null;
		}
		ListNode pre = head;
		ListNode cur = head;
		while (cur != null) {
			if (cur.val == val) {
				pre.next = cur.next;
			} else {
				pre = cur;
			}
			cur = cur.next;
		}
		return head;
	}
}

//方法三  和 83题方法完全相同的方法！！！
class Solution {
	public ListNode removeElements(ListNode head, int val) {
		if (head == null) {
			return null;
		}
		while (head != null && head.val == val) {
			head = head.next;
		}
		if (head == null) {
			return null;
		}
		ListNode cur = head;
		while (cur.next != null) {
			if (cur.next.val == val) {
				cur.next = cur.next.next;
			} else {
				cur = cur.next;
			}
		}
		return head;
	}
}
