package com.leetcode.nextgreaterelementsII;

import java.util.Stack;

public class Solution {
    public static int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length * 2; i++) {
            //这里的num是要放置的第几个元素的下标
            int num = nums[i % nums.length];
            //放置要寻找比其大的元素的下标
            while (!stack.empty() && num > nums[stack.peek()]) {
                res[stack.pop()] = num;
            }
            if (i<nums.length){
                stack.push(i);
            }
        }
        return res;
    }
}
