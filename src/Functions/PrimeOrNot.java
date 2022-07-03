package Functions;

public class PrimeOrNot {
    public static void main(String[] args) {
        printprime(10,30);
    }
    public static boolean prime(int n){
        for(int i=2;i<n;i++){
            if(n%i==0){
                return false;
            }
        }


        return true;

    }
    public static void printprime(int s,int n){
        for(int i=s;i<n;i++){
            boolean isprime = prime(i);
            if(isprime){
                System.out.println(i);
            }
        }
    }
}
