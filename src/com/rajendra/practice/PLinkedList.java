package com.rajendra.practice;

import com.rajendra.collection.LinkedList;
import com.rajendra.model.ListNode;
import com.rajendra.model.Node;

/**
 * Created by Rajendra Verma on 27/08/22.
 */
public class PLinkedList extends LinkedList {

    @Override
    public void insert(int val, int index) {
        if (index == 0) {
            insertFirst(val);
        }
        if (index == size) {
            insertLast(val);
        }
        Node current = head;

        for (int i = 1; i < index; i++) {
            current = current.next;
        }
        Node newNode = new Node(val);
        Node temp = current.next;
        current.next = newNode;
        newNode.next = temp;
    }

    @Override
    public Node insertRec(int val, int index, Node node) {
        if (index == 0) {
            Node newNode = new Node(val, node);
            size++;
            return newNode;
        }
        node.next = insertRec(val, index - 1, node.next);

        return node;
    }

    @Override
    public void duplicates() {
        Node temp = head;
        while (temp != null && temp.next != null) {
            if (temp.value == temp.next.value) {

                temp.next = temp.next.next;
                size--;
            } else {

                temp = temp.next;
            }
        }
        tail = temp;
        tail.next = null;
    }


    @Override
    public PLinkedList merge(LinkedList first, LinkedList second) {
        Node a = first.head;
        Node b = second.head;
        PLinkedList ans = new PLinkedList();
        while (a != null && b != null) {
            if (a.value < b.value) {
                ans.insertLast(a.value);
                a = a.next;
            } else {
                ans.insertLast(b.value);
                b = b.next;
            }
        }

        while (a != null) {
            ans.insertLast(a.value);
            a = a.next;
        }
        while (b != null) {
            ans.insertLast(b.value);
            b = b.next;
        }
        return ans;
    }

    @Override
    public boolean hasCycle(ListNode node) {
        ListNode fast = node;
        ListNode slow = node;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int lengthCycle(ListNode node) {
        ListNode fast = node;
        ListNode slow = node;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {

                ListNode temp = slow;
                int length = 0;
                do {
                    temp = temp.next;
                    length++;
                } while (temp != slow);
                return length;
            }
        }
        return 0;


    }
    @Override
    public ListNode detectCycle(ListNode head) {
// lets clear it has cycle or not

        ListNode fast = head;
        ListNode slow = head;

        int lengthOfCycle = 0;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
//                 length of the cycle
                lengthOfCycle = lengthCycle(slow);
                break;

            }
        }
        if (lengthOfCycle == 0)
            return null;

//  find the start node

        ListNode first = head;
        ListNode second = head;

        while (lengthOfCycle > 0) {
            second = second.next;
            lengthOfCycle--;
        }
        while (first != second) {

            first = first.next;
            second = second.next;
        }


        return first;


    }

    @Override
    public boolean isHappyNumber(int num) {

        int slow = num;
        int fast = num;
        do {

            slow = findDigitSquare(slow);
            fast = findDigitSquare(findDigitSquare(fast));

        } while (slow != fast);

        if (slow == 1)
            return true;

        return false;


    }

    @Override
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }



    private int findDigitSquare(int num) {
        int ans = 0;
        while (num != 0) {

            int rem = num % 10;
            ans = ans + rem * rem;

            num = num / 10;

        }
        return ans;
    }

    public void printSize() {

        System.out.println("Size " + size);
    }

    public static void main(String[] args) {

    }
}
