package com.sss.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        Predicate<Integer> greaterThanTen = i -> i > 10;
        boolean result = greaterThanTen.test(15);
        System.out.println(result);
        Predicate<Integer> lowerThanTen = i -> i < 20;
        Predicate<Integer> equalsHundred = i -> i == 100;
        result = greaterThanTen.and(lowerThanTen).or(equalsHundred).test(15);
        System.out.println(result);
        result = greaterThanTen.and(lowerThanTen).or(equalsHundred).test(100);
        System.out.println(result);
        result = greaterThanTen.and(lowerThanTen).or(equalsHundred).test(55);
        System.out.println(result);
        result = greaterThanTen.and(lowerThanTen).or(equalsHundred).negate().test(55);
        System.out.println(result);

        List<User> usr = new ArrayList<>();
        User a = new User("A", "Admin");
        User x = new User("X", "Admin");
        User b = new User("B", "usr");
        User y = new User("Y", "usr");
        User z = new User("Z", "usr");
        usr.add(a);
        usr.add(b);
        usr.add(x);
        usr.add(y);
        usr.add(z);

        Predicate<User> userPredicate = s -> s.role.equals("Admin");
        for (User u: usr) {
            if (userPredicate.test(u)) {
                System.out.print(u.name + " ");
            }
        }
    }

    static class User {
        String name;
        String role;

        public User(String name, String role) {
            this.name = name;
            this.role = role;
        }

        public String getName() {
            return name;
        }

        public String getRole() {
            return role;
        }
    }
}
