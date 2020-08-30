package algorithm.graph;

import javax.management.StandardEmitterMBean;
import java.util.ArrayList;

/**
 * 对图的广度优先搜索，对树而言就是层次搜索
 *                1
 *             3      4
 *           5   6   |  9
 *                8
 *     广度 1 3 5 6 15 4 8 9
 *     这里假设4的左孩子为8，6的右孩子也为8，则成图
 *     这里要不仅要确保没被访问而且也不在待访问序列中，即list为(6,8,9),visit为(1,3,4,5)
 *     此时访问6节点，vist并不包含8，于是将8重复添加到8当中，会进行重复访问。
 */
public class BFS {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        root.left = n3;
        root.right = n4;
        n3.left = n5;
        n3.right = n6;
        n4.left = n8;
        n4.right = n9;
        n6.right = n8;
        bfs(root);
    }
    private static void bfs(TreeNode node){
        ArrayList<TreeNode> list = new ArrayList<>();
        ArrayList<TreeNode> visit = new ArrayList<>();
        list.add(node);
        visit.add(node);
        //防止出现visit还未添加，但是已经在队列中的情况。两种解决方式：第一种队列添加的同时，visit也添加。第二种，判断同时不在visit和队列中
        while (!list.isEmpty()){
            TreeNode temp = list.remove(0);
            visit.add(temp);
            System.out.print(temp.val+" ");
            if (temp.left!=null&&!visit.contains(temp.left)){
                list.add(temp.left);
                visit.add(temp.left);
            }
            if (temp.right!=null&&!visit.contains(temp.right)){
                list.add(temp.right);
                visit.add(temp.right);
            }
        }
    }
}
