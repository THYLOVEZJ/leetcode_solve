package com.leetcode.serialize;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;

/***
 * Leetcode297序列化一个二叉树
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 *
 * 你需要设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *
 * 输入：root = [1,2,3,null,null,4,5]
 * 输出：[1,2,3,null,null,4,5]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class codec {
    String sep = ",";
    String NULL = "#";
    StringBuilder ans = new StringBuilder();
    public String serialize(TreeNode root) {
        traverse(root);
        return ans.toString();
    }

    public void traverse(TreeNode root){
        if(root == null){
            ans.append(NULL).append(sep);
            return;
        }
        ans.append(root.val).append(sep);
        traverse(root.left);
        traverse(root.right);
    }

    public TreeNode deserialize(String data) {
        LinkedList<String> treeNodes = new LinkedList<String>();
        for (String s : data.split(",")) {
            treeNodes.addLast(s);
        }
        return deserialize(treeNodes);
    }

    public TreeNode deserialize(LinkedList<String> treeNodes){
        if (treeNodes.isEmpty()){
            return null;
        }
        String s = treeNodes.removeFirst();
        if (s.equals(""))return null;
        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = deserialize(treeNodes);
        root.right = deserialize(treeNodes);
        return root;
    }
}
