package com.leetcode.canjump;

public class Solution {
    public boolean canJump(int[] nums) {
        int maxJump = 0;
        for (int i = 0; i < nums.length-1; i++) {
            //能跳到的最大距离为
            maxJump = Math.max(maxJump, i + nums[i]);
            if (maxJump <= i+1)return false;
        }

        return maxJump>nums.length-1;
    }
}
