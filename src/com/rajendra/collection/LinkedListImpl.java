package com.rajendra.collection;

import com.rajendra.model.ListNode;

/**
 * kunal class
 * Created by Rajendra Verma on 27/08/22.
 */
public class LinkedListImpl {

    public ListNode head;
    public ListNode tail;
    public int size;

    public LinkedListImpl() {
        this.size = 0;
    }

    public void insertFirst(int val) {
        ListNode node = new ListNode(val);
        node.next = head;
        head = node;

        if (tail == null) {
            tail = head;
        }
        size += 1;
    }

    public void insertLast(int val) {
        if (tail == null) {
            insertFirst(val);
            return;
        }
        ListNode node = new ListNode(val);
        tail.next = node;
        tail = node;
        size++;
    }

    public void insert(int val, int index) {
        if (index == 0) {
            insertFirst(val);
            return;
        }
        if (index == size) {
            insertLast(val);
            return;
        }

        ListNode temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }

        ListNode node = new ListNode(val, temp.next);
        temp.next = node;

        size++;
    }

    // insert using recursion
    public void insertRec(int val, int index) {
        head = insertRec(val, index, head);
    }

    public ListNode insertRec(int val, int index, ListNode node) {
        if (index == 0) {
            ListNode temp = new ListNode(val, node);
            size++;
            return temp;
        }

        node.next = insertRec(val, index - 1, node.next);
        return node;
    }


    public int deleteLast() {
        if (size <= 1) {
            return deleteFirst();
        }

        ListNode secondLast = get(size - 2);
        int val = tail.value;
        tail = secondLast;
        tail.next = null;
        size--;
        return val;
    }

    public int delete(int index) {
        if (index == 0) {
            return deleteFirst();
        }
        if (index == size - 1) {
            return deleteLast();
        }

        ListNode prev = get(index - 1);
        int val = prev.next.value;

        prev.next = prev.next.next;
        size--;
        return val;
    }

    public ListNode find(int value) {
        ListNode node = head;
        while (node != null) {
            if (node.value == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public ListNode get(int index) {
        ListNode node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public int deleteFirst() {
        int val = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return val;
    }

    public void display() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public void display(ListNode d ) {
        ListNode temp = d;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    // https://leetcode.com/problems/remove-duplicates-from-sorted-list
    public void duplicates() {
        ListNode node = head;

        while (node.next != null) {
            if (node.value == node.next.value) {
                node.next = node.next.next;
                size--;
            } else {
                node = node.next;
            }
        }
        tail = node;
        tail.next = null;
    }

    // https://leetcode.com/problems/merge-two-sorted-lists/submissions/
    public LinkedListImpl merge(LinkedListImpl first, LinkedListImpl second) {
        ListNode f = first.head;
        ListNode s = second.head;

        LinkedListImpl ans = new LinkedListImpl();

        while (f != null && s != null) {
            if (f.value < s.value) {
                ans.insertLast(f.value);
                f = f.next;
            } else {
                ans.insertLast(s.value);
                s = s.next;
            }
        }

        while (f != null) {
            ans.insertLast(f.value);
            f = f.next;
        }

        while (s != null) {
            ans.insertLast(s.value);
            s = s.next;
        }

        return ans;
    }

    public void bubbleSort() {
        bubbleSort(size - 1, 0);
    }

    private void bubbleSort(int row, int col) {
        if (row == 0) {
            return;
        }

        if (col < row) {
            ListNode first = get(col);
            ListNode second = get(col + 1);

            if (first.value > second.value) {
                // swap
                if (first == head) {
                    head = second;
                    first.next = second.next;
                    second.next = first;
                } else if (second == tail) {
                    ListNode prev = get(col - 1);
                    prev.next = second;
                    tail = first;
                    first.next = null;
                    second.next = tail;
                } else {
                    ListNode prev = get(col - 1);
                    prev.next = second;
                    first.next = second.next;
                    second.next = first;
                }
            }
            bubbleSort(row, col + 1);
        } else {
            bubbleSort(row - 1, 0);
        }
    }

    // recursion reverse
    public void reverse(ListNode node) {
        if (node == null) {
            return;
        }
        reverse(node.next);
        tail.next = node;
        tail = node;
        tail.next = null;
    }

    public void reverseRec() {
        reverse(head);

    }

    // in place reversal of linked list
    // google, microsoft, apple, amazon: https://leetcode.com/problems/reverse-linked-list/
    public void reverse() {
        if (size < 2) {
            return;
        }

        ListNode prev = null;
        ListNode present = head;
        ListNode next = present.next;

        while (present != null) {
            present.next = prev;
            prev = present;
            present = next;
            if (next != null) {
                next = next.next;
            }
        }
        head = prev;
    }

//     linked list cycle related question

    public boolean hasCycle(ListNode node) {
        return false;
    }

    public int lengthCycle(ListNode node) {
        return 0;
    }

    public ListNode detectCycle(ListNode node) {

        return null;
    }

    //     happy number
    public boolean isHappyNumber(int num) {
        return false;
    }
//    middleOf linkedlist

    public ListNode middleNode(ListNode head) {
        ListNode mid  = head;
        while (head!=null && head.next !=null){

            mid  = mid.next;

            head  = head.next.next;

        }

        return mid;

    }


    public ListNode reverseBetween(ListNode head, int left, int right) {

        return null;
    }



}
