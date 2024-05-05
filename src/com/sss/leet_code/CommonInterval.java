package com.sss.leet_code;

import java.util.Arrays;

public class CommonInterval {
    public static void main(String[] args) {
        int[][] time_stamps = {{9, 13}, {10, 12}, {1, 18}, {17, 20}, {8, 14}};
        System.out.println(commonInterval(time_stamps));
    }

    public static int commonInterval(int[][] t) {
        if(t.length == 0) {
            return 0;
        }
        Arrays.sort(t, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        int count = 1;
        int maxIn = t[0][0];
        int maxOut = t[0][1];
        for(int i = 1; i < t.length; i++) {
            if(t[i][0] >= maxIn && t[i][1] <= maxOut) {
                count++;
            } else {
                maxIn = t[i][0];
                maxOut = t[i][1];
            }
        }
        return count;
    }
}
