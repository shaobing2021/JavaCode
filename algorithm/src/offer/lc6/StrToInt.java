package offer.lc6;

public class StrToInt {
    public static void main(String[] args) {
        String str = "-5";
        System.out.println(strToInt(str));
    }
    public static int strToInt(String str) {
        char[] c = str.trim().toCharArray();
        if(c.length == 0) return 0;
        int res = 0, bndry = Integer.MAX_VALUE / 10;
        int i = 1, sign = 1;
        if(c[0] == '-') sign = -1;
        else if(c[0] != '+') i = 0;
        for(int j = i; j < c.length; j++) {
            if(c[j] < '0' || c[j] > '9') break;
            //m*10+c[i]>Integer.MaxValue
            if(res>( Integer.MAX_VALUE-(c[j]-'0'))/10) return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            //if(res > bndry || res == bndry && c[j] > '7') return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + (c[j] - '0');
        }
        return sign * res;
    }
    public static int strToInt1(String str) {
        str = str.trim();
        if (str.isEmpty()||(!Character.isDigit(str.charAt(0))&&str.charAt(0)!='-')&&str.charAt(0)!='+') return 0;
        char[] chars = str.toCharArray();
        int res ;
        boolean flag;
        if (chars[0]=='-'){
            res = 0;
            flag = false;
        }else if (chars[0]=='+'){
            res = 0;
            flag = true;
        } else {
            res = (int)chars[0] - (int)('0');
            flag = true;
        }
        boolean number = false;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i]=='.') break;
            if (!Character.isDigit(chars[1])) break;
            if ((number&&!Character.isDigit(chars[i]))){
               break;
            }
            number = true;
            int num = (int)chars[i] - (int)('0');
            if (res>Integer.MAX_VALUE/10||(res==Integer.MAX_VALUE/10&&((flag&&num>7)||(num>8)))){
                return flag?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            res = res*10+num;
        }
        return flag?res:-res;
    }

}
