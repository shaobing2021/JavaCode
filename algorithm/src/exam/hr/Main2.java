package exam.hr;

public class Main2 {
    public static void main(String[] args) {
        int a = 1;
        int b = 1;
        if (a++==1){
            System.out.println(a);
        }
        if (a++==2||++b==1){
            System.out.println(b);
        }
        String s1 = "abcdef";
        String s2 = "abcdef";
        System.out.println(s1==s2);
        String substring = s1.substring(3);
        System.out.println(s1);
        System.out.println(substring);
    }
}
