package ninja.array;

import utils.MathUtils;
import utils.PrintArray;

/**
 * Created by Rajendra Verma on 08/08/22.
 */
public class Recurssion1 {
    public void solution() {


//        String result  = piReplace("xpix",'pi',"3.14");
//        PrintArray printArray = new PrintArray();
//        printArray.answer("Geo-metric progression  " + result);




    }


    private int multiOfTwoNo(int x, int y) {
        if (x < y)
            return multiOfTwoNo(y, x);
        else if (y != 0)
            return (x + multiOfTwoNo(x, y - 1));
        else
            return 0;

    }

    public int countDigits(int n, int k) {
        if (n == 0)
            return 0;
        int digit = n % 10;
        if (digit == k)
            return 1 + countDigits(n / 10, k);
        return countDigits(n / 10, k);
    }

    public double geometricProgression(int n) {
        if (n == 0)
            return 1;
        // calculate the sum each time
        double ans = 1 / (double) Math.pow(3, n) + geometricProgression(n - 1);
        // return final answer
        return MathUtils.roundOff(ans, 5);
    }


    public boolean isPalidrom(int number) {

        int num = rev(number, 0);

        return num == number;


    }

    private int rev(int n, int temp) {

        // base case
        if (n == 0)
            return temp;

        // stores the reverse
        // of a number
        temp = (temp * 10) + (n % 10);

        return rev(n / 10, temp);

    }





    public static String piReplace(String s, char from, char to){
        if (s.length() < 1) {
            return s;
        }
        else {
            char first = from == s.charAt(0) ? to : s.charAt(0);
            return first + piReplace(s.substring(1), from, to);
        }
    }


}




