package algorithm.search;

/**
 * 1 2 3 5 5 5 6
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,3,4,5,6,8,9,15};
        System.out.println(binarySearch(arr,8));
    }

    private static Integer binarySearch(int[] arr,int key){
        int low = 0;
        int high = arr.length-1;
        while (high>=low){
            int mid = low +(high-low)/2;
            if (arr[mid]==key) return mid;
            else if (arr[mid]>key) {
                high = --mid;
            }else {
                low = ++mid;
            }
        }
        return null;
    }
}
