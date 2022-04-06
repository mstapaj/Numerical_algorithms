package com.company;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

public class MyFraction implements MyNumber<Fraction> {
    private final Fraction frac;

    public MyFraction(BigInteger numerator, BigInteger denumerator) {
        this.frac = new Fraction(numerator, denumerator);
    }

    public void setZero() {
        this.frac.setNumerator(BigInteger.ZERO);
        this.frac.setDenumerator(BigInteger.ONE);
    }

    @Override
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

    @Override
    public void shorten() {
        BigInteger gcd = this.frac.getNumerator().gcd(this.frac.getDenumerator());
        this.frac.setNumerator(this.frac.getNumerator().divide(gcd));
        this.frac.setDenumerator(this.frac.getDenumerator().divide(gcd));
    }

    @Override
    public void add(Fraction frac) {
        BigInteger lcm = LCM(this.frac.getDenumerator(), frac.getDenumerator());
        BigInteger first_mul = lcm.divide(this.frac.getDenumerator());
        BigInteger sec_mul = lcm.divide(frac.getDenumerator());
        this.frac.setNumerator(this.frac.getNumerator().multiply(first_mul).add(frac.getNumerator().multiply(sec_mul)));
        this.frac.setDenumerator(lcm);
//        BigInteger gcd = this.frac.getNumerator().gcd(lcm);
//        this.frac.setDenumerator(lcm.divide(gcd));
//        this.frac.setNumerator(this.frac.getNumerator().divide(gcd));
//        return new Fraction(new_numerator.divide(gcd), lcm.divide(gcd));
    }

    @Override
    public void sub(Fraction frac) {
        BigInteger lcm = LCM(this.frac.getDenumerator(), frac.getDenumerator());
        BigInteger first_mul = lcm.divide(this.frac.getDenumerator());
        BigInteger sec_mul = lcm.divide(frac.getDenumerator());
        this.frac.setNumerator(this.frac.getNumerator().multiply(first_mul).subtract(frac.getNumerator().multiply(sec_mul)));
        this.frac.setDenumerator(lcm);
    }

    @Override
    public void mul(Fraction frac) {
        this.frac.setNumerator(this.frac.getNumerator().multiply(frac.getNumerator()));
        this.frac.setDenumerator(this.frac.getDenumerator().multiply(frac.getDenumerator()));
//        BigInteger gcd = this.frac.getNumerator().gcd(this.frac.getDenumerator());
//        this.frac.setNumerator(this.frac.getNumerator().divide(gcd));
//        this.frac.setDenumerator(this.frac.getDenumerator().divide(gcd));
    }

    @Override
    public void div(Fraction frac) {
        this.frac.setNumerator(this.frac.getDenumerator().multiply(frac.getDenumerator()));
        this.frac.setDenumerator(this.frac.getNumerator().multiply(frac.getNumerator()));
    }

    @Override
    public MyFraction initialize() {
        return new MyFraction(BigInteger.ZERO, BigInteger.ONE);
    }

    @Override
    public MyFraction return_new() {
        return new MyFraction(frac.getNumerator(), frac.getDenumerator());
    }
}
