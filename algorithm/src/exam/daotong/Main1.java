package exam.daotong;

import java.util.ArrayList;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] chars = s.toCharArray();
//        String s = "get(fun1(]))";
        help(s.toCharArray());
    }
    private static void help(char[] chars){
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]=='{'||chars[i]=='['||chars[i]=='('){
                list.add(chars[i]);
            }else if (list.size()>0){
                if (chars[i]=='}') {
                    if (list.get(list.size() - 1) == '{') {
                        list.remove(list.size() - 1);
                    }else {
                        System.out.println(false);
                        return;
                    }
                }else if (chars[i]==']') {
                    if (list.get(list.size() - 1) == '[') {
                        list.remove(list.size() - 1);
                    }else {
                        System.out.println(false);
                        return;
                    }
                }else if (chars[i]==')') {
                    if (list.get(list.size() - 1) == '(') {
                        list.remove(list.size() - 1);
                    }else {
                        System.out.println(false);
                        return;
                    }
                }
            }
        }
        if (list.size()==0){
            System.out.println(true);
        }else {
            System.out.println(false);
        }
    }
}
