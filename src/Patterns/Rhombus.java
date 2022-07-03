package Patterns;

public class Rhombus {
    public static void main(String[] args) {
        int n=4;
        for(int i=1;i<=n;i++){
            int space=n-i;
            for(int s=1;s<=space;s++){
                System.out.print(" ");
            }
            for(int j=1;j<=n;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
