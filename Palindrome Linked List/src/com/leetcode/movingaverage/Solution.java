package com.leetcode.movingaverage;

import com.thylovezj.queue.ArrayQueue;
import com.thylovezj.queue.Queue;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    private Deque<Integer> queue;
    private int capacity;
    private int sum;

    /**
     * Initialize your data structure here.
     */

    public Solution(int size) {
        queue = new LinkedList<>();
        capacity = size;
        sum = 0;
    }

    public double next(int val) {
        queue.offer(val);
        sum += val;
        if (queue.size() > capacity) {
            sum -= queue.poll();

        }
        return sum / queue.size();
    }
}
