package com.leetcode.numSquares;

import java.util.Arrays;

/**
 * Leetcode279. 完全平方数
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 * <p>
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/perfect-squares
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int numSquares(int n) {
        if (n == 1) return 1;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 666);
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < dp.length; i++) {
            for (int j = 1; j < i; j++) {
                if (i == j * j) {
                    dp[i] = 1;
                }
                dp[i] = Math.min(dp[i], dp[i - j] + dp[j]);
            }
        }
        return dp[dp.length - 1];
    }
}
