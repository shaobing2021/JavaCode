package offer.lc5;

import java.util.ArrayList;

public class MaxQueue {
    public static void main(String[] args) {
        MaxQueue maxQueue = new MaxQueue();
        maxQueue.push_back(1);
        maxQueue.push_back(3);
        maxQueue.push_back(2);
        maxQueue.push_back(3);
        System.out.println(maxQueue.max_value());
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.max_value());
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.max_value());
    }
    ArrayList list;
    ArrayList max ;
    public MaxQueue(){
        list = new ArrayList<Integer>();
        max = new ArrayList<Integer>();
    }
    public int max_value() {
        if (list.isEmpty()) return -1;
        return (Integer) max.get(0);
    }
    public void push_back(int value) {
        list.add(value);
        while (!max.isEmpty()&&(Integer)max.get(max.size()-1)<value){
            max.remove(max.size()-1);
        }
        max.add(value);
    }
    public int pop_front() {
        if (list.size()==0) return -1;
        Integer temp = (Integer) list.remove(0);
        if (temp.equals(max.get(0))) max.remove(0);//注意这里一定要用equals
        return temp;
    }
}
