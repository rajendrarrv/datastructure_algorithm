package com.rajendra.utils;

import java.util.Arrays;

/**
 * Created by Rajendra Verma on 25/09/22.
 */
public class ArraysUtils {
    public void printSubArrays(int [] arrA){

        int arrSize = arrA.length;
        //start point
        for (int startPoint = 0; startPoint <arrSize ; startPoint++) {
            //group sizes
            for (int grps = startPoint; grps <=arrSize ; grps++) {
                //if start point = 1 then
                //grp size = 1 , print 1
                //grp size = 2, print 1 2
                //grp size = 3, print 1 2 3 ans so on
                System.out.print("[");

                for (int j = startPoint ; j < grps ; j++) {
                    System.out.print(" "+arrA[j] + "");
                }
                System.out.print("]");
                System.out.println();
            }
        }
    }


    public void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }
}
