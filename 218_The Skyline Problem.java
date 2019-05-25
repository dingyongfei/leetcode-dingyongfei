// 关键的总结： 跟踪每个位置的最大高度变化，生成轮廓线！！
// pmMap：记录每一个位置冲到的最大高度
// 最后用pmMap生成轮廓线
class Solution {
	public static class Node {
		public boolean isUp;
		public int posi;
		public int h;

		public Node(boolean bORe, int position, int height) {
			isUp = bORe;
			posi = position;
			h = height;
		}
	}

	public static class NodeComparator implements Comparator<Node> {
		public int compare(Node o1, Node o2) {
			if (o1.posi != o2.posi) {
				return o1.posi - o2.posi;
			}
			if (o1.isUp != o2.isUp) {
				return o1.isUp ? -1 : 1;
			}
			return 0;
		}
	}

	public static List<List<Integer>> getSkyline(int[][] buildings) {
		Node[] nodes = new Node[buildings.length * 2];
		for (int i = 0; i < buildings.length; i++) {
			nodes[i * 2] = new Node(true, buildings[i][0], buildings[i][2]);
			nodes[i * 2 + 1] = new Node(false, buildings[i][1], buildings[i][2]);
		}
		Arrays.sort(nodes, new NodeComparator());
		TreeMap<Integer, Integer> htMap = new TreeMap<>();
		TreeMap<Integer, Integer> pmMap = new TreeMap<>();
		for (int i = 0; i < nodes.length; i++) {
			if (nodes[i].isUp) {
				if (!htMap.containsKey(nodes[i].h)) {
					htMap.put(nodes[i].h, 1);
				} else {
					htMap.put(nodes[i].h, htMap.get(nodes[i].h) + 1);
				}
			} else {
				if (htMap.containsKey(nodes[i].h)) {
					if (htMap.get(nodes[i].h) == 1) {
						htMap.remove(nodes[i].h);
					} else {
						htMap.put(nodes[i].h, htMap.get(nodes[i].h) - 1);
					}
				}
			}
			if (htMap.isEmpty()) {
				pmMap.put(nodes[i].posi, 0);
			} else {
				pmMap.put(nodes[i].posi, htMap.lastKey());
			}
		}
		List<List<Integer>> res = new ArrayList<>();
		int start = 0;
		int height = 0;                                   // 之前的高度
		for (Map.Entry<Integer, Integer> entry : pmMap.entrySet()) {
			int curPosition = entry.getKey();
			int curMaxHeight = entry.getValue();
			if (height != curMaxHeight) {
				// if (height != 0) {
				List<Integer> newRecord = new ArrayList<Integer>();
				newRecord.add(start);
				// newRecord.add(curPosition);
				newRecord.add(height);
				res.add(newRecord);
				// }
				start = curPosition;
				height = curMaxHeight;
			}
		}

		List<Integer> tailRecord = new ArrayList<Integer>();
		tailRecord.add(start);
		tailRecord.add(0);
		res.add(tailRecord);
		res.remove(0);

		return res;
	}
}
