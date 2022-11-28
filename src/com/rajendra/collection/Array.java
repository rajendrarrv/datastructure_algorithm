package com.rajendra.collection;

public class Array {
    private int anInt[];


    public void setAnInt(int[] anInt) {
        this.anInt = anInt;
    }

    public int findPivot() {
        return findPivot(anInt);
    }

    private int findPivot(int[] anInt) {
        if (anInt == null || anInt.length == 0) return -1;

        int sum = 0;
        for (int i = 0; i < anInt.length; i++) sum += anInt[i];

        int leftSum = 0;

        for (int i = 0; i < anInt.length; i++) {

            if (leftSum == sum - leftSum - anInt[i]) return i;
            leftSum += anInt[i];

        }


        return -1;
    }
}
