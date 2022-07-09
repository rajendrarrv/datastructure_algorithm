package ajavaBasics;

import java.util.Scanner;

public class Assi {
//    public static void main(String args[])
//    {
//        Scanner sc = new Scanner(System.in);
//        char c = sc.nextLine().charAt(0);
//
//        if(c>='A' && c<='Z'){
//            System.out.println(1);
//        } else if (c>='a' && c<='z'){
//            System.out.println(-1);
//        } else{
//            System.out.println(0);
//        }
//
//    }
public static void main(String args[])
{
    int x = 10;
    int y = 20;
    if(x++ > 10 || ++y > 20 ){
        System.out.print("Inside if  ");
    }else{
        System.out.print("Inside else  ");
    }
    System.out.println(x  + " " + y);
}
}

