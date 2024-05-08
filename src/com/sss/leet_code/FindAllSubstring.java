package com.sss.leet_code;

public class FindAllSubstring {
    public static void main(String[] args) {
        findAllSubStrings("ababa", "");
    }

    private static void findAllSubStrings(String str, String s) {
        if (str.isEmpty()) {
            System.out.print(s + " ");
            return;
        }
        findAllSubStrings(str.substring(1), s + str.charAt(0));
        findAllSubStrings(str.substring(1), s);
    }
}
