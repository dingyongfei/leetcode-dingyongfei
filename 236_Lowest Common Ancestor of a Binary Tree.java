// 注: 本题和” 给定一棵二叉树的头节点head，请返回最大搜索二叉子树的大小. ” 的思路很是相似(对照着看):
// 整个过程为二叉树的后序遍历
// 假设处理cur左子树时返回节点为left, 处理右子树时返回right.
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return right == null ? left : right;
    }
}
