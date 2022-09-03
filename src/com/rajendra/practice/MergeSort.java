package com.rajendra.practice;

import com.rajendra.collection.LinkedListImpl;
import com.rajendra.model.ListNode;

/**
 * Created by Rajendra Verma on 27/08/22.
 */
public class MergeSort implements IMergeSort {


    @Override
    public ListNode merge(ListNode list1, ListNode list2) {
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
    public ListNode sortList(ListNode head) {
        if (head ==null || head.next!=null){
            return head;
        }

        ListNode mid = mid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }

    @Override
    public ListNode mid(ListNode head) {
        ListNode midPrev = head;
        while (head != null && head.next != null) {
            midPrev = (midPrev == null) ? head : midPrev.next;
            head = head.next.next;
        }
        ListNode mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }

    public static void main(String[] args) {
        MergeSort f   = new MergeSort();
        LinkedListImpl d  = new LinkedListImpl();
        d.insertLast(5);
        d.insertLast(4);
        d.insertLast(3);
        d.insertLast(2);
        d.insertLast(1);
       d.head= f.sortList(d.head);
        d.display();
    }
}
