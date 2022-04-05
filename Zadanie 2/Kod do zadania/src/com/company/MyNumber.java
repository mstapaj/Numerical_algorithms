package com.company;

import java.math.BigInteger;

abstract class MyNumber<T> {

    void setValue() {
    }

    public abstract BigInteger getNumerator();

    public abstract BigInteger getDenumerator();

    void add(T value) {
    }

    void sub(T value) {
    }

    void mul(T value) {
    }

    void div(T value) {
    }

    void setZero() {
    }

    public abstract T getValue();
}
