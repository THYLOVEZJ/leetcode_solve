package com.leetcode.treetodoublelist;

public class testTreeToDoublyList {
    public static void main(String[] args) {
        Node node = new Node(1,null,null);
        Node node2 = new Node(3,null,null);
        Node node1 = new Node(2,node,node2);

        Node fir = Solution.treeToDoublyList(node1);
        for (int i = 0;i<4;i++){
            System.out.println(fir.val);
            fir = fir.right;
        }
    }
}
