package algorithm.tree;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

/**
 * 假设遍历 {1,3,4,5,6,8,9,15};
 *              1
 *           3      4
 *         5   6   8  9
 *              15
 *     中序遍历结果为： 5 3 6 15 1 8 4 9
 */
public class InOrder {
    public static void main(String[] args) {

    }
    private static void inOrder(TreeNode root){
        if(root!=null){
            inOrder(root.left);
            System.out.print(root.val+" ");
            inOrder(root.right);
        }
    }
}
