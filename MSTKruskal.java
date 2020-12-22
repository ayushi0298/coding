package com.company.graphs;

import javax.crypto.spec.PSource;
import java.util.ArrayList;
import java.util.Collections;
//https://www.hackerearth.com/practice/algorithms/graphs/minimum-spanning-tree/tutorial/
public class MSTKruskal {
    ArrayList<Integer> parent;
    ArrayList<Edge> edgesArraylist;
    int vertices, edges;
    //constructor for 2 arraylists. one for filling parent and second for arraylist which is storing edges
    public MSTKruskal(int n) {
        edgesArraylist = new ArrayList<>();
        parent = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            parent.add(i);
        }
    }
    //This class is for making edges as they contains source node, destination and wight of that edge.
    public static class Edge implements Comparable<Edge> {

        int source;
        int destination;
        int weight;

        //constructor for the edges
        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

        public int compareTo(Edge compareEdge)
        {
            return this.weight - compareEdge.weight;
        }
    }

    public void addEdge(int source, int destination, int weight) {
        Edge edge = new Edge(source,destination,weight);
        edgesArraylist.add(edge);
    }

    //this function is to the root of a node
    int find(int key) {
        //here if index and element are same
        if (parent.get(key) == key) {
            return key;
            //when they are not same
        } else {
            int result = find(parent.get(key));
            //parent.add(key, result);
            // int index = parent.indexOf(key);
            //parent.set(index, result);//here i was going wrong as multiple times that key may be present. ex: 2,3,3
            parent.set(key, result);//recursive call on the element whose index and element are still not the same
            return result;
        }
    }
    //This function is for checking the sets of the nodes passed in the argument
    void union(int value1, int value2) {
        int value1Parent = find(value1);
        int value2Parent = find(value2);
        parent.set(value1Parent, value2Parent);
    }
    //to print the graph
    public void printGraph(ArrayList<Edge> input) {
        for (int i = 0; i < input.size(); i++) {
            Edge edge = input.get(i);
            System.out.println("Edge: " + i + " "+ "source: " + edge.source + " " + "destination: " + edge.destination +  " " +"weight: " + edge.weight);
        }
    }
    //main kruskal algorithm to find minimum edge and add it into the resultant arraylist.
    public int kruskal() {
        ArrayList<Edge> result = new ArrayList<>();
        int sum=0;
        Collections.sort(edgesArraylist);
        for (int j = 0; j < edgesArraylist.size(); j++) {
            Edge curEdge = edgesArraylist.get(j);
            //This is to add only those edges whose sets are not same. we will ignore edges whose connecting nodes belongs to same sets.
            if(find(curEdge.source) != find(curEdge.destination)){
                result.add(curEdge);
                parent.set(curEdge.source, curEdge.destination);
                sum = sum + curEdge.weight;
            }
        }
        printGraph(result);
        return sum;
    }
    //main function
    public static void main(String args[]) {
        int n = 4;
        MSTKruskal mst = new MSTKruskal(n);
        mst.addEdge(0,1,9);
        mst.addEdge(1,2,15);
        mst.addEdge(2,1,18);
        System.out.println(mst.kruskal());
    }
}
