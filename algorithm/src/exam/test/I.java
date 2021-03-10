package exam.test;

public abstract class I {
    private int a;
    static {
        System.out.println("11");
    }
    static void m(){
        System.out.println("123");
    }
    abstract void hello();
}
