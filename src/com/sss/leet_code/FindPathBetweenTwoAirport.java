package com.sss.leet_code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindPathBetweenTwoAirport {
    public static void main(String[] args) {
        String[] airport = {"A", "B", "C", "D", "E"};
        String[] flights = {"A-B", "B-C", "C-D", "B-A", "D-E", "E-A"};
        String source = "D";
        String dest = "A";

        System.out.println(findPath(airport, flights, source, dest));
    }

    private static boolean findPath(String[] airports, String[] flights, String source, String dest) {
        Map<String, Set<String>> map = new HashMap<>();
        for (String airport: airports) {
            map.put(airport, new HashSet<>());
        }
        for (String flight: flights) {
            String[] fromAndTo = flight.split("-");
            Set<String> toSet = map.getOrDefault(fromAndTo[0], new HashSet<>());
            toSet.add(fromAndTo[1]);
            map.put(fromAndTo[0], toSet);
        }
        Set<String> visited = new HashSet<>();
        return findFlights(map, source, dest, visited);
    }

    private static boolean findFlights(Map<String, Set<String>> map, String source, String destination, Set<String> visited) {
        visited.add(source);
        if (source.equals(destination) || map.get(source).contains(destination)) return true;
        Set<String> a = map.getOrDefault(source, new HashSet<>());
        for (String p : a) {
            if (!visited.contains(p)) {
                visited.add(p);
                boolean x = findFlights(map, p, destination, visited);
                if (x) {
                    return true;
                }
            }
        }
        return false;
    }
}
