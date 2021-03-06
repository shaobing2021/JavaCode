package algorithm.sort;

import java.util.Arrays;

public class MaxPQ {
    public static void main(String[] args) {
        int[] arr = {2,5,8,1,3,9,0,7};
        MaxPQ maxPQ = new MaxPQ(arr);
        int[] pq = maxPQ.getPq();
        maxPQ.buildHeap();
        System.out.println(Arrays.toString(maxPQ.getPq()));
        System.out.println(maxPQ.N);
        while (maxPQ.N>0){
            System.out.print(maxPQ.delMax()+" ");
        }
    }

    private int[] pq;
    private int N = 0;
    public MaxPQ(int maxN){
//        为什么是maxN+1，因为第一个元素不用。
        pq = new int[maxN+1];
    }

    public int[] getPq() {
        return pq;
    }

    public MaxPQ(int[] arr){
        pq = new int[arr.length+1];
        System.arraycopy(arr,0,pq,1,arr.length);
        N = arr.length;
    }
    public void buildHeap(){
        for (int i = N/2; i > 0; i--) {
            sink(i);
        }
    }
    public boolean isEmpty(){
        return N==0;
    }
    public int size(){
        return N;
    }
    public void insert(int v){
        pq[++N] = v;
        swim(N);
    }
    public int delMax(){
        int max = pq[1];
        swap(1,N--);
        sink(1);
        return max;
    }
//    上浮
    private void swim(int k){
        while (k>1 && pq[k/2]<pq[k]){
            swap(k/2,k);
            k=k/2;
        }
    }
    private void swap(int i,int j){
        int temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }
//    下沉
    private void sink(int k){
//        这里判断了k有孩子节点
        while (2*k<=N){
            int j = 2*k;
//            这里要判断是否有两个孩子节点
            if (j<N && pq[j]<pq[j+1]) j++;
//            完成判断，当前节点是否大于右孩子节点，大于则说明不要进行下沉了
            if (pq[k]>pq[j]) break;
            swap(k,j);
            k=j;
        }
    }
}
