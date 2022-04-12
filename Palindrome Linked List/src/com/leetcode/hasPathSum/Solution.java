package com.leetcode.hasPathSum;

public class Solution {
    boolean flag = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return flag;
        check(root, targetSum, root.val);
        return flag;
    }

    public void check(TreeNode root, int targetSum, int sum) {
        if (root == null) {
            return;
        }

        //如果是叶子节点，判断路径和是否为target，
        if (root.left == null && root.right == null) {
            //判断
            if (targetSum == sum) {
                flag = true;
            }
        }
        check(root.left, targetSum, sum + root.val);
        check(root.right, targetSum, sum + root.val);
    }
}
