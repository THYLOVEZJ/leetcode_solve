package com.leetcode.Permutations;

import java.util.ArrayList;
import java.util.List;

public class Solution {
List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public List<List<Integer>> permute(int[] nums) {
        //声明一个ArrayList记录路径
        ArrayList<Integer> track = new ArrayList<>();
        backtrack(nums,track);
        return ans;
    }

    public void backtrack(int[] nums,ArrayList<Integer> track){
        //返回条件，达到决策树底层，即track里边的长度和nums数组的长度相同
        if (nums.length == track.size()){
            //给结果添加track，同时返回
            ans.add(new ArrayList<>(track));
            return;
        }
        for(int i = 0;i<nums.length;i++){
            if (track.contains(nums[i])){
                continue;
            }

            track.add(nums[i]);
            backtrack(nums,track);
            track.remove(track.size()-1);
        }
    }
}
