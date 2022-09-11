package com.rajendra.collection.utils;

/**
 * Created by Rajendra Verma on 08/09/22.
 */
public class Probability {
    public int ncr(int n, int r) {
        return fact(n) / (fact(r) *
                fact(n - r));
    }


    private int fact(int n) {
        if (n == 0)
            return 1;
        int res = 1;
        for (int i = 2; i <= n; i++)
            res = res * i;
        return res;
    }

}


