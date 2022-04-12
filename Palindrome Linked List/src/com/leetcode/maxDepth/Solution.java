package com.leetcode.maxDepth;

/**
 * Leetcode104. 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class Solution {
    public int ans = 0;

    /**
     * 该解法为二叉树的前序遍历解法，想一想是否有后序遍历解法
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        //根节点的深度为1
        depth(root, 1);
        return ans;
    }

    /**
     * 该函数即是求二叉树的深度
     */
    public void depth(TreeNode root, int dep) {
        //递归中止条件
        if (root == null) return;

        //如果二叉树为叶子节点，判断此时叶子节点是否为二叉树高度最大的叶子
        if (root.left == null && root.right == null) {
            ans = Math.max(ans, dep);
        }

        //递归计算左子树和右子树的高度
        depth(root.left, dep + 1);
        depth(root.right, dep + 1);
    }


    /**
     * 后序遍历解法
     * @param root
     * @return
     */
    public int maxDepthI(TreeNode root) {
        return depthI(root);
    }

    public int depthI(TreeNode root){
        //递归中止条件
        if (root==null){
            return 0;
        }
        int leftCount = depthI(root.left)+1;
        int rightCount = depthI(root.right)+1;
        return Math.max(leftCount,rightCount);
    }
}
