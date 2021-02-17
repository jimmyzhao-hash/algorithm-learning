package com.jimmy;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MaxHeap {

    //By default priority queue of Java is a minheap. Therefore use lambda expression to make it a max heap.
    //A max heap has the biggest number on top.
    public PriorityQueue<Integer> maxHeap = new PriorityQueue<>(((o1, o2) -> o2-o1));

    public ArrayList<Integer> GetKthNumber(int [] nums, int k){
        for(int num : nums){
            maxHeap.add(num);
            if (maxHeap.size() > k)
                maxHeap.poll();
        }
        return new ArrayList<>(maxHeap);
    }
}
