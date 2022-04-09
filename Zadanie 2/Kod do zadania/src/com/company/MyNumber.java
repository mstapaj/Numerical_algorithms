package com.company;

import java.math.BigDecimal;

public interface MyNumber<T> {
    void add(T a);

    void subtract(T a);

    void multiply(T a);

    void divide(T a);

    T initialize(T a);

    T absolute();

    T initializeWithZero();

    Integer compare(T a);

    BigDecimal returnValue();

    Number getNumber();

    T getValue();
}
