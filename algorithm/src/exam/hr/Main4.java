package exam.hr;

public class Main4 {
    private int id = 1001;
    private String name ;

    {
        System.out.println("{");
        System.out.println(name);
        System.out.println(id);
        name = "13";
        id = 11;
        System.out.println(name);
        System.out.println(id);
        System.out.println("}");
        i =1;
        System.out.println(i);
    }
    static int i;
    public Main4(){
        System.out.println("main4");
        System.out.println(name);
        System.out.println(id);
    }

    public static void main(String[] args) {
        Main4 main4 = new Main4();
        System.out.println(main4.name);
    }
}
class Account{

}
