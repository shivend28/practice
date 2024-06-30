package com.sss.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
        Consumer<Integer> display = System.out::println;
        display.accept(10);


        Consumer<List<Integer>> dispList = x -> x.forEach(a -> System.out.print(a + " "));
        Consumer<List<Integer>> modify = list -> {
            for (int i = 0; i < list.size(); i++) {
                list.set(i, (i + i) * list.get(i));
            }
        };
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        dispList.accept(list);
        System.out.println();
        modify.andThen(dispList).accept(list);
        System.out.println();
        dispList.accept(list);
    }
}
