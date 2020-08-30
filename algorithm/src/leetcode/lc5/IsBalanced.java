package leetcode.lc5;

public class IsBalanced {

    public boolean isBalanced(TreeNode root){
        return dfs(root)!=-1;
    }
    public int dfs(TreeNode node){
        if (node==null) return 0;
        int left = dfs(node.left);
        if (left==-1) return -1;
        int right = dfs(node.right);
        if (right==-1) return -1;
        return Math.abs(left-right)<=1?Math.max(left,right)+1:-1;
    }

    public boolean isBalanced1(TreeNode root){
        if (root==null) return true;
        return isBalanced1(root.left)&&isBalanced1(root.right)&&Math.abs(depth(root.left)-depth(root.right))<=1;
    }
    private int depth(TreeNode root){
        if (root==null)return 0;
        return Math.max(depth(root.left),depth(root.right))+1;
    }
}
