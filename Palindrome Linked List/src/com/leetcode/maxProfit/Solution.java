package com.leetcode.maxProfit;


/***
 * 给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格 。​
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int maxProfit(int[] prices) {
        //这里的dp数组记录能获得的最大利润，其中dp[i][0]表示未持有状态,dp[i][1]表示买入状态,dp[i][2]表示冷冻状态
        int[][] dp = new int[prices.length][3];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            //未持有状态可以由未持有状态和持有状态卖出股票转换而来
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = dp[i-1][1] + prices[i];
        }
        return dp[prices.length - 1][0] >= dp[prices.length - 1][2] ? dp[prices.length - 1][0] : dp[prices.length - 1][2];
    }
}
