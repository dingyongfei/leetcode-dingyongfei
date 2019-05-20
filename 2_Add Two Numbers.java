class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null) {
			return null;
		}
		ListNode head = null;
		ListNode cur = null;
		int carry = 0;
		while (l1 != null || l2 != null) {
			int num1 = l1 == null ? 0 : l1.val;
			l1 = l1 == null ? null : l1.next;
			int num2 = l2 == null ? 0 : l2.val;
			l2 = l2 == null ? null : l2.next;
			int sum = num1 + num2 + carry;
			carry = sum / 10;
			if (head == null) {
				head = cur = new ListNode(sum % 10);
			} else {
				cur.next = new ListNode(sum % 10);
				cur = cur.next;
			}
		}

		if (carry > 0) {
			cur.next = new ListNode(carry); // 注意，必须要有这一步，否则：
		}
		return head;
	}
}
