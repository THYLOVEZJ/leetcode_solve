package com.leetcode.robII;

public class Solution {
    public int rob(int[] nums) {
        int[] dp1 = new int[nums.length ];
        int[] dp2 = new int[nums.length ];
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0], nums[1]);
        dp2[1] = nums[1];
        dp2[2] = Math.max(nums[1], nums[2]);
        for (int i = 2; i < nums.length - 1; i++) {
            dp1[i] = Math.max(nums[i] + dp1[i - 2], dp1[i - 1]);
        }
        for (int j = 3; j < nums.length; j++) {
            dp2[j] = Math.max(nums[j] + dp2[j - 2], dp2[j - 1]);
        }
        return dp1[nums.length - 2] > dp2[nums.length - 1] ? dp1[nums.length - 2] : dp2[nums.length - 1];
    }
}
