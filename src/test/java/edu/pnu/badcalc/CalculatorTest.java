package edu.pnu.badcalc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private final Calculator calc = new Calculator();

    @Test
    void testAdd() {
        assertEquals(5.0, calc.add(2, 3));
    }

    @Test
    void testSubtract() {
        assertEquals(-2.0, calc.subtract(3, 5));
    }

    @Test
    void testMultiply() {
        assertEquals(7.5, calc.multiply(2.5, 3));
    }

    @Test
    void testDivide() {
        assertEquals(2.0, calc.divide(10, 5));
    }

    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class,
                () -> calc.divide(5, 0));
    }

    @Test
    void testFactorial() {
        assertEquals(120, calc.factorial(5));
    }

    @Test
    void testParseAndCompute_Add() {
        assertEquals(7.0, calc.parseAndCompute("3 + 4"));
    }

    @Test
    void testParseAndCompute_NoSpaces() {
        assertEquals(5.0, calc.parseAndCompute("2+3"));
    }

    @Test
    void testParseAndCompute_MultipleSpaces() {
        assertEquals(8.0, calc.parseAndCompute("  5   +   3  "));
    }
}
