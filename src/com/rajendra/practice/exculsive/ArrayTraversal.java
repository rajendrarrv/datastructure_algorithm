package com.rajendra.practice.exculsive;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Rajendra Verma on 12/09/22.
 */
public class ArrayTraversal {
    private int[] array;
    private int[][] matrix;

    public ArrayTraversal(int[][] matrix) {
        this.matrix = matrix;
    }

    public ArrayTraversal(int[] array) {
        this.array = array;
    }

    private void dialognal() {
        int[] result = findDiagonalOrder(this.matrix);
        System.out.println(Arrays.toString(result));
    }

    public void sprial() {
        List<Integer> data = spiralOrder(this.matrix);
    }

    private List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();
        int i, row = 0, col = 0;
        int rowlen = matrix.length;
        int colLen = matrix[0].length;

        while (row < rowlen && col < colLen) {
            // Print the first row from the remaining rows
//            left
            for (i = col; i < colLen; ++i) {
                result.add(matrix[row][i]);
                System.out.print(matrix[row][i] + " ");
            }
            row++;

            // Print the last column from the remaining
            // columns
//            down
            for (i = row; i < rowlen; ++i) {
                result.add(matrix[i][colLen - 1]);
                System.out.print(matrix[i][colLen - 1] + " ");
            }
            colLen--; //

            // Print the last row from the remaining rows */
//            Moving right
            if (row < rowlen) {
                for (i = colLen - 1; i >= col; --i) {
                    result.add(matrix[rowlen - 1][i]);
                    System.out.print(matrix[rowlen - 1][i] + " ");
                }
                rowlen--;
            }

            // Print the first column from the remaining
            // columns */
//            Moving up
            if (col < colLen) {
                for (i = rowlen - 1; i >= row; --i) {
                    result.add(matrix[i][col]);

                    System.out.print(matrix[i][col] + " ");
                }
                col++;
            }

        }
        return result;

    }


    private int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return new int[0];

        int m = matrix.length, n = matrix[0].length;

        int i = 0;
        int[] arr = new int[m * n];
        int row = 0, col = 0;
        boolean up = true;

        while (row < m && col < n) {
            if (up) {
                while (row > 0 && col < n - 1) {
//                    when  we are moving up
//                    rows values needs to decrese,
//                    check diagram
                    arr[i++] = matrix[row][col];
                    row--;
                    col++;
                }
                arr[i++] = matrix[row][col];
                if (col == n - 1) {
                    row++;
                } else {
                    col++;
                }
            } else {
                while (col > 0 && row < m - 1) {
//                    row value is need to increase
                    arr[i++] = matrix[row][col];
                    row++;
                    col--;
                }
                arr[i++] = matrix[row][col];
                if (row == m - 1) {
                    col++;
                } else {
                    row++;
                }
            }
            if (up) up = false;
            else up = true;
        }

        return arr;
    }


    public static void main(String[] args) {


//        [[1,2,3],[4,5,6],[7,8,9]]
        ArrayTraversal a = new ArrayTraversal(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        a.sprial();
    }

}

