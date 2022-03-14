package com.leetcode.BinaryTreePostorderTraversal;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(1);
        TreeNode treeNode4 = new TreeNode(5);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;
        Solution sol = new Solution();
        List<Integer> lists = sol.postorderTraversal(treeNode);
        for (int list:lists){
            System.out.print(list);
        }
    }
}
