package ninja.array;

/**
 * Created by Rajendra Verma on 09/07/22.
 */
public class TripleSum {
    public int solution(int[] array, int x) {
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                for (int k = j + 1; k < array.length; k++) {
                    int a = array[i];
                    int b = array[j];
                    int c = array[k];
                    int sum = a + b + c;
                    if (sum == x) counter++;

                }
            }
        }

        return counter;
    }

}
