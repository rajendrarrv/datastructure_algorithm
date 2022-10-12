package com.rajendra.practice.apna;

import com.rajendra.utils.Beautify;

import org.junit.Test;

import java.util.Locale;

/**
 * Created by Rajendra Verma on 01/10/22.
 */
public class LongestPalindromSequence {
    Beautify beautify = new Beautify();

    //Brute Force
    public String simpleApproach(String str) {

        int maxLength = 1, start = 0;

        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                int flag = 1;

                for (int k = 0; k < (j - i + 1) / 2; k++)
                    if (str.charAt(i + k) != str.charAt(j - k)) flag = 0;

                if (flag != 0 && (j - i + 1) > maxLength) {
                    start = i;
                    maxLength = j - i + 1;
                }
            }
        }
        return str.substring(start, start + maxLength);
    }

    public String dynamicProgramming(String str) {
        int n = str.length();
        boolean table[][] = new boolean[n][n];

        // ! All substrings of length 1 are palindromes
        int maxLength = 1;
        for (int i = 0; i < n; ++i)
            table[i][i] = true;

        //! check for sub-string of length 2.
        int start = 0;
        for (int i = 0; i < n - 1; ++i) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                table[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }

        // !Check for lengths greater than 2.
        // k is length of substring
        for (int k = 3; k <= n; ++k) {

            // Fix the starting index
            for (int i = 0; i < n - k + 1; ++i) {

                int j = i + k - 1;

//      *          table[i + 1][j - 1] if the inner string is palidrone then than check for the outer string
//     *           str.charAt(i) == str.charAt(j)  check for the outer one
                if (table[i + 1][j - 1] && str.charAt(i) == str.charAt(j)) {
                    table[i][j] = true;

//                    store the maxium value and starting index
                    if (k > maxLength) {
                        start = i;
                        maxLength = k;
                    }
                }
            }
        }

        // return length of LPS
        return str.substring(start, start + maxLength);
    }

    public String expandingTheMiddleApproach(String str) {
        if (str == null || str.isEmpty()) return "";
        int length = str.length();
//         this is going to be the index of final result
        int startBoundry = 0;
        int endBoundry = 0;

        for (int i = 0; i < length; i++) {



/*
! racecar
in  racecar this case the middle character is not same but  rest of the character are same
 */
            int length_one = expandingTheMiddle(str, i, i);
            /*
            ! aabbaa
            in this case the middle element is same bb  and all other character are same
             */
            int length_two = expandingTheMiddle(str, i, i + 1);
            int len = Math.max(length_one, length_two);

            if (len > endBoundry - startBoundry) {
                startBoundry = i - ((len - 1 )/ 2);
                endBoundry = i + (len / 2);
            }
        }
        return str.substring(startBoundry, endBoundry + 1);
    }

    public int expandingTheMiddle(String str, int left, int right) {
        if (str == null || left > right) return 0;
        int length = str.length();

        while ((left >= 0 && right < length) && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }


//    TEST CASES


    @Test
    public void test() {
        LongestPalindromSequence sequence = new LongestPalindromSequence();
        String string = sequence.dynamicProgramming("babad");

        sequence.beautify.setFrontColor(Beautify.ANSI_RED);
        sequence.beautify.println(string);
    }


    @Test
    public void test1() {
        LongestPalindromSequence sequence = new LongestPalindromSequence();
        String string = sequence.expandingTheMiddleApproach("cbbd");

        sequence.beautify.setFrontColor(Beautify.ANSI_RED);
        sequence.beautify.println("Result =" + string);
    }

    @Test
    public void test3() {
        LongestPalindromSequence sequence = new LongestPalindromSequence();
        String string = sequence.expandingTheMiddleApproach("a");

        sequence.beautify.setFrontColor(Beautify.ANSI_RED);
        sequence.beautify.println(string);
    }

    @Test
    public void test4() {
        LongestPalindromSequence sequence = new LongestPalindromSequence();
        String string = sequence.expandingTheMiddleApproach("ac");

        sequence.beautify.setFrontColor(Beautify.ANSI_RED);
        sequence.beautify.println(string);
    }

    @Test
    public void test5() {
        LongestPalindromSequence sequence = new LongestPalindromSequence();
        String string = sequence.expandingTheMiddleApproach("bb");

        sequence.beautify.setFrontColor(Beautify.ANSI_RED);
        sequence.beautify.println("Result = " + string);
    }

    @Test
    public void test6() {
        LongestPalindromSequence sequence = new LongestPalindromSequence();
        String string = sequence.expandingTheMiddleApproach("abb");

        sequence.beautify.setFrontColor(Beautify.ANSI_RED);
        sequence.beautify.println("Result = " + string);
    }

    @Test
    public void test7() {
        LongestPalindromSequence sequence = new LongestPalindromSequence();
        String string = sequence.expandingTheMiddleApproach("bbbbbabbb");

        sequence.beautify.setFrontColor(Beautify.ANSI_RED);
        sequence.beautify.println("Result = " + string);
    }
}
