package com.sss.dp.linked_list.print_ll;

import com.sss.dp.linked_list.LLNode;

public class PrintLL {
    public static void printLinkedList(LLNode root) {
        while (root != null) {
            System.out.print(root.data + " ");
            root = root.next;
        }
    }
}
