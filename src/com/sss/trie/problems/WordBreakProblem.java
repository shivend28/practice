package com.sss.trie.problems;

import com.sss.trie.TrieNode;
import com.sss.trie.TrieOperations;

public class WordBreakProblem {
    /*
    Word Break Problem
    Given an input string and a dictionary of words, find out if the input string can be broken into a space-separated sequence of dictionary words.
        words[] = { i, like, sam, samsung, mobile, ice}
        key = "ilikesamsung"
        output: true
     */

    public static void main(String[] args) {
        String[] words = { "i", "like", "sam", "samsung", "mobile", "ice"};
        String key = "ilikesamsung";
        TrieNode root = new TrieNode();
        for (String word: words) {
            TrieOperations.insertWord(root, word);
        }
        System.out.println(wordBreakProblem(root, key));
    }

    private static boolean wordBreakProblem(TrieNode root, String key) {
        if (key.isEmpty()) return true;
        for (int i = 1; i <= key.length(); i++) {
            String first = key.substring(0, i);
            String second = key.substring(i);
            if (TrieOperations.searchWord(root, first) && wordBreakProblem(root, second)) {
                return true;
            }
        }
        return false;
    }


}
