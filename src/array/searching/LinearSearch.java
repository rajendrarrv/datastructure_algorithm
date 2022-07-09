package array.searching;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 34, 5, 64, 3, 32};
        int key = 5;

        System.out.println(linearS(arr,key));
    }
    public static int linearS(int[] arr,int key){
            for(int i=0;i<arr.length;i++){
                if(arr[i]==key){

                    return i;
                }
            }
           return -1;
        }

}
