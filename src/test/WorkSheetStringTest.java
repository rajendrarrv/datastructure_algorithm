package test;

import com.rajendra.practice.apna.WorkSheetString;

import org.junit.Test;

import java.util.List;

/**
 * Created by Rajendra Verma on 01/10/22.
 */
public class WorkSheetStringTest {
    WorkSheetString stringTest = new WorkSheetString();

    @Test
    public void isPalindromeTest() {
        boolean is = stringTest.isPalindrome("0P");
        System.out.println("Result " + is);
    }

    @Test
    public void isPalindromeTest1() {
        boolean is = stringTest.isPalindrome("A man, a plan, a canal: Panama");
        System.out.println("Result " + is);

    }
    @Test
    public void isPalindromeTest2() {
        boolean is = stringTest.isPalindrome("a.");
        System.out.println("Result " + is);

    }

    @Test
    public  void  anagramTest(){
        String  s = "anagram";
        String t = "nagaram";

        boolean is = stringTest.isAnagram(s,t);
        System.out.println("Result " + is);

    }

    @Test
    public  void  anagramTest1(){
        String  s = "rat";
        String t = "car";

        boolean is = stringTest.isAnagram(s,t);
        System.out.println("Result " + is);

    }

    @Test
    public  void  validParenthesisTest(){
       boolean is = stringTest.isValidParenthesis("()");
        System.out.println("Result " + is);

    }

    @Test
    public  void  validParenthesisTest1(){
       boolean is = stringTest.isValidParenthesis("()[]{}");
        System.out.println("Result " + is);

    }
    @Test
    public  void  validParenthesisTest2(){
       boolean is = stringTest.isValidParenthesis("(]");
        System.out.println("Result " + is);

    }
    @Test
    public  void  validParenthesisTest3(){
       boolean is = stringTest.isValidParenthesis("([)]");
        System.out.println("Result " + is);

    }
    @Test
    public  void  validParenthesisTest4(){
       boolean is = stringTest.isValidParenthesis("(){}}{");
        System.out.println("Result " + is);

    }
    @Test
    public  void  validParenthesisTest5(){
       boolean is = stringTest.isValidParenthesis("(])");
        System.out.println("Result " + is);

    }
    @Test
    public  void  removeConsecutiveCharacterTest(){
       String is = stringTest.removeConsecutiveCharacter("aabb");
        System.out.println("Result " + is);

    }
    @Test
    public  void  removeConsecutiveCharacterTest1(){
        String is = stringTest.removeConsecutiveCharacter("aabaa");
        System.out.println("Result " + is);

    } @Test
    public  void  longestCommonPrefixTest(){
        String is = stringTest.longestCommonPrefix(new String[]{"flower","flow","flight"});
        System.out.println("Result " + is);

    }@Test
    public  void  longestCommonPrefixTest1(){
        String is = stringTest.longestCommonPrefix(new String[]{"dog","racecar","car"});
        System.out.println("Result " + is);

    }
    @Test
    public  void lengthOfLongestSubstringTest(){
        int result  = stringTest.lengthOfLongestSubstring("pwwkew");
        System.out.println("Result "+result);
    }
    @Test
    public  void lengthOfLongestSubstringTest1(){
        int result  = stringTest.lengthOfLongestSubstring("aab");
        System.out.println("Result "+result);
    } @Test
    public  void lengthOfLongestSubstringTest2(){
        int result  = stringTest.lengthOfLongestSubstring("bbbbb");
        System.out.println("Result "+result);
    }
    @Test
    public  void anagramGroupTest(){
        String [] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> result  = stringTest.groupAnagrams(strs);
        System.out.println("Result "+result);
    }
    @Test
    public  void anagramGroupTest1(){
        String [] strs = {""};
        List<List<String>> result  = stringTest.groupAnagrams(strs);
        System.out.println("Result "+result);
    }

    @Test
    public  void anagramGroupTest2(){
        String [] strs = {"a"};
        List<List<String>> result  = stringTest.groupAnagrams(strs);
        System.out.println("Result "+result);
    }
    @Test
    public  void longestPalindromeTest(){
        String result  = stringTest.longestPalindrome("cbbd");
        System.out.println("Result "+result);
    }

    @Test
    public  void longestPalindromeTest1(){
        String result  = stringTest.longestPalindrome("babad");
        System.out.println("Result "+result);
    }
    @Test
    public  void longestPalindromeTest2(){
        String result  = stringTest.longestPalindrome("ac");
        System.out.println("Result "+result);
    }

    @Test
    public  void longestPalindromeTest3(){
        String result  = stringTest.longestPalindrome("abb");
        System.out.println("Result "+result);
    }


}
