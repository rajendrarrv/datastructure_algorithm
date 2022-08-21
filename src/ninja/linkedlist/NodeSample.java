package ninja.linkedlist;

/**
 * Created by Rajendra Verma on 14/08/22.
 */
public class NodeSample {
    private Node root;

    public NodeSample() {
        root = new Node(1);
        root.next = new Node(2, new Node(3));
    }
    public Node getNodeList() {
        return root;
    }

}
