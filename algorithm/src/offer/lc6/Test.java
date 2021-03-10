package offer.lc6;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 0 1 2 3 4
 * 0 1 3 4
 * 1 3 4
 * 1 3
 * 3
 */
public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator<Integer> iter = list.iterator();
//        while (iter.hasNext()){
//            Integer temp = iter.next();
//            list.remove(temp);
//        }
//        for (Integer integer : list) {
//            list.remove(integer);
//        }
//        for (int i = 0; i < list.size(); i++) {
//            Integer integer = list.get(i);
//            System.out.println(integer);
//            list.remove(integer);
//            i--;
//        }
        while (iter.hasNext()){
            Integer next = iter.next();
            System.out.println(next);
            iter.remove();
        }
    }
    public int lastRemaining(int n, int m) {

        if (n==0||m==0) return -1;
        ArrayList<Integer> list = new ArrayList();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int c = (m-1)%n;
        while (list.size()!=1){
            list.remove(c);
            c = (c+m-1)%list.size();
        }
        return list.get(0);
    }
}
