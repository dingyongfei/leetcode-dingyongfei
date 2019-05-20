class Solution {
	public int[][] insert(int[][] intervals, int[] newInterval) {
		int[][] newArr = new int[intervals.length + 1][2];
		int i = 0;
		for (int[] c : intervals) {
			newArr[i++] = c;
		}
		newArr[i] = newInterval;

		if (intervals.length < 1) {
			return newArr;
		}

		Arrays.sort(newArr, new Comparator<int[]>() {
			@Override
			public int compare(int[] a1, int[] a2) {
				return a1[0] - a2[0];
			}
		});

		ArrayList<int[]> res = new ArrayList<int[]>();
		res.add(newArr[0]);
		for (i = 1; i < newArr.length; i++) {
			if (newArr[i][0] <= res.get(res.size() - 1)[1]) {
				// 总是和当前链表中的最后一个元素作比较
				res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], newArr[i][1]);
			} else {
				res.add(newArr[i]);
			}
		}
		return res.toArray(new int[res.size()][2]);
	}
}
