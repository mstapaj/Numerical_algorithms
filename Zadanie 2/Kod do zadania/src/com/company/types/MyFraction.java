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
        this.numerator = this.numerator.multiply(frac.denumerator);
        this.denumerator = this.denumerator.multiply(frac.numerator);
    }

    @Override
    public MyFraction initialize() {
        return new MyFraction(this.numerator, this.denumerator);
    }

    @Override
    public MyFraction absolute() {
        return new MyFraction(this.numerator.abs(), this.denumerator);
    }

    @Override
    public MyFraction initialize_zero() {
        return new MyFraction(BigInteger.ZERO, BigInteger.ONE);
    }

    @Override
    public Integer compare(MyFraction frac) {
//        BigInteger lcm = LCM(this.denumerator, frac.denumerator);
//        BigInteger first_mul = lcm.divide(this.denumerator);
//        BigInteger sec_mul = lcm.divide(frac.denumerator);
//        BigInteger n1=new BigInteger(this.numerator.multiply(first_mul).signum());
        BigInteger n1 = new BigInteger(this.numerator.toString());
        BigInteger d1 = new BigInteger(this.denumerator.toString());
        BigInteger n2 = new BigInteger(frac.numerator.toString());
        BigInteger d2 = new BigInteger(frac.denumerator.toString());
        return n1.multiply(d2).compareTo(n2.multiply(d1));
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

    @Override
    public MyFraction shorten() {
        BigInteger gcd = this.numerator.gcd(this.denumerator);
        return new MyFraction(this.numerator.divide(gcd), this.denumerator.divide(gcd));
    }
}
