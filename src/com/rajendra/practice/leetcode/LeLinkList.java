package com.rajendra.practice.leetcode;

import com.rajendra.practice.leetcode.model.SinglyListNode;
import com.rajendra.practice.leetcode.protocol.LeLinkListImpl;


/**
 * Created by Rajendra Verma on 17/09/22.
 */
public class LeLinkList implements LeLinkListImpl {
    private SinglyListNode head;
    private SinglyListNode tail;
    private int count = 0;

    @Override
    public int get(int index) {
        if (head == null || index >= count) {
            return -1;
        }
        SinglyListNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;

        }
        return current.val;
    }

    @Override
    public void addAtHeat(int val) {
        if (head == null) {
            head = new SinglyListNode();
            head.val = val;
            tail = head;
        } else {
            SinglyListNode current = new SinglyListNode();
            current.val = val;
            current.next = head;
            head = current;
        }

        count++;
    }

    @Override
    public void addAtTail(int val) {
        if (tail == null) {
            head = new SinglyListNode();
            head.val = val;
            tail = head;
        } else {
            SinglyListNode current = new SinglyListNode();
            current.val = val;
            tail.next = current;
            tail = current;
            current.next = null;


        }
        count++;
    }

    @Override
    public void addAtIndex(int index, int val) {

        if (head == null) {
            head = new SinglyListNode();
            head.val = val;
            tail = head;
        }
        SinglyListNode prev = head;
        SinglyListNode next = head.next;
        SinglyListNode current = head;
        SinglyListNode addingNode = new SinglyListNode();
        addingNode.val = val;
        for (int i = 0; i < index; i++) {
            prev = current;
            current = current.next;
            next = current.next;
        }
        prev.next = addingNode;
        addingNode.next = current;
        current.next = next;

        count++;
    }

    @Override
    public boolean deleteAtIndex(int index) {
        if (head == null || index >= count) {
            return false;
        }
        if (index == 0) {

            head = head.next;
            count--;
            return true;
        }
        SinglyListNode prev = null;
        SinglyListNode current = head;

        for (int i = 0; i < index; i++) {
            prev = current;
            current = current.next;

        }
        prev.next = current.next;
        current = null;
        count--;
        return true;
    }

    @Override
    public void display() {
        System.out.print("[");
        while (head != null) {
            System.out.print(head.val);

            if (head.next != null)
                System.out.print(",");
            head = head.next;
        }
        System.out.print("]");
    }

    public static void main(String[] args) {
        LeLinkList leLinkList = new LeLinkList();
        leLinkList.addAtTail(1);
        leLinkList.addAtTail(2);
        leLinkList.addAtTail(3);
        leLinkList.addAtTail(4);
        leLinkList.addAtIndex(2, 9);
        System.out.println("delete  at INDEX " + leLinkList.deleteAtIndex(5));

        leLinkList.display();
    }
}
