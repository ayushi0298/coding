package com.company.graphs;

import javax.crypto.spec.PSource;
import java.util.ArrayList;
import java.util.Collections;

public class UnionAndFindImplementation {
    ArrayList<Integer> parent;


    public UnionAndFindImplementation(int n) {
        parent = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            parent.add(i);
        }
    }

    int find(int key) {
        if (parent.get(key) == key) {
            return key;
        } else {
            int result = find(parent.get(key));
            //parent.add(key, result);
            // int index = parent.indexOf(key);
            //parent.set(index, result);//here i was going wrong as multiple times that key may be present. ex: 2,3,3
            parent.set(key, result);
            return result;
        }
    }

    void union(int value1, int value2) {
        int value1Parent = find(value1);
        int value2Parent = find(value2);
        parent.set(value1Parent, value2Parent);
    }

    public static void main(String args[]) {
        int n = 4;
        UnionAndFindImplementation input = new UnionAndFindImplementation(n);
        input.union(1, 2);
        input.union(2, 3);
        if (input.find(1) == input.find(3)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
