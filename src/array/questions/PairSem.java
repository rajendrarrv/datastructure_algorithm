package array.questions;

public class PairSem {
    public static void main(String[] args) {
        int[] arr= {2,8,10,5,-2,5};

        int count=0;
        int x=10;
        for(int i=0;i< arr.length;i++){
            for(int j=i+1;j< arr.length;j++){
                if(arr[i]+arr[j]==x){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
