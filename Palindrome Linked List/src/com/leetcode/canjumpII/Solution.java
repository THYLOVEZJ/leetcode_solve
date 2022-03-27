package com.leetcode.canjumpII;

public class Solution {
    int res = Integer.MAX_VALUE;

    public int jump(int[] nums) {
        return solve(nums, 0);
    }

    //该递归函数的定义是，从索引p跳到最后总共需要多少步
    public int solve(int[] nums, int p) {
        //base case
        if (p >= nums.length - 1) return 0;
        int maxjump = nums[p];
        //我可以选择跳1,2...maxjump步
        for (int i = 1; i <= maxjump; i++) {
            int ans = solve(nums, p + i);
            res = Math.min(res, ans + 1);
        }
        return res;
    }


    /***
     * 算法复杂度o(n)
     * @param nums
     * @return
     */
    public int jumpII(int[] nums) {
        int maxEnd = 0;
        int end = 0;
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxEnd = Math.max(i + nums[i], maxEnd);
            if (i == end) {//如果i走到了这一步的最大值处。那么更新下一步能走到的最大值
                end = maxEnd;
                res++;
            }
        }
        return res;
    }
}
