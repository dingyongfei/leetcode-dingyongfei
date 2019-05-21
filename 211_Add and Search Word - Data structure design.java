// Using backtrack to check each character of word to search.
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

class WordDictionary {

	private TrieNode root;

	public WordDictionary() {
		root = new TrieNode();
	}

	public void addWord(String word) {
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
		return match(chs, 0, root);             //使用递归函数match去递归查找是否匹配！！
	}

	private boolean match(char[] chs, int i, TrieNode node) {
		if (i == chs.length) {
			return node.end > 0 ? true : false;
		}
		if (chs[i] != '.') {
			int index = chs[i] - 'a';
			return node.nexts[index] != null && match(chs, i + 1, node.nexts[index]);
		} else {
			for (int index = 0; index < node.nexts.length; index++) {
				if (node.nexts[index] != null) {
					if (match(chs, i + 1, node.nexts[index])) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
