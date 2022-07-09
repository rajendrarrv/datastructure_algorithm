package array.questions;

public class FindUnique {
    public static void main(String[] args) {
        int[] arr = {2,3,1,6,3,6,2};
        


        for(int i=0;i<arr.length;i++){
           int unique=arr[i];
            boolean duplictae = false;
            for(int j=i;j< arr.length-1;j++){
                if(arr[j+1]==unique  ){
                    duplictae=true;
                    break;
                } 
            }
            if(!duplictae) {
                System.out.println(unique);
                return;
            }
        }

    }
}
