package Patterns;

public class Diamond {
    public static void main(String[] args) {
        int n=5;

        for(int i=1;i<=2*n-1;i++){
            int space;
            if(i>n){
            space=i-n;
            } else {
                space=n-i;
            }
            for(int j=1;j<=space;j++){
                System.out.print(" ");
            }
            int col;
            if(i>n){
                col=2*n-i;
            } else{
                col=i;
            }
            for(int j=1;j<=col;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
