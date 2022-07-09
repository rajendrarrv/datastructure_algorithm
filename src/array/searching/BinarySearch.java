package array.searching;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {7,8,9};
        int key=7;
        System.out.println(binarys(arr,key));
    }

    private static int binarys(int[] arr, int key) {
        int s=0;
        int e=arr.length-1;
        while (s<=e){
            int mid=(s+e)/2;
            if(arr[mid]==key){
                return mid;
            }
            else if(arr[mid]>key){
                e=mid-1;
            }
           else {
                s=mid+1;
            }
        }
        return -1;
    }
}
