package loops;

public class LargestOfN {
    public static void main(String[] args) {
        int n=5;
        int[] arr = {52,80,399,1000,12987};
        int lar=arr[0];

        for(int i=0;i<n;i++){
            if(arr[i]>=lar){
                lar=arr[i];
            }
        }
        System.out.println(lar);
    }
}
