class Solution {
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null || k <= 0) {
			return head;
		}
		ListNode pre = null;
		ListNode last = null;
		int len = 0;
		ListNode cnt = head;
		while (cnt != null) {
			cnt = cnt.next;
			len++;
		}
		for (int i = 1; i <= k % len; i++) { // 注意，要对链表长度取模，否则会产生Time Limit Exceeded！！
			ListNode cur = head;
			while (cur.next.next != null) {
				cur = cur.next;
			}
			pre = cur;
			last = cur.next;
			pre.next = null;
			last.next = head;
			head = last;
		}
		return head;
	}
}
