package exam.jd;
import java.util.Scanner;
/**
 * 题目描述：
 * 某滚球游戏规则如下：球从入口处（第一层）开始向下滚动，
 * 每次可向下滚动一层，直到滚至最下面一层为止。球每次可滚至左下、
 * 下方或右下三个方格中的任意一个，每个方格都有一个得分，如下图所示。
 * 第1层有1个方格，第2层有3个方格，……，以此类推，第n层有2*n-1个方格。
 * 设计一个算法，使得球从入口滚至最下面一层的总得分和最大
 *
 * 3
 *     1
 *   2 1 2
 * 3 4 2 1 3
 *
 * 7
 */
public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        int res = 0;
        for (int i = 1; i <= total; i++) {
            int max = 0;
            for (int j = 0; j <2*i-1 ; j++) {
                int temp = scanner.nextInt();
                if (max<temp){
                    max = temp;
                }
            }
            res += max;
        }
        System.out.println(res);
    }
}
