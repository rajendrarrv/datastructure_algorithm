package com.rajendra.practice;

import com.rajendra.model.ListNode;

/**
 * Created by Rajendra Verma on 27/08/22.
 */
public interface IMergeSort {
    public ListNode merge(ListNode left,ListNode right);

    public ListNode sortList(ListNode listNode);

    public ListNode mid(ListNode node);
}
