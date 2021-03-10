package offer.lc5;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class MaxQueue1 {
    /**
     * linkedlist实现了list接口，queue接口
     * list:add,contains,get,indexof接口
     * queue:offer,remove,peek   抽象类
     * linkedlist:removefirst,removelast,offer  双向链表
     * stack:push,pop,peek
     */

    public static void main(String[] args) {
        LinkedList<Integer> lists = new LinkedList<>();
        lists.offer(1);
        System.out.println(lists);
        Stack<Object> objects = new Stack<>();
        Queue q = new LinkedList();
    }

    LinkedList<Integer> list ;
    LinkedList<Integer> max ;
    public MaxQueue1() {
        list = new LinkedList();
        max = new LinkedList();
    }

    public int max_value() {
        if (list.isEmpty()) return -1;
        return max.getFirst();
    }

    public void push_back(int value) {
        list.add(value);
        while (!max.isEmpty()&&max.getLast()<value){
            max.removeLast();
        }
        max.addLast(value);
    }

    public int pop_front() {
        if (list.isEmpty()) return -1;
        Integer temp = list.removeFirst();
        Integer maxFirst = max.getFirst();
        if (temp.equals(maxFirst)){
            max.removeFirst();
        }
        return temp;
    }
}
