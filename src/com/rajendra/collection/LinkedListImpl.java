package com.rajendra.collection;

import com.rajendra.model.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * kunal class
 * Created by Rajendra Verma on 27/08/22.
 */
public class LinkedListImpl {
    //head - 1-2-3-4-trail
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
        int val = tail.val;
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
        int val = prev.next.val;

        prev.next = prev.next.next;
        size--;
        return val;
    }

    public ListNode find(int value) {
        ListNode node = head;
        while (node != null) {
            if (node.val == value) {
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
        int val = head.val;
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
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public void display(ListNode d) {
        ListNode temp = d;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    // https://leetcode.com/problems/remove-duplicates-from-sorted-list
    public void duplicates() {
        ListNode node = head;

        while (node.next != null) {
            if (node.val == node.next.val) {
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
            if (f.val < s.val) {
                ans.insertLast(f.val);
                f = f.next;
            } else {
                ans.insertLast(s.val);
                s = s.next;
            }
        }

        while (f != null) {
            ans.insertLast(f.val);
            f = f.next;
        }

        while (s != null) {
            ans.insertLast(s.val);
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

            if (first.val > second.val) {
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
        ListNode mid = head;
        while (head != null && head.next != null) {

            mid = mid.next;

            head = head.next.next;

        }

        return mid;

    }


    public ListNode reverseBetween(ListNode head, int left, int right) {


//         operation is already done
        if (left == right) {
            return head;
        }

        // skip the first left-1 nodes
        ListNode current = head;
        ListNode prev = null;
        for (int i = 0; current != null && i < left - 1; i++) {
            prev = current;
            current = current.next;
        }

        ListNode last = prev;
        ListNode newEnd = current;

        // reverse between left and right
        ListNode next = current.next;
        for (int i = 0; current != null && i < right - left + 1; i++) {
            current.next = prev;
            prev = current;
            current = next;
            if (next != null) {
                next = next.next;
            }
        }

        if (last != null) {
            last.next = prev;
        } else {
            head = prev;
        }

        newEnd.next = current;
        return head;


    }

    public void swapPairs() {


        swapPairsRec(this.head);
    }

    public ListNode swapPairsItr(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode temp = head;

        while (temp != null && temp.next != null) {

            int k = temp.val;
            temp.val = temp.next.val;
            temp.next.val = k;
            temp = temp.next.next;
        }
        return head;
    }

    public void swapPairsRec(ListNode node) {
        if (node == null || node.next == null)
            return;
        int k = node.val;
        node.val = node.next.val;
        node.next.val = k;
        swapPairsRec(node.next.next);
    }

    public void reverseList() {

        ListNode newHead = reverseListRec(head);
        head = newHead;
    }

    public ListNode reverseListRec(ListNode head) {
        if (head.next == null)
            return head;

        ListNode newHead = reverseListRec(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }


    public void mergeTwoListsRec(ListNode list1, ListNode list2, ListNode result) {
        if (list1 == null && list2 == null) {
            return;
        }
        if (list1 == null && list2 != null) {
            result.next = list2;
            return;
        }
        if (list2 == null && list1 != null) {
            result.next = list1;
            return;
        }
        if (list1.val < list2.val) {
            result.next = new ListNode(list1.val);
            mergeTwoListsRec(list1.next, list2, result.next);
        } else {
            result.next = new ListNode(list2.val);
            mergeTwoListsRec(list1, list2.next, result.next);
        }
    }

    private void append(ListNode result, int value) {
        while (result.next != null) {
            result = result.next;
        }
        result.next = new ListNode(value);
    }

    public boolean isPerfectSquare(int num) {
        if (num == 0) {
            return true;
        }
        if (num == 1) {
            return true;
        }

        int left = 1;
        int right = num;
        int mid = (left + right) / 2;

        int s = mid * mid;

        if (s == num)
            return true;
        else if (s > num) {

        } else {

        }

        return false;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        while (headB != null) {
            ListNode temp = headA;
            while (temp != null) {
                // if both Nodes are same
                if (temp == headB) {
                    return headB;
                }
                temp = temp.next;
            }
            headB = headB.next;
        }
        // If intersection is not present between the lists,
        // return NULL.
        return null;
    }


    int getSize(ListNode head) {

        int count = 0;
        while (head != null) {

            head = head.next;
            count++;
        }
        return count;
    }

    public ListNode rotateRight(int k) {
        if (k <= 0 || head == null || head.next == null) {
            return head;
        }

        ListNode last = head;
        int length = 1;
        while (last.next != null) {
            last = last.next;
            length++;
        }

        last.next = head;
        int rotations = k % length;
        int skip = length - rotations;
        ListNode newLast = head;
        for (int i = 0; i < skip - 1; i++) {
            newLast = newLast.next;
        }
        head = newLast.next;
        newLast.next = null;

        return head;
    }

    public boolean isHappy(int n) {
        int fast = sq(sq(n));
        int slow = sq(n);

        if (fast == slow)
            return true;

        while (fast != slow) {
            fast = sq(sq(fast));
            slow = sq(slow);

            if (fast == 1 || slow == 1)
                return true;
            System.out.printf("Fast %d and Slow %d", fast, slow);
            System.out.println();
        }
        return false;
    }

    private int sq(int n) {
        int num = n;
        int k = 0;
        while (num > 0) {
            int rem = num % 10;
            num = num / 10;
            k += rem * rem;
        }
        return k;
    }

    public void reverseKGroup(int k) {
        this.head = reverseKGroup(this.head, k);

    }

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode prev = null;
        ListNode current = head;
        ListNode next = current.next;
        for (int i = 0; i < k; i++) {
            current.next = prev;
            prev = current;
            current = next;
            if (next != null)
                next = next.next;

        }
        return prev;
    }

    public void removeNthFromEnd(int n) {
        this.head = removeNthFromEnd(this.head, n);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n == 0)
            return null;
        int sizeOfList = getSize(head);

        int reverseIndex = sizeOfList - n;

//         remove at index

        if (reverseIndex == 0) {
            if (head.next == null) {
                head = null;
                return head;
            } else {
                head = head.next;
                return head;
            }
        }
        ListNode temp = head;
        for (int i = 0; i < reverseIndex - 1; i++) {
            temp = temp.next;
            System.out.println("Value " + temp.val);

        }
        temp.next = temp.next.next;

        return head;
    }

    public void removeFirstOccElements(int val) {
        this.head = removeFirstOccElements(this.head, val);
    }

    public void removeElements(int val) {

        this.head = removeElements(this.head, val);
    }

    private ListNode removeElements(ListNode head, int val) {
        ListNode temp = head, prev = null;
//         change the  head and temp to the target elelment
        while (temp != null && temp.val == val) {
            prev = temp;
            head = temp.next; // Changed head
            temp = head; // Change Temp
        }
        while (temp != null) {
            while (temp != null && temp.val == val) {
                prev.next = temp.next;
                temp = temp.next;
            }
            if (temp == null)
                return head;
            prev = temp;
            temp = temp.next;
        }
        return head;
    }


    public ListNode removeFirstOccElements(ListNode head, int val) {
//         delete from the begining
        ListNode temp = head;
        ListNode prev = null;
        int index = 0;
        while (temp != null) {

//            delete at the first
            if (index == 0 && val == temp.val) {
                temp = temp.next;
                return temp;
//                delte at last
            } else if (index >= size - 1 && val == temp.val) {
                prev.next = temp.next;
                return head;
            } else { // delete at middle

                if (temp.val == val) {
                    prev.next = temp.next;
                }

            }
            prev = temp;
            temp = temp.next;
            index++;
        }

        return head;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode temp = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            ListNode node = new ListNode(sum % 10);
            carry = sum / 10;
            if (temp == null) {
                temp = head = node;
            } else {
                temp.next = node;
                temp = temp.next;
            }
        }
        if (carry > 0) {
            temp.next = new ListNode(carry);
        }
        this.head = head;
        return head;
    }


    public static void main(String[] args) {
        LinkedListImpl linkedList = new LinkedListImpl();
//        3,0,2,6,8,1,7,9,4,2,5,5,0
        linkedList.insertLast(3);
        linkedList.insertLast(0);
        linkedList.insertLast(2);
        linkedList.insertLast(6);
        linkedList.insertLast(8);
        linkedList.insertLast(1);
        linkedList.insertLast(7);
        linkedList.insertLast(9);
        linkedList.insertLast(4);
        linkedList.insertLast(2);
        linkedList.insertLast(5);
        linkedList.insertLast(5);
        linkedList.insertLast(0);
        System.out.println(Arrays.toString(linkedList.spiralMatrix(3, 5)));
        linkedList.display();

    }

    public int[][] spiralMatrix(int m, int n) {
        int[][] matrix = new int[m][n];


        ListNode temp = head;
        int i, row = 0, col = 0;
        int rowlen = matrix.length;
        int colLen = matrix[0].length;

        while (row < rowlen && col < colLen) {
            // Print the first row from the remaining rows
//            left
            for (i = col; i < colLen; ++i) {
                if (temp == null)
                    break;
                matrix[row][i] = temp.val;
                temp = temp.next;
                System.out.print(matrix[row][i] + " ");
            }
            row++;

            // Print the last column from the remaining
            // columns
//            down
            for (i = row; i < rowlen; ++i) {
                matrix[i][colLen - 1] = temp.val;
                temp = temp.next;
                System.out.print(matrix[i][colLen - 1] + " ");
            }
            colLen--; //

            // Print the last row from the remaining rows */
//            Moving right
            if (row < rowlen) {
                for (i = colLen - 1; i >= col; --i) {
                    matrix[rowlen - 1][i] = temp.val;
                    temp = temp.next;
                    System.out.print(matrix[rowlen - 1][i] + " ");
                }
                rowlen--;
            }

            // Print the first column from the remaining
            // columns */
//            Moving up
            if (col < colLen) {
                for (i = rowlen - 1; i >= row; --i) {
                    matrix[i][col] = temp.val;
                    temp = temp.next;
                    System.out.print(matrix[i][col] + " ");
                }
                col++;
            }

        }
        return matrix;


    }


}
