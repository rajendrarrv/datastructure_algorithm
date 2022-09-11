package com.rajendra.practice;

import com.rajendra.collection.utils.RomanNumber;

import java.util.Arrays;

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

    public static void main(String[] args) {
        StringImpl string = new StringImpl();
//        System.out.println(string.integerToRoman("MCMLXXXVI"));
        System.out.println(string.integerToRoman(1986));
    }

    public int romanToInteger(String roman) {
        RomanNumber romanNumber  = new RomanNumber();
        return romanNumber.convertRomanToInteger(roman);
    }
    public String integerToRoman(int num){
        RomanNumber romanNumber  = new RomanNumber();
        return romanNumber.convertIntegerRomanNumber(num);

    }
}
