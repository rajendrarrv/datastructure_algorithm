package com.rajendra.collection;

import com.rajendra.model.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Rajendra Verma on 05/09/22.
 */
public class Tree {
    private Node root;

    public Tree(Node root) {
        this.root = root;
    }


    private void levelOrderTraversal() {
        System.out.println("Level Order Traversal");
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node node = queue.poll();
                System.out.print(node.id + " ");
                for (Node item : node.neighbors) {
                    queue.offer(item);
                }
            }
            System.out.println();
        }


    }

    public static void main(String[] args) {
        int data[] = {1, -1, 3, 2, 4, -1, 5, 6};

        Node root = new Node(1);
        root.neighbors.add(new Node(3));
        root.neighbors.get(0).neighbors.add(new Node(5));
        root.neighbors.get(0).neighbors.add(new Node(6));
        root.neighbors.add(new Node(2));
        root.neighbors.add(new Node(4));
        Tree tree = new Tree(root);
        tree.levelOrderTraversal();
//        tree.preOrderTraversal();
//        tree.inOrderTraversal();
        tree.postOrderTraveral();
        List<Integer> result = tree.postOrderTraveralLeetCode();
    }

    private List<Integer> postOrderTraveralLeetCode() {
        List<Integer> result = new ArrayList<>();
        postOrderTraveralLeetCodeRec(this.root, result);
        return result;
    }

    private void postOrderTraveralLeetCodeRec(Node root, List<Integer> result) {
        if (root == null)
            return;
        int total = root.neighbors.size();
        for (int i = 0; i < total - 1; i++)
            postOrderTraveralLeetCodeRec(root.neighbors.get(i), result);


        if (total > 0) {
            postOrderTraveralLeetCodeRec(root.neighbors.get(total - 1), result);
        }
        result.add(root.id);


    }

    private void postOrderTraveral() {
        System.out.println("Post Order Traversal");
        postOrderTraveralRec(this.root);
    }

    private void postOrderTraveralRec(Node root) {
        if (root == null)
            return;
        int total = root.neighbors.size();
        for (int i = 0; i < total - 1; i++)
            postOrderTraveralRec(root.neighbors.get(i));


        if (total > 0) {
            postOrderTraveralRec(root.neighbors.get(total - 1));
        }
        System.out.print("" + root.id + " ");
    }

    private void inOrderTraversal() {
        System.out.println("In order traversal");
        inOrderTraversalRec(this.root);

    }

    private void inOrderTraversalRec(Node root) {


        if (root == null)
            return;
        int total = root.neighbors.size();
        for (int i = 0; i < total - 1; i++)
            inOrderTraversalRec(root.neighbors.get(i));

        System.out.print("" + root.id + " ");

        if (total > 0) {
            inOrderTraversalRec(root.neighbors.get(total - 1));
        }
    }

    private List<Integer> preOrderTraversal() {
        List<Integer> result = new ArrayList<>();
        System.out.println("Pre Order Traversal");
        preOrderTraversalRec(this.root, result);
        return result;

    }

    public List<List<Integer>> levelOrderTraveralLeetCode() {
        return levelOrderTraveralLeetCodeRec(this.root);

    }

    private List<List<Integer>> levelOrderTraveralLeetCodeRec(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> innerList = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                Node node = queue.poll();
                innerList.add(node.val);
                for (Node item : node.neighbors) {
                    queue.offer(item);
                }
            }
            result.add(innerList);
        }
        return result;
    }

    private void preOrderTraversalRec(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }
        Node main = root;
        result.add(main.id);
        System.out.print(main.id + " ");
        if (main.neighbors != null) {
            for (int i = 0; i < main.neighbors.size(); i++) {
                preOrderTraversalRec(main.neighbors.get(i), result);
            }
        }
    }

}
