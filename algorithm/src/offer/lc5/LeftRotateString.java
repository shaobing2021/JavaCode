package offer.lc5;

public class LeftRotateString {

    public static void main(String[] args) {
        System.out.println(LeftRotateString("abxXyz",3));
    }
    public static String LeftRotateString(String str,int n) {
       if (str.length()==0||str==null) return "";
        return str.substring(n)+str.substring(0,n);
    }
}
