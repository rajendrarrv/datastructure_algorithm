package javaBasics;

import java.util.Scanner;

public class TotalSalary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int salary = sc.nextInt();
        char grade = sc.nextLine().charAt(0);
        System.out.println(grade);

//        float hra = (20.0f/100)*salary;
//        System.out.println(hra);
//        float da = (50.0f/100)*salary;
//        System.out.println(da);
//        float pf = (11.0f/100)*salary;
//        System.out.println(pf);

        int allow;
        if(grade=='A'){
            allow=1700;
        } else if(grade=='B'){
            allow=1500;
        } else{
            allow=1300;
        }
        System.out.println(allow);
//        float totalSalary = salary + hra + da+ allow-pf;
//        System.out.println(totalSalary);
//        int ts = Math.round(totalSalary);
//        System.out.println(ts);
   }
}
