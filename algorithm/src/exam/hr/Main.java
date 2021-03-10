package exam.hr;

public class Main {
    private int a;
    Main(int b){
        a =b ;
    }

    public static void main(String[] args) {
        Main main = new Main(3);
        System.out.println(main.a);
    }
}
