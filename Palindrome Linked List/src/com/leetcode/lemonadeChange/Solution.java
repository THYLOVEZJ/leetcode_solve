package com.leetcode.lemonadeChange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/***
 * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 *
 * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
 *
 * 注意，一开始你手头没有任何零钱。
 *
 * 给你一个整数数组 bills ，其中 bills[i] 是第 i 位顾客付的账。如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lemonade-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public boolean lemonadeChange(int[] bills) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(5, 0);
        map.put(10, 0);
        map.put(20, 0);
        for (int i = 0; i < bills.length; i++) {
            //如果付款为5，那么直接将其添加到list
            if (bills[i] == 5) {
                map.put(5, map.get(5) + 1);
            } else {
                int repay = bills[i] - 5;
                if (repay == 15) {
                    if (map.get(10) != 0 && map.get(5) != 0) {
                        map.put(10, map.get(10) - 1);
                        map.put(5, map.get(5) - 1);
                        map.put(20, map.get(20) + 1);
                    } else if (map.get(5) >= 3) {
                        //能不能用三张5块
                        map.put(5, map.get(5) - 3);
                        map.put(20, map.get(20) + 1);
                    } else {
                        return false;
                    }
                } else {
                    if (map.get(5) > 0) {
                        map.put(5, map.get(5) - 1);
                        map.put(10, map.get(10) + 1);
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
