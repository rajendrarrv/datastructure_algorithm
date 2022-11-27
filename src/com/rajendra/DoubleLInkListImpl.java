package com.rajendra;

import com.rajendra.model.DoubleNode;

/**
 * Created by Rajendra Verma on 21/09/22.
 */
public class DoubleLInkListImpl {
    public DoubleNode head;
    public DoubleNode tail;
    public int size;

//    Input: head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
//    Output: [1,2,3,7,8,11,12,9,10,4,5,6]
//    Explanation: The multilevel linked list in the input is shown.
//    After flattening the multilevel linked list it becomes:


    public void insetAtFirst(int val) {
        DoubleNode new_Node = new DoubleNode();
        new_Node.val = val;
        new_Node.next = head;
        new_Node.prev = null;
        tail = head;
        if (head != null)
            head.prev = new_Node;
        tail = head.next;
        head = new_Node;

        size++;
    }


    public void insertAfter(DoubleNode prev_Node, int val) {

        if (prev_Node == null) {
            System.out.println(
                    "The given previous node cannot be NULL ");
            return;
        }

        DoubleNode new_node = new DoubleNode();
        new_node.val = val;

        new_node.next = prev_Node.next;

        prev_Node.next = new_node;
        new_node.prev = prev_Node;

        if (new_node.next != null)
            new_node.next.prev = new_node;
        size++;
    }

    public void insertAtLast(int val) {
        DoubleNode new_node = new DoubleNode();
        new_node.val = val;

        DoubleNode last = head; /* used in step 5*/
        new_node.next = null;

        if (head == null) {
            new_node.prev = null;
            head = new_node;
            return;
        }

        while (last.next != null)
            last = last.next;

        last.next = new_node;

        new_node.prev = last;
    }

    public void printlist() {
        printlist(this.head);
    }

    public void printlist(DoubleNode node) {
        DoubleNode last = null;
        System.out.println(
                "Traversal in forward Direction");
        while (node != null) {
            System.out.print(node.val + " ");
            last = node;
            node = node.next;
        }
        System.out.println();
        System.out.println(
                "Traversal in reverse direction");
        while (last != null) {
            System.out.print(last.val + " ");
            last = last.prev;
        }
    }

    public void flatten() {
        flatten(this.head);

    }

    public void flatten(DoubleNode head) {
        if (head == null) {
            return;
        }
//        traverse to  next
        System.out.println(head.val + "->");

        if (head.next != null) // 1,2,3,4,5,6
            flatten(head.next);
        else if (head.prev != null) {
            flatten(head.prev);
        } else {
            flatten(head.child);
        }


    }

    public static void main(String[] args) {
        DoubleLInkListImpl doubleLInkList = new DoubleLInkListImpl();
        doubleLInkList.insertAtLast(1);
        doubleLInkList.insertAtLast(2);
        doubleLInkList.insertAtLast(3);
        doubleLInkList.insertAtLast(4);
        doubleLInkList.printlist();
    }


}
