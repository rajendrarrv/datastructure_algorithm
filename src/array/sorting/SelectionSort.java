package array.sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {1,2,4,3,4,53,-5,87,-9};
        bubblesort(arr);
        selectionsort(arr);
        insertionSort(arr);
    }

    private static void insertionSort(int[] arr) {
        for(int i=1;i<arr.length;i++){
            for(int j=i;j>0;j--){
                if(arr[j-1]>arr[j]){
                    swap(arr,j-1,j);
                }
            }

        }
        System.out.println(Arrays.toString(arr));
    }

    private static void selectionsort(int[] arr) {

        for (int m = 0; m < arr.length; m++){
            int min = arr[m];
            int minIndex = m;
            for (int i = m; i < arr.length; i++) {
                if (arr[i] < min) {
                    min = arr[i];
                    minIndex =i;
                }
            }
            swap(arr,m,minIndex);
    }

        System.out.println(Arrays.toString(arr));
    }

    private static void bubblesort(int[] arr) {
        for(int i=0;i<arr.length;i++){
            for (int j=0;j< arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                }
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
