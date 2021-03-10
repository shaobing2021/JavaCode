package offer.lc6;

/**
 * 剑指offer64it
 */
public class Add {
    public static void main(String[] args) {
        System.out.println(Add(13,7));
    }

    public static int Add(int num1,int num2) {
//        num1^num2
        while (num2!=0){//确保进位不为0
            int a = num1^num2;//得到常规位
            int b = (num1&num2)<<1;//得到进位
            num1 = a;
            num2 = b;
        }
        return num1;
    }

















    public static int Add1(int num1,int num2) {
        while (num2!=0){
           int a= num1^num2;
            int b= (num1&num2)<<1;
            num1 = a ;
            num2 = b;
        }
        return num1;
    }
}
