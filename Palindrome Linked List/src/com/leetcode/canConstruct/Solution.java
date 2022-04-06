package com.leetcode.canConstruct;

import java.util.*;

/***Leetcode1400
 * 给你一个字符串 s 和一个整数 k 。请你用 s 字符串中 所有字符 构造 k 个非空 回文串 。
 *
 * 如果你可以用 s 中所有字符构造 k 个回文字符串，那么请你返回 True ，否则返回 False 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-k-palindrome-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * 思路:如果字符串的长度等于k，那么一定能够构成回文字符串
 * 如果字符串的长度小于k，那么一定不能构成回文字符串
 * <p>
 * 其次，如果字符串里的字符长度为偶数，那么必然能构成回文字符串，否则，需要判断为奇数的字符总数是否小于或者等于k
 * 如果小于或者等于。那么可以构成回文字符串，否则不能构成回文字符串
 */
public class Solution {
    public boolean canConstruct(String s, int k) {
        if (s.length() == k) return true;
        if (s.length() < k) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        int res = 0;
        Iterator<Map.Entry<Character, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Character, Integer> next = iterator.next();
            if (next.getValue() % 2 == 1) {
                res++;
            }
        }
        if (res <= k) return true;
        return false;
    }
}
