package array.questions;

import java.util.Arrays;

public class PushZeroesToEnd {
    public static void main(String[] args) {
        int[] arr={0,3,0,2,0};
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
                swap(arr,i,count);
                count++;
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
