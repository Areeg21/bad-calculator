package edu.pnu.badcalc;

public class Calculator {

    // Stores the last computed result
    private double lastResult;

    public double add(double operand1, double operand2) {
        lastResult = operand1 + operand2;
        return lastResult;
    }

    public double subtract(double operand1, double operand2) {
        lastResult = operand1 - operand2;
        return lastResult;
    }

    public double multiply(double operand1, double operand2) {
        lastResult = operand1 * operand2;
        return lastResult;
    }

    public double divide(double operand1, double operand2) {
        if (operand2 == 0) {
            throw new ArithmeticException("Division by zero");
        }
        lastResult = operand1 / operand2;
        return lastResult;
    }

    public long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial not defined for negative numbers");
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        lastResult = result;
        return result;
    }

    /**
     * Parses and computes a simple expression.
     * Supported formats:
     *   "2+3", "2 + 3", "  2   +   3  ", "10/5", etc.
     */
    public double parseAndCompute(String expression) {
        if (expression == null || expression.trim().isEmpty()) {
            throw new IllegalArgumentException("Expression cannot be empty");
        }

        // Remove all whitespace to support: "2+3", "2 + 3", "2   +   3"
        expression = expression.replaceAll("\\s+", "");

        // Find the operator position
        int opIndex = -1;
        char operator = ' ';

        for (char c : new char[]{'+', '-', '*', '/'}) {
            int index = expression.indexOf(c);
            if (index != -1) {
                opIndex = index;
                operator = c;
                break;
            }
        }

        if (opIndex == -1) {
            throw new IllegalArgumentException("No valid operator found in expression");
        }

        // Split expression into two operands
        double operand1 = Double.parseDouble(expression.substring(0, opIndex));
        double operand2 = Double.parseDouble(expression.substring(opIndex + 1));

        switch (operator) {
            case '+':
                return add(operand1, operand2);
            case '-':
                return subtract(operand1, operand2);
            case '*':
                return multiply(operand1, operand2);
            case '/':
                return divide(operand1, operand2);
            default:
                throw new IllegalArgumentException("Unsupported operator: " + operator);
        }
    }

    public double getLastResult() {
        return lastResult;
    }
}
