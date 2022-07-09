package array.sorting;

import java.util.Arrays;

public class CyclicSort {
    public static void main(String[] args) {

        int[] arr={1,0,2,3};
        int i=0;
        while (i< arr.length){
            int correct = arr[i];
            if( arr[i]<arr.length && arr[i]!=arr[correct]){
                swap(arr,i,correct);
            }else{
                i++;
            }
        }
        System.out.println(Arrays.toString(arr));

    }
        public static void swap(int[] arr,int j,int e){
            int temp=arr[j];
            arr[j]=arr[e];
            arr[e]=temp;
        }

}
