class Solution {
	public int[] maxSlidingWindow(int[] nums, int w) {
		if (nums == null || nums.length == 0 || w < 1 || nums.length < w) {
			return new int[] {};
}

			/** 注意base case的写法, “ 不要写 return null; ”否则:
			 		
			*/

		LinkedList<Integer> qmax = new LinkedList<Integer>();
		int index = 0;
		int[] res = new int[nums.length - w + 1];
		for (int i = 0; i < nums.length; i++) {
			while (!qmax.isEmpty() && nums[qmax.peekLast()] <= nums[i]) {
				qmax.pollLast();
			}
			qmax.addLast(i);                // 注意该行的位置!
			if (qmax.peekFirst() == i - w) {
				qmax.pollFirst();
			}
			if ((i - w) >= -1) {
				res[index++] = nums[qmax.peekFirst()];
			}
		}
		return res;
	}
}
