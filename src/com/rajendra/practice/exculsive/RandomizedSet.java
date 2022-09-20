package com.rajendra.practice.exculsive;

/**
 * Created by Rajendra Verma on 19/09/22.
 */
public class RandomizedSet {
    boolean[] _v;

    public RandomizedSet() {
        _v = new boolean[1000001];
        for (int i = 0; i < _v.length; i++) {
            _v[i] = false;
        }
    }

    public boolean insert(int val) {
        if (_v[val]) {
            return false;
        }
        _v[val] = true;
        return true;
    }

    public boolean remove(int val) {
        if (_v[val]) {
            _v[val] = false;

            return true;
        }
        return false;
    }

    public int getRandom() {
        for (int i = 0; i < _v.length; i++) {

            if (_v[i]) return i;
        }
        return -1;
    }
}
