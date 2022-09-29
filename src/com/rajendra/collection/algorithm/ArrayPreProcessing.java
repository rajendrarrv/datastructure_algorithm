package com.rajendra.collection.algorithm;

import java.util.Arrays;

/**
 * Created by Rajendra Verma on 26/09/22.
 */
public class ArrayPreProcessing {


    public int trap(int[] heights) {
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            leftMax = Math.max(leftMax, heights[i]);
            left[i] = leftMax;
        }

        for (int i = heights.length - 1; i >=0; i--) {
            rightMax = Math.max(rightMax, heights[i]);
            right[i] = rightMax;
        }

        int trapWater = 0;
        for (int i = 0; i < heights.length; i++) {

            trapWater += Math.min(left[i], right[i]) - heights[i];
          //  System.out.println(trapWater);
        }
        return trapWater;
    }


}
