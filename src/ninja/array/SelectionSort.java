package ninja.array;

import utils.PrintArray;

/**
 * Created by Rajendra Verma on 23/07/22.
 */

public class SelectionSort {
    public void solution(int[] input) {

        PrintArray printArray = new PrintArray();
        printArray.title("SelectionSort");
        printArray.input();
        printArray.horizontal(input);
        printArray.end();

        for (int i = 0; i < input.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < input.length; j++) {
                if (input[j] < input[index])
                    index = j;
            }
            int temp = input[index];
            input[index] = input[i];
            input[i] = temp;
        }
        printArray.output();
        printArray.horizontal(input);
    }


}
