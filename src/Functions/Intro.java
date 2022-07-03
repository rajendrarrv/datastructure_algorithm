package Functions;

import java.util.Scanner;

public class Intro {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
      int num=  fact(n);
        int r= sc.nextInt();
      int d1=  fact(r);
      int d2=  fact(n-r);

        int per = num/((d1)*(d2));
        System.out.println(per);


    }
    public static int fact(int n){
        int fac=1;
        for(int i=1;i<=n;i++){
            fac*=i;
        }
        return fac;
    }
}
