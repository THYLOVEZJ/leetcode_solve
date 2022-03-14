package com.leetcode.BestTimetoBuyandSellStockIII;

public class test {
    public static void main(String[] args) {
        Solution solve = new Solution();
        int[] nums = new int[]{3,3,5,0,0,3,1,4};
        int max = solve.maxProfit(nums);
        System.out.println(max);
    }
}
