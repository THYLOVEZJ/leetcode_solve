package com.leetcode.minAddToMakeValid;


import java.util.Stack;

public class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        char[] arr = s.toCharArray();
        int count = 0;
        for (char c : arr) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                    count++;
                } else {
                    stack.push(c);
                }
            }
        }
        return arr.length - count * 2;
    }
}
