//1，O(1)空间复杂度
class Solution {
	public ListNode getIntersectionNode(ListNode head1, ListNode head2) {
		if (head1 == null || head2 == null) {
			return null;
		}

		ListNode n1 = head1;
		ListNode n2 = head2;
		while (n1 != n2) {                            //又写错了。一定要注意这个条件啊！！！和题目”寻找链表入环节点”中的写法是一样的，傻吊！
			n1 = (n1 == null ? head2 : n1.next);
			n2 = (n2 == null ? head1 : n2.next);
		}
		return n1;
	}
}

//2. 普通解法：Hash表
class Solution {
	public ListNode getIntersectionNode(ListNode head1, ListNode head2) {
		if (head1 == null || head2 == null) {
			return null;
		}

		Set<ListNode> set = new HashSet<ListNode>();
		while (head1 != null) {
			set.add(head1);
			head1 = head1.next;
		}
		while (head2 != null) {
			if (set.contains(head2)) {
				break;
			}
			head2 = head2.next;
		}
		return head2;
	}
}

//3. 差值法
class Solution {
	public ListNode getIntersectionNode(ListNode head1, ListNode head2) {
		if (head1 == null || head2 == null) {
			return null;
		}
		ListNode n1 = head1;
		int len1 = 0;
		while (n1 != null) {
			len1++;
			n1 = n1.next;
		}
		ListNode n2 = head2;
		int len2 = 0;
		while (n2 != null) {
			len2++;
			n2 = n2.next;
		}

		int len = 0;
		if (len1 >= len2) {
			len = len1 - len2;
			while (len > 0) {
				head1 = head1.next;
				len--;
			}
			while (head1 != head2) {
				head1 = head1.next;
				head2 = head2.next;
			}
		} else {
			len = len2 - len1;
			while (len > 0) {
				head2 = head2.next;
				len--;
			}
			while (head1 != head2) {
				head1 = head1.next;
				head2 = head2.next;
			}
		}
		return head1;
	}
}
