package ninja.array;

/**
 * Created by Rajendra Verma on 10/07/22.
 */
public class Sorting {
    public void solution(int array[]) {

        for (int k = 0; k < array.length; k++) {
            System.out.print(" "+array[k]);
        }
        System.out.println();
        System.out.println("---before--");
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {

                int a = array[i];
                int b = array[j];

                if (a>b) {
                    int temp = a;
                    a = b;
                    b = temp;
                    array[i] = a;
                    array[j] = b;
                }

            }

        }
        System.out.println("--after---");

        for (int k = 0; k < array.length; k++) {
            System.out.print(" "+array[k]);
        }


    }
}
