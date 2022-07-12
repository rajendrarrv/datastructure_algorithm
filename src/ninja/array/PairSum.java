package ninja.array;

/**
 * Created by Rajendra Verma on 05/07/22.
 */
public class PairSum {
    public int solution(int array[], int x) {
        int count = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int a = array[i];
                int b = array[j];

                int sum = a + b;

                if (sum == x) count++;

            }
        }
        return count;
    }
}
