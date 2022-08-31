package com.rajendra.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;
import java.util.Vector;

/**
 * Created by Rajendra Verma on 30/08/22.
 */
public class Graph {
    private Map<Integer, LinkedList<Integer>> map = new HashMap<>();

    public void addVertex(int s) {
        map.put(s, new LinkedList());
    }

//  Adding of edge or connection

/*
 we have only the provision to add the  connection not node, when we are adding the connection we have total of three cases
 cases :
 1. source does not exist
 2. destination does not exist
 3. both are existing just you have to establish the connection
 4. if  the connection is bi-directional than make the connection voice versa
*/


    public void addEdge(int s, int d) {
        addEdge(s, d, false);
    }

    public void addEdge(int source, int destination, boolean bidirectional) {
//        source Node/vertex does not exist
        if (!map.containsKey(source))
            addVertex(source);
//destination Node/vertex does not exist
        if (!map.containsKey(destination))
            addVertex(destination);
//  both the nodes exist just you have to connect
        map.get(source).add(destination);
//         you  havve to connet both the ways
        if (bidirectional == true) {
            map.get(destination).add(source);
        }
    }

    // get the number of connection
    public int getVertexCount() {

        return map.keySet().size();
    }

    public int getEdgesCount(boolean bidirection) {
        int count = 0;
        for (int v : map.keySet()) {
            count += map.get(v).size();
        }
        if (bidirection == true) {
            count = count / 2;
        }
        return count;
    }

    public boolean hasVertex(int s) {

        return map.containsKey(s);
    }

    // total number of connection
    public boolean hasEdge(int s, int d) {
        return map.get(s).contains(d);

    }


    /*
 Breath first search traversal

 1. Visiting a vertex
 2. Exploring the vertex
 3. Mark the visited vertex

Visiting of the vertex
Going to the particular node/vertex, like we are going to visit relatives,friends or going to date someone.

Exploring the vertex
While going to date a girl, explore other  girls to date to the same place for the next time.

Marked the visited vertex
Date a girl once in a life.

Collection used
1. array
2. queue.

Strategy

Iterative

BFS common with tree
1. it is level traversal order of the binary tee


 * */


    void bfsTraversal(int s) {
        int v = map.keySet().size();
        boolean visited[] = new boolean[v];

        LinkedList<Integer> queue = new LinkedList<Integer>();

        visited[s] = true;
        queue.add(s);
        while (queue.size() != 0) {
            s = queue.poll();
            System.out.print(s + "->");
            Iterator<Integer> i = map.get(s).listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

/*
Depth First Search Traversal
 1. Visiting a vertex
 2. Exploring the vertex
 3. Mark the visited vertex

 Visiting a vertex and exploring a vertex

 suppose you have to date three girls a day, in three different location, date first girl at location (A), date second girl at location (B), date third girl at location (C)
 when you have completed dating all the girls and going to home, explore all the girl opportunity at location C,B,A.

Marked the visited vertex
Date a girl once in a life.

Collection

1. stack

Strategy

1. Recursive

Default  stack  when calling recursive function

2. Iterative

same as queue in BFS  we used stack


Common with tree
It is a same as pre-order traversal


Complexity Analysis:

Time complexity: O(V + E), where V is the number of vertices and E is the number of edges in the graph.
Space Complexity: O(V), since an extra visited array of size V is required.
 */

    public void dfsTraversal(int s) {
        int v = map.keySet().size();

        boolean[] visited = new boolean[v];
        dfsTraversalRec(s, visited);
    }

   /* Recursive
    default  stack  when calling recursive function*/

    private void dfsTraversalRec(int s, boolean[] visited) {
        visited[s] = true;
        System.out.print(s + "->");

        // Recur for all the vertices adjacent to this
        // vertex
        Iterator<Integer> i = map.get(s).listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                dfsTraversalRec(n, visited);
        }
    }

    void dfsTraversalIterative(int s) {
        int v = map.keySet().size();
        Vector<Boolean> visited = new Vector<Boolean>(v);
//        mark all the visiter false by default
        for (int i = 0; i < v; i++)
            visited.add(false);

        Stack<Integer> stack = new Stack<>();
        stack.push(s);
        while (stack.empty() == false) {
            s = stack.peek();
            stack.pop();
            if (visited.get(s) == false) {
                System.out.print(s + " ");
                visited.set(s, true);
            }
            Iterator<Integer> i = map.get(s).listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited.get(n))
                    stack.push(n);
            }

        }
    }

    public void printAdjecent() {
        StringBuilder builder = new StringBuilder();

        for (int v : map.keySet()) {
            builder.append(v + ": ");
            for (int w : map.get(v)) {
                builder.append(w + " ");
            }
            builder.append("\n");
        }
        System.out.println(builder);

    }


    public static void main(String args[]) {

//        directed graph
        Graph g = new Graph();
        g.addEdge(1, 0, true);
        g.addEdge(2, 1, true);
        g.addEdge(3, 4, true);
        g.addEdge(4, 0, true);
//        if the all nodes/vertices is bidirectional than it is number of egdes will be double
        System.out.println("Number of Edges " + g.getEdgesCount(true));
        System.out.println("Number of nodes(Vertex) " + g.getVertexCount());
        System.out.println("BFS traversal ");
        g.bfsTraversal(0);


    }


}

