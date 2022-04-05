package com.company;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

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

    public BigDecimal getFraction() {
        return new BigDecimal(this.numerator).divide(new BigDecimal(this.getDenumerator()), MathContext.DECIMAL128);
    }
}
