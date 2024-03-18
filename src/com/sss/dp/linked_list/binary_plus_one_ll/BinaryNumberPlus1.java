package com.sss.dp.linked_list.binary_plus_one_ll;

import com.sss.dp.linked_list.LLNode;

public class BinaryNumberPlus1 {
    public static void main(String[] args) {
        LLNode root = new LLNode(new LLNode(new LLNode(new LLNode(null, 1), 0), 1), 1);
        binaryNumberPlusOne(root);
    }

    // 1 1 0 1 >

    private static void binaryNumberPlusOne(LLNode node) {
        String resp = "";
        int carry = 1;
        while (node != null) {
            if (node.data + carry == 2) {
                resp = 0 + resp;
                carry = 1;
            } else if (node.data + carry == 1) {
                resp = 1 + resp;
                carry = 0;
            } else {
                resp = 0 + resp;
                carry = 0;
            }
            node = node.next;
        }
        if (carry == 1) {
            resp = 1 + resp;
        }
        System.out.println(resp);
    }
}
