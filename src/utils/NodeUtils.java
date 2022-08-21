package utils;

import ninja.linkedlist.Node;

/**
 * Created by Rajendra Verma on 14/08/22.
 */
public class NodeUtils {
    public static void printList(Node head) {
        Node n = head;
        while (n != null) {
            System.out.print(n.data + "->");
            n = n.next;
        }
        System.out.println();
    }

    public static int sizeOf(Node head) {
        Node n = head;
        int size  =0;
        while (n != null) {
            n = n.next;
            size ++;
        }
        return size;
    }
}
