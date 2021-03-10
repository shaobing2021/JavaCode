package offer.lc3;

import algorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * offer 32-II 思路：深度搜索或广度搜素
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/solution/dfshe-bfsliang-chong-fang-shi-jie-jue-by-sdwwld/
 */
public class LevelOrderII {
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
        System.out.println((levelOrder(a)));
    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) return new ArrayList<List<Integer>>();
        ArrayList<List<Integer>> res = new ArrayList<>();
        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        ArrayList<TreeNode> tmp = new ArrayList<>();
        while(!queue.isEmpty()){
            while(!queue.isEmpty()){
                TreeNode cur = queue.remove(0);
                tmp.add(cur);
            }
            ArrayList<Integer> num = new ArrayList<>();
            while (!tmp.isEmpty()){
                TreeNode r = tmp.remove(0);
                if (r.left!=null) queue.add(r.left);
                if (r.right!=null) queue.add(r.right);
                num.add(r.val);
            }
            res.add(num);
        }
        return res;
    }
    public static List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        return res;
    }
}
