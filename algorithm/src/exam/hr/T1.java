package exam.hr;

public class T1 extends T2{
    public static void main(String[] args) {
        T1 t1 = new T1();
    }
}
class T2{
    static {
        System.out.println("static");
    }
    {
        System.out.println("t");
    }
}