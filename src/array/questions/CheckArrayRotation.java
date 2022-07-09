package array.questions;

public class CheckArrayRotation {
    public static void main(String[] args) {
        int[] arr={10,20,30,1};
        System.out.println(checkR(arr));
        int ans=findPivot(arr);
        System.out.println(ans+1);
    }

    private static int findPivot(int[] arr) {
        int s=0;
        int e= arr.length-1;
        while (s<=e){
            int mid = (s+e)/2;
            if( mid<e && arr[mid]>arr[mid+1]){
                return mid;
            }
            if( mid>s && arr[mid-1]>arr[mid]){
                return mid-1;
            }
            if(arr[s]>=arr[mid]){
                e=mid-1;
            }
            if(arr[s]<arr[mid]){
                s=mid+1;
            }
        }
        return -1;
    }

    private static int checkR(int[] arr) {
        int lar= Integer.MIN_VALUE;
        int index=-1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>lar){
                lar=arr[i];
                index=i;

            }
        }
        if(index==arr.length-1){
            return 0;
        }
        return index+1;
    }
}
