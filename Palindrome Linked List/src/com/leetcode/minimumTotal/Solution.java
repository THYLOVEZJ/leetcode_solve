package com.leetcode.minimumTotal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/***Leetcode120
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 *
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < triangle.size(); i++) {//第一层循环为行数
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < triangle.get(i).size(); j++) {//第二层循环为列数
                if (i == 0) {
                    list.add(triangle.get(i).get(j));
                } else {//第二行及以后
                    //如果j为0，那么，只能由triangle[i-1][0]转换来
                    if (j == 0) {
                        list.add(lists.get(i - 1).get(j) + triangle.get(i).get(j));
                    } else if (j == triangle.get(i).size() - 1) {
                        list.add(lists.get(i - 1).get(j - 1) + triangle.get(i).get(j));
                    } else {
                        list.add(Math.min(lists.get(i - 1).get(j - 1), lists.get(i - 1).get(j)) + triangle.get(i).get(j));
                    }
                }
            }
            lists.add(list);
        }
        return Collections.min(lists.get(lists.size() - 1));
    }
}
