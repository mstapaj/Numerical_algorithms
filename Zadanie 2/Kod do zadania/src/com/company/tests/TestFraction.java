package com.company.tests;


import com.company.types.MyFraction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class TestFraction {
    private MyFraction first;
    private MyFraction second;

    @Before
    public void beforeEachTestMethod() {
        first = new MyFraction(BigInteger.ONE, BigInteger.valueOf(17));
        second = new MyFraction(BigInteger.TWO, BigInteger.valueOf(6));
    }

    @Test
    public void testAddFraction() {
        List<BigInteger> res = new ArrayList<>();
        Collections.addAll(res, BigInteger.valueOf(40), BigInteger.valueOf(102));
        first.add(second);
        List<BigInteger> temp = new ArrayList<>();
        temp.add(first.numerator);
        temp.add(first.denumerator);
        assertEquals("Add fraction", res, temp);
    }

    @Test
    public void testAddFractionWithShorten() {
        List<BigInteger> res = new ArrayList<>();
        Collections.addAll(res, BigInteger.valueOf(20), BigInteger.valueOf(51));
        first.add(second);
        first = first.shorten();
        List<BigInteger> temp = new ArrayList<>();
        temp.add(first.numerator);
        temp.add(first.denumerator);
        assertEquals("Add fraction shorten", res, temp);
    }

    @Test
    public void testSubFraction() {
        List<BigInteger> res = new ArrayList<>();
        Collections.addAll(res, BigInteger.valueOf(-28), BigInteger.valueOf(102));
        first.sub(second);
        List<BigInteger> temp = new ArrayList<>();
        temp.add(first.numerator);
        temp.add(first.denumerator);
        assertEquals("Substract fraction", res, temp);
    }

    @Test
    public void testSubFractionWithShorten() {
        List<BigInteger> res = new ArrayList<>();
        Collections.addAll(res, BigInteger.valueOf(-14), BigInteger.valueOf(51));
        first.sub(second);
        first = first.shorten();
        List<BigInteger> temp = new ArrayList<>();
        temp.add(first.numerator);
        temp.add(first.denumerator);
        assertEquals("Substract fraction shorten", res, temp);
    }

    @Test
    public void testMulFraction() {
        List<BigInteger> res = new ArrayList<>();
        Collections.addAll(res, BigInteger.valueOf(2), BigInteger.valueOf(102));
        first.mul(second);
        List<BigInteger> temp = new ArrayList<>();
        temp.add(first.numerator);
        temp.add(first.denumerator);
        assertEquals("Multiply fraction", res, temp);
    }

    @Test
    public void testMulFractionWithShorten() {
        List<BigInteger> res = new ArrayList<>();
        Collections.addAll(res, BigInteger.valueOf(1), BigInteger.valueOf(51));
        first.mul(second);
        first = first.shorten();
        List<BigInteger> temp = new ArrayList<>();
        temp.add(first.numerator);
        temp.add(first.denumerator);
        assertEquals("Multiply fraction shorten", res, temp);
    }

    @Test
    public void testDivFraction() {
        List<BigInteger> res = new ArrayList<>();
        Collections.addAll(res, BigInteger.valueOf(6), BigInteger.valueOf(34));
        first.div(second);
        List<BigInteger> temp = new ArrayList<>();
        temp.add(first.numerator);
        temp.add(first.denumerator);
        assertEquals("Divide fraction", res, temp);
    }

    @Test
    public void testDivFractionWithShorten() {
        List<BigInteger> res = new ArrayList<>();
        Collections.addAll(res, BigInteger.valueOf(3), BigInteger.valueOf(17));
        first.div(second);
        first = first.shorten();
        List<BigInteger> temp = new ArrayList<>();
        temp.add(first.numerator);
        temp.add(first.denumerator);
        assertEquals("Divide fraction shorten", res, temp);
    }

    @After
    public void after() throws Exception {
        first = null;
        second = null;
    }
}
