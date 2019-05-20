class Solution {
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {          // 相当于“ if(l==r) return; ”
			return head;
		}
		ListNode fast = head;
		ListNode slow = head;
		while (fast.next != null && fast.next.next != null) {      //寻找链表中间节点的写法！！
			fast = fast.next.next;
			slow = slow.next;
		}

		ListNode h2 = sortList(slow.next);
		slow.next = null;                // 关键的一步，分界处，相当于 mid。且这一行的code 的位置只能在这里，注意！！
		ListNode h1 = sortList(head);

		return merge(h1, h2);
	}

	public ListNode merge(ListNode list1, ListNode list2) {
		ListNode mergeHead = null;
		ListNode cur = null;
		while (list1 != null && list2 != null) {
			if (list1.val < list2.val) {
				if (mergeHead == null) {
					mergeHead = cur = list1;
				} else {
					cur.next = list1;
					cur = cur.next;
				}
				list1 = list1.next;
			} else {
				if (mergeHead == null) {
					mergeHead = cur = list2;
				} else {
					cur.next = list2;
					cur = cur.next;
				}
				list2 = list2.next;
			}
		}
		if (list1 != null) {
			cur.next = list1;
		}
		if (list2 != null) {
			cur.next = list2;
		}
		return mergeHead;
	}
}
