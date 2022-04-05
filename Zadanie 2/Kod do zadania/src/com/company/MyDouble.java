package com.company;

import java.math.BigInteger;

public class MyDouble extends MyNumber<Double> {
    private Double value;

    public MyDouble(double value) {
        this.value = value;
    }

    public MyDouble() {
        this.value = 0.0;
    }

    public void setZerp() {
        this.value = 0.0;
    }

    public Double getValue() {
        return this.value;
    }

    public void setValue(Double another) {
        this.value = another;
    }

    @Override
    public BigInteger getNumerator() {
        return null;
    }

    @Override
    public BigInteger getDenumerator() {
        return null;
    }

    public void add(Double another) {
        this.value += another;
    }

    public void sub(Double another) {
        this.value = this.value - another;
    }

    public void mul(Double another) {
        this.value = this.value * another;
    }

    public void div(Double another) {
        this.value = this.value / another;
    }
}
