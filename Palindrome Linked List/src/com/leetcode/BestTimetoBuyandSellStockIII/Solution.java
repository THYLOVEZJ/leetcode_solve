package com.leetcode.BestTimetoBuyandSellStockIII;

public class Solution {
    /**
     * dp[i][j][k]表示第i天，j表示是否持有股票，0为未持有，1为持有。k表示进行了k次交易
     * 状态转移方程
     * dp[i][0][0] = Math.max(dp[i-1][0][0],dp[i-1][1][0]+prices[i])
     * dp[i][1][0] = Math.max(dp[i-1][1][0],dp[i-1][0][0]-prices[i])
     * dp[i][0][1] = Math.max(dp[i-1][1][0]+prices[i],dp[i-1][0][1])
     * dp[i][1][1] = Math.max(dp[i-1][1][1],dp[i-1][0][1]-prices[i])
     * dp[i][0][2] = Math.max(dp[i-1][0][2],dp[i-1][1][1]+prices[i])
     * dp[i][1][2] = Math.MINVALUE/2
     */

    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length][2][3];
        //初始条件
        dp[0][0][0] = 0;
        dp[0][1][0] = -prices[0];
        dp[0][1][1] = dp[0][0][1] = dp[0][0][2] = dp[0][1][2] = Integer.MIN_VALUE/2;
        for (int i = 1;i<prices.length;i++){
            //这个地方容易出错
                 dp[i][0][0] = 0;
                 dp[i][1][0] = Math.max(dp[i-1][1][0],dp[i-1][0][0]-prices[i]);
                 dp[i][0][1] = Math.max(dp[i-1][1][0]+prices[i],dp[i-1][0][1]);
                 dp[i][1][1] = Math.max(dp[i-1][1][1],dp[i-1][0][1]-prices[i]);
                 dp[i][0][2] = Math.max(dp[i-1][0][2],dp[i-1][1][1]+prices[i]);
                 dp[i][1][2] = Integer.MIN_VALUE;
        }
        return Math.max(dp[prices.length-1][0][0],Math.max(dp[prices.length-1][0][1],dp[prices.length-1][0][2]));
    }
}
