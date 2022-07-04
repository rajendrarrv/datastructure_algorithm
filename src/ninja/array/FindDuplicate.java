package ninja.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Rajendra Verma on 04/07/22.
 */
public class FindDuplicate {
    public List<Integer> solution(int[] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                map.put(array[i], map.getOrDefault(array[i], 0) + 1);
            } else {
                map.put(array[i], 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 2) {
                resultList.add(entry.getKey());
            }

        }
        return resultList;
    }
}
