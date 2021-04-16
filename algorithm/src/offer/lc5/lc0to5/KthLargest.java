package offer.lc5.lc0to5;

public class KthLargest {
    public static void main(String[] args) {
        TreeNode r1 = new TreeNode(3);
        TreeNode r2 = new TreeNode(1);
        TreeNode r3 = new TreeNode(4);
        TreeNode r4 = new TreeNode(2);
        r1.left=r2;
        r1.right=r3;
        r2.right=r4;
        System.out.println(new KthLargest().kthLargest(r1,1));
    }
    int res,k;
    public int kthLargest(TreeNode root,int k){
        this.k = k;
        help(root);
        return res;
    }
    /*
       3
     1     4
   null 2
   这里主要在怎么跳出递归循环而卡住了
   可以使用全局变量和局部变量
     */
    private void help(TreeNode root){
        if (root!=null){
            help(root.right);
            if (k==0)return;
            if (--k==0) res = root.val;
            //这里应该做两件事，提前退出，记录此节点
            //count++;if (count==k) return root.val;
            help(root.left);
        }

    }
}
