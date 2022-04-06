package com.leetcode.maximumUnits;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int res = 0;
        //先将boxType排序
        Arrays.sort(boxTypes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] > o2[1]) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        for (int[] box : boxTypes) {
            if (box[0] < truckSize) {//如果box个数比truckSize小，那么全部装到车里
                res += box[1] * box[0];
                truckSize -= box[0];
            } else {
                res += truckSize * box[0];
                break;
            }
        }
        return res;
    }
}
