package com.leetcode.flatten;

import com.leetcode.addtwonumbers.ListNode;

public class Solution {
    public Node flatten(Node head) {
        Node res = head;
        //head.next ->head.child
        //last.next ->next
        while (head != null) {
            Node next = head.next;
            Node child = head.child;
            if (child != null) {
                head.next = head.child;
                head.child.prev = head;
                //寻找该层最后一个节点
                while(child.next!=null){
                    child = child.next;
                }
                //这里的child就是最后一层节点
                child.next = next;
                next.prev = child;

                //head.child置为空
                head.child = null;
            }
            head = head.next;
        }
        return res;
    }
}
