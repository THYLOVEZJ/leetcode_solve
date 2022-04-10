package com.leetcode.coinChange;

import java.util.Arrays;
import java.util.Comparator;

/***Leetcode322 零钱兑换
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 *
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 *
 * 你可以认为每种硬币的数量是无限的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    /***
     * 该解法超时，在于没有消除子问题
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        return coinPro(coins, amount);
    }

    public int coinPro(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int count = coinPro(coins, amount - coin);
            if (count == -1) continue;
            res = Math.min(res, count + 1);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }


    public int coinChangeI(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 666);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int coin : coins) {
                if (i == coin) {
                    dp[i] = 1;
                    continue;
                }
                if (i - coin > 0) {
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                }
            }
        }
        return dp[dp.length - 1] == 666 ? -1 : dp[dp.length - 1];
    }
}
