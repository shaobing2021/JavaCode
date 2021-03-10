package leetcode.lc140;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * linkedlist+hashmap
 */
public class LRUCache {
    private int capacity;
    private LinkedList<Integer> linkedList ;
    private HashMap<Integer,Integer> hashMap ;

    public LRUCache(int capacity){
        this.capacity = capacity;
        linkedList = new LinkedList<>();
        hashMap = new HashMap<>();
    }
    public int get(int key){
        if (hashMap.containsKey(key)){
            linkedList.remove((Integer) key);
            linkedList.addLast(key);
            return hashMap.get(key);
        }
        return -1;
    }
    public void put(int key ,int value){
        if (hashMap.containsKey(key)){
             linkedList.remove((Integer)key);
             linkedList.addLast(key);
             return;
        }
        if (linkedList.size()==capacity){
            Integer integer = linkedList.removeFirst();
            System.out.println(integer);
        }
        hashMap.put(key,value);
        linkedList.addLast(key);
    }

    public static void main(String[] args) {
        LRUCache lru = new LRUCache(5);
        lru.put(1,11);
        lru.put(2,22);
        lru.put(3,33);
        lru.put(4,44);
        lru.put(2,22);
        lru.put(5,55);
        lru.put(1,11);
        lru.put(6,66);
    }
}
