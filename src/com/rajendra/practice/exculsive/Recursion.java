package com.rajendra.practice.exculsive;

import com.rajendra.model.ListNode;
import com.rajendra.model.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Rajendra Verma on 16/09/22.
 */
public class Recursion {
    public String reverseString(String s) {

        reverseStringRec(s.toCharArray(), 0, s.length() - 1);
        return null;
    }


    private char[] reverseString(char[] s, int start, int end) {
        if (start >= end)
            return s;

        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;

        return reverseString(s, start + 1, end - 1);
    }


    public void reverseStringRec(char[] s, int left, int right) {
        if (left >= right) {
            System.out.println(Arrays.toString(s));
            return;
        }
        char temp = s[right];
        s[right] = s[left];
        s[left] = temp;
        reverseStringRec(s, left + 1, right - 1);
    }

    public ListNode swapPairsItr(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode temp = head;

        while (temp != null && temp.next != null) {

            int k = temp.value;
            temp.value = temp.next.value;
            temp.next.value = k;
            temp = temp.next.next;
        }
        return head;
    }

    public void swapPairsRec(ListNode node) {
        if (node == null || node.next == null)
            return;
        int k = node.value;
        node.value = node.next.value;
        node.next.value = k;
        swapPairsRec(node.next.next);
    }


    public ListNode reverseListRec(ListNode head) {
//     case condition
        if (head.next == null)
            return head;

//        Recurrence Relation
        ListNode newHead = reverseListRec(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null)
            return root;

        if (val == root.val) {
            return root;
        } else if (val > root.val)
            return searchBST(root.right, val);
        else return searchBST(root.left, val);


    }

    public void getRowRec(int rowIndex, int colIndex, List<Integer> result, Map<Integer, Integer> storeage) {
        if (rowIndex == 0) {
            result.add(1);
            return;
        }
        if (rowIndex == 1) {
            result.add(1);
            result.add(1);
            return;
        }
        if (rowIndex + 1 == colIndex)
            return;
        int cache = storeage.getOrDefault(rowIndex, -1);
        if (cache == -1) {
            cache = pascalValue(rowIndex, colIndex);
        }
        result.add(cache);
        getRowRec(rowIndex, colIndex + 1, result, storeage);
    }

    public int pascalValue(int i, int j) {
        if (j == 0 || j == i) {
            return 1;
        } else {
            return pascalValue(i - 1, j - 1) + pascalValue(i - 1, j);
        }
    }

    public int fib(int n) {
        if (n <= 0)
            return 0;
        if (n <= 1)
            return 1;
        return fib(n - 1) + fib(n - 2);
    }

    HashMap<Integer, Integer> cache = new HashMap<>();

    public int climbStairs(int n) {
        int result = 0;

        if (cache.containsKey(n)) return cache.get(n);
        if (n == 1) return 1;
        if (n == 2) return 2;
        result = climbStairs(n - 1) + climbStairs(n - 2);
        return result;
    }

    double mul = 1;

    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (x == 0)
            return 0;
        return x * myPow(x, n - 1);
    }

    public boolean isPerfectSquare(int num, long left, long right) {
        if (left >= right) {
            return false;
        }
        if (num == 0) {
            return true;
        }
        if (num == 1) {
            return true;
        }
        long mid = left + (right - left) / 2;


        long s = mid * mid;

        if (s == num)
            return true;
        else if (s > num) {
            right = (mid - 1);
            return isPerfectSquare(num, left, right);
        } else {
            left = (mid + 1);
            return isPerfectSquare(num, left, right);
        }


    }


    public static void main(String[] args) {
        Recursion recursion = new Recursion();
        System.out.println(recursion.isPerfectSquare(81, 1, 81));
    }

   }
