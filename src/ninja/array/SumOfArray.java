package ninja.array;

/**
 * Created by Rajendra Verma on 02/07/22.
 */
public class SumOfArray {

    public int solution(int[] array) {
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            result = result + array[i];
        }
        return result;
    }

}
