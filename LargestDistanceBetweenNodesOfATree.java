package com.company.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LargestDistanceBetweenNodesOfATree {
    ArrayList<ArrayList<Integer>> graph;
    HashMap<Integer, Integer> storeMaxDistance = new HashMap<>();
    int vertices, current;
    boolean visited[];
    public void graphCreation(ArrayList<Integer> passingArrayList ) {
        this.vertices = passingArrayList.size();
        graph = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }
        for(int j=0;j<passingArrayList.size();j++){
            if(passingArrayList.get(j)!=-1){
                addEdges(j,passingArrayList.get(j));
            }
        }
    }
    public void addEdges(int x, int y) {
        graph.get(x).add(y);
        graph.get(y).add(x);
    }
    public void DFS(int source, boolean visited[]) {
        ArrayList<Integer> adjacentNodes = graph.get(source);
        //storeMaxDistance.put(source, 0);
        int sourceDistance = storeMaxDistance.get(source);
        for (int i = 0; i < adjacentNodes.size(); i++) {
            current = adjacentNodes.get(i);
            if (!visited[current]) {
                storeMaxDistance.put(current, sourceDistance + 1);
                visited[current] = true;
                System.out.println(current + " " + (sourceDistance+1));
                DFS(current, visited);
            }
        }
    }
    public int maxDistance(int source) {
        storeMaxDistance.put(source, 0);
        boolean visited[] = new boolean[vertices];
        visited[source] = true;
        DFS(source,visited);
        int key = Collections.max(storeMaxDistance.entrySet(), Map.Entry.comparingByValue()).getKey();
        storeMaxDistance.clear();
        boolean visited1[] = new boolean[vertices];
        visited1[key] = true;
        //System.out.println(key);
        storeMaxDistance.put(key,0);
        DFS(key , visited1);
        return Collections.max(storeMaxDistance.values());
    }
    public static void main(String args[]) {
        LargestDistanceBetweenNodesOfATree graph = new LargestDistanceBetweenNodesOfATree();
        ArrayList<Integer> passingArrayList = new ArrayList<>();
        passingArrayList.add(-1);
        passingArrayList.add(0);
        /*passingArrayList.add(0);
        passingArrayList.add(0);
        passingArrayList.add(3);*/
        graph.graphCreation(passingArrayList);
        //System.out.println( graph.maxDistance(0));
    }

}
