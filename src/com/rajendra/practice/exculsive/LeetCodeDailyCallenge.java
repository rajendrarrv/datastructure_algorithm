package com.rajendra.practice.exculsive;

/**
 * Created by Rajendra Verma on 20/09/22.
 */
public class LeetCodeDailyCallenge {

    public int findLength(int[] nums1, int[] nums2) {
        if (nums1.length < 0 || nums1.length < 0)
            return -1;
        int[][] matrix = new int[nums1.length + 1][nums2.length + 1];
//        initialize the matrix  with the zero

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = 0;
            }
        }
// fill the matrix in reverse order
        for (int i = nums1.length-1; i >=0; i--) {
            for (int j = nums2.length-1; j >=0; j--) {
                if (nums1[i] == nums2[j]) {
                    matrix[i][j] = matrix[i + 1][j + 1] + 1;
                }
            }
        }
//  the maximum number in the matrix is the subseqence length
        int lengthOfSubSequence = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                // Update the length
                lengthOfSubSequence = Math.max(lengthOfSubSequence, matrix[i][j]);
            }
        }
        return lengthOfSubSequence;
    }



    public static void main(String[] args) {
        LeetCodeDailyCallenge leetCodeDailyCallenge  = new LeetCodeDailyCallenge();
        System.out.println( leetCodeDailyCallenge.findLength(new int[]{1,2,3,2,1}, new int[]{3,2,1,4,7}));
    }
}
