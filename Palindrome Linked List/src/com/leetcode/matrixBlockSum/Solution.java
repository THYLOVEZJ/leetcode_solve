package com.leetcode.matrixBlockSum;

/***Leetcode1314 矩阵区域和
 * 给你一个 m x n 的矩阵 mat 和一个整数 k ，请你返回一个矩阵 answer ，其中每个 answer[i][j] 是所有满足下述条件的元素 mat[r][c] 的和： 
 *
 * i - k <= r <= i + k,
 * j - k <= c <= j + k 且
 * (r, c) 在矩阵内。
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/matrix-block-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int mat_length = mat.length;
        int mat_weight = mat[0].length;
        int[][] dp = new int[mat_length + 1][mat_weight + 1];
        for (int i = 1; i < mat_length + 1; i++) {
            for (int j = 1; j < mat_weight + 1; j++) {
                //计算二维数组前缀和
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }
        int[][] ans = new int[mat_length][mat_weight];
        for (int i = 0; i < mat_length; i++) {
            for (int j = 0; j < mat_weight; j++) {
                //up是最上面的一行
                int up = Math.max(0, i - k);
                int down = Math.min(dp.length - 1, i + k + 1);
                int left = Math.max(0, j - k);
                int right = Math.min(dp[0].length - 1, j + k + 1);
                ans[i][j] = dp[down][right] - dp[down][left] - dp[up][right] + dp[up][left];
            }
        }
        return ans;
    }
}
