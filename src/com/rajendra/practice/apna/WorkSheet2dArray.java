package com.rajendra.practice.apna;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Rajendra Verma on 06/10/22.
 */
public class WorkSheet2dArray {

    private void printDiagonal(int[][] mat) {
        int rowLength = mat.length;
        int colLength = mat[0].length;
        int row = 0;
        int extraRow = 0;
        int extraCol = 0;
        int col = 0;
        for (row = 0; row < mat.length; row++) {

            extraRow = row;
            col = 0;
            while (extraRow >= 0 && col < colLength) {
                System.out.print(mat[extraRow][col] + " ");
                extraRow--;
                col++;
            }
            System.out.println();
        }
        col = 1;
        row--;

        for (int k = col; k < colLength; k++) {
            extraCol = k;
            while (extraCol < colLength) {

                System.out.print(mat[row][extraCol] + " ");
                row--;
                extraCol++;
            }
            System.out.println();


            row = rowLength - 1;
        }


    }

    //    Brut force approach
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {

                    int ind = i - 1;
//                    moving to column to left
                    while (ind >= 0) {
                        if (matrix[ind][j] != 0) {
                            matrix[ind][j] = -1;
                        }
                        ind--;
                    }
//                     moving to colm to right
                    ind = i + 1;
                    while (ind < rows) {
                        if (matrix[ind][j] != 0) {
                            matrix[ind][j] = -1;
                        }
                        ind++;
                    }
//                    moving up to row
                    ind = j - 1;
                    while (ind >= 0) {
                        if (matrix[i][ind] != 0) {
                            matrix[i][ind] = -1;

                        }
                        ind--;
                    }
//                    moving down to row
                    ind = j + 1;
                    while (ind < cols) {
                        if (matrix[i][ind] != 0) {
                            matrix[i][ind] = -1;

                        }
                        ind++;
                    }
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] <= 0) {
                    matrix[i][j] = 0;
                }
            }
        }


    }

//    optimize approach

    public void setZeroesOptimizeLevel1(int[][] matrix) {
        int lengthOfRow = matrix[0].length;
        int lengthOfCol = matrix.length;
        int[] arrayForRow = new int[lengthOfRow];
        int[] arrayForCol = new int[lengthOfCol];
        Arrays.fill(arrayForCol, -1);
        Arrays.fill(arrayForRow, -1);


        for (int col = 0; col < lengthOfCol; col++) {
            for (int row = 0; row < lengthOfRow; row++) {
                if (matrix[col][row] == 0) {
                    arrayForRow[row] = 0;
                    arrayForCol[col] = 0;
                }
            }
        }
        for (int col = 0; col < lengthOfCol; col++) {
            for (int row = 0; row < lengthOfRow; row++) {
                if (arrayForRow[row] == 0 || arrayForCol[col] == 0) {

                    matrix[col][row] = 0;

                }
            }
        }


    }

    public void rotate(int[][] matrix) {

        
    }
    @Test
    public void rotateTest(){
        int mat[][] = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(mat);
//        System.out.println("The Final Matrix is ");
//        for (int i = 0; i < mat.length; i++) {
//            for (int j = 0; j < mat[0].length; j++) {
//                System.out.print(mat[i][j] + " ");
//            }
//            System.out.println();
//        }
    }


    @Test
    public void setZeroesTest() {
        int mat[][] = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        setZeroesOptimizeLevel1(mat);

        System.out.println("The Final Matrix is ");
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }

    }

    @Test
    public void setZeroesTestOne() {
        int mat[][] = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setZeroesOptimizeLevel1(mat);

        System.out.println("The Final Matrix is ");
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }

    }


    @Test
    public void printDiagonalTest() {
        WorkSheet2dArray sheet2dArray = new WorkSheet2dArray();

        int[][] mat = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}, {17, 18, 19, 20}, {21, 22, 23, 24},


        };
        sheet2dArray.printDiagonal(mat);
    }
}
