package com.leetcode.maxProduct;

public class Solution {
    public int maxProduct(int[] nums) {
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        max[0] = nums[0];
        min[0] = nums[0];
        int maxVal = 0;
        int minVal = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                //如果小于0，那么前面最大的max乘nums[i]既是最小值
                int temp = maxVal;
                maxVal = minVal;
                minVal = temp;
            }
            max[i] = Math.max(maxVal * nums[i], nums[i]);
            min[i] = Math.min(minVal * nums[i], nums[i]);
            maxVal = Math.max(maxVal, max[i]);
            minVal = Math.min(minVal, min[i]);
        }
        return maxVal;
    }
}
