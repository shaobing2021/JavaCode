package offer.lc3;

import algorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * leetcode32-I
 */
public class LevelOrder {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(9);
        TreeNode c = new TreeNode(20);
        TreeNode d = new TreeNode(15);
        TreeNode e = new TreeNode(7);
        a.left = b;
        a.right = c;
        c.left = d;
        c.right = e;
        System.out.println(Arrays.toString(levelOrder(a)));
    }
    public static int[] levelOrder(TreeNode root) {
        if (root==null) return new int[0];
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        list.add(root);
        while(list.size()!=0){
            TreeNode cur = list.remove(0);
            res.add(cur.val);
            if(cur.left!=null) list.add(cur.left);
            if(cur.right!=null) list.add(cur.right);
        }
        int[] r = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            r[i] = res.get(i);
        }
        return r;
    }
}
