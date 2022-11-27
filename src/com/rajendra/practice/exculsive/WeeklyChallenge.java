package com.rajendra.practice.exculsive;

import com.rajendra.collection.BinaryTree;
import com.rajendra.model.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Rajendra Verma on 24/09/22.
 */
public class WeeklyChallenge {

    public int longestContinuousSubstring(String s) {
        int count = 1;
        int prev = 0;
        int current = 0;
        if (s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int max = Integer.MIN_VALUE;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            prev = chars[i];
            current = chars[i + 1];

            if (prev + 1 == current) {
                count++;
                max = Math.max(max, count);

            } else {
                count = 1;
            }
        }

        return max;
    }

    public void reverseOddLevels(TreeNode left, TreeNode right, boolean odd) {
        if (left == null || right == null) {

            return;
        }
        if (odd) {
            int temp = left.val;
            left.val = right.val;
            right.val = temp;
        }

        reverseOddLevels(left.left, right.right, !odd);
        reverseOddLevels(left.right, right.left, !odd);
    }

    public String removeDigit(String number, char digit) {
        StringBuilder sb = new StringBuilder(number);
        for (int i = 0; i < sb.length() - 1; i++) {
            if (sb.charAt(i) != digit) continue;

            int num1 = sb.charAt(i) - '0';
            int num2 = sb.charAt(i + 1) - '0';
            if (num2 > num1) {
                return sb.deleteCharAt(i).toString();
            }
        }
        int lastIndex = number.lastIndexOf(digit);
        sb.deleteCharAt(lastIndex);
        return sb.toString();


    }


    public int minimumCardPickup(int[] cards) {
        int[] lastIndex = new int[10000001];
        Arrays.fill(lastIndex,-1);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < cards.length; i++) {
            if (lastIndex[cards[i]]!=-1)
            ans = Math.min(i - lastIndex[cards[i]] + 1,ans);
            lastIndex[cards[i]] = i;
        }
        return ans == Integer.MAX_VALUE?-1:ans;
    }

    public static void main(String[] args) {
        WeeklyChallenge weeklyChallenge = new WeeklyChallenge();
        System.out.println(weeklyChallenge.minimumCardPickup(new int[]{3, 4, 2, 3, 4, 7,4,3,8,9}));
    }
}
