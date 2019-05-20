class Solution {
	public void reorderList(ListNode head) {
		if (head == null || head.next == null || head.next.next == null) {
			return;
		}
		ListNode rHead = head;
		ListNode fast = head;
		ListNode slow = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		ListNode sep = slow.next;
		slow.next = null;

		ListNode pre = null;
		ListNode next = null;
		while (sep != null) {
			next = sep.next;
			sep.next = pre;
			pre = sep;
			sep = next;
		}

		ListNode next1 = null;
		while (head.next != null && pre.next != null) {
			next = head.next;
			next1 = pre.next;
			head.next = pre;
			pre.next = next;
			head = next;
			pre = next1;
		}
		if (head.next != null) {
			ListNode tail = head.next;
			head.next = pre;
			pre.next = tail;
		} else {
			head.next = pre;
			//pre.next = null;
		}
		return;
	}
}
