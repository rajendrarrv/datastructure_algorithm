package loops;

import java.util.Arrays;

public class DecimalToBinary {
    public static void main(String[] args) {
        int[] arr = new int[40];
        int n=10;
        int store=0;
        while(n>0){
            int rem = n%2;
            arr[store++]=rem;
            n/=2;
        }
        for(int i=store-1;i>=0;i--){
            System.out.println(arr[i]);
        }
    }
}
