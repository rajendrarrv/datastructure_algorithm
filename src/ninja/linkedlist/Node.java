package ninja.linkedlist;

/**
 * Created by Rajendra Verma on 14/08/22.
 */
public class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}
