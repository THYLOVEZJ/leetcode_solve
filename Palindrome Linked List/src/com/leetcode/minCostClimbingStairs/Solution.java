package com.leetcode.minCostClimbingStairs;

/**
 * 746. 使用最小花费爬楼梯
 * 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
 * <p>
 * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
 * <p>
 * 请你计算并返回达到楼梯顶部的最低花费。
 * <p>
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-cost-climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(cost[i] + dp[i - 1], cost[i] + dp[i - 2]);
        }
        return dp[cost.length - 1];
    }

    /**
     * 状态压缩后的代码
     *
     * @param cost
     * @return
     */
    public int minCostClimbingStairsI(int[] cost) {
        int pre = cost[0];
        int cur = cost[1];
        int sum = 0;
        for (int i = 2; i < cost.length; i++) {
            sum = Math.min(pre, cur) + cost[i];
            pre = cur;
            cur = sum;

        }
        return pre > cur ? cur : pre;
    }
}
