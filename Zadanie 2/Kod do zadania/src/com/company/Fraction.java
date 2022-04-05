package com.company;

import java.math.BigInteger;

public class Fraction {
    private BigInteger numerator;
    private BigInteger denumerator;

    public Fraction(BigInteger numerator, BigInteger denumerator) {
        this.numerator = numerator;
        this.denumerator = denumerator;
    }

    public BigInteger getNumerator() {
        return numerator;
    }

    public void setNumerator(BigInteger numerator) {
        this.numerator = numerator;
    }

    public BigInteger getDenumerator() {
        return denumerator;
    }

    public void setDenumerator(BigInteger denumerator) {
        this.denumerator = denumerator;
    }
}
