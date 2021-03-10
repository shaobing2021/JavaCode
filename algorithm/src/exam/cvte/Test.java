package exam.cvte;

public abstract class Test {
    static {
        System.out.println("hello static");
    }
    {
        System.out.println("hello .");
    }

    static void hello(){
        System.out.println("1111");
    }
    abstract void hello(int i);
    void test(){

    };
}
class Hello extends Test{
    public static void main(String[] args) {
        Hello hello = new Hello();
        hello();
    }
    public Hello(){
        int age;
        System.out.println("hello....");
    }

    @Override
    void hello(int i) {

    }
}
