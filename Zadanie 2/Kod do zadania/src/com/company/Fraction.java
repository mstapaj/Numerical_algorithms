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

    private BigInteger LCM(BigInteger a, BigInteger b) {
        if (a.signum() == 0 || b.signum() == 0) {
            return BigInteger.ZERO;
        }
        return a.divide(a.gcd(b)).multiply(b).abs();
    }

    public Fraction adding_frac(Fraction frac) {
        BigInteger lcm = LCM(this.getDenumerator(), frac.getDenumerator());
        BigInteger first_mul = lcm.divide(this.getDenumerator());
        BigInteger sec_mul = lcm.divide(frac.getDenumerator());
        BigInteger new_numerator = this.getNumerator().multiply(first_mul).add(frac.getNumerator().multiply(sec_mul));
        BigInteger gcd = new_numerator.gcd(lcm);
        return new Fraction(new_numerator.divide(gcd), lcm.divide(gcd));
//        return new Fraction(new_numerator, lcm);
    }

    public Fraction substract_frac(Fraction frac) {
        BigInteger lcm = LCM(this.getDenumerator(), frac.getDenumerator());
        BigInteger first_mul = lcm.divide(this.getDenumerator());
        BigInteger sec_mul = lcm.divide(frac.getDenumerator());
        BigInteger new_numerator = this.getNumerator().multiply(first_mul).subtract(frac.getNumerator().multiply(sec_mul));
        BigInteger gcd = new_numerator.gcd(lcm);
        return new Fraction(new_numerator.divide(gcd), lcm.divide(gcd));
//        return new Fraction(new_numerator, lcm);
    }

    public Fraction multiply_frac(Fraction frac) {
        BigInteger new_numerator = this.getNumerator().multiply(frac.getNumerator());
        BigInteger new_denumerator = this.getDenumerator().multiply(frac.getDenumerator());
        BigInteger gcd = new_numerator.gcd(new_denumerator);
        return new Fraction(new_numerator.divide(gcd), new_denumerator.divide(gcd));
//        return new Fraction(new_numerator, new_denumerator);
    }

    public Fraction divide_frac(Fraction frac) {
        BigInteger new_numerator = this.getNumerator().multiply(frac.getDenumerator());
        BigInteger new_denumerator = this.getDenumerator().multiply(frac.getNumerator());
        BigInteger gcd = new_numerator.gcd(new_denumerator);
        return new Fraction(new_numerator.divide(gcd), new_denumerator.divide(gcd));
//        return new Fraction(new_numerator, new_denumerator);
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

