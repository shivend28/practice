package com.sss.tree;

public class TreeNode {
    TreeNode left;
    TreeNode right;
    int count;  // This will be an ans for each node
    String data;

    public TreeNode(TreeNode left, TreeNode right, String data) {
        this.left = left;
        this.right = right;
        this.data = data;
    }

}
