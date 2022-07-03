package Patterns;

public class Palindrome {
    public static void main(String[] args) {
        int n=5;
        for(int i=1;i<=n;i++){
            int space = n-i;
            for(int s=1;s<=space;s++){
                System.out.print("  ");
            }
            for(int j=i;j>1;j--){
                System.out.print(j +" ");
            }
            for(int j=1;j<=i;j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}
