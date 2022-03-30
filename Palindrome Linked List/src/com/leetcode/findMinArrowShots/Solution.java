package com.leetcode.findMinArrowShots;


import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int findMinArrowShots(int[][] points) {
        int res = 0;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        System.out.println(points.length);
        for (int i = 0; i < points.length; i++) {
            int j = i+1;
            while (points[j][0]>=points[i][1]){
                //气球会被引爆
                res++;
                j++;
            }
            i = j;
        }
        return res;
    }
}
