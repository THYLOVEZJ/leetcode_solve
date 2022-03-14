package com.leetcode.findanagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public static List<Integer> findAnagrams(String s, String p) {
        int leftp = 0;
        char[] charArray = s.toCharArray();
        char[] charArray1 = p.toCharArray();
        int m = charArray.length;
        int n = charArray1.length;
        if (n > m) return new ArrayList<Integer>();
        ArrayList<Integer> list = new ArrayList<>();
        int[] res = new int[26];
        for (char c : charArray1) {
            res[c - 'a']--;
        }
        for (int rightp = 0; rightp < m; rightp++) {
            int index = charArray[rightp] - 'a';
            res[index]++;
            while (res[charArray[rightp]-'a'] > 0) {
                res[charArray[leftp] - 'a']--;
                leftp++;
            }
            if (rightp - leftp + 1 == n) {
                list.add(leftp);
            }
        }
        return list;
    }
}
