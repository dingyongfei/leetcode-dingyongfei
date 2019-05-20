//写法二
// A good solution !!
/**
 * Find the middle, root is the middle. 
 * left subtree is left part of middle.
 * right subtree is right part of middle.
 */
class Solution {
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null)                    //” if (head == null) “是和 下面的” slowPre.next = null “相互关联的。
			return null;
		ListNode slow = head, fast = head, slowPre = null;
		while (fast.next != null && fast.next.next != null) {
			slowPre = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		if (slowPre != null)
			slowPre.next = null;
/*		
if (slow == null)
			return null;
*/
		TreeNode root = new TreeNode(slow.val);
		if (head != slow)                             //重要!!
			root.left = sortedListToBST(head);
		root.right = sortedListToBST(slow.next);
		return root;
	}
}


//方法二 （链表先转成数组，剩下的按照 题 108 来做即可）
class Solution {
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) {
			return null;
		}
		int len = 0;
		ListNode tmp = head;
		while (tmp != null) {
			len++;
			tmp = tmp.next;
		}
		int[] nums = new int[len];
		tmp = head;
		for (int i = 0; i < len; i++) {
			nums[i] = head.val;
			head = head.next;
		}
		TreeNode root = process(nums, 0, len - 1);
		return root;
	}

	public TreeNode process(int[] nums, int s, int e) {
		if (s > e) {
			return null;
		}
		int mid = ((e - s) >> 1) + s;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = process(nums, s, mid - 1);
		root.right = process(nums, mid + 1, e);
		return root;
	}
}
