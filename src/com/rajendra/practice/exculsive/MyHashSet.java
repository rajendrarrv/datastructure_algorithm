package com.rajendra.practice.exculsive;

/**
 * Created by Rajendra Verma on 19/09/22.
 */
public class MyHashSet {

    boolean[] map;

    public MyHashSet() {
        map = new boolean[1000001];
    }

    public void add(int key) {
        map[key] = true;
    }

    public void remove(int key) {
        map[key] = false;
    }

    public boolean contains(int key) {

        return map[key];
    }
}
