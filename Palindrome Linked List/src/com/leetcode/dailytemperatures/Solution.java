package com.leetcode.dailytemperatures;

import java.util.Stack;

public class Solution {
    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            //说明栈不为空，且栈顶元素小于当前日温度
            while (!stack.empty() && temperatures[stack.peek()] < temperatures[i]) {
                //栈顶元素出栈，且记录栈顶元素的最近升温日
                int num = 0;
                num = stack.pop();
                res[num] = i - num;
            }
            stack.push(i);
        }
        return res;
    }
}
