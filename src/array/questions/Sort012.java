package array.questions;

import java.util.Arrays;

public class Sort012 {
    public static void main(String[] args) {
        int[] arr= {0,1,2,0,2,0,1};
        sort012(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort012(int[] arr) {
        int s=0;
        int m=0;
        int e= arr.length-1;
        while (m<=e){
            if(arr[m]==0){
                swap(arr,m,s);
                s++;
                m++;
            }
           else if(arr[m]==1){
                m++;
            }
            else if (arr[m]==2){
                swap(arr,e,m);
                e--;
            }
        }

    }

    private static void swap(int[] arr, int s, int e) {
        int temp = arr[s];
        arr[s]=arr[e];
        arr[e]=temp;
    }
}
