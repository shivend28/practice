package com.sss.trie.problems;

import com.sss.trie.TrieNode;
import com.sss.trie.TrieOperations;

public class LongestWordWithAllPrefix {
    /*
        Longest Word with all Prefixes
        Find the longest string in words such that every prefix of it is also in words.
            words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
            ans = "apple"
     */

    static String max = "";

    public static void main(String[] args) {
        String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        TrieNode root = new TrieNode();
        for (String word: words) {
            TrieOperations.insertWord(root, word);
        }

        findLongestWordWithAllPrefix(root, new StringBuilder());
        System.out.println(max);
    }

    private static void findLongestWordWithAllPrefix(TrieNode root, StringBuilder temp) {
        if (root == null)
            return;
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null && root.children[i].eow) {
                temp.append((char)(i + 'a'));
                if (temp.length() > max.length()) {
                    max = temp.toString();
                }
                findLongestWordWithAllPrefix(root.children[i], temp);
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }
}
