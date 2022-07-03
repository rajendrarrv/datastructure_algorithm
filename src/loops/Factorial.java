package loops;

public class Factorial {
    public static void main(String[] args) {
        int n=5;
        int fac=1;

        for(int i=n;i>=1;i--){
            fac*=i;
        }
        System.out.println(fac);
    }
}
