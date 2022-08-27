package com.rajendra.model;

/**
 * Created by Rajendra Verma on 27/08/22.
 */
public class ListNode  {
    public int value;
    public ListNode next;

    public ListNode(int value) {
        this.value = value;
    }

    public ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }
}
