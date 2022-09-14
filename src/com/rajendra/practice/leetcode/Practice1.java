package com.rajendra.practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Rajendra Verma on 13/09/22.
 */
public class Practice1 {


    public Practice1() {
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
                if (row == m - 1) {
                    col++;
                } else {
                    row++;
                }


            }
// we will switch up and down untill  not rached to the end of the matrix
            if (up) up = false;
            else up = true;

        }

        return result;
    }

    public List<Integer> sprial(int[][] input) {
        List<Integer> result = new ArrayList<>();
        int row = 0;
        int col = 0;
        int i = 0;
        int rowLen = input.length;
        int colLen = input[0].length;

        while (row < rowLen && col < colLen) {

//            moving left
            for (i = col; i < colLen; i++) {
                result.add(input[row][i]);
            }
            row++;

//            moving down
            for (i = row; i < rowLen; i++) {
                result.add(input[i][colLen - 1]);

            }

            colLen--;

            if (row < rowLen) {

                for (i = colLen - 1; i >= col; --i) {
                    result.add(input[rowLen - 1][i]);
                }

//     move right

                rowLen--;
            }

            if (col < colLen) {
                for (i = rowLen - 1; i >= row; --i) {
                    result.add(input[i][col]);

                }
                col++;


            }


        }

        return result;
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

    public List<List<Integer>> pascalTriangle(int n) {
        List<List<Integer>> rowArray = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) {
            List<Integer> colArray = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    colArray.add(1);
                } else {
                    colArray.add(j, rowArray.get(i - 1).get(j - 1) + rowArray.get(i - 1).get(j));
                }
            }
            rowArray.add(colArray);
        }


        return rowArray;

    }

    public String addBinary(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        int i = s1.length() - 1, j = s2.length() -1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0)
                sum += s2.charAt(j--) - '0';
            if (i >= 0)
                sum += s1.charAt(i--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Practice1 d = new Practice1();
d.addBinary("11","10");
    }


}
