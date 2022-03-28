package com.company;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Fraction {
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
}

