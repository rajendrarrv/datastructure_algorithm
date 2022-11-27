package com.rajendra.collection.queue;

/**
 * Created by Rajendra Verma on 25/09/22.
 */
public interface VQueue {

    public int dequeue();

    public void enqueue(int x);

    public int peek();

    public int size();

    public boolean isEmpty();

    public boolean isFull();
}
