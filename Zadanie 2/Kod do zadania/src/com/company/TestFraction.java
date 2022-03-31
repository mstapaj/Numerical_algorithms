package com.company;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class TestFraction {
    private Fraction first;
    private Fraction second;

    @Before
    public void beforeEachTestMethod() {
        first = new Fraction(BigInteger.ONE, BigInteger.valueOf(17));
        second = new Fraction(BigInteger.TWO, BigInteger.valueOf(6));
    }

    @Test
    public void testAddFraction() {
        List<BigInteger> res = new ArrayList<>();
        Collections.addAll(res, BigInteger.valueOf(20), BigInteger.valueOf(51));
        assertEquals("Add fraction", res, first.adding_frac(second).getFraction());
    }

    @Test
    public void testSubFraction() {
        List<BigInteger> res = new ArrayList<>();
        Collections.addAll(res, BigInteger.valueOf(-14), BigInteger.valueOf(51));
        assertEquals("Substract fraction", res, first.substract_frac(second).getFraction());
    }

    @Test
    public void testMulFraction() {
        List<BigInteger> res = new ArrayList<>();
        Collections.addAll(res, BigInteger.valueOf(1), BigInteger.valueOf(51));
        assertEquals("Multiply fraction", res, first.multiply_frac(second).getFraction());
    }

    @Test
    public void testDivFraction() {
        List<BigInteger> res = new ArrayList<>();
        Collections.addAll(res, BigInteger.valueOf(3), BigInteger.valueOf(17));
        assertEquals("Divide fraction", res, first.divide_frac(second).getFraction());
    }

    @After
    public void after() throws Exception {
        first = null;
        second = null;
    }


}
