package com.rajendra.practice.exculsive;

import com.rajendra.collection.LinkedListImpl;
import com.rajendra.model.ListNode;
import com.rajendra.practice.leetcode.LeLinkList;

import java.util.Arrays;

/**
 * Created by Rajendra Verma on 20/09/22.
 */
public class LeetCodeDailyCallenge {

    public int findLength(int[] nums1, int[] nums2) {
        if (nums1.length < 0 || nums1.length < 0)
            return -1;
        int[][] memo = new int[nums1.length + 1][nums2.length + 1];
//        initialize the matrix  with the zero

        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[0].length; j++) {
                memo[i][j] = 0;
            }
        }
// fill the matrix in reverse order
        for (int i = nums1.length - 1; i >= 0; i--) {
            for (int j = nums2.length - 1; j >= 0; j--) {
                if (nums1[i] == nums2[j]) {
                    memo[i][j] = memo[i + 1][j + 1] + 1;
                }
            }
        }
//  the maximum number in the matrix is the subseqence length
        int lengthOfSubSequence = 0;

        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[0].length; j++) {
                // Update the length
                lengthOfSubSequence = Math.max(lengthOfSubSequence, memo[i][j]);
            }
        }
        return lengthOfSubSequence;
    }

    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {

        int result[] = new int[nums.length];
        int sumOFeven = sumOfEven(nums);

        for (int i = 0; i < queries.length; i++) {
            int val = queries[i][0];
            int index = queries[i][1];
            if (nums[index] % 2 == 0) sumOFeven -= nums[index];
            nums[index] += val;
            if (nums[index] % 2 == 0) sumOFeven += nums[index];
            result[i] = sumOFeven;
        }
        System.out.println(Arrays.toString(result));

        return result;
    }

    private int sumOfEven(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0)
                sum = sum + nums[i];
        }
        return sum;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode temp = result;
        if (l1 == null) {
            return l2;
        }
        if (l2 == null)
            return l1;
        int c = 0;
        while (l1 != null || l2 != null) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            sum = sum + c;
            int val = sum % 10;
            c = sum / 10;
            ListNode n = new ListNode(val);
            temp.next = n;
            temp = temp.next;
        }
        if (c >= 1) {
            temp.next = new ListNode(c);
            temp = temp.next;
        }
        result = result.next;
        return result;


    }


    public static void main(String[] args) {
        LeetCodeDailyCallenge leetCodeDailyCallenge = new LeetCodeDailyCallenge();


//        Input: nums = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
//        Output: [8,6,2,4]
//        Input: l1 = [2,4,3], l2 = [5,6,4]


        LinkedListImpl linkedList = new LinkedListImpl();
        linkedList.insertLast(9);
        linkedList.insertLast(9);
        linkedList.insertLast(9);
        linkedList.insertLast(9);
        linkedList.insertLast(9);
        linkedList.insertLast(9);
        linkedList.insertLast(9);

        LinkedListImpl linkedList1 = new LinkedListImpl();
        linkedList1.insertLast(9);
        linkedList1.insertLast(9);
        linkedList1.insertLast(9);
        linkedList1.insertLast(9);

        ListNode result = leetCodeDailyCallenge.addTwoNumbers(linkedList.head, linkedList1.head);
        linkedList.display(result);
    }
}
