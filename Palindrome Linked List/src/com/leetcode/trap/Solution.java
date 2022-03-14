package com.leetcode.trap;

public class Solution {
    public int trap(int[] height) {
        //获取每一个位置左边最高的柱子高度
        int[] left_max = new int[height.length];
        //获取每一个位置右边最高的柱子高度
        int[] right_max = new int[height.length];
        //获得最高的柱子
        int lmax = -1;
        for (int i = 0; i < height.length; i++) {
            if (height[i]>lmax){
                lmax = height[i];
                left_max[i] = lmax;
            }else{
                left_max[i] = lmax;
            }
        }
        int rmax = -1;
        for (int j = height.length - 1; j >= 0; j--) {
            if (height[j]>rmax){
                rmax = height[j];
                right_max[j] = rmax;
            }else{
                right_max[j] = rmax;
            }
        }
        //声明返回的res
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            res += Math.min(left_max[i], right_max[i]) - height[i];
        }
        return res;
    }
}
