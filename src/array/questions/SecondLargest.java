package array.questions;

public class SecondLargest {
    public static void main(String[] args) {
        int[] arr={2,2,2};
        System.out.println(Slargest(arr));
    }

    private static int Slargest(int[] arr) {
        int lar=Integer.MIN_VALUE;
        int sc=Integer.MIN_VALUE;
        boolean nsame = false;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>lar){
                lar=arr[i];
            }
        }
       for(int i=0;i<arr.length;i++){
           if(arr[i]==lar){
               continue;
           }
           if(arr[i]>sc){
               nsame=true;
               sc=arr[i];
           }
       }
       if(nsame){
           return sc;
       } else{
           return Integer.MIN_VALUE;
       }
    }
}
