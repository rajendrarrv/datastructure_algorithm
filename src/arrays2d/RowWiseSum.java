package arrays2d;

import java.time.chrono.MinguoDate;

public class RowWiseSum {
    public static void main(String[] args) {
        int[][] arr = {
                {3,6,9},
                {1,4,7},
                {2,8,9}
        };
//  rowsum(arr);
//  colsum(arr);
        largestRoworCol(arr);

    }

    private static void largestRoworCol(int[][] arr) {
     int[] rs=   rowsum(arr);
      int[] cs=  colsum(arr);

        if(rs[1]>cs[1] ){
            System.out.println("row " + rs[0] +" " + rs[1]);
        } else{
            System.out.println("col " + cs[0] +" " +  cs[1]);
        }

    }

    private static int[]  colsum(int[][] arr) {

int cols = arr[0].length;
int largest = Integer.MIN_VALUE;
int index = -1;
        for(int i=0;i<cols;i++){
            int sum=0;
            for(int j=0;j<arr.length;j++){
             sum+=   arr[j][i];
             if(sum>largest){
                 largest=sum;
                 index=i;
             }
            }

        }
        return new int[]{index,largest};
    }

    private static int[] rowsum(int[][] arr) {
        int largest = Integer.MIN_VALUE;
       int index = -1;
            for(int i=0;i< arr.length;i++){
                int sum=0;
                for(int j=0;j<arr[i].length;j++){
                    sum+= arr[i][j];
                    if(sum>largest){
                        largest=sum;
                        index =i;
                    }
                }

            }
       return new int[]{index,largest};
        }

            }
