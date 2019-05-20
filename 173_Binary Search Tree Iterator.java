class BSTIterator {
	//构造方法中初始化两个变量。
	private Stack<TreeNode> stack;
	private TreeNode root;

	public BSTIterator(TreeNode root) {
		this.stack = new Stack<TreeNode>();
		this.root = root;
	}

	public boolean hasNext() {
		return (!stack.isEmpty() || root != null);            //注意，二叉树中序遍历过程中，栈是有可能变为空的! 所以只有当当前节点为空了，栈也为空时，才说明中序遍历真正的结束了！
	}

	public int next() {    
/* if (root == null && stack.isEmpty()) {
       		return 0;
    		} */
		while (root != null || !stack.isEmpty()) {
			if (root != null) {
				stack.push(root);
				root = root.left;
			} else {
				break;                  //整个过程为改写的二叉树中序遍历。当一直加入左节点(“ if(root!=null) “)不能再左的时候, (“ else “)弹出栈中节点，再遍历右子树。本题为改写的中序遍历， “ else “ 在while循环的外面, 所以当root为空时，要break掉！避免发生死循环！
			}
		}
		root = stack.pop();                     //将开始遍历右子树的转折点拿出while循环，直接返回左到不能再左时, 从栈中弹出的节点值即可。
		int res = root.val;
		root = root.right;
		return res;
	}
}

//next()方法更方便的写法如下：
//--------------------------------------------------------------------------------------------
public int next() {
	while (root != null) {
		stack.push(root);
		root = root.left;
	}
	root = stack.pop();
	int res = root.val;
	root = root.right;
	return res;
}
//--------------------------------------------------------------------------------------------
