package ninja.pattern;

/**
 * Created by Rajendra Verma on 03/07/22.
 */
public class IsoscelesTriangle {
    public  void  solution(){
        int rows = 5;
// main loop
        for (int i = 0; i < rows; i++) {
// space loop
            for (int j = 1; j <rows-i ; j++) {

                System.out.print(" ");
            }

            for (int j = 0; j <i+2-1; j++) {
                System.out.print(" *");

            }
            System.out.println();


        }


//     *
//    * *
//   * * *
//  * * * *
// * * * * *




    }




    }

