package loops;

public class Armstrong {
    public static void main(String[] args) {
        int n=1537;
        int digit =n;
        int og=n;
        int ans=0;
        int count=0;
        while(digit>0){
          int l=  digit%10;
          count++;
            digit/=10;
        }
        while (n>0){
            int l= n%10;
            ans += Math.pow(l,count);
            n/=10;
        }
        System.out.println(ans);
        if(ans==og){
            System.out.println("armstrong");
        } else{
            System.out.println("not armstrong");
        }
    }
}
