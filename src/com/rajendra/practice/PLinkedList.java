package com.rajendra.practice;

import com.rajendra.collection.LinkedList;
import com.rajendra.model.ListNode;

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
        ListNode current = head;

        for (int i = 1; i < index; i++) {
            current = current.next;
        }
        ListNode newListNode = new ListNode(val);
        ListNode temp = current.next;
        current.next = newListNode;
        newListNode.next = temp;
    }

    @Override
    public ListNode insertRec(int val, int index, ListNode ListNode) {
        if (index == 0) {
            ListNode newListNode = new ListNode(val, ListNode);
            size++;
            return newListNode;
        }
        ListNode.next = insertRec(val, index - 1, ListNode.next);

        return ListNode;
    }

// duplicates  the adjecent
    @Override
    public void duplicates() {
        ListNode temp = head;
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

//  non adjectent
    public void duplicatesII() {
        ListNode temp = head;
        ListNode prev = null;
        while (temp != null) {
            int val = temp.value;

            ListNode temp1 = temp.next;

            while (temp1 != null) {
//                corner case
                if (temp1.next == null) {
                    prev.next = null;
                }
                if (val == temp1.value) {
                    prev.next = temp1.next;

                }
                prev = temp1;
                temp1 = temp1.next;

            }


            temp = temp.next;

        }

    }


    @Override
    public PLinkedList merge(LinkedList first, LinkedList second) {
        ListNode a = first.head;
        ListNode b = second.head;
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


    public ListNode mergeWithNode(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;
        while (list1 != null && list2 != null) {
            if (list1.value < list2.value) {
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }
        tail.next = (list1 != null) ? list1 : list2;
        return dummyHead.next;
    }

    @Override
    public boolean hasCycle(ListNode ListNode) {
        ListNode fast = ListNode;
        ListNode slow = ListNode;

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
    public int lengthCycle(ListNode ListNode) {
        ListNode fast = ListNode;
        ListNode slow = ListNode;

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

//  find the start ListNode

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

        if (slow == 1 || fast == 1)
            return true;

        return false;


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

    @Override
    public void reverse() {
//        corner
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

    public ListNode getMid(ListNode head) {
        if (head == null)
            return head;
        ListNode mid = head;
        while (head != null && head.next != null) {

            mid = mid.next;
            head = head.next.next;
        }


        return mid;


    }


    public ListNode reverseFromListNode(ListNode head) {
        if (head == null)
            return head;

        ListNode prev = null;
        ListNode current = head;
        ListNode next = current.next;
        while (current != null) {
            current.next = prev;
            prev = current;
            current = next;
            if (next != null) {
                next = next.next;
            }

        }
        return prev;
    }


    @Override
    public ListNode reverseBetween(ListNode head, int left, int right) {

//         operation is already done
        if (left == right) {
            return head;
        }

        // skip the first left-1 ListNodes
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


    public void printSize() {

        System.out.println("Size " + size);
    }

    public void reorderList() {
        if (head == null || head.next == null) {
            return;
        }

        ListNode mid = middleNode(head);

        ListNode hs = reverseFromListNode(mid);
        ListNode hf = head;

        // rearrange
        ListNode dummyNode = new ListNode();
        ListNode trail = dummyNode;
        while (hf != null && hs != null) {

            trail.next = hf;
            trail = trail.next;
            hf = hf.next;
            trail.next = hs;
            trail = trail.next;
            hs = hs.next;

        }

       this. head = dummyNode.next;


    }

    public int getLength(ListNode head) {
        ListNode node = head;
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1 || head == null) {
            return head;
        }

        ListNode current = head;
        ListNode prev = null;

        int length = getLength(head);
        int count = length / k;
        while (count > 0) {
            ListNode last = prev;
            ListNode newEnd = current;

            ListNode next = current.next;
            for (int i = 0; current != null && i < k; i++) {
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

            prev = newEnd;
            count--;
        }
        return head;
    }


    public static void main(String[] args) {
        PLinkedList dummyList = new PLinkedList();

        PLinkedList a = new PLinkedList();
        a.insertLast(1);
        a.insertLast(2);
        a.insertLast(3);
        a.insertLast(4);
        a.insertLast(5);
        a.insertLast(6);
        a.reorderList();
        a.display();
//        System.out.println(""+ a.isPalidrome());
//
    }

    public ListNode reverseAlternateKGroup(ListNode head, int k) {
        if (k <= 1 || head == null) {
            return head;
        }

        // skip the first left-1 nodes
        ListNode current = head;
        ListNode prev = null;

        while (current != null) {
            ListNode last = prev;
            ListNode newEnd = current;

            // reverse between left and right
            ListNode next = current.next;
            for (int i = 0; current != null && i < k; i++) {
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

            // skip the k nodes
            for (int i = 0; current != null && i < k; i++) {
                prev = current;
                current = current.next;
            }
        }
        return head;
    }

    public ListNode rotateRight(ListNode head, int k) {
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

    private boolean isPalidrome() {
        ListNode temp = head;
        ListNode mid = getMid(temp);
        ListNode rev = reverseFromListNode(mid);
        while (rev != null) {
            if (temp.value != rev.value)
                break;

            temp = temp.next;
            rev = rev.next;

        }
        if (rev == null)
            return true;


        return false;
    }
}
