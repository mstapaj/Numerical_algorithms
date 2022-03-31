package com.company;


import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class TestFraction {

    @Test
    public void testAddFraction() {
        Fraction first = new Fraction(BigInteger.ONE, BigInteger.valueOf(17));
        Fraction second = new Fraction(BigInteger.TWO, BigInteger.valueOf(6));
        List<BigInteger> res = new ArrayList<>();
        Collections.addAll(res, BigInteger.valueOf(20), BigInteger.valueOf(51));
        assertEquals("Add fraction", res, first.adding_frac(second).getFraction());
    }

    @Test
    public void testSubFraction() {
        Fraction first = new Fraction(BigInteger.ONE, BigInteger.valueOf(17));
        Fraction second = new Fraction(BigInteger.TWO, BigInteger.valueOf(6));
        List<BigInteger> res = new ArrayList<>();
        Collections.addAll(res, BigInteger.valueOf(-14), BigInteger.valueOf(51));
        assertEquals("Substract fraction", res, first.substract_frac(second).getFraction());
    }

    @Test
    public void testMulFraction() {
        Fraction first = new Fraction(BigInteger.ONE, BigInteger.valueOf(17));
        Fraction second = new Fraction(BigInteger.TWO, BigInteger.valueOf(6));
        List<BigInteger> res = new ArrayList<>();
        Collections.addAll(res, BigInteger.valueOf(1), BigInteger.valueOf(51));
        assertEquals("Multiply fraction", res, first.multiply_frac(second).getFraction());
    }

    @Test
    public void testDivFraction() {
        Fraction first = new Fraction(BigInteger.ONE, BigInteger.valueOf(17));
        Fraction second = new Fraction(BigInteger.TWO, BigInteger.valueOf(6));
        List<BigInteger> res = new ArrayList<>();
        Collections.addAll(res, BigInteger.valueOf(3), BigInteger.valueOf(17));
        assertEquals("Divide fraction", res, first.divide_frac(second).getFraction());
    }


}
