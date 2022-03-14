package com.leetcode.BestTimetoBuyandSellStock;

public class test {
    public static void main(String[] args) {
        int[] stock = {7, 1, 5, 3, 6, 4};
        Solution solve = new Solution();
        int max = solve.maxProfitI(stock);
        System.out.println(max);
    }
}
