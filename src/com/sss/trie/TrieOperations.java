package com.sss.trie;

public class TrieOperations {

    public static void main(String[] args) {
        String[] words = {"the", "a", "there", "their", "any"};
        TrieNode root = new TrieNode();
        for (String word : words) {
            insertWord(root, word);
        }
        System.out.println(searchWord(root, "a"));
        System.out.println(searchWord(root, "there"));
        System.out.println(searchWord(root, "their"));
        System.out.println(searchWord(root, "and"));
    }

    public static void insertWord(TrieNode root, String word) {
        TrieNode node = root;
        int len = word.length();
        for (int i = 0; i < len; i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            if (i == len - 1) {
                node.children[index].eow = true;
            }
            node = node.children[index];
        }
    }

    public static boolean searchWord(TrieNode root, String word) {
        TrieNode node = root;
        int len = word.length();
        for (int i = 0; i < len; i++) {
            int index = word.charAt(i) - 'a';
            node = node.children[index];
            if (node == null) {
                return false;
            }
            if (i == len - 1 && !node.eow) {
                return false;
            }
        }
        return true;
    }
}
