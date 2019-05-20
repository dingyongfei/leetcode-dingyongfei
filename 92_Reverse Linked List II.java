class Solution {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null) {
			return head;
		}
		ListNode before = head;
		ListNode last = head;
		ListNode first = null;
		ListNode after = null;

		if (m == 1) {
			before = null;
			first = head;
		} else {
			for (int i = 1; i < m - 1; i++) {
				before = before.next;
			}
			first = before.next;
		}

		for (int i = 1; i < n; i++) {
			last = last.next;
		}
		after = last.next;

		reverse(first, after);

		if (before == null) {
			first.next = after;
			return last;
		} else {
			before.next = last;
			first.next = after;
			return head;
		}
	}

	public void reverse(ListNode first, ListNode after) {
		ListNode next = null;
		ListNode pre = null;
		while (first != after) {
			next = first.next;
			first.next = pre;
			pre = first;
			first = next;
		}
	}
}
