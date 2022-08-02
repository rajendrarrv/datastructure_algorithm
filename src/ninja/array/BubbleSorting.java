package ninja.array;

import utils.PrintArray;

/**
 * Created by Rajendra Verma on 23/07/22.
 */
public class BubbleSorting {
    public void solution(int[] input) {
        int n = input.length;
        PrintArray printArray = new PrintArray();
        printArray.title("BubbleSorting");
        printArray.input();
        printArray.horizontal(input);
        for (int i = 0; i < n - 1; i++) {
            System.out.println("OUTER LOOP");
            for (int j = 0; j < n - i - 1; j++) {
                System.out.println("---INNER LOOP");
                if (input[j] > input[j + 1]) {
                    int temp = input[j];
                    input[j] = input[j + 1];
                    input[j + 1] = temp;
                }

            }
        }
        printArray.output();
        printArray.horizontal(input);

    }
}
