package com.thylovezj.lengthoflongestsubstring;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    public static int lengthOfLongestSubstring(String s) {
        int left = 0;
        int res = Integer.MIN_VALUE;

        ArrayList<Character> lists = new ArrayList<>();
        for (int right = 0; right < s.length(); right++) {

            if (!lists.contains(s.charAt(right))) {
                //不存在重复元素
                res = Math.max(res,right-left+1);
            }else {
                while(lists.contains(s.charAt(right))){
                    lists.remove(0);
                    left++;
                }
            }
            lists.add(s.charAt(right));
        }
        return res == Integer.MIN_VALUE ? s.length() : res;
    }
}
