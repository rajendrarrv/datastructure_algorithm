package javaBasics;

import java.util.Scanner;

public class Powe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x= sc.nextInt();
        int y = sc.nextInt();

        if(y==0){
            System.out.println(1);
            return;
        }
        int pow=1;
        while (y>0){
            pow=pow*x;
           y= y-1;
        }
        System.out.println(pow);
    }
}
