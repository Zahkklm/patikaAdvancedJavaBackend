package com.patika;

public class ScientificCalculator {

    // 4 temel işlem
    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        if (b != 0) {
            return a / b;
        } else {
            throw new ArithmeticException("Division by zero");
        }
    }

    // Üs alma
    public static double power(double base, int exponent) {
        double result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }

    // Karekök alma
    public static double squareRoot(double value) {
        if (value < 0) {
            throw new ArithmeticException("Cannot take the square root of a negative number");
        }
        double epsilon = 1e-10;
        double guess = value;
        while (Math.abs(guess * guess - value) > epsilon) {
            guess = (guess + value / guess) / 2;
        }
        return guess;
    }

    // Faktöriyel hesaplama
    public static long factorial(int n) {
        if (n < 0) {
            throw new ArithmeticException("Factorial is not defined for negative numbers");
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // Mod alma
    public static double mod(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero in modulus operation");
        }
        return a % b;
    }

    // Mutlak değer hesaplama
    public static double absoluteValue(double value) {
        return value < 0 ? -value : value;
    }

    // Türev alma
    public static double derivative(double[] coefficients, double x) {
        int degree = coefficients.length - 1;
        double result = 0;
        for (int i = 1; i <= degree; i++) {
            result += i * coefficients[i] * power(x, i - 1);
        }
        return result;
    }

    // Integral alma (yaklaşık)
    public static double integral(double[] coefficients, double lowerBound, double upperBound, int n) {
        double deltaX = (upperBound - lowerBound) / n;
        double area = 0;
        for (int i = 0; i < n; i++) {
            double x = lowerBound + i * deltaX;
            double fx = polynomialValue(coefficients, x);
            area += fx * deltaX;
        }
        return area;
    }

    // Polinom değeri hesaplama
    private static double polynomialValue(double[] coefficients, double x) {
        double result = 0;
        int degree = coefficients.length - 1;
        for (int i = 0; i <= degree; i++) {
            result += coefficients[i] * power(x, i);
        }
        return result;
    }

    // Test etme
    public static void main(String[] args) {
        double a = 5;
        double b = 3;
        System.out.println("Addition: " + add(a, b));
        System.out.println("Subtraction: " + subtract(a, b));
        System.out.println("Multiplication: " + multiply(a, b));
        System.out.println("Division: " + divide(a, b));
        System.out.println("Power: " + power(a, 3));
        System.out.println("Square Root: " + squareRoot(25));
        System.out.println("Factorial: " + factorial(5));
        System.out.println("Modulus: " + mod(a, b));
        System.out.println("Absolute Value: " + absoluteValue(-a));

        // Derivative example
        double[] coefficients = {1, -2, 3}; // Represents 3x^2 - 2x + 1
        System.out.println("Derivative at x=2: " + derivative(coefficients, 2));

        // Integral example
        System.out.println("Integral from 0 to 2: " + integral(coefficients, 0, 2, 1000));
    }
}
