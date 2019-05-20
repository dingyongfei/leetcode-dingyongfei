class Solution {
	public TreeNode buildTree(int[] pre, int[] in) {
		if (pre == null || in == null) {
			return null;
		}
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<in.length;i++) {               ------>           //但是，本题采用了优化的方法，使用一个map缓存，这样就不用在下面的函数中用for循环查找了。
            map.put(in[i], i);
        }
		TreeNode root = process(pre, 0, pre.length - 1, in, 0, in.length - 1, map);
		return root;
	}

	public TreeNode process(int[] pre, int sPre, int ePre, int[] in, int sIn, int eIn, Map<Integer, Integer> map) {
		if (sPre > ePre || sIn > eIn) {
			return null;
		}
		TreeNode root = new TreeNode(pre[sPre]);
        int i = map.get(pre[sPre]);

		/* for (int i = sIn; i <= eIn; i++) {                            //Fuck! man 要写一个循环从 [sIn, eIn]范围内找到一个i,使得 in[i] = pre[sPre] !!!!!!!
			if (in[i] == pre[sPre]) {            */
		root.left = process(pre, sPre + 1, sPre + i - sIn, in, sIn, i - 1, map);
		root.right = process(pre, sPre + i - sIn + 1, ePre, in, i + 1, eIn, map);
				//break;
			//}
		//}
		return root;
	}
}
