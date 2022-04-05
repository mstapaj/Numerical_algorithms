package com.company;

public class MyFloat extends MyNumber<Float> {
    private Float value;

    public MyFloat(float value) {
        this.value = value;
    }

    public MyFloat() {
        this.value = 0F;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public void setZero() {
        this.value = 0F;
    }

    public Float getValue() {
        return this.value;
    }

    public void add(Float another) {
        this.value += another;
    }

    public void sub(Float another) {
        this.value = this.value - another;
    }

    public void mul(Float another) {
        this.value = this.value * another;
    }

    public void div(Float another) {
        this.value = this.value / another;
    }
}
