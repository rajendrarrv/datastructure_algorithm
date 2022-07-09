package array.questions;

public class ArrayIntersection {
    public static void main(String[] args) {
        int[] arr1= {10,10};
        int[] arr2={10};

        for(int i=0;i< arr1.length;i++){
            for(int j=0;j< arr2.length;j++){
                if(arr1[i]==arr2[j]){
                    System.out.print(arr1[i]+" ");
                    arr2[j]=Integer.MIN_VALUE; // because we have to change that elem , so that it does not appear twice
                    break;
                }
            }

        }
    }
}
