package com.leetcode.serialize;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;

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
