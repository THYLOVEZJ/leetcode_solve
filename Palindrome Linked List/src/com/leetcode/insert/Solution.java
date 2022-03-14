package com.leetcode.insert;

public class Solution {
    public static Node insert(Node head, int insertVal) {
        if (head == null) {
            Node node = new Node(insertVal);
            node.next = node;
            return node;
        }
        Node pre = head.next;
        Node cur = head;
        while(true){
            if (pre.val>insertVal&&insertVal>cur.val){
                Node next = cur.next;
                cur.next = new Node(insertVal,next);
                break;
            }else if ((pre.val<cur.val&&insertVal<pre.val)||(pre.val<cur.val&&insertVal>cur.val)){
                Node next = cur.next;
                cur.next = new Node(insertVal,next);
                break;
            }else if (cur.val==insertVal){
                Node next = cur.next;
                cur.next = new Node(insertVal,next);
                break;
            }

            pre = pre.next;
            cur = cur.next;
        }
        return head;
    }
}
