package com.rajendra.practice.apna;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Rajendra Verma on 02/10/22.
 */
public class LongestSubStringWithoutRepeating {

    public int lengthOfLongestSubstring_brutalForce(String s) {
        int length = s.length();
        int maxLength = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {

                if (uniqueStr(s, i, j)) {

                    int lengthOfUniqueString = j - i + 1;
                    maxLength = Math.max(maxLength, lengthOfUniqueString);
                }

            }

        }

        return maxLength;
    }

    public int lengthOfLongestSubstring_windowSlide(String s) {
        int max = 0;
        int length = s.length();
        boolean[] visitMarker = new boolean[256];

        for (int i = 0; i < length; i++) {

            for (int j = i; j < length && !visitMarker[s.charAt(j)]; j++) {

                max = Math.max(max, j - i + 1);
                visitMarker[s.charAt(j)] = true;
            }
            visitMarker[s.charAt(i)] = false;
        }

        return max;
    }

    public int lengthOfLongestSubstring_windowSlide_alpha(String s) {
        int length = s.length();
        if (length < 0) return 0;
        Set<Character> set = new HashSet<>();

        int i = 0;
        int j = 0;
        int max = 0;
        while (i < length && j < length) {

            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j = j + 1;
                max = Math.max(max, j - i);
            } else {
                set.remove(s.charAt(i));
                i = i + 1;
            }
        }
        return max;
    }


    private boolean uniqueStr(String str, int i, int j) {

        boolean[] visiter = new boolean[256];

        for (int k = i; k < j; k++) {

            if (visiter[str.charAt(k)]) {
                return false;
            }
            visiter[str.charAt(k)] = true;
        }
        return true;
    }

    @Test
    public void testOne() {
        LongestSubStringWithoutRepeating longestSubStringWithoutRepeating = new LongestSubStringWithoutRepeating();
        int result = longestSubStringWithoutRepeating.lengthOfLongestSubstring_windowSlide("abc");
        System.out.println(result);
    }

    @Test
    public void testTwo() {
        LongestSubStringWithoutRepeating longestSubStringWithoutRepeating = new LongestSubStringWithoutRepeating();
        int result = longestSubStringWithoutRepeating.lengthOfLongestSubstring_windowSlide("aaa");
        System.out.println(result);
    }

    @Test
    public void testThree() {
        LongestSubStringWithoutRepeating longestSubStringWithoutRepeating = new LongestSubStringWithoutRepeating();
        int result = longestSubStringWithoutRepeating.lengthOfLongestSubstring_windowSlide_alpha("abc");
        System.out.println(result);
    }

    @Test
    public void testFour() {
        LongestSubStringWithoutRepeating longestSubStringWithoutRepeating = new LongestSubStringWithoutRepeating();
        int result = longestSubStringWithoutRepeating.lengthOfLongestSubstring_windowSlide_alpha("aaa");
        System.out.println(result);
    }

}
