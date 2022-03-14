package com.leetcode.subarraySum;

public class testSubArraySum {
    public static void main(String[] args) {
        int ans = Solution.subarraySum(new int[]{1, 1, 1}, 2);
        System.out.println(ans);
        int ans2 = Solution.subarraySumII(new int[]{1, 1, 1}, 2);
        System.out.println(ans2);
    }
}
