package com.rajendra.collection.queue;

/**
 * Created by Rajendra Verma on 25/09/22.
 */
public class MyCircularQueue {
    int size;
    int capacity;
    int array[];
    int front = -1;
    int rear = -1;

    public MyCircularQueue(int k) {
        array = new int[k];
        size = 0;
        capacity = k;


    }

    public boolean enQueue(int value) {
        if (isEmpty()) {
            front = 0;
            rear = 0;
            array[rear] = value;
            System.out.println(value);
            rear = (rear + 1) % capacity;
            System.out.println("inserting element " + value);

            size++;
            return true;
        } else if (isFull()) {
            System.out.println("Overflow");
            System.exit(0);
            return false;
        }
        array[rear] = value;
        System.out.println("inserting element " + value);
        rear = (rear + 1) % capacity;
        size++;

        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            System.out.println("Underflow ");
            System.exit(0);
            return false;
        }
        int x = array[front];
        front = (front + 1) % capacity;
        System.out.println("deleting element " + x);
        size--;
        return true;
    }

    public int Front() {
        return front;
    }

    public int Rear() {
        return rear;
    }

    public boolean isEmpty() {
        return size <= 0;

    }

    public boolean isFull() {
        return size >= capacity;

    }
}
