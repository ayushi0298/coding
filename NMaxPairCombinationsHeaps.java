package com.company.heaps;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
//https://www.interviewbit.com/problems/n-max-pair-combinations/
public class NMaxPairCombinationsHeaps {
    public static void maxSum(ArrayList<Integer> first, ArrayList<Integer> second) {
        int key= first.size();
        Collections.sort(first);
        Collections.sort(second);
        PriorityQueue<PairSum> storeSumAndPair = new PriorityQueue<>();
        //System.out.println(storeSumAndPair.size());
        HashSet<Pair> storePair = new HashSet<>();
        int lastOfFirstList = first.size()-1;
        int lastOfSecondList = second.size()-1;
        storeSumAndPair.add(new PairSum(first.get(lastOfFirstList)+ second.get(lastOfSecondList), lastOfFirstList,lastOfSecondList));
        //System.out.println(storeSumAndPair.size());
        storePair.add(new Pair(lastOfFirstList,lastOfSecondList));
        for (int i = 0; i < key ;i++) {
            //System.out.println(storeSumAndPair.size());
            PairSum maximumSum = storeSumAndPair.poll();
            System.out.println(maximumSum.sum);
            //System.out.println(maximumSum + " " +storeSumAndPair.size());
            lastOfFirstList = maximumSum.l - 1;
            //System.out.println(lastOfFirstList);
            lastOfSecondList = maximumSum.m;
            if (lastOfFirstList >= 0 && lastOfSecondList >= 0 && !storePair.contains(new Pair(lastOfFirstList, lastOfSecondList))) {
                storeSumAndPair.add(new PairSum(first.get(lastOfFirstList) + second.get(lastOfSecondList), lastOfFirstList, lastOfSecondList));
                storePair.add(new Pair(lastOfFirstList, lastOfSecondList));
            }
            lastOfFirstList = maximumSum.l;
            lastOfSecondList = maximumSum.m - 1;
            if (lastOfFirstList >= 0 && lastOfSecondList >=0 && !storePair.contains(new Pair(lastOfFirstList, lastOfSecondList))) {
                storeSumAndPair.add(new PairSum(first.get(lastOfFirstList) + second.get(lastOfSecondList), lastOfFirstList, lastOfSecondList));
                storePair.add(new Pair(lastOfFirstList, lastOfSecondList));
            }
        }
    }
    public static class PairSum
            implements Comparable<PairSum> {

        public PairSum(int sum, int l, int m) {
            this.sum = sum;
            this.l = l;
            this.m = m;
        }
        int sum;
        int l;
        int m;

        @Override
        public int compareTo(PairSum o) {
            return Integer.compare(o.sum, sum);
        }
    }
    public static void main(String args[]) {
       /* Pair<Integer, Pair<Integer,Integer>> x= new Pair<>(10, new Pair<>(1,2));
        Pair<Integer, Pair<Integer,Integer>> y= new Pair<>(12, new Pair<>(1,2));
        PriorityQueue<Pair<Integer, Pair<Integer,Integer>>> pq = new PriorityQueue<>();
        pq.add(x);
        pq.add(y);
        System.out.println(pq.peek());*/
        ArrayList<Integer> first = new ArrayList<>();
        ArrayList<Integer> second = new ArrayList<>();
        first.add(1);
        first.add(2);
        second.add(3);
        second.add(4);
        maxSum(first,second);

    }
}
