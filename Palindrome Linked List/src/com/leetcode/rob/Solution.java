package com.leetcode.rob;

/***
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 该题的思路为动态规划，应该想到边界条件有两种，如果只有一间房子，那么获得的最大金额就是这间房子的金额
 * 如果有两件房子，就是两间房子金额较大的
 *
 */
public class Solution {
    public int rob(int[] nums) {
        if(nums.length==1)return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i = 2;i<dp.length;i++){
            //每间屋子只有两种选择，一种是偷，一种是不偷。
            //不偷的话，获得的最大利润是偷dp[i-1]获得的最大利润，偷的话是dp[i-2]+nums[i]获得的最大利润
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[dp.length-1];
    }
}
