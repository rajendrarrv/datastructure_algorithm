package ninja.array;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by Rajendra Verma on 02/07/22.
 */
public class LinearSearch {
    public  int  solution(int [] array, int number){
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {

            if (array[i]==number){
                return i;
            }
        }

        return  -1;
    }
}
