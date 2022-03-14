package com.leetcode.nextgreaterelement;

import java.util.Stack;

public class Solution {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums1.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = -1;
        }
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums2[j] == nums1[i]) {
                    stack.push(i);
                }
                if (!stack.empty() && nums2[j] > nums1[stack.peek()]) {
                    res[i] = nums2[j];
                    break;
                }
            }
            stack.pop();
        }
        return res;
    }
}
