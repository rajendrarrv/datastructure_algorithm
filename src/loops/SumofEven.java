package loops;

public class SumofEven {
    public static void main(String[] args) {
        int sum=0;
        int n=10;

//        for(int i=1;i<=n;i++){
//            if(i%2==0){
//                sum+=i;
//            }
//        }
//        System.out.println(sum);
        int i=1;
        while(i<=n){
            if(i%2==0){
                sum+=i;
           }
            i++;
        }
        System.out.println(sum);
    }
}
