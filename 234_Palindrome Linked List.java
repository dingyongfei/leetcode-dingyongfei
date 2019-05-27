// 记住!!!  本题一共只用 ” 3个指针 ”， 不包含其他任何指针 !!
// n1、n2、n3共三个指针即可 !!
class Solution {
	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}

		ListNode n1 = head;
		ListNode n2 = head;
		while (n1.next != null && n1.next.next != null) {
			n1 = n1.next.next;
			n2 = n2.next;
		}
		n1 = null;
		ListNode n3 = n2.next;
		n2.next = null;

		while (n3 != null) {
			n1 = n3.next;
			n3.next = n2;
			n2 = n3;
			n3 = n1;
		}

		n1 = head;
		n3 = n2;
		while (n1 != null) {
			if (n1.val != n3.val) {
				return false;
			}
			n1 = n1.next;
			n3 = n3.next;
		}

		// recover
		while (n2 != null) {
			n3 = n2.next;
			n2.next = n1;
			n1 = n2;
			n2 = n3;
		}
		return true;
	}
}
