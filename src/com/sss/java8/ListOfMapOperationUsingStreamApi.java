package com.sss.java8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListOfMapOperationUsingStreamApi {
    public static void main(String[] args) {
        List<Map<Integer, Integer>> mapList = new ArrayList<>();
        Map<Integer, Integer> m = new HashMap<>();
        m.put(1, 1);
        m.put(11, 11);
        m.put(111, 111);
        Map<Integer, Integer> m1 = new HashMap<>();
        m1.put(2, 2);
        m1.put(22, 22);
        m1.put(222, 222);
        Map<Integer, Integer> m2 = new HashMap<>();
        m2.put(3, 3);
        m2.put(33, 33);
        m2.put(333, 333);

        mapList.add(m);
        mapList.add(m1);
        mapList.add(m2);


        Map<String, Integer> myMap = new HashMap<>();
        myMap.put("One", 1);
        myMap.put("Two", 2);
        myMap.put("Three", 3);

        myMap.keySet().removeAll(myMap.entrySet().stream().filter(a -> a.getValue().equals(2)).map(e -> e.getKey()).collect(Collectors.toList()));

        System.out.println(myMap);

        mapList.forEach(x -> {
            x.entrySet().stream().filter(y -> y.getValue() > 10).map(e -> e.getValue()).collect(Collectors.toList());
            System.out.println(x);
        });

        mapList.forEach(x -> x.entrySet().stream().reduce((y, z) -> {
            if (y.getValue() > z.getValue()) {
                return y;
            }
            return z;
        }));
    }
}
