package com.rajendra.practice.exculsive;

import com.rajendra.collection.BinaryTree;
import com.rajendra.collection.LinkedListImpl;
import com.rajendra.model.ListNode;
import com.rajendra.model.TreeNode;
import com.rajendra.practice.leetcode.LeLinkList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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

    public int concatenatedBinary(int n) {
        int MOD = (int) 1_000_000_007;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {

            sb.append(Integer.toBinaryString(i));

        }
        System.out.println(sb);
        long result = convertBinaryToDecimal(sb);
        return (int) (result % MOD);
    }


    public String turing(String s) {
        String[] colorIndex = s.split(" ");
        HashMap<Integer, String> map = new HashMap<>();
        for (int i = 0; i < colorIndex.length; i++) {

            String src = colorIndex[i];

//            red2 blue5 black4 green1 gold3
            char numberchar = src.charAt(src.length() - 1);
            int number = numberchar - '0';
            String word = src.substring(0, src.length() - 1);
            map.put(number, word);


        }
        StringBuilder res = new StringBuilder();

        for (int i = 1; i <= colorIndex.length; i++) {

            res.append(map.get(i) + " ");
        }
        System.out.println(res);
        return res.toString();

    }

    public long convertBinaryToDecimal(StringBuilder num) {
        long decimalNumber = 0;
        StringBuilder stringBuilder = num.reverse();
        for (int i = 0; i < stringBuilder.length(); i++) {
            int binary = -1;
            if (stringBuilder.charAt(i) == '1') {
                binary = 1;
            } else {
                binary = 0;
            }
            decimalNumber += Math.pow(2, i) * binary;
        }
        return decimalNumber;
    }

    int sum = 0;
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        pathSumRec(root, new ArrayList<>(),targetSum);
        return result;
    }

    public void pathSumRec(TreeNode node, ArrayList<Integer> list, int targetSum) {
        if(node == null) return;
        sum += node.val;
        list.add(node.val);

        if(node.left == null && node.right == null){
            if(targetSum == sum){
                sum =0;
                result.add(list);
            }else{
                return;
            }
        }
        if(node.left != null){
            pathSumRec(node.left, new ArrayList<Integer>(list), targetSum);
        }
        if(node.right != null){
            pathSumRec(node.right, new ArrayList<Integer>(list), targetSum);

        }

    }



    public static void main(String[] args) {
        LeetCodeDailyCallenge leetCodeDailyCallenge = new LeetCodeDailyCallenge();

        int[] input = {5, 4, 11, 7, -1, -1, 2, -1, -1, 8, 13, -1, -1, 4, 5, -1, -1, 1, -1, -1};
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.buildTree(input);

        leetCodeDailyCallenge.pathSum(binaryTree.root, 20);


    }
}
