// 本题是通过改写二叉树的后序列遍历来完成的（即将 “左-右-中” 改为 “右-左-中”的遍历方式），改写后，所遍历的路径就正好是符合题意的链表连接顺序！

//方法一（nice solution）
class Solution {
  TreeNode pre = null;
  
  public void flatten(TreeNode root) {
      if(root==null) {
          return;
      }
      
      flatten(root.right);
      flatten(root.left);
      
      root.right = pre;
      root.left = null;
      pre = root;
  }
}

//方法二：  当然，也可以通过“ 先序遍历 ”来实现，但是一定要注意，本题中，先序遍历flatten链表的过程中，树的节点会在递归过程中发生改变，所以要将相应的节点临时记录下来！
class Solution {
    TreeNode pre = null;
    
    public void flatten(TreeNode root) {
        if(root==null) {
            return;
        }
        if(pre==null) {
            pre = root;
        } else {
            pre.left = null;    //set left to null, as we do not need left nodes
            pre.right = root;
            pre = root;
        }
        
        TreeNode tmp = root.right;    //right will be changed in next recursive calls
        flatten(root.left);
        flatten(tmp);
    }
}
