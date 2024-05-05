package com.sss.leet_code;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

public class LRUCache {
    private  static LinkedHashSet<Integer> cache = new LinkedHashSet<>();
    static int capacity = 3;
    public static void main(String[] args) {
        List<Integer> data = Arrays.asList(1, 2, 3, 4, 5);
        for (Integer d: data) {
            add(d);
        }
        for (Integer integer : cache) {
            System.out.println(integer);
        }
    }

    private static void add(Integer d) {
        if (!cache.contains(d)) {
            if (cache.size() == capacity) {
                cache.remove(cache.getFirst());
            }
        } else {
            cache.remove(d);
        }
        cache.add(d);
    }
}
