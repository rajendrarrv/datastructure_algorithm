package com.rajendra.collection.algorithm;

import java.util.Arrays;

/**
 * Created by Rajendra Verma on 25/09/22.
 */
public class KadaneAlgorithm {


    public void simpleApproach(int[] array) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                sum += array[j];
                max = Math.max(sum, max);
            }
            sum = 0;
        }
        System.out.println("Result " + max);
    }


    /*
    the problem with the simple approch is the time complexity log2N when the size of the array is larger than the answer is not acceptable
     */

    public void kadaneApproach(int[] array) {
        int sum = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {

            sum += array[i];
            max = Math.max(sum, max);
            if (sum < 0)
                sum = 0;
        }

        System.out.println("Result " + max);

    }

    public int minimumCardPickup(int[] cards) {
        int[] lastIndex = new int[10000001];
        Arrays.fill(lastIndex,-1);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < cards.length; i++) {
            if (lastIndex[cards[i]]!=-1)
                ans = Math.min(i - lastIndex[cards[i]] + 1,ans);
            lastIndex[cards[i]] = i;
        }
        return ans == Integer.MAX_VALUE?-1:ans;
    }

}
