package com.leetcode.longestPalindrome;

import java.util.ArrayList;

public class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1) return s;
        ArrayList<String> ans = new ArrayList<>();
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            int left = i;
            int right = i;
            while (left >= 0 && left < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            ans.add(s.substring(left + 1, right));
            left = i;
            right = i + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            ans.add(s.substring(left + 1, right));
        }
        for (String a : ans) {
            res = a.length() > res.length() ? a : res;
        }
        return res;
    }
}
