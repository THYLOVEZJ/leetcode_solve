package com.leetcode.dailytemperatures;

public class testDailyTemperatures {
    public static void main(String[] args) {
        int[] temp = new int[]{30,40,50,60};
        int[] res = Solution.dailyTemperatures(temp);
        for (int i : res){
            System.out.println(i);
        }
    }
}
