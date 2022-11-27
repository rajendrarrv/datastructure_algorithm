package com.rajendra.collection.utils;

import java.util.HashMap;

/**
 * Created by Rajendra Verma on 11/09/22.
 */
public class RomanNumber {
    HashMap<Character, Integer> chart = new HashMap<>();

    public RomanNumber() {
        chart.put('I', 1);
        chart.put('V', 5);
        chart.put('X', 10);
        chart.put('L', 50);
        chart.put('C', 100);
        chart.put('D', 500);
        chart.put('M', 1000);
    }


    public int convertRomanToInteger(String str) {
        int result = 0;
        for (int i = 0; i < str.length() ; i++) {
            int s = getInteger(str.charAt(i));
            if (i + 1 < str.length()) {
                int r = getInteger(str.charAt(i + 1));
                if (s >= r) {
                    result = result + s;
                }
                else {
                    result = result + r - s;
                    i++;
                }
            }
            else {
                result = result + s;
            }
        }
        return result;
    }
    public String convertIntegerRomanNumber(int num){
        String m[] = { "", "M", "MM", "MMM" };
        String c[] = { "",  "C",  "CC",  "CCC",  "CD",
                "D", "DC", "DCC", "DCCC", "CM" };
        String x[] = { "",  "X",  "XX",  "XXX",  "XL",
                "L", "LX", "LXX", "LXXX", "XC" };
        String i[] = { "",  "I",  "II",  "III",  "IV",
                "V", "VI", "VII", "VIII", "IX" };

        // Converting to roman
        String thousands = m[num / 1000];
        String hundreds = c[(num % 1000) / 100];
        String tens = x[(num % 100) / 10];
        String ones = i[num % 10];

        String ans = thousands + hundreds + tens + ones;

        return ans;
    }

    private int getInteger(char charAt) {
        return chart.get(charAt);
    }

}
