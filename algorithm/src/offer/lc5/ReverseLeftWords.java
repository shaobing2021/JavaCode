package offer.lc5;

/**
 * leetcode58-II
 */
public class ReverseLeftWords {
    public static void main(String[] args) {
        String s = "abcdefg";
        System.out.println(reverseLeftWords(s,2));
    }
    public static String reverseLeftWords(String s, int n) {
        if (s.isEmpty()||n<=0) return s;
        StringBuilder sb = new StringBuilder();
        for (int i = n; i < s.length(); i++) {
            sb.append(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
    public static String reverseLeftWords1(String s, int n) {
        if (s.isEmpty()||n<=0) return s;
        StringBuilder sb = new StringBuilder();
        for (int i = n; i < n+s.length(); i++) {
            sb.append(s.charAt(i%s.length()));
        }
        return sb.toString();
    }
    public static String reverseLeftWords2(String s, int n) {
        return s.substring(n,s.length())+s.substring(0,n);
    }
}

