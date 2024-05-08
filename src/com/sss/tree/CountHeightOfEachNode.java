package com.sss.tree;

import java.util.LinkedList;
import java.util.Queue;

public class CountHeightOfEachNode {
    public static void main(String[] args) {
        TreeNode n8 = new TreeNode(null, null, "n8");
        TreeNode n7 = new TreeNode(null, null, "n7");
        TreeNode n6 = new TreeNode(null, null, "n6");
        TreeNode n5 = new TreeNode(n8, null, "n5");
        TreeNode n4 = new TreeNode(n7, null, "n4");
        TreeNode n3 = new TreeNode(n5, n6, "n3");
        TreeNode n2 = new TreeNode(n4, null, "n2");
        TreeNode n1 = new TreeNode(n2, n3, "n1");
        set_descendant_per_node(n1);
        System.out.println(count_descendants(n1, "n3"));
        System.out.println(count_descendants(n1, "n7"));
    }

    public static int count_descendants(TreeNode treeNode, String data) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(treeNode);
        while (!q.isEmpty()) {
            TreeNode n = q.poll();
            if (n.data.equals(data)) {
                return n.count;
            }
            if (n.left != null) {
                q.add(n.left);
            }
            if (n.right != null) {
                q.add(n.right);
            }
        }
        return -1;
    }

    public static void set_descendant_per_node(TreeNode treeNode) {
        if(treeNode == null) {
            return;
        }
        treeNode.count = count_numbers(treeNode) - 1;
        set_descendant_per_node(treeNode.left);
        set_descendant_per_node(treeNode.right);
    }

    public static int count_numbers(TreeNode treeNode) {
        if(treeNode == null) {
            return 0;
        }
        return count_numbers(treeNode.left) +  count_numbers(treeNode.right) + 1;
    }
}



