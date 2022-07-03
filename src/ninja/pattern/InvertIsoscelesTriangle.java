package ninja.pattern;

/**
 * Created by Rajendra Verma on 03/07/22.
 */
public class InvertIsoscelesTriangle {
    public  void  solution(){
        int n=4;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i+1;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
