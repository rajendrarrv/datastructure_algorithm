package array.questions;

import java.util.Arrays;

public class Sort01 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 0, 1, 0, 1, 0, 0, 1, 1};
     //   sort01(arr);
        sort01tp(arr);
        System.out.println(Arrays.toString(arr));

    }
    private static void sort01tp(int[] arr) {

        int s=0;
        int e= arr.length-1;

        while (s<e){
            if (arr[s]==0){
                s++;
            }
            else if (arr[e]==1){
                e--;
            }
          else if (s<e) {
                swap(arr, s, e);
                s++;
                e--;
            }
        }

    }


    private static void sort01(int[] arr) {
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                count++;
            }
        }
        for(int i=0;i<count;i++){
            arr[i]=0;
        }
        for(int i=count;i<arr.length;i++){
            arr[i]=1;
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void swap(int[] arr, int s, int e) {
        int temp = arr[s];
        arr[s]=arr[e];
        arr[e]=temp;
    }
}
