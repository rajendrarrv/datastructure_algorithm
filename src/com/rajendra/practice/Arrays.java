package com.rajendra.practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Rajendra Verma on 05/09/22.
 */
public class Arrays {
    int[] root;

    public Arrays(int[] root) {
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

        for (int e:nums1){
            set.add(e);
        }
        for (int e:nums2){
            if (set.contains(e) ) {
                set2.add(e);
            }
        }

        int[]arr = new int[set2.size()];
        int c = 0;
        for (int e :set2){
            arr[c++] =  e ;
        }
        return arr;


    }


    public  int minAbsolutateDifference(){
        int arr[] = this.root;
        int n  = arr.length;
        int sum=0;
        for(int i=0;i<n;i++){
            int diff=Integer.MAX_VALUE;
            for(int j=0;j<n;j++){
                if(i!=j){
                    diff=Math.min(diff,Math.abs(arr[i]-arr[j]));
                }
            }
            sum+=diff;

        }
        // required sum
        return sum;
    }

    public static void main(String[] args) {
        int root[] = {4,2,6,1,3};
        int[] nums2 = {2,2};

        Arrays arrays = new Arrays(root);
        System.out.println("Min AbsoluteDifference  is  = " + arrays.minAbsolutateDifference());
    }
}
