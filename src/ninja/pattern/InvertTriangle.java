package ninja.pattern;

/**
 * Created by Rajendra Verma on 03/07/22.
 */
public class InvertTriangle
{

    public  void  solution(){
        int n=5;
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n-i; j++) {
                System.out.print(" *");

            }
            System.out.println();
        }
    }
}
