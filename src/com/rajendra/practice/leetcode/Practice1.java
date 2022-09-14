package com.rajendra.practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Rajendra Verma on 13/09/22.
 */
public class MatrixUtils {

    int matrix[][];


    public MatrixUtils(int[][] matrix) {
        this.matrix = matrix;
    }


    private List<Integer> diagonal(int[][] ints) {
        List<Integer> result = new ArrayList<>();
//        length of Matrix
        int m = ints.length;
        int n = ints[0].length;
//        index
        int row = 0, col = 0;
        boolean up = true;

//         we will move untill not traverse to all the element of matrix.
        while (row < m && col < n) {

// here  boolean up will decide where to move
            if (up) {
//                moving of up ,

                while (row > 0 & col < n - 1) { // moving up to the last column
                    result.add(ints[row][col]);
                    row--;
                    col++;
                }
                result.add(ints[row][col]); //  fill the last index
                if (col == n - 1) { // if it is not reached to the respective col for the next step
                    row++;
                } else {
                    col++;
                }
            } else {
                while (row < n - 1 & col > 0) {
                    result.add(ints[row][col]);
                    col--;
                    row++;
                }
                result.add(ints[row][col]);
                if (row == m-1){
                    col++;
                }else {
                    row++;
                }


            }
// we will switch up and down untill  not rached to the end of the matrix
            if (up) up = false;
            else up = true;

        }

        return result;
    }


    public static void main(String[] args) {
        MatrixUtils d = new MatrixUtils(null);
       List<Integer> result =   d.diagonal(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        System.out.println(result);
    }

    void reverse(int[] arr, int s, int e) {
        while (s < e) {
            int temp = arr[s];
            arr[s++] = arr[e];
            arr[e--] = temp;
        }
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, n - k, n - 1);
        reverse(nums, 0, n - k - 1);
        reverse(nums, 0, n - 1);
        System.out.println(Arrays.toString(nums));

    }
}
