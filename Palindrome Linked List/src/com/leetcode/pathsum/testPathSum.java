package com.leetcode.pathsum;

public class testPathSum {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1, null, null);
        TreeNode treeNode2 = new TreeNode(2, null, null);
        TreeNode treeNode3 = new TreeNode(3, treeNode1, treeNode2);
        int res = Solution.pathSum(treeNode3, 5);
        System.out.println(res);
    }
}
