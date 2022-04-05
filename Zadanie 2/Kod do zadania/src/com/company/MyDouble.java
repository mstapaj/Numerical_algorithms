package com.company;

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
