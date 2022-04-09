package com.company.types;

import com.company.MyNumber;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

public class MyFraction implements MyNumber<MyFraction> {
    public BigInteger numerator;
    public BigInteger denumerator;

    private BigInteger LCM(BigInteger a, BigInteger b) {
        if (a.signum() == 0 || b.signum() == 0) {
            return BigInteger.ZERO;
        }
        return a.divide(a.gcd(b)).multiply(b).abs();
    }

    public MyFraction(BigInteger numerator, BigInteger denumerator) {
        this.numerator = numerator;
        this.denumerator = denumerator;
    }

    @Override
    public void add(MyFraction frac) {
        BigInteger lcm = LCM(this.denumerator, frac.denumerator);
        BigInteger first_mul = lcm.divide(this.denumerator);
        BigInteger sec_mul = lcm.divide(frac.denumerator);
        this.numerator = this.numerator.multiply(first_mul).add(frac.numerator.multiply(sec_mul));
        this.denumerator = lcm;

    }

    @Override
    public void sub(MyFraction frac) {
        BigInteger lcm = LCM(this.denumerator, frac.denumerator);
        BigInteger first_mul = lcm.divide(this.denumerator);
        BigInteger sec_mul = lcm.divide(frac.denumerator);
        this.numerator = this.numerator.multiply(first_mul).subtract(frac.numerator.multiply(sec_mul));
        this.denumerator = lcm;
    }

    @Override
    public void mul(MyFraction frac) {
        this.numerator = this.numerator.multiply(frac.numerator);
        this.denumerator = this.denumerator.multiply(frac.denumerator);
    }

    @Override
    public void div(MyFraction frac) {
        this.numerator = this.numerator.divide(frac.numerator);
        this.denumerator = this.denumerator.divide(frac.denumerator);
    }

    @Override
    public MyFraction initialize() {
        return new MyFraction(this.numerator, this.denumerator);
    }

    @Override
    public MyFraction absolute() {
        return null;
    }

    @Override
    public MyFraction initialize_zero() {
        return new MyFraction(BigInteger.ZERO, BigInteger.ONE);
    }

    @Override
    public Integer compare(MyFraction a) {
        return null;
    }

    @Override
    public BigDecimal returnValue() {
        return new BigDecimal(this.numerator).divide(new BigDecimal(this.denumerator), MathContext.DECIMAL128);
    }

    public BigDecimal getNumber() {
        return new BigDecimal(this.numerator).divide(new BigDecimal(this.denumerator), MathContext.DECIMAL128);
    }

    public MyFraction getValue() {
        return this;
    }

//    @Override
//    public Fraction getValue() {
//        return this.frac;
//    }
//
//    @Override
//    public void setValue(Fraction value) {
//        this.frac = value;
//    }
//
//    public BigInteger getNumerator() {
//        return this.frac.getNumerator();
//    }
//
//    public BigInteger getDenumerator() {
//        return this.frac.getDenumerator();
//    }
//
//    public BigDecimal getDecimalValue() {
//        return new BigDecimal(this.frac.getNumerator()).divide(new BigDecimal(this.frac.getDenumerator()), MathContext.DECIMAL128);
//    }
//
//    private BigInteger LCM(BigInteger a, BigInteger b) {
//        if (a.signum() == 0 || b.signum() == 0) {
//            return BigInteger.ZERO;
//        }
//        return a.divide(a.gcd(b)).multiply(b).abs();
//    }
//
//    @Override
//    public void shorten() {
//        BigInteger gcd = this.frac.getNumerator().gcd(this.frac.getDenumerator());
//        this.frac.setNumerator(this.frac.getNumerator().divide(gcd));
//        this.frac.setDenumerator(this.frac.getDenumerator().divide(gcd));
//    }
//
//
//
//
//
//    @Override
//    public void div(Fraction frac) {
//        this.frac.setNumerator(this.frac.getDenumerator().multiply(frac.getDenumerator()));
//        this.frac.setDenumerator(this.frac.getNumerator().multiply(frac.getNumerator()));
//    }
//
//    @Override
//    public MyFraction return_new() {
//        return new MyFraction(frac.getNumerator(), frac.getDenumerator());
//    }
//
//    @Override
//    public Fraction initialize_zero() {
//        return new Fraction(BigInteger.ZERO, BigInteger.ONE);
//    }
}
