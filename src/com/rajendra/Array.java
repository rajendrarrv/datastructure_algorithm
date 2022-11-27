package com.rajendra;

public class Array {
    private int[] array;

    public Array(int[] array) {
        this.array = array;
    }

    public int findPivot() {
        return findPivot(array);

    }

    private int findPivot(int[] array) {
// corner case
        if (array == null || array.length == 0) return -1;
//        sum of the array
        int sum = 0;
        for (int i = 0; i < array.length; i++)
            sum += array[i];
        int leftSum = 0;

        for (int i = 0; i < array.length; i++) {

            if (leftSum == sum - leftSum - array[i]) return i;
            leftSum += array[i];
        }
// corner case
        return -1;
    }
}
