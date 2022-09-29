package com.rajendra.practice.apna;

import com.rajendra.collection.algorithm.ArrayPreProcessing;
import com.rajendra.utils.ArraysUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

/**
 * Created by Rajendra Verma on 25/09/22.
 */
public class WorkSheet {

    private ArraysUtils arraysUtils = new ArraysUtils();

    public void reverseArray(int[] array) {
        arraysUtils.printArray(array);

        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int temp = array[end];
            array[end] = array[start];
            array[start] = temp;
            start++;
            end--;
        }
        arraysUtils.printArray(array);

    }

    public void reverseArrayRec(int array[]) {
        arraysUtils.printArray(array);
        reverseArrayRec(array, 0, array.length - 1);
        arraysUtils.printArray(array);
    }

    public void reverseArrayRec(int[] array, int start, int end) {
        if (start > end) return;
        int temp = array[end];
        array[end] = array[start];
        array[start] = temp;
        start++;
        end--;

        reverseArrayRec(array, start, end);

    }

    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {

            sum += nums[i];
            max = Math.max(sum, max);
            if (sum < 0) {
                sum = 0;
            }
        }
        System.out.println("Result " + max);
        return max;
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) return true;
        }
        return false;
    }

    public int minimumChocolateDifference(int[] chocolatePackets, int students) {
        Arrays.sort(chocolatePackets);
        int min = Integer.MAX_VALUE;

        for (int i = 0; i + students - 1 < chocolatePackets.length; i++) {
            int diff = chocolatePackets[i + students - 1] - chocolatePackets[i];

            min = Math.min(diff, min);
        }
        System.out.println(min);
        return min;
    }


    public int maxProfit(int[] prices) {
        StockMarket stockMarket = new StockMarket();
        return stockMarket.maxProfitOpt1(prices);
    }


    public int[] repeatingNum(int[] array) {
        Arrays.sort(array);
        int[] result = new int[2];
        Arrays.fill(result, -1);
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] + 1 == array[i + 1] && array[i + 1] - array[i] == 1) continue;
//            repeating number
            if (array[i] == array[i + 1]) result[0] = array[i];
//            missing num
            if (array[i + 1] - array[i] > 1) result[1] = array[i] + 1;

        }
        if (result[0] != -1) {
            result[1] = result[0] - 1;


        }

        return result;
    }

    public int kthLargestElement(int[] input, int k) {
        Arrays.sort(input);
        int lastIndex = input.length;
        return input[lastIndex - k];
    }


    public int trap(int[] heights) {
        ArrayPreProcessing arrayPreProcessing = new ArrayPreProcessing();
        return arrayPreProcessing.trap(heights);
    }

    public int maxProduct(int[] nums) {

        int max = Integer.MIN_VALUE;
        int currentProduct = 1;
// all left
        for (int i = 0; i < nums.length; i++) {
            currentProduct *= nums[i];

            max = Math.max(currentProduct, max);

            if (currentProduct == 0) currentProduct = 1;
        }
        currentProduct = 1;
//        all right
        for (int i = nums.length - 1; i >= 0; i--) {
            currentProduct *= nums[i];
            max = Math.max(currentProduct, max);

            if (currentProduct == 0) currentProduct = 1;
        }

        return max;
    }

    public int[] productExceptSelf(int[] nums) {
        // Initialize memory to all arrays

        int left[] = new int[nums.length];
        int right[] = new int[nums.length];
        int prod[] = new int[nums.length];

        left[0] = 1;
        right[nums.length - 1] = 1;

//        product  of all left
        for (int i = 1; i < nums.length; i++) {
            left[i] = nums[i - 1] * left[i - 1];
        }
//         product of all right
        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = nums[i + 1] * right[i + 1];
        }
//        product of left and right
        for (int i = 0; i < nums.length; i++) {
            prod[i] = left[i] * right[i];
        }

        return prod;
    }

    public int findMin(int[] nums) {
        if (nums.length < 0) return 0;
        if (nums.length <= 1) return nums[0];
        int p = findPivot(nums, 0, nums.length - 1);

        if (p >= 0 && p < nums.length - 1) {
            return nums[p + 1];
        }
        return nums[0];

    }

    private int findPivot(int arr[], int low, int high) {
        if (high < low) return -1;
        if (high == low) return low;

        int mid = (low + high) / 2;
        if (mid < high && arr[mid] > arr[mid + 1]) return mid;
        if (mid > low && arr[mid] < arr[mid - 1]) return (mid - 1);
        if (arr[low] >= arr[mid]) return findPivot(arr, low, mid - 1);
        return findPivot(arr, mid + 1, high);
    }


    public boolean pairInSortedRotated(int arr[], int x) {
        int n = arr.length;
        int pivote;
        for (pivote = 0; pivote < n - 1; pivote++)
            if (arr[pivote] > arr[pivote + 1]) break;

        int smallest = (pivote + 1) % n;

        int largestest = pivote;

        while (smallest != largestest) {
            if (arr[smallest] + arr[largestest] == x) return true;

            if (arr[smallest] + arr[largestest] < x) smallest = (smallest + 1) % n;

            else largestest = (n + largestest - 1) % n;
        }
        return false;
    }

    /*

    It is a extension of two sum of problem
    that is

    a+b  = target
    let's say
    a+b =0
    then
    a = -b
    in the same ways
    a+b+c = 0
    then
    a+b = -c;
    here target is -c

     */
    public List<List<Integer>> threeSum(int[] nums) {
//        sort the array
        Arrays.sort(nums);
        int n = nums.length;

        List<List<Integer>> triplets = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            // Skip the duplicates
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // Left and right pointers
            int left = i + 1;
            int right = n - 1;
            // Loop for all the remaining pairs
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] == 0) {
                    triplets.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    // Never let j refer to the same value twice (in an output) to avoid duplicates
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                } else if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return triplets;


    }

    /*

    the  distance in between two i and i+1 is width and value is height.
    the largest area is  the answer


     */
    public int maxArea(int[] heights) {
        int max = Integer.MIN_VALUE;
        int right = heights.length - 1;
        int length = 0;
        int left = 0;

        while (left <= right) {
            length = right - left;
            int height = Math.min(heights[left], heights[right]);
            int area = length * height;
            max = Math.max(area, max);
            if (heights[left] < heights[right]) {
                left = left + 1;
            } else {
                right = right - 1;
            }
        }
        return max;
    }

    public int kthSmallest(int[] arr, int k) {
        Arrays.sort(arr);

        return arr[k - 1];
    }

    public int kthSmallestOptimize(int[] arr, int k) {
        k--;
        int n = arr.length - 1;
        Set<Integer> s = new TreeSet<Integer>();

        for (int i = 0; i < n; i++)
            s.add(arr[i]);

        // Use iterator method of Iterator
        // for the traversal
        Iterator<Integer> itr = s.iterator();

        while (k > 0) {
            itr.next();
            k--;
        } // itr points to the Kth element in the set

        return itr.next();
    }


    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
return  ints[0] - t1[0];
//                if (ints[0] > t1[0]) {
//                    return 1;
//                }
//                return -1;

            }
        });

        Stack<int[]> stack = new Stack<>();
//add top here
        System.out.println("Print Top"+Arrays.toString(intervals[0]));
        stack.add(intervals[0]);

        int start = 0;
        int end = 1;
        for (int i = 1; i < intervals.length; i++) {
            // get interval from stack top
            int[] top = stack.peek();

            // if current interval is not overlapping with stack top,
            // push it to the stack
            if (top[end] < intervals[i][start]) stack.push(intervals[i]);

                // Otherwise update the ending time of top if ending of current
                // interval is more
            else if (top[end] < intervals[i][end]) {
                top[end] = intervals[i][end];
                stack.pop();
                stack.push(top);
            }
        }

        int[][] result = new int[stack.size()][2];
        int index = stack.size()-1;
        while (!stack.isEmpty()) {
            int[] t = stack.pop();
            result[index] = t;
            index--;
        }
        return result;
    }


public  int findMinOps(int[] arr, int n)
    {
        int ans = 0; // Initialize result

        // Start from two corners
        for (int i=0,j=n-1; i<=j;)
        {
            // If corner elements are same,
            // problem reduces arr[i+1..j-1]
            if (arr[i] == arr[j])
            {
                i++;
                j--;
            }

            // If left element is greater, then
            // we merge right two elements
            else if (arr[i] > arr[j])
            {
                // need to merge from tail.
                j--;
                arr[j] += arr[j+1] ;
                ans++;
            }

            // Else we merge left two elements
            else
            {
                i++;
                arr[i] += arr[i-1];
                ans++;
            }
        }

        return ans;
    }


}
