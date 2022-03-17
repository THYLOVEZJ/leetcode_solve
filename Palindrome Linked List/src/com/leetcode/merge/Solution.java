package com.leetcode.merge;

import java.util.Arrays;

/***
 * 归并排序代码
 * 算法复杂度(nlogn)
 */
public class Solution {
    private int[] temp;

    public int[] sortArray(int[] nums) {
        int length = nums.length;
        temp = new int[nums.length];
        sort(nums, 0, length - 1);
        return nums;
    }

    public void sort(int[] nums, int left, int right) {
        //单个元素不用排序
        if (left == right) return;
        int mid = left + (right - left) / 2;
        sort(nums, left, mid);
        sort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    public void merge(int[] nums, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }
        int i = left, j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i == mid+1) {
                nums[k] = temp[j++];

            } else if (j == right+1) {
                nums[k] = temp[i++];

            } else if (temp[i] > temp[j]) {
                nums[k] = temp[j++];

            } else {
                nums[k] = temp[i++];
            }
        }
    }
}
