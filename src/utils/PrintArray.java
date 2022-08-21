package utils;

/**
 * Created by Rajendra Verma on 23/07/22.
 */
public class PrintArray {


    public void horizontal(int[] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.print(" " + input[i]);
        }
    }

    public void title(String title) {
        System.out.println("--------------------------" + title + "-----------------------------");
    }

    public void input() {
        System.out.println("-----------------------INPUT--------------------------");

    }

    public void end() {
        System.out.println();
        System.out.println("------------------------------------------------------");

    }

    public void output() {
        System.out.println();
        System.out.println("------------------OUTPUT------------------------------");

    }

    public void vertical(int[] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.println(input[i]);
        }
    }

    public void answer(Object answer) {
        System.out.println("ANSWER "+answer);
    }
}
