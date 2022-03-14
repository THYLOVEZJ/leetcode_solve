package com.leetcode.LongestIncreasingSubsequence;

public class test {
    public static void main(String[] args) {
        Solution solve = new Solution();
        int[] nums =new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        int max = solve.lengthOfLIS(nums);
        System.out.println(max);
    }
}
