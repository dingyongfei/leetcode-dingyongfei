//C++中，前缀树的delete方法，要依次将某个path为0的节点后面所有的节点都析构掉，才能返回；而Java中因为JVM会自动回收，所以只需将当前path为0的节点直接指向null, 它后面的所有节点就都被删掉了。
//实现前缀树需要谨记的一点是：一定不要把字符字母放在节点上！否则很难实现出前缀树！应该将字符放在前缀树的边上！


class TrieNode {
	public int path;
	public int end;
	public TrieNode[] nexts;

	public TrieNode() {
		path = 0;
		end = 0;
		nexts = new TrieNode[26];
	}
}

class Trie {
	private TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	public void insert(String word) {
		if (word == null) {
			return;
		}
		char[] chs = word.toCharArray();
		TrieNode node = root;
		int index = 0;
		for (int i = 0; i < chs.length; i++) {
			index = chs[i] - 'a';
			if (node.nexts[index] == null) {
				node.nexts[index] = new TrieNode();
			}
			node = node.nexts[index];
			node.path++;
		}
		node.end++;
	}

	public boolean search(String word) {
		if (word == null) {
			return false;
		}
		char[] chs = word.toCharArray();
		TrieNode node = root;
		int index = 0;
		for (int i = 0; i < chs.length; i++) {
			index = chs[i] - 'a';
			if (node.nexts[index] == null) {
				return false;
			}
			node = node.nexts[index];
		}
		return node.end > 0 ? true : false;
	}

	public boolean startsWith(String pre) {
		if (pre == null) {
			return false;
		}
		char[] chs = pre.toCharArray();
		TrieNode node = root;
		int index = 0;
		for (int i = 0; i < chs.length; i++) {
			index = chs[i] - 'a';
			if (node.nexts[index] == null) {
				return false;
			}
			node = node.nexts[index];
		}
		return true;
	}
}
