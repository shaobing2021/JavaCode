package offer.lc5.lc0to5;

public class MaxDepth {
    public static void main(String[] args) {
        TreeNode r1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(1);
        TreeNode r3 = new TreeNode(1);
        TreeNode r4 = new TreeNode(1);
        r1.left=r2;
        r2.left=r4;
        r1.right=r3;
        System.out.println(maxDepth(r1));
    }
    public static int maxDepth(TreeNode root){
        if (root==null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {val =x;}
}

