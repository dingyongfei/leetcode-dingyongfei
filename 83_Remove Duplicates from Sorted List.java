//fantastic solution :
//一个指针就搞定！---->  不断向前伸头并不断修改next指针，伸不到（即node.val!=node.next.val）的时候就移动（node = node.next）
class Solution {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode node = head;

		while (node.next != null) {

			if (node.val == node.next.val) {
				node.next = node.next.next;
			} else {
				node = node.next;
			}
		}

		return head;
	}
}
