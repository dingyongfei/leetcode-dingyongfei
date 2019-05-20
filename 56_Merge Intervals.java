class Solution {
	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> result = new LinkedList<Interval>();
		Collections.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				return i1.start - i2.start;
			}
		});

		int i = 0;
		while (i < intervals.size() - 1) {
			Interval current = intervals.get(i);
			Interval next = intervals.get(i + 1);
			if (next.start <= current.end) {
				int max = Math.max(next.end, current.end);
				current.end = max;
				intervals.remove(i + 1);
			} else {
				i++;
			}
		}
		return intervals;
	}
}
