package com.sss.trie;

public class TrieNode {
    public TrieNode[] children;
    public boolean eow;

    public TrieNode() {
        this.children = new TrieNode[26];
        for (int i = 0; i < 26; i++) {
            this.children[i] = null;
        }
        eow = false;
    }
}
