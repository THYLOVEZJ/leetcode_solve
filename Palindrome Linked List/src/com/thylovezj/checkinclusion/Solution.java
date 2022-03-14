package com.thylovezj.checkinclusion;

public class Solution {
    public static boolean checkInclusion(String s1, String s2) {
        char[] charArray = s1.toCharArray();
        int m = charArray.length;
        char[] charArray1 = s2.toCharArray();
        int n = charArray1.length;
        if (m > n) {
            return false;
        }
        int leftp = 0;
        int[] res = new int[26];
        for (char c : charArray) {
            res[c - 'a']--;
        }
        for (int rightp = 0; rightp < charArray1.length; rightp++) {
            res[charArray1[rightp]-'a']++;
            while (res[charArray1[rightp] - 'a'] > 0) {
                res[charArray1[leftp]-'a']--;
                leftp++;
            }
            if (rightp-leftp+1==m)return true;
        }
        return false;
    }
}
