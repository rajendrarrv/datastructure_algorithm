package loops;

public class Primebtw2no {
    public static void main(String[] args) {
        int s=2;
        int e=23;
           for(int i=s;i<=e;i++){
        for(int j=2;j<=i;j++) {

            if(i==j){
                System.out.println(i);
                break;
            }

            if(i%j==0){
              break;
            }
        }
        }
    }
}
