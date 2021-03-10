package exam.hr;

/**
 * 异常
 * 结果
 * 10
 */
public class Main1 {
    public static void main(String[] args) {
        System.out.println(test());
    }
    private static int test(){
        int num = 0;
        try {
            int a = num/0;
        }catch (Exception e){
            num = 5;
            System.out.println("异常");
            e.printStackTrace();
        }finally {
            System.out.println("结果");
            num =10;
        }
        return num;
    }
}
