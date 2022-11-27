package com.rajendra.practice.exculsive;

import java.util.Arrays;

/**
 * Created by Rajendra Verma on 08/09/22.
 */
public class NumArray {
    private int[] prefixArray;

    public NumArray(int[] nums) {
        prefixArray = nums;
    }

    public int sumRange(int left, int right) {
        int sum  =0;
        for (int i = left; i <=right ; i++) {
            sum  =sum+prefixArray[i];
        }
        return sum;
    }

    public static void main(String[] args) {

        int[] data = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(data);

        System.out.println("Sum of Range "+numArray.sumRange(0,2));
        System.out.println("Sum of Range "+numArray.sumRange(2,5));
        System.out.println("Sum of Range "+numArray.sumRange(0,5));


    }
}
