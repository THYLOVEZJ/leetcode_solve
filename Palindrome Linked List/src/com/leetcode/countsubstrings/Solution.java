package com.leetcode.countsubstrings;

public class Solution {
    public static int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += isValid(s, i, i);
            count += isValid(s, i, i + 1);
        }
        return count;
    }

    public static int isValid(String s, int left, int right) {
        int count = 0;
        //循环条件是:当左边界>0且右边界小于s.length时
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left)==s.charAt(right)){
                count++;
            }
            if (s.charAt(left)!=s.charAt(right)){
                return count;
            }
            left--;
            right++;
        }
        return count;
    }
}
