package com.company.graphs;

import java.util.ArrayList;

public class DepthFirstSearch {
    ArrayList<ArrayList<Integer>> graph;


    int vertices, current;

    public void graphCreation(int vertices) {
        this.vertices = vertices;
        graph = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }
    }

    public void addEdges(int x, int y) {
        graph.get(x).add(y);
        graph.get(y).add(x);
    }

    public void callingDFS(int source, boolean visited[]) {
        ArrayList<Integer> adjacentNodes = graph.get(source);
        visited[source] = true;
        // System.out.println(source + " ");
       // System.out.println(source + " " + adjacentNodes.size() + " " + Arrays.toString(visited));
        for (int i = 0; i < adjacentNodes.size(); i++) {
            current = adjacentNodes.get(i);
                if (!visited[current]) {
                    visited[current] = true;
                    callingDFS(current, visited);
            }
        }
        System.out.println(source);
    }
    public void DFS(int source) {
        boolean visited[] = new boolean[vertices];
        callingDFS(source, visited);

    }

    public static void main(String args[]) {
        DepthFirstSearch graph = new DepthFirstSearch();
        graph.graphCreation(8);
        graph.addEdges(1, 2);
        graph.addEdges(1, 3);
        graph.addEdges(2, 4);
        graph.addEdges(2, 5);
        graph.addEdges(3 ,6);
        graph.addEdges(3, 7);
        graph.DFS(1);


    }


}
