package com.company.types;//package com.company;

import com.company.MyNumber;

import java.math.BigDecimal;

public class MyDouble implements MyNumber<MyDouble> {
    public Double value;

    public MyDouble(Double value) {
        this.value = value;
    }

    @Override
    public void add(MyDouble a) {
        this.value = this.value + a.value;
    }

    @Override
    public void sub(MyDouble a) {
        this.value = this.value - a.value;

    }

    @Override
    public void mul(MyDouble a) {
        this.value = this.value * a.value;

    }

    @Override
    public void div(MyDouble a) {
        this.value = this.value / a.value;

    }

    @Override
    public MyDouble initialize() {
        return new MyDouble(this.value);
    }

    @Override
    public MyDouble absolute() {
        return new MyDouble(Math.abs(this.value));
    }

    @Override
    public MyDouble initialize_zero() {
        return new MyDouble(0D);
    }

    @Override
    public Integer compare(MyDouble a) {
        return this.value.compareTo(a.value);
    }

    @Override
    public BigDecimal returnValue() {
        return BigDecimal.valueOf(this.value);
    }

    public Double getNumber() {
        return this.value;
    }

    public MyDouble getValue() {
        return this;
    }

    @Override
    public MyDouble shorten() {
        return this;
    }
}
