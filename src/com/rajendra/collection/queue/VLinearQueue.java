package com.rajendra.collection.queue;

import java.util.Arrays;

/**
 * Created by Rajendra Verma on 25/09/22.
 */
public class VLinearQueue implements VQueue, PrintCondition {
    int arrary[];
    int size =0;
    int capacity;
    int front = -1;
    int rear = -1;

    public VLinearQueue(int size) {

        arrary = new int[size];
        capacity = size;

    }

    @Override
    public int dequeue() {
        if (isEmpty()) {
            printUnderflow();
            size = 0;

            System.exit(0);
            return -1;
        }
        int item = arrary[front];
        front++;
        size--;
        printRemoving(item);
        return item;
    }

    @Override
    public void enqueue(int x) {
//        check underflow
        if (isEmpty()) {
            front = 0;
            rear = 0;
            arrary[rear] = x;
            rear = rear + 1;
            printInserting(x);
size ++;
            return;
        } else if (isFull()) {
            printOverflow();
            System.out.println(Arrays.toString(arrary));
            System.exit(0);
            return;
        }
        printInserting(x);
        arrary[rear] = x;
        rear++;
        size++;


    }

    @Override
    public int peek() {
        return arrary[rear];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size<=0;
    }

    @Override
    public boolean isFull() {
        return size >= capacity;
    }

    @Override
    public void printOverflow() {
        System.out.println("Overflow !");
    }

    @Override
    public void printUnderflow() {
        System.out.println("Underflow !");

    }

    @Override
    public void printInserting(int x) {
        System.out.println("Inserting element " + x);
    }

    @Override
    public void printRemoving(int x) {
        System.out.println("Removing " + x);
    }
}
