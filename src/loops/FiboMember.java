package loops;

public class FiboMember {
    public static void main(String[] args) {
        int n=35;
        int i=0;
        int j=1;
        int fib=0;
        while(fib<n){
            fib=i+j;
            i=j;
            j=fib;
        }
        if(n==fib){
            System.out.println("belong to fibonachi series");
        } else{
            System.out.println("does not belong");
        }

    }
}
