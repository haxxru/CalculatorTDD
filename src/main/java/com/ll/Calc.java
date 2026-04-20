package com.ll;

public class Calc {
    public static int run(String expression) {
        String operator = expression.contains(" + ") ? "+" : "-";
        String[] expressionBits = expression.split(" \\" + operator + " ");

        int num1 = Integer.parseInt(expressionBits[0]);
        int num2 = Integer.parseInt(expressionBits[1]);

        if (operator.equals("+")) {
            return num1 + num2;
        }

        return num1 - num2;
    }
}
