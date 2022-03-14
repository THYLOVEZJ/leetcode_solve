package com.leetcode.LongestIncreasingSubsequence;

import java.util.Arrays;

class Solution {
    public int lengthOfLIS(int[] nums) {
        //声明一个dp数组，用来存储第i个数组的最长子序列数
        int[] dp = new int[nums.length];
        //每个数组的最短子序列就是自己，即为1
        Arrays.fill(dp,1);
        int ans = 0;
        for (int i=0;i<nums.length;i++){
            for (int j=0;j<i;j++){
                if (nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }

        }
        for (int i=0;i<dp.length;i++)
            ans = Math.max(dp[i],ans);
        return ans;
    }
}