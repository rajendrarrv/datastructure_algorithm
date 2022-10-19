package com.rajendra.collection.queue;

import java.util.Arrays;

/**
 * Created by Rajendra Verma on 25/09/22.
 */
public class VCircularQueue extends VLinearQueue {
    public VCircularQueue(int size) {
        super(size);
    }


    @Override
    public void enqueue(int x) {

        if (isEmpty()) {
            front = 0;
            rear = 0;

            arrary[rear] = x;

        } else if (isFull()) {
            printOverflow();
            System.exit(0);

        }
        arrary[rear] = x;
        rear = (rear + 1) % capacity;

        size++;
        printInserting(x);


    }

    @Override
    public int dequeue() {

        if (isEmpty()) {
            printUnderflow();
            System.exit(0);
        }
        int x = arrary[front];
        printRemoving(x);
        front = (front + 1) % capacity;
        size--;
        return x;

    }
}
