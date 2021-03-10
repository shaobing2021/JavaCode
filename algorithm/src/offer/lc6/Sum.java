package offer.lc6;

/**
 * 剑指64题
 */
public class Sum {
    public static void main(String[] args) {
        System.out.println(Sum_Solution(2));
    }

    public static int Sum_Solution(int n) {
        boolean flag = n>1&&(n+=Sum_Solution(n-1))>0;
        return n;
    }

    public static int Sum_Solution2(int n) {
       boolean flag = n>1 && (n+=Sum_Solution(n-1))>0;
       return n;
    }
    //正常来说可以使用递归，但是此处不允许使用if，因此只能修改
    public static int Sum_Solution1(int n) {
        if (n<=1) return 1;
        return Sum_Solution(n-1)+n;
    }
}
