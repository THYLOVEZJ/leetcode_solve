package com.leetcode.integerBreak;

/**
 * Leetcode343. 整数拆分
 * 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
 * 返回 你可以获得的最大乘积 。
 */
public class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i < dp.length; i++) {
            for (int j = 1; j < i; j++) {
                //比较的是拆分后的和不拆分的大小
                dp[i] = Math.max(dp[i], Math.max(dp[i - j] * j, (i - j) * j));
            }
        }
        return dp[dp.length - 1];
    }
}
