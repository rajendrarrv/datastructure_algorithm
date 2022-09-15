package com.rajendra.collection.utils;

import java.util.Arrays;

/**
 * Created by Rajendra Verma on 15/09/22.
 */
public class SearchingAlgorithm {

    private int binarySearchRec(int[] nums, int left, int right, int target) {
        if (right >= left) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;

            if (nums[mid] > target)
                return binarySearchRec(nums, left, mid - 1, target);

            return binarySearchRec(nums, mid + 1, right, target);
        }

        return -1;
    }

    private int binarySearchItr(int[] nums, int left, int right, int target) {
        if (nums.length <= 0) return -1;

        if (nums.length == 1 && nums[0] == target) {
            return 0;
        }
        while (left <= right) {


            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        SearchingAlgorithm searchingAlgorithm = new SearchingAlgorithm();
        System.out.println( searchingAlgorithm.sqrt(2147483647));
    }

    private int sqrt(int x) {
        return sqrtRec(1, x, x);
    }


    private int sqrtRec(int left, int right, int x) {
        if(x==0) return 0;
        if (left <= right) {


            double mid = (left + right) / 2;
            double square =mid * mid;
            if (( square<= x)
                    && ((mid + 1) * (mid + 1) > x)) {
                return(int) mid;
            }

            else if (square < x) {
                return sqrtRec((int) mid + 1, right, x);
            }
            else {
                return sqrtRec(left, (int)mid - 1, x);
            }
        }
        return left;     }

    public int firstBadVersion(int n) {

        int left = 1;
        int right = n;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        return left;

    }
    private boolean isBadVersion(int mid) {
        if (mid == 2 || mid == 5) return true;

        return false;
    }




}
