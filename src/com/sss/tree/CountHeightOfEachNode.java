package com.sss.tree;

import java.util.LinkedList;
import java.util.Queue;

public class CountHeightOfEachNode {
    public static void main(String[] args) {
        Node n8 = new Node(null, null, "n8");
        Node n7 = new Node(null, null, "n7");
        Node n6 = new Node(null, null, "n6");
        Node n5 = new Node(n8, null, "n5");
        Node n4 = new Node(n7, null, "n4");
        Node n3 = new Node(n5, n6, "n3");
        Node n2 = new Node(n4, null, "n2");
        Node n1 = new Node(n2, n3, "n1");
        set_descendant_per_node(n1);
        System.out.println(count_descendants(n1, "n3"));
        System.out.println(count_descendants(n1, "n7"));
    }

    public static int count_descendants(Node node, String data) {
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            Node n = q.poll();
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

    public static void set_descendant_per_node(Node node) {
        if(node == null) {
            return;
        }
        node.count = count_numbers(node) - 1;
        set_descendant_per_node(node.left);
        set_descendant_per_node(node.right);
    }

    public static int count_numbers(Node node) {
        if(node == null) {
            return 0;
        }
        return count_numbers(node.left) +  count_numbers(node.right) + 1;
    }


}

class Node {
    Node left;
    Node right;
    int count;  // This will be an ans for each node
    String data;

    public Node(Node left, Node right, String data) {
        this.left = left;
        this.right = right;
        this.data = data;
    }

}

