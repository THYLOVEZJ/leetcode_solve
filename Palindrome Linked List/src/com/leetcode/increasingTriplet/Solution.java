package com.leetcode.increasingTriplet;

public class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) return false;
        //声明一个数组记录是否有两个元素的增序列
        boolean have[] = new boolean[nums.length];
        int lmin = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (lmin < nums[i]) {
                have[i] = true;
            } else {
                lmin = nums[i];
            }
        }

        int rmax = nums[nums.length - 1];
        for (int j = nums.length - 2; j >= 1; j--) {
            if (nums[j] < rmax && have[j]) {
                return true;
            } else if (have[j]) {
                rmax = nums[j];
            }
        }
        return false;
    }
}
