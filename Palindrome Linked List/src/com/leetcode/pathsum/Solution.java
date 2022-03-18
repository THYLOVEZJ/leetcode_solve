package com.leetcode.pathsum;

public class Solution {
    /***
     * 第一个循环负责保证root作为根节点时的递归
     * @param root
     * @param targetSum
     * @return
     */
    public static int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int ret = dfs(root, targetSum);
        ret += pathSum(root.left, targetSum);
        ret += pathSum(root.right, targetSum);
        return ret;
    }

    /***
     * 第二个循环负责找到不同的根节点总共有多少种可能
     * @param root
     * @param targetSum
     * @return
     */
    public static int dfs(TreeNode root, int targetSum) {
        //这里每次赋值ret==0是为了清除之前找到的节点
        int ret = 0;
        //递归终止条件，root为null
        if (root == null) return 0;
        if (root.val == targetSum) {
            ret++;
        }
        ret += dfs(root.left, targetSum - root.val);
        ret += dfs(root.right, targetSum - root.val);
        return ret;
    }
}
