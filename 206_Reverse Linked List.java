/*  迭代
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null) {
            return head;
        }
        
        ListNode pre = null;
        ListNode next = null;
        while(head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
*/

//递归   (漂亮的写法)，好好看一下
// 和剑指offer 第3题 相似
class Solution {
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {            //和剑指offer”删除链表中的重复节点” 的base case写法一样！因为递归函数中用到了head.next.next.
			return head;
		}
		ListNode res = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return res;
	}
}
