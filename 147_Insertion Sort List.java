class Solution {

	public ListNode insertionSortList(ListNode head) {
		if (head == null)
			return head;
		ListNode cur = head.next;
		ListNode pre = head;
		while (cur != null) {
			if (pre.val <= cur.val)
				pre = cur;
			else {
				ListNode after = head;
				ListNode before = null;
				while (after != cur && after.val < cur.val) {
					before = after;
					after = after.next;
				}
				pre.next = cur.next;
				if (before == null)
					head = cur;
				else
					before.next = cur;
				cur.next = after;
			}
			cur = pre.next;
		}
		return head;
	}
}
