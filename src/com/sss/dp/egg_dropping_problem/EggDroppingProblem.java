package com.sss.dp.egg_dropping_problem;

public class EggDroppingProblem {
    public static void main(String[] args) {
        int f = 10;
        int e = 3;
        int ans = solve(f, e);
        System.out.println(ans);
    }

    private static int solve(int f, int e) {
        if (f == 0 || f == 1) {
            return 1;
        }
        if (e == 1) {
            return f;
        }
        int min = Integer.MAX_VALUE;
        for (int k = 1; k <= f; k++) {
            int temp = 1 + Math.max(solve(f - k, e), solve(k - 1, e - 1));
            min = Math.min(min, temp);
        }
        return min;
    }
}
