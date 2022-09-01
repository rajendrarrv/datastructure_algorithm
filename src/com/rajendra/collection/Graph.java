package com.rajendra.collection;

import com.rajendra.model.Node;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

/*
 * 1. adjest and vertices
 * 2. degree
 * 3. path
 * 4. connected graph
 * 5. connected component
 *  */

public class Graph {

    public static final int BI_DIRECTIONAL = 12;
    public HashMap<Integer, Node> nodeLookup = new HashMap<>();


    public int v;
    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Graph(int v) {
        this.v = v;
        for (int i = 1; i <= v; i++) {
            nodeLookup.put(i, new Node(i));
        }
    }


    public void build(int[][] matrix) {
        int col = matrix.length;
        for (int i = 0; i < col; i++) {
            int s = matrix[i][0];
            int d = matrix[i][1];
            addEdge(s, d);
        }


    }


    Node getNode(Integer id) {
        if (nodeLookup.containsKey(id))
            return nodeLookup.get(id);
        else {
            Node newNode = new Node(id);
            nodeLookup.put(id, newNode);
            return newNode;
        }
    }


    public int edgesSize() {
        int sum = 0;
        for (Map.Entry<Integer, Node> entry : nodeLookup.entrySet()) {
            sum += entry.getValue().neighbors.size();
        }
        return sum / 2;

    }


    public boolean hasVertex(int s) {
        return nodeLookup.getOrDefault(s, null) != null;
    }

    public int vertexNoSelfEdges() {
        Iterator hmIterator = nodeLookup.entrySet().iterator();

        while (hmIterator.hasNext()) {

            Map.Entry mapElement
                    = (Map.Entry) hmIterator.next();
            Node d = ((Node) mapElement.getValue());

            if (d.neighbors.size() == 0) {
                return d.id;
            }
        }
        return -1;
    }

    public boolean hasEdge(int source, int destination) {
        Node s = getNode(source);
        Node d = getNode(destination);
        return s != null && d != null;
    }

    public int verticesSize() {
        return nodeLookup.size();
    }


    void addEdge(int source, int dest) {
        Node s = getNode(source);
        Node d = getNode(dest);
        d.inDegree();
        s.inDegree();
        s.neighbors.add(d);
        switch (type) {
            case BI_DIRECTIONAL:
                d.neighbors.add(s);
                break;
        }
    }

    public void bfsTraversal(int source) {
        boolean visited[] = new boolean[v];
        LinkedList<Node> queue = new LinkedList<>();
        visited[source] = true;
        queue.add(getNode(source));
        while (!queue.isEmpty()) {
            Node disPlayNode = queue.poll();
            System.out.print(disPlayNode.id + "->");
            Iterator<Node> i = disPlayNode.neighbors.listIterator();
            while (i.hasNext()) {
                Node next = i.next();
                if (!visited[next.id]) {
                    visited[next.id] = true;
                    queue.add(next);
                }
            }
        }

    }


    void dfsTraversalRec(int v, boolean visited[]) {
        visited[v] = true;
        System.out.print(v + " ");

        Node source = getNode(v);
        Iterator<Node> i = source.neighbors.listIterator();
        while (i.hasNext()) {
            Node n = i.next();
            if (!visited[n.id])
                dfsTraversalRec(n.id, visited);
        }
    }

    void dfsTraversalIter(int s, boolean[] visited) {

        boolean nodes[] = new boolean[v];

        Node sourceNode = getNode(s);
        Stack<Node> stack = new Stack<>();

        stack.push(sourceNode);                                    //push root node to the stack

        while (!stack.empty()) {
            Node rootNode = stack.peek();
            stack.pop();

            if (nodes[s] == false) {
                System.out.print(rootNode.id + " ");
                nodes[rootNode.id] = true;
            }

            for (int i = 0; i < rootNode.neighbors.size(); i++)  //iterate through the linked list and then propagate to the next few nodes
            {
                Node a = rootNode.neighbors.get(i);
                if (!nodes[a.id])                    //only push those nodes to the stack which aren't in it already
                {
                    stack.push(a);                          //push the top element to the stack
                }
            }

        }
    }


    public boolean isValidGraph(int source, int destination) {
        if (source > v || destination > v) return false;
        LinkedList<Node> temp;
        boolean visited[] = new boolean[v];
        LinkedList<Node> queue = new LinkedList<Node>();
        visited[source] = true;
        queue.add(getNode(source));
        Iterator<Node> i;
        while (queue.size() != 0) {
            Node disPlayNode = queue.poll();

            int n;
            i = disPlayNode.neighbors.listIterator();
            while (i.hasNext()) {
                Node nextNode = i.next();
                if (nextNode.id == destination)
                    return true;

                if (!visited[nextNode.id]) {
                    visited[nextNode.id] = true;
                    queue.add(nextNode);
                }
            }
        }
        return false;


    }


    public int findCentre() {
        Iterator hmIterator = nodeLookup.entrySet().iterator();

        while (hmIterator.hasNext()) {

            Map.Entry mapElement
                    = (Map.Entry) hmIterator.next();
            Node d = ((Node) mapElement.getValue());

            int centreNode = nodeLookup.size() - 1;
            if (d.inDegree == centreNode)
                return (int) mapElement.getKey();

        }
        return -1;
    }
}
