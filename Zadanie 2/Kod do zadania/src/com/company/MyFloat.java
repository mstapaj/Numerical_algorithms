package com.company;

import java.math.BigDecimal;

public class MyFloat implements MyNumber<MyFloat> {
    public Float value;

    public MyFloat(Float value) {
        this.value = value;
    }


    @Override
    public void add(MyFloat a) {
        this.value = this.value + a.value;
    }

    @Override
    public void subtract(MyFloat a) {
        this.value = this.value - a.value;

    }

    @Override
    public void multiply(MyFloat a) {
        this.value = this.value * a.value;

    }

    @Override
    public void divide(MyFloat a) {
        this.value = this.value / a.value;

    }

    @Override
    public MyFloat initialize(MyFloat a) {
        return new MyFloat(a.value);
    }

    @Override
    public MyFloat absolute() {
        return new MyFloat(Math.abs(this.value));
    }

    @Override
    public MyFloat initializeWithZero() {
        return new MyFloat(0F);
    }

    @Override
    public Integer compare(MyFloat a) {
        return this.value.compareTo(a.value);
    }

    @Override
    public BigDecimal returnValue() {
        return BigDecimal.valueOf(this.value);
    }

    public Float getNumber() {
        return this.value;
    }

    public MyFloat getValue() {
        return this;
    }
}