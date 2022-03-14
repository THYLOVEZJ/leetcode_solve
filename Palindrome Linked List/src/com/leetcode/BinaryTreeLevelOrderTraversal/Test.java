package com.leetcode.BinaryTreeLevelOrderTraversal;

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
        Solution solve = new Solution();
        List<List<Integer>> lists = solve.levelOrder(treeNode);
        for (List<Integer> list:lists){
            System.out.print(list);
        }
    }

}
