package offer.lc5;

public class ReverseSentence {
    public static void main(String[] args) {
        System.out.println(ReverseSentence("  "));
    }
    //注意以空格为分割符完成字符串分割后，若两单词间有 x > 1x>1 个空格，则在单词列表 strsstrs 中，此两单词间会多出 x - 1x−1 个 “空单词” （即 "" ）。
    // 解决方法：倒序遍历单词列表，并将单词逐个添加至 StringBuilder ，遇到空单词时跳过。
    public static String ReverseSentence(String str) {
        String[] strs = str.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strs.length-1; i >= 0; i--) {
            if (strs[i].equals("")) continue;
            sb.append(strs[i]+" ");
        }
        return sb.toString().trim();
    }
    //双指针法
}
