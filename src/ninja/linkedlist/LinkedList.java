package ninja.linkedlist;

import utils.NodeUtils;

/**
 * Created by Rajendra Verma on 15/08/22.
 */
public class LinkedList {
    private Node root;
    private Node head;

    public LinkedList(Node root) {
        this.root = root;
        this.head = root;
    }

    /*
     * The the insertion operarion includes
     * 1. push
     * 2 . append
     * 3.  push after the index
     *
     * */

    public void push(Node newNode) {
        newNode.next = head;
        head = newNode;
        root = head;

    }


    public void append(Node node) {
        if (head == null)
            head = node;
        node.next = null;
        Node last = head;
        while (last.next != null)
            last = last.next;
        last.next = node;
        head = last;
    }

    public void insertAfter(Node prev_node, Node new_node) {
        if (prev_node == null) {
            System.out.println("The given previous node cannot be null");
            return;
        }
        new_node.next = prev_node.next;
        prev_node.next = new_node;
    }

    public void insertBefore(int value, Node newNode) {

        if (head.data == value){
            newNode.next = head;
            root  =newNode;
            return;
        }



        Node prev = null;
        Node temp = head;
        while (temp != null) {
            if (temp.data == value) {
                prev.next = newNode;
                newNode.next = temp;
                return;
            }
            prev = temp;
            temp = temp.next;

        }

    }


    public void deleteSpecificNode(int value) {
        Node prev = null;
        Node temp = head;
        // If head node itself holds the key to be deleted
        if (temp != null && temp.data == value) {
            head = temp.next; // Changed head
            return;
        }
// Search for the key to be deleted, keep track of
        // the previous node as we need to change temp.next
        while (temp != null && temp.data != value) {
            prev = temp;
            temp = temp.next;
        }

        // If key was not present in linked list
        if (temp == null)
            return;

        // Unlink the node from linked list
        prev.next = temp.next;

    }

    public void deleteTheNodeFromBegining() {
        Node temp = head;
        if (temp != null) {
            head = temp.next;
        }
        root = head;

    }

    public void deleteTheNodeFromLast() {
        if (head == null) {
            System.out.println("list is empty");
            return;
        }
        if (head.next == null) {
            head = null;
        }

        Node temp = new Node(0);
        temp = this.head;
        while (temp.next.next != null)
            temp = temp.next;

        //3. Change the next of the second
        //   last node to null and delete the
        //   last node
        Node lastNode = temp.next;
        temp.next = null;
        lastNode = null;

    }

    public void deleteTheNodeFromMiddle() {
        if (head == null) {
            System.out.println("list is empty");
            return;
        }
        int middle = NodeUtils.sizeOf(head) / 2;
        int count = 0;
        Node temp = head;
        Node current = null;
        while (temp != null) {
            if (count == middle) {
                current = temp;
                break;
            }
            temp = temp.next;
            count++;
        }
        head.next = temp.next;
        temp = null;


    }



    /*
     *
     * */

    public Node getHead() {
        return head;
    }

    public Node getRoot() {
        return root;
    }

}
