package exam.tx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * 大团队n个人，m个小团队
 *
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            int num = sc.nextInt();
            for (int j = 0; j < num; j++) {
                list.add(sc.nextInt());
            }
            lists.add(list);
        }
        help(lists);
    }
    private static void help(ArrayList<ArrayList<Integer>> list){
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> queue = new ArrayList<>();
        queue.add(0);
        while (!queue.isEmpty()){
            Integer item = queue.remove(0);
            set.add(item);
            for (ArrayList<Integer> l : list) {
                if (l.contains(item)){
                    for (Integer integer : l) {
                        if (!queue.contains(integer)&&!set.contains(integer)){
                            queue.add(integer);
                        }
                    }
                }
            }
        }
        System.out.println(set.size());
//        for (Integer integer : set) {
//            for (int i = 0; i < list.size(); i++) {
//                ArrayList<Integer> l = list.get(i);
//                if (l.contains(integer)){
//                    for (Integer i1 : l) {
//                        set.add(i1);
//                    }
//                    list.remove(i);
//                }
//            }
//        }

    }
}
