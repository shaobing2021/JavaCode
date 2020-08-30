package algorithm.tree;

/**
 * 假设遍历 {1,3,4,5,6,8,9,15};
 *              1
 *           3      4
 *         5   6   8  9
 *              15
 *     后序遍历结果为： 5  15 6 3 8 9 4 1
 */
public class PostOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        TreeNode n15 = new TreeNode(15);
        root.left = n3;
        root.right = n4;
        n3.left = n5;
        n3.right = n6;
        n4.left = n8;
        n4.right = n9;
        n6.right = n15;
        postOrder(root);
    }
    private static void postOrder(TreeNode root){
        if(root!=null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.val+" ");
        }
    }
}
