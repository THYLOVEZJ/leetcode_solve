package com.leetcode.serialize;

import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(3);

        codec codec = new codec();
        String serialize = codec.serialize(treeNode);
        System.out.println(serialize);

//        TreeNode n = codec.deserialize(serialize);
//        System.out.println(n.val);

    }
}
