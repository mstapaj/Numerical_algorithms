package com.company;

public class MyDouble implements MyNumber<Double> {
    private Double value;

    public MyDouble(double value) {
        this.value = value;
    }

    @Override
    public Double getValue() {
        return this.value;
    }

    public void setValue(Double another) {
        this.value = another;
    }

    @Override
    public void add(Double another) {
        this.value += another;
    }

    @Override
    public void sub(Double another) {
        this.value = this.value - another;
    }

    @Override
    public void mul(Double another) {
        this.value = this.value * another;
    }

    @Override
    public void div(Double another) {
        this.value = this.value / another;
    }

    @Override
    public MyDouble initialize() {
        return new MyDouble(0);
    }

    @Override
    public MyDouble return_new() {
        return new MyDouble(value);
    }
}
