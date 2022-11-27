package com.rajendra.practice.leetcode.protocol;

/**
 * Created by Rajendra Verma on 18/09/22.
 */
public interface LeLinkListImpl {
    public  int get(int index);
    public  void  addAtHeat(int val);
    public  void  addAtTail(int val);
    public void  addAtIndex(int index,int val);
    public  boolean deleteAtIndex(int index);
    public  void  display();
}
