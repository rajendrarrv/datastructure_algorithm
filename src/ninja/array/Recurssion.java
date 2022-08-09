package ninja.array;

import utils.PrintArray;

/**
 * Created by Rajendra Verma on 08/08/22.
 */
public class Recurssion {
    public void solution() {

        int []inputArray = {1, 2, 3, 2, 2, 5};
        int searchElement  = 2 ;
        int [] result  = allIndex(inputArray,searchElement,0);

        PrintArray printArray = new PrintArray();
        printArray.horizontal(result);

    }

    private void recur_searchArray(int[] input, int index, int value) {
        if (index < 0) {
            return;
        }
        recur_searchArray(input, index - 1, value);
        int search = input[index];
        if (search == value) {
            System.out.println("Index " + index);
            return;
        }
    }

    private void recur_printArray(int[] input, int index) {
        if (index < 0) {
            return;
        }
        recur_printArray(input, index - 1);
        System.out.println(input[index]);

    }

    private void recur_numberOfDigit(int num) {
        if (num == 0) return;
        int digit = num % 10;
        System.out.println(digit);
        recur_numberOfDigit(num / 10);
    }


    private double recur_power(int base, int exponent) {

        if (exponent == 0) {// base
            return 1;
        }
        if (exponent < 0) { // base
            return 1 / recur_power(base, -exponent);
        } else {
            double results = base * recur_power(base, exponent - 1);
            return results;
        }

    }

    private void recur_printNumber(int n) {
        if (n == 0) {
            return;
        }

        recur_printNumber(n - 1);
        System.out.println(n);

    }


    //
    public int[] allIndex(int inputArray[], int searchElement, int startIndex) {
        if (startIndex == inputArray.length) { // base 1, if the array is empty
            int[] ans = new int[0]; // empty array
            return ans;
        }
//       same method with the different input
        int[] smallIndex = allIndex(inputArray, searchElement,
                startIndex + 1);

        if (inputArray[startIndex] == searchElement) {
            int[] myAns = new int[smallIndex.length + 1];
            myAns[0] = startIndex;
            for (int i = 0; i < smallIndex.length; i++) {
                myAns[i + 1] = smallIndex[i];
            }
            return myAns;
        } else {
            return smallIndex;
        }
    }

}
