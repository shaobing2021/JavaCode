package leetcode.lc5;

public class FindNumsAppearOnce {
    public static void main(String[] args) {
        int[] array = {1,2,2,3,3,5};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        FindNumsAppearOnce(array, num1,num2);
    }
//    核心点在于：b^b=0  0^a=a 如果只有一个不同的数，那么可直接区分，如果要找到两个不同的数，那么就先根据结果再进行划分
    public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int res = 0;
//        获取num1^num2的结果
        for (int s : array) {
            res ^= s;
        }
//        由于异或不同为1，那么可以获取1所在的位置划分num1，num2 1100   那么可以根据x&(-x)获取最低位
        int k = res&(-res);
        for (int s : array) {
            if ((s&k)==0) num1[0]^=s;
            else num2[0]^=s;
        }
        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }
}
