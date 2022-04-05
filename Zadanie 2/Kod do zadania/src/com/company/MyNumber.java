package com.company;

import java.math.BigInteger;

abstract class MyNumber<T> {

    void setValue() {
    }

    BigInteger getNumerator() {
        return null;
    }

    ;

    BigInteger getDenumerator() {
        return null;
    }

    ;

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
