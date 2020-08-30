package algorithm.search;

public class BinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(6);
        root.left = n1;
        n1.right = n2;
        root.right=n3;
        n3.right=n4;
        System.out.println(search(root, 5));
    }
    private static Integer search(TreeNode root,int key){
        while (root!=null){
            if (root.val<key) root = root.right;
            else if (root.val>key) root = root.left;
            else return root.val;
        }
        return null;
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {
        this.val = val;
    }
}