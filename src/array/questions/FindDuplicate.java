package array.questions;

public class FindDuplicate {
    public static void main(String[] args) {
        int[] arr= {0,7,2,5,4,7,1,3,6};
       int ans= duplicate(arr);
        System.out.println(ans);
    }

    private static int duplicate(int[] arr) {
        for(int i=0;i< arr.length;i++){
            int dup=arr[i];
            for(int j=i+1;j< arr.length;j++){
                if(arr[j]==dup){
                    return dup;
                }
            }
        }

        return -1;
    }
}
