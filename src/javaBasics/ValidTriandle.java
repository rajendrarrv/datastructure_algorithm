package javaBasics;

public class ValidTriandle {
    public static void main(String[] args) {
        int a=7,b=2,c=8;
        // a triangle is valid only if its 2 sides are greater then the 3rd side
        if(a+b>c && b+c>a && a+c>b ){
            System.out.println("valid");
        }
        else{
            System.out.println("not valid");
        }
    }
}
