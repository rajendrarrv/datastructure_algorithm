package javaBasics;

public class Largestof3 {
    public static void main(String[] args) {
        int a=8,b=8,c=5;

        if(a>=b && a>=c){
            System.out.println("a is largest");
        }
      else  if(b>=a && b>=c){
            System.out.println("b is largest");
        }
        else{
            System.out.println("c is largest");
        }
    }
}
