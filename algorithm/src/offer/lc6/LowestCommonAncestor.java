package offer.lc6;

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //1.终止条件
        if (root==null||root==p||root==q) return root;//如果p，q中等于root的，则最近公共祖先为root
        //2.递推条件
        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
        //3.返回值
        if (leftNode==null) return rightNode;//说明在右子树中
        if (rightNode==null) return leftNode;//说明在左子树中
        return root;//说明在两边
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val = x;
    }
}