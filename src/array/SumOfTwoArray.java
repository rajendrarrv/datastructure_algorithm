package array;

import java.util.Arrays;

public class SumOfTwoArray {
    public static void main(String[] args) {
        int[] arr1 = {6,2,4};
        int[] arr2 = {7,5,6};
        sum(arr1,arr2);
    }

    private static void sum(int[] arr1, int[] arr2) {
       int i= 1;
       int j=1;
       int[] ans = new int[4];
       while (i<= arr1.length && j<= arr2.length){
           int sum = arr1[arr1.length-i] + arr2[arr2.length-j];
           ans[ans.length-i] = sum;
           i++;
           j++;
       }
        System.out.println(Arrays.toString(ans));
    }
}
