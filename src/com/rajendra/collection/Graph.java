package com.rajendra.collection;

import com.rajendra.model.Node;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
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
    public HashMap<Integer, Node> verticesMap = new HashMap<>();


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
//        Collection of Non Connected Vertices
        for (int i = 0; i < v; i++) {
            verticesMap.put(i, new Node(i));
        }
    }

    // establishing the connection in between two  vertices, called source and destination
    public void build(int[][] matrix) {
        int col = matrix.length;
        for (int i = 0; i < col; i++) {
            int s = matrix[i][0];
            int d = matrix[i][1];
            addEdge(s, d);
        }


    }


    Node getNode(Integer id) {
        if (verticesMap.containsKey(id))
            return verticesMap.get(id);
        else {
            Node newNode = new Node(id);
            verticesMap.put(id, newNode);
            return newNode;
        }
    }

    // total number of connection
    public int edgesSize() {
        int sum = 0;
        for (Map.Entry<Integer, Node> entry : verticesMap.entrySet()) {
            sum += entry.getValue().neighbors.size();
        }
        return sum / 2;

    }


    public boolean hasVertex(int s) {
        return verticesMap.getOrDefault(s, null) != null;
    }

    //  Vertices which don't have any connection
    public int vertexNoSelfEdges() {
        Iterator hmIterator = verticesMap.entrySet().iterator();

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

    // no degree and maximum indegree
    public int trust() {
        Iterator hmIterator = verticesMap.entrySet().iterator();

        while (hmIterator.hasNext()) {

            Map.Entry mapElement
                    = (Map.Entry) hmIterator.next();
            Node d = ((Node) mapElement.getValue());

            int inDegree = d.inDegree;
            if (d.neighbors.size() == 0 && inDegree == v - 1) {


                return d.id;
            }
        }
        return -1;
    }

    // has connection in between source and destination
    public boolean hasEdge(int source, int destination) {
        Node s = getNode(source);
        Node d = getNode(destination);
        return s != null && d != null;
    }

    public int verticesSize() {
        return verticesMap.size();
    }


    void addEdge(int source, int dest) {
        Node s = getNode(source);
        Node d = getNode(dest);
        d.inDegree();
        s.neighbors.add(d);
        switch (type) {
            case BI_DIRECTIONAL:
                d.neighbors.add(s);
                break;
        }
    }

    public void bfsTraversal(int source) {
        Map<Integer, Boolean> visited = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        visited.put(source, true);

        queue.add(getNode(source));
        while (!queue.isEmpty()) {
            Node disPlayNode = queue.poll();
//            visting of node
            System.out.print(disPlayNode.id + "->");
            Iterator<Node> i = disPlayNode.neighbors.listIterator();
            while (i.hasNext()) {
                Node next = i.next();
//                exploring of node
                if (!visited.getOrDefault(next.id, false)) {
                    visited.put(next.id, true);
                    queue.add(next);
                }
            }
        }

    }


    public void bfsTraversal(Node source) {


        Map<Integer, Boolean> visited = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        visited.put(source.id, true);
        queue.add(source);
        while (!queue.isEmpty()) {
            Node disPlayNode = queue.poll();
//            Visiting a Vertex
            System.out.print(disPlayNode.id + "->");
            Iterator<Node> i = disPlayNode.neighbors.listIterator();
            while (i.hasNext()) {
                Node next = i.next();
                if (!visited.getOrDefault(next.id, false)) {
//                    Exploring the other vertices
                    visited.put(next.id, true);
                    queue.add(next);
                }
            }
        }

    }


    void dfsTraversalRec(int s, Map<Integer, Boolean> visited) {
        visited.put(s, true);
//        Visiting of node
        System.out.print(s + " ");

        Node source = getNode(s);
        Iterator<Node> i = source.neighbors.listIterator();
        while (i.hasNext()) {
            Node n = i.next();
//            Exploration of node
            if (!visited.getOrDefault(n.id, false))
                dfsTraversalRec(n.id, visited);
        }
    }

    void dfsTraversalIter(int s) {

        boolean nodes[] = new boolean[v];
        Node sourceNode = getNode(s);
        Stack<Node> stack = new Stack<>();
        stack.push(sourceNode);
        while (!stack.empty()) {
            Node rootNode = stack.peek();
            stack.pop();
            if (nodes[s] == false) {
//            visiting of Vertex
                System.out.print(rootNode.id + " ");
                nodes[rootNode.id] = true;
            }
            for (int i = 0; i < rootNode.neighbors.size(); i++) {
//                exploration of Vertex
                Node a = rootNode.neighbors.get(i);
                if (!nodes[a.id]) {
                    stack.push(a);
                }
            }

        }
    }


    public boolean isValidGraph(int source, int destination) {
        if (source > v || destination > v) return false;
        boolean visiterMarker[] = new boolean[v];
        LinkedList<Node> queue = new LinkedList<Node>();
        visiterMarker[source] = true;
        queue.add(getNode(source));
        while (queue.size() != 0) {
            Node disPlayNode = queue.poll();
//Visiter
            Iterator<Node> i = disPlayNode.neighbors.listIterator();
            while (i.hasNext()) {
//                Exploration
                Node nextNode = i.next();
                if (nextNode.id == destination)
                    return true;

                if (!visiterMarker[nextNode.id]) {
                    visiterMarker[nextNode.id] = true;
                    queue.add(nextNode);
                }
            }
        }
        return false;


    }


    public int findCentre() {
        Iterator hmIterator = verticesMap.entrySet().iterator();

        while (hmIterator.hasNext()) {

            Map.Entry mapElement
                    = (Map.Entry) hmIterator.next();
            Node d = ((Node) mapElement.getValue());

            int centreNode = verticesMap.size() - 1;
//
            if (d.inDegree == centreNode)
                return (int) mapElement.getKey();

        }


        return -1;
    }

    public Node cloneGraph(int s) {
        Node source = getNode(s);
        Queue<Node> q = new LinkedList<Node>();
        q.add(source);

        HashMap<Node, Node> hm =
                new HashMap<Node, Node>();

        //Put the source node into the HashMap
        hm.put(source, new Node(source.id));

        while (!q.isEmpty()) {
            Node u = q.poll();

//            visiting the vertex
            Node outerClone = hm.get(u);
            if (u.neighbors != null) {
                List<Node> v = u.neighbors;
                for (Node graphNode : v) {

//                    exploring the vertex
                    Node innerClone = hm.get(graphNode);

                    if (innerClone == null) {
                        q.add(graphNode);
                        innerClone = new Node(graphNode.id);
                        hm.put(graphNode, innerClone);
                    }

                    outerClone.neighbors.add(innerClone);
                }
            }
        }

        return hm.get(source);
    }

    public boolean isCyclic(int s) {

        boolean nodes[] = new boolean[v];

        Node sourceNode = getNode(s);
        Stack<Node> stack = new Stack<>();

        stack.push(sourceNode);                                    //push root node to the stack

        while (!stack.empty()) {
            Node rootNode = stack.peek();
            stack.pop();
//vister
            if (!nodes[rootNode.id]) {
                nodes[rootNode.id] = true;
            }

            for (int i = 0; i < rootNode.neighbors.size(); i++) {
                Node nextNode = rootNode.neighbors.get(i);
                if (!nodes[nextNode.id]) {
                    stack.push(nextNode);
                }
// exploration
                if (!nextNode.neighbors.isEmpty() && nextNode.neighbors.get(0).id == rootNode.id)
                    return true;
            }

        }
        return false;
    }

    public void dfsTraversal(int s) {
        Map<Integer, Boolean> visiter = new HashMap<>();
        dfsTraversalRec(s, visiter);
    }

    public static void main(String[] args) {
        Graph graph  = new Graph(4);
        graph.setType(Graph.BI_DIRECTIONAL);
        int [][] data  = {{0,1},{1,3},{2,3},{2,0}};
        graph.build(data);
        graph.bfsTraversal(0);
    }
}
