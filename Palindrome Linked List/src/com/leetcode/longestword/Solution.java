package com.leetcode.longestword;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public String longestWord(String[] words) {
        //对单词进行排序
        Arrays.sort(words);
        //要返回的结果
        String res = "";
        //遍历每一个单词
        Set<String> set = new HashSet<>();
        for (String word : words) {
            if (word.length() == 1 || set.contains(word.substring(0, word.length() - 1))) {
                res = word.length() > res.length() ? word : res;
                //添加该单词到set里
                set.add(word);
            }
        }
        return res;
    }
}
