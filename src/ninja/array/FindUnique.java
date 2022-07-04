package ninja.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rajendra Verma on 04/07/22.
 */
public class FindUnique {
    public int solution(int[] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                map.put(array[i], map.getOrDefault(array[i], 0) + 1);
            }else {
                map.put(array[i], 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) return entry.getKey();

        }
        return -1;
    }
}
