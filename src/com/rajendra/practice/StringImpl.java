package com.rajendra.practice;

import com.rajendra.collection.utils.RomanNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Rajendra Verma on 08/09/22.
 */
public class StringImpl {


    //
    public String reverse(String str) {
//       convert into the array
//        reverse the array
        String[] ar = str.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        int index = ar.length - 1;
        while (index >= 0) {
            stringBuilder.append(ar[index]);
            stringBuilder.append(" ");
            index--;

        }
        return stringBuilder.toString();
    }

//    un optimize approach
//    String longestCommonPrefix(String arr[], int n) {
//        // code here
//        int count = 0;
//        for (int i = 0; i < arr.length - 1; i++) {
//            count = commonStringCount(arr[i], arr[i + 1]);
//
//        }
//
//        if (count == 0) {
//            return "-1";
//        }
//        return arr[0].substring(0, count);
//    }

    //    optimize approach
    String longestCommonPrefix(String arr[], int n) {
        Arrays.sort(arr);
        int count = commonStringCount(arr[0], arr[n - 1]);
        if (count <= 0) {
            return "-1";
        } else {
            return arr[n - 1].substring(0, count);
        }


    }

    private int commonStringCount(String s, String s1) {
        int index = 0;
        for (int i = 0; i < s.length() && i < s1.length(); i++) {

            if (s.charAt(i) != s1.charAt(i))
                break;
            index++;

        }
        return index;
    }


    public int romanToInteger(String roman) {
        RomanNumber romanNumber = new RomanNumber();
        return romanNumber.convertRomanToInteger(roman);
    }

    public String integerToRoman(int num) {
        RomanNumber romanNumber = new RomanNumber();
        return romanNumber.convertIntegerRomanNumber(num);

    }

    public String addBinary(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        int i = s1.length() - 1, j = s2.length() - 1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) sum += s2.charAt(j--) - '0';
            if (i >= 0) sum += s1.charAt(i--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }


    public int strStr(String haystack, String needle) {
        StringBuilder sb = new StringBuilder(haystack);
        sb.indexOf(needle);
        return sb.indexOf(needle);
    }

    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String s = strs[0];
        String l = strs[strs.length - 1];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length() && i < l.length(); i++) {

            if (s.charAt(i) == l.charAt(i))
                sb.append(s.charAt(i));
            else break;
        }

        if (sb.length() <= 0)
            sb.append("-1");

        return sb.toString();
    }

    public static void main(String[] args) {
        StringImpl string = new StringImpl();
        System.out.println(string.reverseWords("the sky is blue"));
    }

    public void reverseString(char[] s) {
        int initial = 0;
        int finall = s.length - 1;
        while (initial < finall) {
            swap(s, initial, finall);
            initial++;
            finall--;
        }
        System.out.println(s);
    }

    private void swap(char[] s, int initial, int finall) {
        char temp = s[initial];
        s[initial] = s[finall];
        s[finall] = temp;
    }

    private void swap(String[] s, int initial, int finall) {
        String temp = s[initial];
        s[initial] = s[finall];
        s[finall] = temp;
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>();
        if (rowIndex <= 0)
            return result;
        result.add(1);
        for (int i = 2; i <= rowIndex; i++) {
            result.add(1);
            for (int j = 0; j < result.size() - 1; j++) {
                result.add(result.get(j) + result.get(j + 1)); //middle
            }
            result.add(1);
        }
        return result;
    }





    public String reverseWords(String s) {
        String[] words = s.split(" ");
        for (int i = 0; i < words.length; i++) {
            StringBuilder sb = new StringBuilder(words[i]);
            words[i] = sb.reverse().toString();

        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            sb.append(words[i]);
            if (i < words.length - 1) {
                sb.append("-");
            }
        }
        return sb.toString();
    }

    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        HashMap<Character, Character> map1 = new HashMap<>();

        if (s.length() != t.length())
            return false;
        for (int i = 0; i < s.length(); i++) {
// degree pairing
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), t.charAt(i));
            } else {
                if (map.get(s.charAt(i)) != t.charAt(i))
                    return false;
            }
// indegree pairing
            if (!map1.containsKey(t.charAt(i))) {
                map1.put(t.charAt(i), s.charAt(i));
            } else {
                if (map1.get(t.charAt(i)) != s.charAt(i))
                    return false;
            }


        }


        return true;
    }
}




