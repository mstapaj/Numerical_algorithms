package com.company;

import java.math.BigDecimal;

public interface MyNumber<T> {
    void add(T a);

    void sub(T a);

    void mul(T a);

    void div(T a);

    T initialize();

    T absolute();

    T initialize_zero();

    Integer compare(T a);

    BigDecimal returnValue();

    Number getNumber();

    T getValue();
}
