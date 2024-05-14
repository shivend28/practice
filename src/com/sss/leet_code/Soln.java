package com.sss.leet_code;

public class Soln {
    public static void main(String[] args) {
        String[] arr = {"Apple 1 2", "abc - 1;222 ", "xyz M N", "pqr -1 2"};
        // o/p: 2+222+2=226 => 1 * 2 + 222 * 1 + 2 * 1 => 2+222+2=226
        System.out.println(total(arr));
    }

    public static String total( String[] groceryList ) {
        int sum = 0;
        String sumStr = "";
        for(String grocery: groceryList) {
            grocery = grocery.replaceAll("[^a-zA-Z0-9]+"," ");
            String[] arr = grocery.split(" ");
            int len = grocery.length();
            try {
                int count = Integer.parseInt(arr[arr.length - 1]);
                int qty = Integer.parseInt(arr[arr.length - 2]);
                int temp = count * qty;
                sumStr = sumStr + "+" + temp;
                sum = sum + temp;
            } catch(Exception e) {

            }
        }
        return sumStr.substring(1) + "=" + sum;
    }
}
