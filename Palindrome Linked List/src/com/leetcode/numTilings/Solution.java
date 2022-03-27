package com.leetcode.numTilings;

public class Solution {
    private final int mod = 1000000007;
    public int numTilings(int n) {
        int [][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[0][2] = 0;
        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[1][2] = 1;
        for (int i = 2;i<=n;i++){
            dp[i][0] = (dp[i-1][0]+dp[i-2][0]+dp[i-1][1]+dp[i-1][2])%mod;
            dp[i][1] = (dp[i-2][0]+dp[i-1][2])%mod;
            dp[i][2] = (dp[i-2][0]+dp[i-1][1])%mod;
        }
        return dp[n][0]%mod;
    }
}
