package com.rajendra.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Rajendra Verma on 31/08/22.
 */
public class Node {
    public int val;
    public int id;
    public int inDegree = 0;
    public List<Node> neighbors;
    public boolean visited;

    public void inDegree() {
        inDegree++;
    }


    public Node() {
        val = 0;
        neighbors = new LinkedList<>();
    }

    public Node(int id) {
        this.id = id;
        neighbors = new ArrayList<Node>();
    }

    public Node(int id, ArrayList<Node> _neighbors) {
        this.id = id;
        neighbors = _neighbors;
    }
}
