package com.company;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Fraction extends Number {
    private BigInteger numerator;
    private BigInteger denumerator;

    public BigInteger getNumerator() {
        return numerator;
    }

    public void setNumerator(BigInteger numerator) {
        this.numerator = numerator;
    }

    public BigInteger getDenumerator() {
        return denumerator;
    }

    public List<BigInteger> getFraction() {
        List<BigInteger> res = new ArrayList<>();
        res.add(numerator);
        res.add(denumerator);
        return res;
    }

    public void setDenumerator(BigInteger denumerator) {
        this.denumerator = denumerator;
    }

    public Fraction(BigInteger a, BigInteger b) {
        this.numerator = a;
        this.denumerator = b;
    }

    @Override
    public int intValue() {
        return 0;
    }

    @Override
    public long longValue() {
        return 0;
    }

    @Override
    public float floatValue() {
        return 0;
    }

    @Override
    public double doubleValue() {
        return 0;
    }
}

