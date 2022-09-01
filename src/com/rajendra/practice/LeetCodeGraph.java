package com.rajendra.practice;


import com.rajendra.collection.Graph;

/**
 * Created by Rajendra Verma on 31/08/22.
 */
public class LeetCodeGraph {
//    https://leetcode.com/problems/find-if-path-exists-in-graph/
    //    easy problem
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Graph graph = new Graph(n);
        graph.build(edges);
        graph.setType(Graph.BI_DIRECTIONAL);
        return graph.isValidGraph(source, destination);

    }


//    https://leetcode.com/problems/find-the-town-judge/
    //easy problem
    public int findJudge(int n, int[][] trust) {
        Graph graph = new Graph(n);
        graph.build(trust);
        int judge = graph.vertexNoSelfEdges();
        return judge;

    }


    public static void main(String[] args) {
        LeetCodeGraph d = new LeetCodeGraph();
        int[][] truest = {{1, 2}, {5, 1}, {1, 3}, {1, 4}};
        System.out.println("Node centre  = " + d.findCenter(truest));
    }

//    https://leetcode.com/problems/find-center-of-star-graph/
    // easy
    private int findCenter(int[][] truest) {
        Graph graph = new Graph(truest.length);
        graph.build(truest);
        return graph.findCentre();
    }
}
