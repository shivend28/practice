package com.sss.dp.linked_list.mid_of_ll;

import com.sss.dp.linked_list.LLNode;

public class MidOfLinkedList {

    public static int midOfLinkedList(LLNode node) {
        if (node == null) {
            return -1;
        }
        if (node.next == null) {
            return node.data;
        }
        LLNode counter1 = node, counter2 = node;
        while (counter2 != null) {
            try {
                counter2 = counter2.next.next;
                if (counter2 != null) {
                    counter1 = counter1.next;
                }
            } catch (Exception e) {
                break;
            }
        }
        return counter1.data;
    }

    public static void main(String[] args) {
        LLNode root = new LLNode(new LLNode(new LLNode(new LLNode(null, 4), 3), 2), 1);
        System.out.println(midOfLinkedList(root));
    }
}
