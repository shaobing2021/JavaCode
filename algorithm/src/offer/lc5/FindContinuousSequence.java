package offer.lc5;

import java.util.ArrayList;

public class FindContinuousSequence {
    public static void main(String[] args) {
        System.out.println(FindContinuousSequence(3));
    }
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> listss = new ArrayList<>();
        int left = 1; //定义左边界
        int right = 1; //定义有边界
        int res = 0; //定义结果
        while (left<=(sum/2)){
            //右边界右移
            if (res<sum){
                res+=right;
                right++;
            }else if (res>sum){//左边界左移
                res-=left;
                left++;
            }else {
                ArrayList<Integer> lists = new ArrayList<>();
                for (int i = left; i < right; i++) {
                    lists.add(i);
                }
                listss.add(lists);
                res-=left;
                left++;
            }
        }
        return listss;
    }
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence1(int sum) {
//        ArrayList<ArrayList<Integer>> listss = new ArrayList<>();
//        for (int i = 1; i < sum/2; i++) {
//            ArrayList<Integer> lists = new ArrayList<>();
//            int res =0;
//            for (int j = i; j < sum; j++) {
//               res+= j;
//               lists.add(j);
//               if (res==sum) {
//                   listss.add(lists);
//                   break;
//               }else if (res>sum){
//                   break;
//               }
//            }
//        }
        ArrayList<ArrayList<Integer>> listss = new ArrayList<>();
        for (int i = 1; i <= sum/2; i++) {
            ArrayList<Integer> lists = new ArrayList<>();
            int res =0;
            for (int j = i; j <sum; j++) {//实际j<=sum/2+1
                res+= j;
                lists.add(j);
                if (res==sum&&lists.size()>1) {
                    listss.add(lists);
                    break;
                }else if (res>sum){
                    break;
                }
            }
        }
        return listss;
    }
}
