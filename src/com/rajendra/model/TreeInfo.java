package com.rajendra.model;

/**
 * Created by Rajendra Verma on 29/08/22.
 */
public class TreeInfo {
    public int height;
    public int diameter;
    public  int tilt;
    public int sumRange =0;

    public TreeInfo(int height, int diameter) {
        this.height = height;
        this.diameter = diameter;
    }

    public TreeInfo(int tilt) {
        this.tilt = tilt;
    }

    public TreeInfo() {
    }
}
