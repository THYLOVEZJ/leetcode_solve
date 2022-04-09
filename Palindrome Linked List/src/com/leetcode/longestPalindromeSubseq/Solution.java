package com.leetcode.longestPalindromeSubseq;

public class Solution {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];

        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = 1;
        }

        int max = 1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i][j];
                }
                max = Math.max(max,dp[i][j]);
            }
        }
        return max;
    }
}
