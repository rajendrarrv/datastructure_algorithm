package test;

import com.rajendra.practice.apna.WorkSheet;
import com.rajendra.practice.apna.WorkSheetArray;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Rajendra Verma on 25/09/22.
 */
public class WorkSheetTest implements VTest {
    WorkSheetArray sheet;

    @Before
    @Override
    public void before() {
        sheet = new WorkSheetArray();
    }

    @Test
    @Override
    public void test() {
//
        int arr[] = {1, 2, 3};
        sheet.reverseArray(arr);
    }

    @Test
    public void reverseArrayTest1() {
        int arr[] = {1, 2, 3};
        sheet.reverseArray(arr);
    }

    @Test
    public void reverseArrayTest2() {
        int arr[] = {4, 5, 1, 2};
        sheet.reverseArray(arr);
    }

    @Test
    public void reverseArrayRecursiveAppraoch() {
        int arr[] = {1, 2, 3};
        sheet.reverseArrayRec(arr);

    }


    @Test
    public void maxSubArrayTest1() {
        int[] input = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        sheet.maxSubArray(input);
    }

    @Test
    public void maxSubArrayTest2() {
        int[] input = {1};
        sheet.maxSubArray(input);
    }

    @Test
    public void maxSubArrayTest3() {
        int[] input = {5, 4, -1, 7, 8};
        sheet.maxSubArray(input);
    }

    @Test
    public void containDuplicateTest1() {
        int[] input = {1, 2, 3, 1};
        System.out.println(sheet.containsDuplicate(input));
    }

    @Test
    public void containDuplicateTest2() {
        int[] input = {1, 2, 3, 4};
        System.out.println(sheet.containsDuplicate(input));
    }

    @Test
    public void containDuplicateTest3() {
        int[] input = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println(sheet.containsDuplicate(input));
    }


//    Input : arr[] = {7, 3, 2, 4, 9, 12, 56} , m = 3
//    Output: Minimum Difference is 2
//    Explanation:
//    We have seven packets of chocolates and we need to pick three packets for 3 students
//    If we pick 2, 3 and 4, we get the minimum difference between maximum and minimum packet sizes.
//
//            Input : arr[] = {3, 4, 1, 9, 56, 7, 9, 12} , m = 5
//    Output: Minimum Difference is 6
//
//    Input : arr[] = {12, 4, 7, 9, 2, 23, 25, 41, 30, 40, 28, 42, 30, 44, 48, 43, 50} , m = 7
//    Output: Minimum Difference is 10

    @Test
    public void chocolateProblemTest1() {
        int arr[] = {7, 3, 2, 4, 9, 12, 56};
        int m = 3;
//
        sheet.minimumChocolateDifference(arr, m);

    }

    @Test
    public void chocolateProblemTest2() {
        int arr[] = {3, 4, 1, 9, 56, 7, 9, 12};
        int m = 5;
//
        sheet.minimumChocolateDifference(arr, m);
    }

    @Test
    public void chocolateProblemTest3() {
        int arr[] = {12, 4, 7, 9, 2, 23, 25, 41, 30, 40, 28, 42, 30, 44, 48, 43, 50};
        int m = 7;
//
        sheet.minimumChocolateDifference(arr, m);
    }


    @Test
    public void maxProfitTest() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int result = sheet.maxProfit(prices);
        System.out.println(result);
    }

    @Test
    public void maxProfitTest1() {
        int[] prices = {7, 6, 4, 3, 1};
        int result = sheet.maxProfit(prices);
        System.out.println(result);
    }

    @Test
    public void repeatingNumTest1() {
        int[] prices = {3, 1, 2, 5, 3};
        int result[] = sheet.repeatingNum(prices);
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void repeatingNumTest2() {
        int[] prices = {2, 2};
        int result[] = sheet.repeatingNum(prices);
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void repeatingNumTest3() {
        int[] prices = {1, 1};
        int result[] = sheet.repeatingNum(prices);
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void repeatingNumTest4() {
        int[] prices = {1, 2};
        int result[] = sheet.repeatingNum(prices);
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void repeatingNumTest5() {
        int[] prices = {4, 3, 2, 3};
        int result[] = sheet.repeatingNum(prices);
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void kthLargestElementTest1() {

        int input[] = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        int s = sheet.kthLargestElement(input, k);
        System.out.println(s);

    }

    @Test
    public void kthLargestElementTest2() {

        int input[] = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int s = sheet.kthLargestElement(input, k);
        System.out.println(s);

    }

    @Test
    public void trapTest() {
        int[] input = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int result = sheet.trap(input);
        System.out.println(result);
    }

    @Test
    public void trapTest1() {
        int[] input = {4, 2, 0, 3, 2, 5};
        int result = sheet.trap(input);
        System.out.println(result);
    }

    @Test
    public void maxProductSubArryTest() {
        int[] input = {2, 3, -2, 4};
        int result = sheet.maxProduct(input);
        System.out.println(result);
    }

    @Test
    public void maxProductSubArryTest1() {
        int[] input = {2, 0, -1};
        int result = sheet.maxProduct(input);
        System.out.println(result);
    }

    @Test
    public void maxProductSubArryTest2() {
        int[] input = {-2};
        int result = sheet.maxProduct(input);
        System.out.println(result);
    }

    @Test
    public void maxProductSubArryTest3() {
        int[] input = {0, 2};
        int result = sheet.maxProduct(input);
        System.out.println(result);
    }

    @Test
    public void productOfSelfTest1() {
        int[] input = {1, 2, 3, 4};
        int result[] = sheet.productExceptSelf(input);
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void productOfSelfTest2() {
        int[] input = {-1, 1, 0, -3, 3};
        int result[] = sheet.productExceptSelf(input);
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void productOfSelfTest3() {
        int[] input = {0, 0};
        int result[] = sheet.productExceptSelf(input);
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void findMinRotatedArrayTest1() {
        int[] input = {3, 4, 5, 1, 2};
        int result = sheet.findMin(input);
        System.out.println(result);
    }

    @Test
    public void findMinRotatedArrayTest2() {
        int[] input = {4, 5, 6, 7, 2, 3};
        int result = sheet.findMin(input);
        System.out.println(result);
    }

    @Test
    public void findMinRotatedArrayTest3() {
        int[] input = {11, 13, 15, 17};
        int result = sheet.findMin(input);
        System.out.println(result);
    }

    @Test
    public void findMinRotatedArrayTest4() {
        int[] input = {2, 1};
        int result = sheet.findMin(input);
        System.out.println(result);
    }

    @Test
    public void pairInSortedRotatedTest() {
        int arr[] = {11, 15, 6, 8, 9, 10};
        int x = 16;
        boolean result = sheet.pairInSortedRotated(arr, x);
        System.out.println("Result " + result);

    }
    @Test
    public void pairInSortedRotatedTest1() {
        int arr[] = {11, 15, 26, 38, 9, 10};
        int x = 35;
        boolean result = sheet.pairInSortedRotated(arr, x);
        System.out.println("Result " + result);

    }


    @Test
    public void threeSumTest() {

        int arr[] = {-1,0,1,2,-1,-4};

        List<List<Integer>> result = sheet.threeSum(arr);
        System.out.println("Result " + result);

    }

    @Test
    public void threeSumTest1() {

        int arr[] = {0,1,1};

        List<List<Integer>> result = sheet.threeSum(arr);
        System.out.println("Result " + result);

    }
    @Test
    public void threeSumTest2() {

        int arr[] = {0,0,0};

        List<List<Integer>> result = sheet.threeSum(arr);
        System.out.println("Result " + result);

    }
    @Test
    public void maxAreaTest() {

        int arr[] = {1,8,6,2,5,4,8,3,7};
        int result = sheet.maxArea(arr);
        System.out.println("Result " + result);

    }

    @Test
    public void maxAreaTest1() {

        int arr[] = {1,1};
        int result = sheet.maxArea(arr);
        System.out.println("Result " + result);

    }

    @Test
    public void kthSmallestTest() {

        int in[]  = {7, 10, 4, 3, 20, 15};
        int result = sheet.kthSmallest(in,3);
        System.out.println("Result " + result);

    }

    @Test
    public void kthSmallestTest1() {

        int in[]  = { 7 ,10, 4 ,20, 15};
        int result = sheet.kthSmallest(in,4);
        System.out.println("Result " + result);

    }






    static int findMinOps(int[] arr, int n)
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

    @Override
    public void after() {

    }
}
