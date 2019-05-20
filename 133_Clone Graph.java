// For one, it wouldn't be thread safe. If you had multiple threads calling this same function, they'd be writing to the same map, and clobbering each other. This implementation is safer, because it gives each call its own copy of a HashMap, and they don't have to worry about it. The question doesn't explicitly say to be concerned about concurrency, but it never hurts to be proactive.
/*
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
	private HashMap<Integer, Node> map = new HashMap<Integer, Node>();

	public Node cloneGraph(Node node) {
		return clone(node);
	}

	private Node clone(Node node) {
		if (node == null)
			return null;
		if (map.containsKey(node.val)) {
			return map.get(node.val);
		}
		Node clone = new Node(node.val, new ArrayList<Node>());
		map.put(clone.val, clone);
		for (Node neighbor : node.neighbors) {
			clone.neighbors.add(clone(neighbor));
		}
		return clone;
	}
}
