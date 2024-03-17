package com.sss.dp.linked_list.reverse_ll;

import com.sss.dp.linked_list.LLNode;
import com.sss.dp.linked_list.print_ll.PrintLL;

public class ReverseLinkedList {

    private static void reverseLinkedList(LLNode root) {
        if (root == null) {
            return;
        }
        reverseLinkedList(root.next);
        System.out.print(root.data + " ");
    }

    private static void reverseLinkedListWithoutRecursion(LLNode root) {
        LLNode next, prev = null, current = root;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        root = prev;
        PrintLL.printLinkedList(root);
    }

    public static void main(String[] args) {
        LLNode root = new LLNode(new LLNode(new LLNode(new LLNode(null, 4), 3), 2), 1);
        reverseLinkedList(root);
        System.out.println();
        reverseLinkedListWithoutRecursion(root);
    }


}
