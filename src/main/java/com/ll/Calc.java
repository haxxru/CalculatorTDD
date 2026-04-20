package com.ll;

public class Calc {
    public static int run(String expression) {
        String[] bits = expression.split(" ");
        int result = 0;
        int current = Integer.parseInt(bits[0]);

        for (int i = 1; i < bits.length; i += 2) {
            String operator = bits[i];
            int num = Integer.parseInt(bits[i + 1]);

            if (operator.equals("*")) {
                current *= num;
                continue;
            }

            if (operator.equals("+")) {
                result += current;
                current = num;
                continue;
            }

            result += current;
            current = -num;

        }

        return result + current;
    }
}
