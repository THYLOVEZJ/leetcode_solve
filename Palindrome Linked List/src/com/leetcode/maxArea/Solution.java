package com.leetcode.maxArea;

public class Solution {
    public int maxArea(int[] height) {
        int lp = 0;
        int rp = height.length - 1;
        int mArea = 0;
        while (lp != rp) {
            mArea = Math.max(mArea,(rp-lp)*Math.min(height[lp],height[rp]));
            if (height[lp]>height[rp]){
                rp--;
            }else{
                lp++;
            }
        }
        return mArea;
    }
}
