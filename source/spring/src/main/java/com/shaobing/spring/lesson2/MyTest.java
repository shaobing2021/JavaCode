package com.shaobing.spring.lesson2;

public class MyTest extends Test{
    public static void main(String[] args) {
        MyTest myTest = new MyTest();
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("user.xml");
    }

    static {
        System.out.println("hello,test1");
    }
    public MyTest() {
        System.out.println("hello,Mytest");
    }
}
class Test{
    static {
        System.out.println("hello");
    }

    public Test() {
        System.out.println("hello,test");
    }
}