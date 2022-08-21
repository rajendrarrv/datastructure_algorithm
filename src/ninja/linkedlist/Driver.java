package ninja.linkedlist;

import utils.NodeUtils;

/**
 * Created by Rajendra Verma on 14/08/22.
 */
public class Driver {
    static Node node;

    public static void main(String[] args) {


        NodeSample nodeSample = new NodeSample();
        node = nodeSample.getNodeList();
        LinkedList linkedList = new LinkedList(node);
        System.out.println("List of Node Before deletion");
        NodeUtils.printList(linkedList.getRoot());
        linkedList.insertBefore(100, new Node(13) );
        System.out.println("List of Node After deletion");
        NodeUtils.printList(linkedList.getRoot());
    }


}
