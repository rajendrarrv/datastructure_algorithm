package com.rajendra.practice.apna;

import com.rajendra.utils.Beautify;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 * Created by Rajendra Verma on 01/10/22.
 */
public class WorkSheetString {

    public boolean isPalindrome(String s) {
        s = s.toLowerCase(Locale.ROOT);
        char charArray[] = s.toCharArray();
        if (charArray.length <= 1) return true;
        int left = 0;
        int right = charArray.length - 1;
        while (left <= right) {
            while (!Character.isLetterOrDigit(charArray[left]) && (left < right)) {
                left++;
            }
            while (!Character.isLetterOrDigit(charArray[right]) && (left < right)) {
                right--;
            }
            if ((charArray[left] != charArray[right])) return false;
            left++;
            right--;
        }
        return true;
    }

    public boolean isAnagram(String strOne, String strTwo) {
        if (strOne.length() != strTwo.length()) {
            return false;
        }
        char strOneArray[] = strOne.toCharArray();
        char strTwoArray[] = strTwo.toCharArray();

        Arrays.sort(strOneArray);
        Arrays.sort(strTwoArray);

        for (int i = 0; i < strOneArray.length; i++) {

            if (strOneArray[i] != strTwoArray[i]) return false;
        }

        return true;
    }

    public boolean isValidParenthesis(String str) {
        if (str.isEmpty()) return false;
        char charArray[] = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        stack.push(charArray[0]);
        for (int i = 1; i < charArray.length; i++) {
            char currentFromArray = charArray[i];
//            (])
            if (currentFromArray == '(' || currentFromArray == '{' || currentFromArray == '[') {
                stack.push(currentFromArray);
                i++;
                currentFromArray = charArray[i];

            }
            if (stack.isEmpty()) {
                return false;
            }

            char currentFromStack = stack.peek();


            if (currentFromArray == '}' && currentFromStack == '{') {
                stack.pop();
            } else if (currentFromArray == ')' && currentFromStack == '(') {
                stack.pop();
            } else if (currentFromArray == ']' && currentFromStack == '[') {
                stack.pop();
            } else {
                stack.push(currentFromArray);
            }

        }
        return stack.empty();
    }

    public String removeConsecutiveCharacter(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) != str.charAt(i + 1)) {
                sb.append(str.charAt(i));
            }

        }
        return sb.toString();
    }

    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];

        StringBuilder sb = new StringBuilder();
        int index = 0;

        while (index < first.length() && index < last.length()) {

            if (first.charAt(index) == last.charAt(index)) {
                sb.append(first.charAt(index));
            } else {
                break;
            }

            index++;
        }

        return sb.toString();
    }

    public int lengthOfLongestSubstring(String s) {
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

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs.length < 0) {
            List<String> s = new ArrayList<>();
            s.add("\"\"");
            result.add(s);
            return result;
        }
//        change all the string value to assending order

        HashMap<String, List<String>> anagram = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] charArray = strs[i].toCharArray();
            String str = strs[i];
            Arrays.sort(charArray);
            if (anagram.containsKey(convertToString(charArray))) {
                anagram.get(convertToString(charArray)).add(str);
            } else {
                List<String> stringList = new ArrayList<>();
                stringList.add(str);
                anagram.put(convertToString(charArray), stringList);
            }

        }
        for (int i = 0; i < strs.length; i++) {
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            List<String> sub = anagram.get(convertToString(charArray));

            if (!result.contains(sub)) {
                result.add(sub);
            }
        }
        return result;
    }


    public String longestPalindrome(String s) {


        return null;
    }

    private String convertToString(char[] charArray) {
        StringBuilder sb = new StringBuilder();
        sb.append(charArray);
        return sb.toString();
    }

    public int countSubstrings(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            int left = i, right = i;
            count += process(str, i, i);
            if (i < str.length() - 1) {
                count += process(str, i, i + 1);
            }
        }
        return count;

    }

    private int process(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            count++;
            left--;
            right++;
        }
        return count;
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


    public int characterReplacement(String s, int k) {
// this is a sliding window problem
        if (s == null || s.isEmpty() || k > s.length()) return 0;
        char[] characterCounter = new char[26];
        int start_window = 0;
        int end_window = 0;
        int max_count = 0;
        int max_length = 0;

        for (end_window = 0; end_window < s.length(); end_window++) {
            int index = s.charAt(end_window) - 'A';
            characterCounter[index]++;
            max_count = Math.max(max_count, characterCounter[index]);

            while (end_window - start_window - max_count + 1 > k) {
                int startIndex = s.charAt(start_window) - 'A';
                characterCounter[startIndex]--;

                start_window++;

            }

            max_length = Math.max(max_length, end_window - start_window + 1);


        }

        return max_length;
    }

    static final int no_of_chars = 26;
//    S = "t i m e t o p r a c t i c e"
//    P = "t oc"
//    t 1 o 1 c 1
//1+1+1 the total count is equal to the target string

//    startWindow and endWindow
//    startWindow = 0
//    the end point of the window is endWindow  = 9


    public String smallestWindow(String source, String target) {
        return smallestWindowProblem(source, target);
//        int lengthSource = source.length();
//        int lengthTarget = target.length();
//        if (lengthSource < lengthTarget) {
//            System.out.println("No such window exists");
//            return "";
//        }
//// take the character array to map the count of character in Source string and target string
//        int characterArrayOfTarget[] = new int[26];
//        int characterArrayofSource[] = new int[26];
//
//// track the mapping of target string
//        for (int i = 0; i < lengthTarget; i++)
//            characterArrayOfTarget[target.charAt(i) - 'a']++;
////for example
//
////        target is tist
////        t  i s     frequency of alphabets
////        2  1 1
//
//
//        int startWindow = 0, newStartPoint = -1, minLengthOfWindow = Integer.MAX_VALUE;
//
//        int windowCount = 0;
//        for (int endWindow = 0; endWindow < lengthSource; endWindow++) {
//
////            count the character occur in the source string
//            characterArrayofSource[source.charAt(endWindow) - 'a']++;
//
////            character occur in the source string is smaller than or equal to  the target string increase the count.
//
////            the main purpose of the count is to increase the size of window untill it will not take all the character from the target.
////            this closer will do following things
//
////            1. it will increase the count if the character is present in source and target string both.
////            2. it will not increase the count if the charcter is not present in the target string
////            3. it will incrase the count only if count of souce is not more than the target.
//
//            if (characterArrayofSource[source.charAt(endWindow) - 'a'] <= characterArrayOfTarget[source.charAt(endWindow) - 'a'])
//                windowCount++;
//
////            if the count of the source string is equal to the length of target string than ur goal is acheived, you have to minimize and update the window size
//            if (windowCount == lengthTarget) {
//
//
////                 if the character count of the source window is greater than the charcter count of the target window than this will decrese the character count of the source window and increase the startwindow ppinter
//                while (characterArrayofSource[source.charAt(startWindow) - 'a'] > characterArrayOfTarget[source.charAt(startWindow) - 'a'] || characterArrayOfTarget[source.charAt(startWindow) - 'a'] == 0) {
//
//                    if (characterArrayofSource[source.charAt(startWindow) - 'a'] > characterArrayOfTarget[source.charAt(startWindow) - 'a'])
//                        characterArrayofSource[source.charAt(startWindow) - 'a']--;
//                    startWindow++;
//                }
//
//                int len_window = endWindow - startWindow + 1;
//                if (minLengthOfWindow > len_window) {
//                    minLengthOfWindow = len_window;
//                    newStartPoint = startWindow;
//                }
//            }
//        }
//
//        if (newStartPoint == -1) {
//            System.out.println("No such window exists");
//            return "";
//        }
//
//        return source.substring(newStartPoint, newStartPoint + minLengthOfWindow);

    }

    public String smallestWindowProblem(String source, String target) {
        return minWindow(source, target);

    }

    public String minWindow(String source, String target) {
        int lengthOfSource = source.length();
        int lenghtOfTarget = target.length();

        if (lenghtOfTarget > lengthOfSource) {
            return null;
        }
        char[] charArrayOfTarget = new char[127];

        for (int i = 0; i < lenghtOfTarget; i++) {
            int index = target.charAt(i);
            charArrayOfTarget[index]++;
        }

        char[] charArrayOfSource = new char[127];
        int windowCount = 0;
        int startWindow = 0;
        int minimumLength = Integer.MAX_VALUE;
        int front = -1;
        for (int endWindow = 0; endWindow < lengthOfSource; endWindow++) {
//  finding of the target
            int index = source.charAt(endWindow);
            charArrayOfSource[index]++;
            if (charArrayOfSource[index] <= charArrayOfTarget[index]) windowCount++;

//            minimizing of window
            if (windowCount == lenghtOfTarget) {
                while (charArrayOfSource[source.charAt(startWindow)] > charArrayOfTarget[source.charAt(startWindow)] || charArrayOfTarget[source.charAt(startWindow)] == 0) {

                    if (charArrayOfSource[source.charAt(startWindow)] > charArrayOfTarget[source.charAt(startWindow)]) {
                        charArrayOfSource[startWindow]--;
                        startWindow++;
                    }

                }
//            calculating and re-calculating the result

                int lengthOfSubSequence = endWindow - startWindow + 1;

                if (lengthOfSubSequence < minimumLength) {

                    minimumLength = lengthOfSubSequence;
                    front = startWindow;
                }
            }


        }
// returning the result
        if (front == -1) {
            return null;
        }

        return source.substring(front, front + minimumLength);

    }


    public int longestPrefixSuffix(String source) {
        int lengthOfSource = source.length();

        if (lengthOfSource < 2) {
            return 0;
        }

        int left = 0;
        int mid = (lengthOfSource + 1) / 2;

        while (mid < lengthOfSource) {

            if (source.charAt(mid) == source.charAt(left)) {
                ++left;
                ++mid;
            } else {
                mid = mid - left + 1;
                left = 0;
            }
        }

        return left;

    }


    public int transformOneStringToAnother(String source, String target) {
        int minNumberOfOperation = 0;

        int lengthOfSource = source.length();
        int lengthOfTarget = target.length();

        if (lengthOfSource != lengthOfTarget) {
            minNumberOfOperation = -1;
            return minNumberOfOperation;
        }
//        now check the subset Of the source and target are same or not;
        int countArray[] = new int[256];
        for (int i = 0; i < lengthOfSource; i++) {

            countArray[source.charAt(i)]++;
            countArray[target.charAt(i)]--;
        }

        for (int i = 0; i < lengthOfSource; i++) {
            if (countArray[i] != 0)
//                can not transform the array length is same but characters are different
                return -1;
        }

//        here is the main logic
        int extraCounter = lengthOfSource - 1;
        for (int i = lengthOfSource - 1; i >= 0; i--) {

            if (source.charAt(i) != target.charAt(extraCounter)) {
                minNumberOfOperation++;
            } else {
                extraCounter--;
            }
        }


        return minNumberOfOperation;
    }


    @Test
    public void transformOneStringToAnotherTest() {
        WorkSheetString stringTest = new WorkSheetString();
        int result = stringTest.transformOneStringToAnother("EACBD", "EABCD");
        System.out.println("Result " + result);

    }

    @Test
    public void longestPrefixAnsSufix() {
        WorkSheetString stringTest = new WorkSheetString();

        int result = stringTest.longestPrefixSuffix("aabcdaabc");
        System.out.println(result);

    }

    @Test
    public void smallestWindowTest() {
        WorkSheetString stringTest = new WorkSheetString();

        String result = stringTest.smallestWindow("thisisateststring", "tist");

        System.out.println(result);


    }

    @Test
    public void smallestWindowTestTwo() {
        WorkSheetString stringTest = new WorkSheetString();

        String result = stringTest.smallestWindow("timetopractice", "toc");

        System.out.println(result);


    }

    @Test
    public void smallestWindowTestOne() {
        WorkSheetString stringTest = new WorkSheetString();

        String result = stringTest.smallestWindow("zoomlazapzo", "oza");

        System.out.println(result);


    }


    @Test
    public void characterReplacementTest() {
        WorkSheetString stringTest = new WorkSheetString();
        int result = stringTest.characterReplacement("ABAB", 2);
        System.out.println("Result " + result);

    }

    @Test
    public void countringSubStringTest() {
        WorkSheetString stringTest = new WorkSheetString();
        int result = stringTest.countSubstrings("abc");
        System.out.println("Result " + result);
    }

    @Test
    public void countringSubStringTest1() {
        WorkSheetString stringTest = new WorkSheetString();
        int result = stringTest.countSubstrings("aab");
        System.out.println("Result " + result);
    }

    @Test
    public void countringSubStringTest2() {
        WorkSheetString stringTest = new WorkSheetString();
        int result = stringTest.countSubstrings("aaa");
        System.out.println("Result " + result);
    }

}


