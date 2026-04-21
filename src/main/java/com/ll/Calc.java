package com.ll;

public class Calc {
    public static int run(String expression) {
        expression = expression.trim();

        if (expression.contains("(")) {
            int openIndex = expression.lastIndexOf("(");
            int closeIndex = expression.indexOf(")", openIndex);
            String bracketExpression = expression.substring(openIndex + 1, closeIndex);
            int bracketResult = run(bracketExpression);
            String replacedExpression = expression.substring(0, openIndex)
                    + bracketResult
                    + expression.substring(closeIndex + 1);

            return run(replacedExpression);
        }

        if (isWrappedByBrackets(expression)) {
            return run(expression.substring(1, expression.length() - 1));
        }

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

    private static boolean isWrappedByBrackets(String expression) {
        return expression.startsWith("(") && expression.endsWith(")");
    }
}
