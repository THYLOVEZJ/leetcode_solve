package com.leetcode.evalrpn;

public class testEvalRPN {
    public static void main(String[] args) {
        String[] token = new String[]{"2", "1", "+", "3", "*"};
        int res = Solution.evalRPN(token);
        System.out.println(res);
    }
}
