package com.leetcode.Permutations;

import java.util.List;

public class test {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution solve = new Solution();
        List<List<Integer>> permute = solve.permute(nums);
        for (List<Integer> list: permute){
            System.out.println(list);
        }
    }
}
