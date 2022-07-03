package loops;

public class PrimeorNot {
    public static void main(String[] args) {
        int a=19;

//        for(int i=2;i<=a;i++){
//            if(a==i){
//                System.out.println("prime");
//                break;
//            }
//            if(a%i==0){
//                System.out.println("not prime");
//                break;
//            }
//        }

        int i=2;
        while(i<a){
            if(a%2==0){
                System.out.println("not prime");
                break;
            }
            i++;
        }
        if(i==a){
            System.out.println("prime");
        }
    }
}
