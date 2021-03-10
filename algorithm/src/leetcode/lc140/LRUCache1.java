package leetcode.lc140;

import java.util.HashMap;

public class LRUCache1 {
    private int capacity;
    private HashMap<Integer,Node> map;
    Node head,tail;
    public LRUCache1(int capacity){
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    class Node{
        Node prev;
        Node next;
        private int key;
        private int value;
        public Node(int key,int value){
            this.key = key;
            this.value = value;
        }
        public Node(){
        }
    }
    public int get(int key){
        Node node = map.get(key);
        if (node==null) return -1;
        moveToHead(node);
        return node.value;
    }

    private void moveToHead(Node node){
        removeNode(node);
        addToHead(node);
    }
    private void removeNode(Node node){
        //System.out.println("移除："+node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        //node = null;//能否增加这个使回收
    }
    private void addToHead(Node node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
    public void put(int key,int value){
        Node node = map.get(key);
        if (node!=null){
            node.value = value;
            moveToHead(node);
        }else{
            node = new Node(key,value);
            if (map.size()>=capacity){
                map.remove(tail.prev.key);
                removeNode(tail.prev);
            }
            map.put(key,node);
           // System.out.println(map.size());
            addToHead(node);
        }
    }
    public static void main(String[] args) {
        LRUCache1 lru = new LRUCache1(2);
        lru.put(1,111);
        lru.put(2,222);
        System.out.println(lru.get(1));
        lru.put(3,333);
        System.out.println(lru.get(1));
        System.out.println(lru.get(2));
//        lru.put(4,444);
//        lru.put(5,555);
//        System.out.println("get:"+lru.get(5));
//        lru.put(6,666);
    }
}
