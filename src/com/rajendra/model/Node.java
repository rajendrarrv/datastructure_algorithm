package com.rajendra.model;

import com.rajendra.collection.LinkedList;

/**
 * Created by Rajendra Verma on 27/08/22.
 */
public class Node  {
    public int value;
    public Node next;

    public Node(int value) {
        this.value = value;
    }

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}
