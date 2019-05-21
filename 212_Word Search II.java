class Solution {
	Set<String> res = new HashSet<String>();

	public static class TrieNode {
		public int path;
		public int end;
		public TrieNode[] nexts;

		public TrieNode() {
			path = 0;
			end = 0;
			nexts = new TrieNode[26];
		}
	}

	public static class Trie {
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

	public List<String> findWords(char[][] board, String[] words) {
		Trie trie = new Trie();
		for (String word : words) {
			trie.insert(word);
		}

		int m = board.length;
		int n = board[0].length;
		boolean[][] visited = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				exist(board, visited, "", i, j, trie);
			}
		}
		return new ArrayList<String>(res);
	}

	private void exist(char[][] board, boolean[][] visited, String str, int i, int j, Trie trie) {
		if (i > board.length - 1 || i < 0 || j < 0 || j > board[0].length - 1)
			return;
		if (visited[i][j])
			return;
		str += board[i][j];

		if (!trie.startsWith(str))
			return;

		if (trie.search(str)) {
			res.add(str);
		}

		visited[i][j] = true;

		exist(board, visited, str, i - 1, j, trie);
		exist(board, visited, str, i, j - 1, trie);
		exist(board, visited, str, i, j + 1, trie);
		exist(board, visited, str, i + 1, j, trie);

		visited[i][j] = false;      ------------------------->>>  // 注意，Fuck! 一定要设置回来！！
	}
}
