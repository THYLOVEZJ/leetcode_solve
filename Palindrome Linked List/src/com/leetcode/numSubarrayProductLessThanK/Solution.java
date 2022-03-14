package com.leetcode.numSubarrayProductLessThanK;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int mult = 1;
        int low = 0;
        int ans = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            mult *= nums[fast];
            while (mult >= k && low <= fast) {
                mult /= nums[low++];
            }
            //这里是指通过最后一个元素来判断有几个子数组，比如0，1，2，那么相比于0，1就多了left-right+1个元素
            ans += fast >= low ? fast - low + 1 : 0;
        }
        return ans;
    }
}
