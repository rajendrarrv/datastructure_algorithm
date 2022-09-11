package com.rajendra.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Rajendra Verma on 05/09/22.
 */
public class ArraysImpl {
    int[] root;

    public ArraysImpl(int[] root) {
        this.root = root;
    }

    public int[] sumOfTarget(int target) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < root.length; i++) {
            int index = root[i];
            for (int ii = 0; ii < i; ii++) {
                if (index + root[ii] == target) {
                    list.add(i);
                    list.add(ii);
                }
            }
        }
        list.trimToSize();
        Integer[] a = list.toArray(new Integer[list.size()]);

        int[] ans = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            ans[i] = a[i];
        }
        return ans;
    }

    public int removeDuplicates() {
        // Arrays.sort(nums);
        int[] nums = root;
        int length = nums.length;
        if (length == 0 || length == 1) {
            return length;
        }

        int temp[] = new int[length];
        int index = 0;
        for (int i = 0; i < length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                temp[index++] = nums[i];

            }

        }
        temp[index++] = nums[length - 1];
        for (int i = 0; i < temp.length; i++) {
            nums[i] = temp[i];
        }
        return index;
    }

    public int missingNumber() {
        int nums[] = this.root;
        int n = nums.length, xo = n;
        for (int i = 0; i < n; i++) {
            xo ^= i;
            xo ^= nums[i];
        }
        return xo;
    }

    public int[] moveZeroes(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != 0)
                list.add(nums[i]);

        }
        int trimLength = list.size();
        int index = 0;
        while (index < trimLength) {
            nums[index] = list.get(index);
            index++;
        }
        while (index < nums.length) {
            nums[index] = 0;
            index++;
        }


        return nums;
    }

    public int[] intersection(int[] nums1) {

        return intersection(this.root, nums1);
    }

    private int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for (int e : nums1) {
            set.add(e);
        }
        for (int e : nums2) {
            if (set.contains(e)) {
                set2.add(e);
            }
        }

        int[] arr = new int[set2.size()];
        int c = 0;
        for (int e : set2) {
            arr[c++] = e;
        }
        return arr;


    }


    public int minAbsolutateDifference() {
        int arr[] = this.root;
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int diff = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    diff = Math.min(diff, Math.abs(arr[i] - arr[j]));
                }
            }
            sum += diff;

        }
        // required sum
        return sum;
    }

    public static void main(String[] args) {
        ArraysImpl arrays = new ArraysImpl(null);
        System.out.println("My Love is " + Arrays.toString(arrays.findErrorNums(new int[]{3,2,2
        })));
    }


    public Set<Integer> intersect(int[] nums1, int[] nums2) {
//     todo  resolved but not submitted
        int index = 0;
        int index1 = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> ans = new HashSet<>();
        while (index < nums1.length && index1 < nums2.length) {

            if (nums1[index] == nums2[index1]) {
                ans.add(nums1[index]);
                index++;
                index1++;
            } else if (nums1[index] < nums2[index1]) {
                index++;
            } else {
                index1++;
            }


        }

        return null;
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int maxConsec = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                maxConsec = Math.max(count, maxConsec);
                count = 0;
            }
        }
        maxConsec = Math.max(count, maxConsec);

        return maxConsec;
    }

    public int islandPerimeter(int[][] grid) {

        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) { // land
                    count += 4;
                    if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                        count -= 2;
                    }
                    if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                        count -= 2;
                    }
                }

                // System.out.println(count);
            }
        }
        return count;
    }


    public int maxCount(int m, int n, int[][] ops) {
        if (ops == null || ops.length == 0) {
            return m * n;
        }

        int row = Integer.MAX_VALUE, col = Integer.MAX_VALUE;
        for (int[] op : ops) {
            row = Math.min(row, op[0]);
            col = Math.min(col, op[1]);
        }

        return row * col;

//
//// create the matrix
//        int matrix[][] = new int[m][n];
////        initialize the matrix
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//
//                matrix[i][j] = 0;
//            }
//        }
//// work on the operation
//
//        for (int i = 0; i < ops.length; i++) {
//
//            int row = ops[i][0];
//            int col = ops[i][1];
//
//
//            for (int r = 0; r < row; r++) {
//                for (int c = 0; c < col; c++) {
//                    matrix[r][c] = matrix[r][c] + 1;
//
//                }
//
//            }
//
//        }
//        Map<Integer, Integer> frequencyCounter = new HashMap<>();
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[i].length; j++) {
//
//                int val = matrix[i][j];
//                frequencyCounter.put(val, frequencyCounter.getOrDefault(val, 0) + 1);
//
//            }
//
//        }
// int maxKey =0;
//        int result =0;
//
//        for (Map.Entry<Integer, Integer> entry : frequencyCounter.entrySet()) {  // Itrate through hashmap
//
//            maxKey  = Math.max(entry.getKey(),maxKey);
//
//            if (maxKey == entry.getKey()){
//                result = entry.getValue();
//            }
//        }
//
//
//        return result;
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int prev = 0;
        int current = 0;
        int next = 0;
        int count = 0;
//        1. now the idea is if prev and next is 0, place flow in current
//        2. increase the value of count
//        3. match count with the n, if its equal return true else return false

        for (int i = 0; i < flowerbed.length; i++) {
            if (i < flowerbed.length - 1) {
                prev = Math.max(i - 1, 0);
                current = i;
                next = current + 1;
                if (prev != current && next != current) {
                    if (flowerbed[prev] == 0 && flowerbed[next] == 0 && flowerbed[current] == 0) {
                        flowerbed[current] = 1;
                        count++;
                    }

                }
            }


        }


        return count == n;
    }

    public int maximumProduct(int[] nums) {

        if (nums != null && nums.length == 0)
            return 0;
        Arrays.sort(nums);

        int first = nums[nums.length - 3];
        int secod = nums[nums.length - 2];
        int third = nums[nums.length - 1];

        int ans = first * secod * third;
        int oth = nums[0];
        int firstth = nums[1];

        int ans2 = third * oth * firstth;

        return Math.max(ans2, ans);


    }

    public boolean isPowerOfThree(int n) {
        int product = 3;
        while (product < n) {
            product *= 3;
        }
        if (product == n) {
            return true;
        }

        return false;
    }


    void bubble_Sort(int array[]) {
        int size = array.length;
        for (int i = 0; i < size - 1; i++)
            for (int j = 0; j < size - i - 1; j++)
// To sort in ascending order, change < to > in this line.
                if (array[j] < array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
    }

    public int maxSumDivThree(int[] nums) {
        bubble_Sort(nums);
        int len = nums.length;
        int sum = 0;
        int skip = 0;
        int max = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];

            if (sum % 3 == 0) {
                max = Math.max(sum, max);
            }
        }
        while (skip < len) {
            sum = 0;
            for (int i = 0; i < len; i++) {
                if (i == skip) {
                    i++;
                }
                if (i < len)
                    sum = sum + nums[i];
                if (sum % 3 == 0) {
                    max = Math.max(sum, max);
                }
            }
            skip++;
        }
        return max;
    }

    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        for (int i = 0; i < k; ++i)
            sum += nums[i];
        double ans = sum;

        for (int i = k; i < nums.length; ++i) {
            sum += nums[i] - nums[i - k];
            ans = Math.max(ans, sum);
        }

        return ans / k;
    }


    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int index = 0;

        int arr[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            index++;
            arr[i] = index;
        }

        int[] result = new int[2];
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length; i++) {

            if (arr[i] != nums[i]) {
                result[1] = arr[i];
                result[0] = nums[i];
            }
        }

        return result;

    }
}









