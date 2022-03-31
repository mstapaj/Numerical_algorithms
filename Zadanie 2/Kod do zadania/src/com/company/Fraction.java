package com.company;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static com.company.Main.LCM;

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

    public Fraction adding_frac(Fraction frac) {
        BigInteger lcm = LCM(this.getDenumerator(), frac.getDenumerator());
        BigInteger first_mul = lcm.divide(this.getDenumerator());
        BigInteger sec_mul = lcm.divide(frac.getDenumerator());
        BigInteger new_numerator = this.getNumerator().multiply(first_mul).add(frac.getNumerator().multiply(sec_mul));
        BigInteger gcd = new_numerator.gcd(lcm);
        return new Fraction(new_numerator.divide(gcd), lcm.divide(gcd));
    }

    public Fraction substract_frac(Fraction a, Fraction b) {
        BigInteger lcm = LCM(a.getDenumerator(), b.getDenumerator());
        BigInteger first_mul = lcm.divide(a.getDenumerator());
        BigInteger sec_mul = lcm.divide(b.getDenumerator());
        BigInteger new_numerator = a.getNumerator().multiply(first_mul).subtract(b.getNumerator().multiply(sec_mul));
        BigInteger gcd = new_numerator.gcd(lcm);
        return new Fraction(new_numerator.divide(gcd), lcm.divide(gcd));
    }

    public Fraction multiply_frac(Fraction frac) {
        BigInteger new_numerator = this.getNumerator().multiply(frac.getNumerator());
        BigInteger new_denumerator = this.getDenumerator().multiply(frac.getDenumerator());
        BigInteger gcd = new_numerator.gcd(new_denumerator);
        return new Fraction(new_numerator.divide(gcd), new_denumerator.divide(gcd));
    }

    public Fraction divide_frac(Fraction a, Fraction b) {
        BigInteger new_numerator = a.getNumerator().multiply(b.getDenumerator());
        BigInteger new_denumerator = a.getDenumerator().multiply(b.getNumerator());
        BigInteger gcd = new_numerator.gcd(new_denumerator);
        return new Fraction(new_numerator.divide(gcd), new_denumerator.divide(gcd));
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

