package array.questions;

public class LargestNo {
    public static void main(String[] args) {
        int[] arr = {3897,4,2,7,999,72};
        int largest = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>largest){
                largest=arr[i];
            }
        }
        System.out.println(largest);

    }


}
