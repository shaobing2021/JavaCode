package leetcode.lc5;

import java.util.ArrayList;

/**
 * 55题
 *                1
 *             3      4
 *           5   6   8  9
 *                15
 */
public class TreeDepth {
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
        System.out.println(TreeDepth1(root));
    }
    public static int TreeDepth1(TreeNode root) {
        if (root==null) return 0;
        ArrayList<TreeNode> list = new ArrayList<>();
        list.add(root);
        int res = 0;
        while (!list.isEmpty()){
            int n = list.size();
            for (int i = 0; i < n; i++) {
                TreeNode temp = list.remove(0);
                if (temp.left!=null) list.add(temp.left);
                if (temp.right!=null) list.add(temp.right);
            }
            res++;
        }
        return res;
    }

}
 class TreeNode {
     int val = 0;
     TreeNode left = null;
     TreeNode right = null;
     public TreeNode(int val) {
        this.val = val;
     }
 }
