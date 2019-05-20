class Solution {
	
	public ListNode partition(ListNode head, int pivot) {
		
		ListNode sH = null;               //设置2个变量，分别记录分段链表的 “头部” 和 “尾部”。
		ListNode sT = null;
		ListNode ebH = null;
		ListNode ebT = null;
		
		ListNode next = null;
		
		while(head!=null) {
			next = head.next;
			head.next = null;              //  将当前head的next指针立即设为空！!(即断开链表中的每一个节点！)
			if(head.val<pivot) {
				if(sH==null) {
					sH = sT = head;
				} else {
					sT.next = head;
					sT = head;
				}
			} else {
				if(ebH==null) {
					ebH = ebT = head;
				} else {
					ebT.next = head;
					ebT = head;
				}
			}
			head = next;
		}
		
		//reconnect
		if(sT!=null) {
			sT.next = ebH;
			//ebT = ebT = null ? sT : ebT;
		}
		return sH != null ? sH : ebH;
	}
}
