package com.leetcode.BestTimetoBuyandSellStock;

public class Solution {
    public int maxProfit(int[] prices) {
        int minValue = Integer.MAX_VALUE;
        //这里设置0是因为默认如果没有交易发生默认返回0
        int maxprofit = 0;

        for (int i=0;i<prices.length;i++){
            //记录股票的最低点
            if(prices[i]<minValue)minValue = prices[i];
            //如果股票最低点与现在的差值最大，那么说明获得利润最大，更新最大利润
            if(prices[i]-minValue>maxprofit)maxprofit = prices[i]-minValue;
        }

        return maxprofit;
    }

    public int maxProfitI(int[] prices) {
        /*
        用动态规划来求解
        1.首先建立dp数组
        dp[i][j]:数组表示第i天能获得的最大利润
        j:表示第i天是否持有股票   0表示未持有，1表示持有
        2.设置状态转移方程
        dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i])
        dp[i][1]=Math.max(dp[i-1][1],-prices[i])
        * */
        int[][] dp = new int[prices.length][2];
        //base case
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i=1;i<prices.length;i++){
            for (int j = 0;j<2;j++){
                dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
                dp[i][1]=Math.max(dp[i-1][1],-prices[i]);
            }
        }
        return dp[prices.length-1][0];
    }



}
