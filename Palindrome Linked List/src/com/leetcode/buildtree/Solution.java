package com.leetcode.buildtree;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    /***
     *
     * @param preorder 是该二叉树的前序遍历
     * @param inorder 是该二叉树的中序遍历
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        //记录二叉树根节点的值
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    /***
     *
     * @param preorder 是该二叉树的前序遍历
     * @param preleft
     * @param preright
     * @param inorder
     * @param inleft
     * @param inright
     * @return
     */
    public TreeNode build(int[] preorder, int preleft, int preright, int[] inorder, int inleft, int inright, Map<Integer, Integer> map) {
        //递归终止条件：当preleft>preright或者inleft>inright时
        if (preleft > preright || inleft > inright) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preleft]);
        Integer pindex = map.get(preorder[preleft]);
        root.left = build(preorder, preleft + 1, preleft + pindex - inleft, inorder, inleft, pindex - 1, map);
        root.right = build(preorder, preleft + pindex - inleft + 1, preright, inorder, pindex + 1, inright, map);
        return root;
    }
}
