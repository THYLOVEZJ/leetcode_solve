package com.leetcode.buildtreeI;

import java.util.HashMap;
import java.util.Map;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/data-structure-binary-tree/xo98qt/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Solution {
    //map里放置了索引和值的映射
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1);
    }

    public TreeNode build(int[] inorder, int inStart, int inEnd,
                          int[] postorder, int postStart, int postEnd) {
        if (inStart>inEnd)return null;
        int rootVal = postorder[postEnd];
        Integer index = map.get(rootVal);
        TreeNode node = new TreeNode(rootVal);
        node.left = build(inorder, inStart, index - 1, postorder, postStart, index - 1 - inStart + postStart);
        node.right = build(inorder, index + 1, inEnd, postorder, index - inStart + postStart, postEnd - 1);
        return node;
    }
}

