package loops;

import java.util.Scanner;

public class ApSeries {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int x= sc.nextInt();

        for(int i=1;i<=x;i++){
            int ap = (3*i)+2;
            if(ap%4==0){
                x++;
                continue;
            }
            System.out.print(ap+ " ");
        }
    }
}
