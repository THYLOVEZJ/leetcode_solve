package com.leetcode.getMaxLen;

public class Solution {
    public int getMaxLen(int[] nums) {
        if (nums.length == 1) return 1;
        int[] positive = new int[nums.length];
        int[] negative = new int[nums.length];
        positive[0] = nums[0] > 0 ? 1 : 0;
        negative[0] = nums[0] < 0 ? 1 : 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                positive[i] = positive[i - 1] + 1;
                negative[i] = negative[i - 1] > 0 ? negative[i - 1] + 1 : 0;
            } else if (nums[i] < 0) {
                positive[i] = negative[i - 1] > 0 ? negative[i - 1] + 1 : 0;
                negative[i] = negative[i - 1] + 1;
            } else {
                //nums[i]==0
                positive[i] = 0;
                negative[i] = 0;
            }
        }
        int res = 0;
        for (int i : positive) {
            res = Math.max(res, i);
        }
        return res;
    }
}
