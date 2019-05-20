class Solution {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode rHead = head.next;
		ListNode next = null;
		ListNode tmp = null;
		while (head != null && head.next != null) { // 2. 注意，使用到了head.next.next，所以这里要判断head.next !!!
			if (tmp != null) {
				tmp.next = head.next;
			}
			next = head.next.next;
			head.next.next = head;
			tmp = head; // 1. 设置一个tmp节点，跟踪 上一段排好序的 待连接下一段的 最后一个 节点
			head = next;
			if (head != null && head.next == null) { // 3. 增加多余一个节点的情况（即head.next==null），在这里直接返回头节点。
				tmp.next = head;
				return rHead;
			}
		}
		tmp.next = null; // 4.
							// 注意！一定要将最后一个节点的指向设置好，否则会超出内存限制！！！(因为tmp节点就是上一轮循环中的head节点，而这个head如果在自己不是链表中最后一个节点的情况下，指向着下一个元素，这样一来会形成环状链表！！！
							// 即tmp -> head.next -> tmp -> head.next...)
		return rHead;
	}
}
