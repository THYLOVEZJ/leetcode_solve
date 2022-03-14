package com.leetcode.subarraySum;

import java.util.HashMap;

public class Solution {
    /**
     * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回该数组中和为 k 的连续子数组的个数。
     *
     * @param nums 给的整数数组
     * @param k    和为k
     * @return
     */
    public static int subarraySum(int[] nums, int k) {
        //首先判断该题能不能用双指针，由于没有说该数组是否全部为正数，因此不能采用双指针进行求解
        //该题思路为前缀和数组+HashMap
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }

        for (int i = 0; i < sum.length; i++) {
            for (int j = i + 1; j < sum.length; j++) {
                if (sum[j] - sum[i] == k) {
                    res = res + 1;
                }
            }
        }
        return res;
    }

    public static int subarraySumII(int[] nums, int k) {
        //利用一个HashMap记录出现过的前缀和和频率
        HashMap<Integer, Integer> preSum = new HashMap<>();
        //base case
        preSum.put(0,1);
        int sum = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            sum +=nums[i];
            //计算sum-k在HashMap是否存在，如果存在则说明
            if (preSum.containsKey(sum-k)){
                ans += preSum.get(sum-k);
            }
            //将sum放入前缀和HashMap中
            preSum.put(sum,preSum.getOrDefault(sum,0)+1);
        }
        return ans;
    }
}
