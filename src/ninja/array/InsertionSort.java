package ninja.array;

import utils.PrintArray;

/**
 * Created by Rajendra Verma on 23/07/22.
 */
public class InsertionSort {

    public void solution(int[] input) {
        PrintArray printArray = new PrintArray();
        printArray.title("InsertionSort");
        printArray.input();
        printArray.horizontal(input);
        int n = input.length;
        for (int i = 0; i < n; i++) {
            System.out.println("Outer loop"+i);
            int key = input[i];
            int j = i - 1;
            while (j >= 0 && input[j] > key) {

                input[j + 1] = input[j];
                j = j - 1;
                System.out.println();
                System.out.println("Innter loop"+j);
                printArray.horizontal(input);
            }
            input[j + 1] = key;
        }
        System.out.println("OUTPUT ARRAY");
        printArray.horizontal(input);

    }
}
