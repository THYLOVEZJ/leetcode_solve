package com.leetcode.cqueue;

import java.util.Stack;

public class CQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (!stack2.empty()){
            return stack2.pop();
        }
        while(!stack1.empty()){
            stack1.push(stack2.pop());
        }
        return stack2.pop();
    }
}
