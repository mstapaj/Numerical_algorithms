package com.company;

public class MyFloat implements MyNumber<Float> {
    private Float value;

    public MyFloat(float value) {
        this.value = value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    @Override
    public Float getValue() {
        return this.value;
    }

    @Override
    public void shorten() {

    }

    @Override
    public void add(Float another) {
        this.value += another;
    }

    @Override
    public void sub(Float another) {
        this.value = this.value - another;
    }

    @Override
    public void mul(Float another) {
        this.value = this.value * another;
    }

    @Override
    public void div(Float another) {
        this.value = this.value / another;
    }

    @Override
    public MyFloat initialize() {
        return new MyFloat(0F);
    }

    @Override
    public MyFloat return_new() {
        return new MyFloat(value);
    }
}
