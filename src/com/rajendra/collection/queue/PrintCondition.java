package com.rajendra.collection.queue;

/**
 * Created by Rajendra Verma on 25/09/22.
 */
public interface PrintCondition {
    void  printOverflow();
    void  printUnderflow();
    void printInserting(int x);
    void  printRemoving(int x);
}
