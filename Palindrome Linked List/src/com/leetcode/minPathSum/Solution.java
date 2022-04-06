package com.leetcode.minPathSum;

/***Leetcode64
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 */
public class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            //左边界的值为上面的值加下面的值
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int j = 1; j < grid[0].length; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        for (int i = 1;i< grid.length;i++){
            for (int j = 1;j<grid[0].length;j++){
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+ grid[i][j];
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}
