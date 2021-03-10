package exam.test;

import java.util.HashMap;

public class Test{
    public static void main(String[] args) throws CloneNotSupportedException {
//        Teacher t1 = new Teacher();
//        t1.setStudent(new Student());
//        t1.setName("lz");
//        System.out.println(t1.toString());
//        Teacher t2 = t1.clone();
//        t2.setStudent(new Student());
//        System.out.println(t2);
//        System.out.println(t1);
//        Teacher t3 = t1;
        int i = 5;
        //5+7+7+5
        HashMap<Object, Object> map = new HashMap<>();
        int t3 = (i++)+(++i)+(i--)+(--i);
        System.out.println(t3);
        String str = "abc";
        String s = "a";
        System.out.println(str.contains(s));
        long a = 1;
        double b = 1;
        float c = 1;
//        int[] a = new int[5]{1,3,4,5,4};
    }

    static class B{

    }
}
