package arrays2d;

import java.util.ArrayList;
import java.util.List;

public class PrintSpiral {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10,11,12}
        };

       List<Integer> ans= spiral(arr);
        System.out.println(ans);
    }

    private static List<Integer> spiral(int[][] arr) {
        List<Integer> list = new ArrayList<>();
        int n = arr.length;
        int m = arr[0].length;

        int t=0;
        int b=n-1;
        int l=0;
        int r=m-1;
        int d=0;
        while (r>=l && t<=b){
            if(d==0){
                for(int i=l;i<=r;i++){
                  list.add(arr[t][i]);
                }
                t+=1;

                d=1;
            }
           else if(d==1){
                for(int i=t;i<=b;i++){
                    list.add(arr[i][r]);
                }
                r-=1;
                 d=2;
            } else if(d==2){
                for(int i=r;i>=l;i--){
                    list.add(arr[b][i]);
                }
                b--;
                  d=3;
            } else if(d==3){
                for(int i=b;i>=t;i--){
                    list.add(arr[i][l]);
                }
                l++;
                 d=0;
            }
        }
        return list;
    }

}
