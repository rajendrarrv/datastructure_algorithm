package ninja.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Rajendra Verma on 05/07/22.
 */
public class IntersectionOfArray {
    public Integer[] solution(int one[], int two[]) {
        List<Integer> resultList = new ArrayList<>();
        if (one == null || one.length == 0) {
            System.out.println("operation is not possible");
            return null;
        }
        if (two == null || two.length == 0) {
            System.out.println("operation is not possible");
            return null;
        }
        HashMap<Integer, Boolean> mapping = new HashMap<>();

        for (int i = 0; i < one.length; i++) {
            if (mapping.containsKey(one[i])) {
                mapping.put(one[i], true);
            } else {
                mapping.put(one[i], false);
            }
        }

        for (int i = 0; i < two.length; i++) {
            if (mapping.containsKey(two[i])) {
                mapping.put(two[i], true);
            } else {
                mapping.put(two[i], false);
            }
        }

        // using for-each loop for iteration over Map.entrySet()
        for (Map.Entry<Integer, Boolean> entry : mapping.entrySet()) {
            if (entry.getValue()) {
                resultList.add(entry.getKey());
                System.out.println("Paired data " + entry.getKey());
            }


        }

        Integer[] s = new Integer[resultList.size()];
        return resultList.toArray(s);
    }
}
