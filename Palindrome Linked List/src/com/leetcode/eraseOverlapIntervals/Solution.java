package com.leetcode.eraseOverlapIntervals;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int res = 0;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int i = 0;
        while (i < intervals.length) {
            for (int j = i + 1; j < intervals.length; j++) {
                //如果后面的start小于i的end，那么我们直接删除，并记录
                if (intervals[j][0] < intervals[i][1]) {
                    res++;
                } else {
                    i = j;
                    break;
                }
            }
        }
        return res;
    }
}
