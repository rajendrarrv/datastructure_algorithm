package array.questions;

import java.util.Arrays;

public class ArrangeNo {
    public static void main(String[] args) {
        int n=9;
        int[] arr = new int[n];
int count=0;
        for(int i=1;i<=n;i++) {
            if (i % 2 != 0) {
                arr[count] = i;
                count++;
            }
        }
            for(int i=n;i>1;i--){
                if(i%2==0){
                    arr[count]=i;
                    count++;
                }
        }
        System.out.println(Arrays.toString(arr));
    }
}