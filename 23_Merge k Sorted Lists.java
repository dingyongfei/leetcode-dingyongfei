class Solution {
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}
		int k = lists.length;
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		});
		for (int i = 0; i < k; i++) {
			if (lists[i] != null) {
				queue.add(lists[i].val);
				// lists[i] = lists[i].next;
			}
		}

		ListNode head = null;
		ListNode cur = null;
		while (!queue.isEmpty()) {
			int data = queue.poll();
			if (head == null) {
				head = cur = new ListNode(data);
			} else {
				cur.next = new ListNode(data);
				cur = cur.next;
			}

			for (int i = 0; i < lists.length; i++) {
				if (lists[i] != null && lists[i].val == data) {
					lists[i] = lists[i].next;
					if (lists[i] != null) { // 注意，这里要判空。
						queue.add(lists[i].val);
					}
					break;
				}
			}

		}
		return head;
	}
}
