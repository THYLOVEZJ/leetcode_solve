package com.leetcode.climbStairs;

/**
 * Leetcode70 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        for (int i = 3; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 状态压缩后的解法
     *
     * @param n
     * @return
     */
    public int climbStairsI(int n) {
        if (n == 1 || n == 2) return n;
        int pre = 1;
        int cur = 2;
        int sum = 0;
        for (int i = 3; i < n + 1; i++) {
            sum = pre + cur;
            pre = cur;
            cur = sum;
        }
        return sum;
    }
}
