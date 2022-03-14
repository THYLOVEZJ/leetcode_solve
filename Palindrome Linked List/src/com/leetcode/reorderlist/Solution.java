package com.leetcode.reorderlist;

import java.util.ArrayList;

public class Solution {
    //线性表方法
    public static ListNode reorderList(ListNode head) {
        ListNode pre = head;
        ArrayList<ListNode> list = new ArrayList<>();
        int length = 0;
        while (pre != null) {
            list.add(pre);
            pre = pre.next;
        }

        int i = 0, j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j) break;
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
        return head;
    }
}
