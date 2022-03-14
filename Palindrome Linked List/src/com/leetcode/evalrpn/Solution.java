package com.leetcode.evalrpn;

import java.util.Stack;

public class Solution {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+":
                case "-":
                case "*":
                case "/":
                    int m = stack.pop();
                    int n = stack.pop();
                    stack.push(Calculate(token, n, m));
                    break;
                default:
                    stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public static int Calculate(String op, int m, int n) {
        switch (op) {
            case "+":
                return m + n;
            case "-":
                return m - n;
            case "*":
                return m * n;
            case "/":
                return m / n;

            default:
                return 0;
        }
    }
}
