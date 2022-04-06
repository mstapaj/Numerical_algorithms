package com.company;

import java.math.BigInteger;

interface MyNumber<T> {

    default MyNumber<T> initialize() {
        return this;
    }

    default MyNumber<T> return_new() {
        return this;
    }

    default BigInteger getNumerator() {
        return null;
    }

    default BigInteger getDenumerator() {
        return null;
    }

    default void add(T value) {
    }

    default void sub(T value) {
    }

    default void mul(T value) {
    }

    default void div(T value) {
    }

    default void setZero() {
    }

    default T getValue() {
        return null;
    }

    void shorten();
}
