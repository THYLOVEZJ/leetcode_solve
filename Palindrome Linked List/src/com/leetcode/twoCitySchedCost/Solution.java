package com.leetcode.twoCitySchedCost;

import java.util.Arrays;
import java.util.Comparator;

/***Leetcode921
 * 公司计划面试 2n 人。给你一个数组 costs ，其中 costs[i] = [aCosti, bCosti] 。第 i 人飞往 a 市的费用为 aCosti ，飞往 b 市的费用为 bCosti 。
 *
 * 返回将每个人都飞到 a 、b 中某座城市的最低费用，要求每个城市都有 n 人抵达。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-city-scheduling
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/***
 * 本题的思路是让这些人全部飞去b地，那么花费即为cost[i][1],然后再按去两地的差值排序，让n人飞去a地。
 */
public class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o1[1] - (o2[0] - o2[1]);
            }
        });

        int res = 0;
        for (int i = 0; i < costs.length; i++) {
            if (i <= (costs.length - 1) / 2) {
                res += costs[i][0];
            } else {
                res += costs[i][1];
            }
        }

        return res;
    }
}
