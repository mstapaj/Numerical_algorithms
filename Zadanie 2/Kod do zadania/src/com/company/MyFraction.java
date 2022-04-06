package com.company;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

public class MyFraction extends MyNumber<Fraction> {
    private final Fraction frac;

    public MyFraction(BigInteger numerator, BigInteger denumerator) {
        this.frac = new Fraction(numerator, denumerator);
    }

    public void setZero() {
        this.frac.setNumerator(BigInteger.ZERO);
        this.frac.setDenumerator(BigInteger.ONE);
    }

    public Fraction getValue() {
        return this.frac;
    }

    public BigInteger getNumerator() {
        return this.frac.getNumerator();
    }

    public BigInteger getDenumerator() {
        return this.frac.getDenumerator();
    }

    public BigDecimal getDecimalValue() {
        return new BigDecimal(this.frac.getNumerator()).divide(new BigDecimal(this.frac.getDenumerator()), MathContext.DECIMAL128);
    }

    private BigInteger LCM(BigInteger a, BigInteger b) {
        if (a.signum() == 0 || b.signum() == 0) {
            return BigInteger.ZERO;
        }
        return a.divide(a.gcd(b)).multiply(b).abs();
    }

    public void add(Fraction frac) {
        BigInteger lcm = LCM(this.frac.getDenumerator(), frac.getDenumerator());
        BigInteger first_mul = lcm.divide(this.frac.getDenumerator());
        BigInteger sec_mul = lcm.divide(frac.getDenumerator());
        this.frac.setNumerator(this.frac.getNumerator().multiply(first_mul).add(frac.getNumerator().multiply(sec_mul)));
        this.frac.setDenumerator(lcm);
//        BigInteger gcd = new_numerator.gcd(lcm);
//        return new Fraction(new_numerator.divide(gcd), lcm.divide(gcd));
    }

    public void sub(Fraction frac) {
        BigInteger lcm = LCM(this.frac.getDenumerator(), frac.getDenumerator());
        BigInteger first_mul = lcm.divide(this.frac.getDenumerator());
        BigInteger sec_mul = lcm.divide(frac.getDenumerator());
        this.frac.setNumerator(this.frac.getNumerator().multiply(first_mul).subtract(frac.getNumerator().multiply(sec_mul)));
        this.frac.setDenumerator(lcm);
    }

    public void mul(Fraction frac) {
        this.frac.setNumerator(this.frac.getNumerator().multiply(frac.getNumerator()));
        this.frac.setDenumerator(this.frac.getDenumerator().multiply(frac.getDenumerator()));
//        BigInteger gcd = new_numerator.gcd(new_denumerator);
    }

    public void div(Fraction frac) {
        this.frac.setNumerator(this.frac.getDenumerator().multiply(frac.getDenumerator()));
        this.frac.setDenumerator(this.frac.getNumerator().multiply(frac.getNumerator()));
    }
}
