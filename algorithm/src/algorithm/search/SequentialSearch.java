package algorithm.search;

public class SequentialSearch {
    static Node first ;
    public static Integer get(String key){
        for (Node x = first; x!=null; x=x.next) {
            if (key.equals(x.key))
                return x.val;
        }
        return null;
    }
    public static void put(String key,int val){
        Node x = first;
        while (x!=null){
            if (key.equals(x.key)){
                x.val = val;
                return;
            }
            x=x.next;
        }
//        这段代码是精髓，头插法
        first = new Node(key,val,first);
    }

    public static void main(String[] args) {
        first = new Node("k1",1);
        put("k2",2);
        put("k3",3);
        put("k4",4);
        System.out.println(get("k4"));
    }
}
class Node{
    String key;
    int val;
    Node next;

    public Node(String key, int val) {
        this.key = key;
        this.val = val;
    }

    public Node(String key, int val, Node next) {
        this.key = key;
        this.val = val;
        this.next = next;
    }

}