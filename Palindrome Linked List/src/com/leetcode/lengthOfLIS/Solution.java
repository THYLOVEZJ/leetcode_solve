package com.leetcode.lengthOfLIS;

import java.util.Arrays;

/***Leetcode300最长递增子序列
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        /**
         * 该dp数组的定义是以dp[i]结尾的数能构成的最长递增子序列
         *
         * 这里如何定义状态转移方程是很重要的问题
         * 1 4 3 4 2 3
         * 1 2 2 3 2 ？
         * 比如我们有以上子序列，我们应该如何判断此处？的值呢
         * 答案:我们应该判断其与前面子序列是否能构成更长的字串
         */
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 1;
        for (int ans : dp) {
            res = Math.max(res, ans);
        }
        return res;
    }
}
