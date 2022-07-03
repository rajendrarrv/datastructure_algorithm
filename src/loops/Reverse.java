package loops;

public class Reverse {
    public static void main(String[] args) {
        int n=1239;
        int count=0;
        int rev = 0;
        while (n>0){
            int rem = n%10;
             rev=rev*10+rem;
            count++;

            n=n/10;
        }
        System.out.println(" ");
        System.out.println(count);
        System.out.print(rev);

    }

}
