package com.leetcode.asteroidcollision;


import java.util.Stack;

public class Solution {
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int as : asteroids) {
            //这里记得empty要放到第一位，否则会报错，因为当栈为空时，peek会报错。
            while (!stack.empty() && stack.peek() > 0 && -as > stack.peek()) {
                stack.pop();
            }

            if (as < 0 && !stack.empty() && stack.peek() == -as) {
                stack.pop();
            } else if (stack.empty() || as > 0 || stack.peek() < 0) {
                stack.push(as);
            }
        }

        //该方法能将stack转换为Array
        return stack.stream().mapToInt(i -> i).toArray();
    }
}
