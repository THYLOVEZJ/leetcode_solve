package com.leetcode.minFallingPathSum;

/***Leetcode931
 * 给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。
 *
 * 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第一个元素）。具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-falling-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int minFallingPathSum(int[][] matrix) {
        //dp[i][j]为第i行，第j列的下降累加和
        int[][] dp = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {//i为行数
            for (int j = 0; j < matrix.length; j++) {//j为列数
                //如果是第一行。那么就是第一行的值
                if (i == 0) {
                    dp[0][j] = dp[0][j];
                } else if (j == 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j + 1]);
                } else if (j == matrix.length - 1) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i - 1][j + 1]);
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            ans = Math.min(ans, dp[matrix.length - 1][i]);
        }
        return ans;
    }
}
