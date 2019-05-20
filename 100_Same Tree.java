//和剑指  “17.输入两棵二叉树A,B,判断B是不是A的子结构。” 比较类似
class Solution {
    public boolean isSameTree(TreeNode p1, TreeNode p2) {
        if(p1==null || p2==null) {        ---->                //非常简便的写法！
            return p1 == p2;
        }
        if(p1.val != p2.val) {
            return false;
        }
        return isSameTree(p1.left, p2.left)&&isSameTree(p1.right, p2.right);
    }
}
