package com.company;

import java.math.BigInteger;

abstract class MyNumber<T> {

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

    abstract public T getValue();

    public MyNumber<T> copy(MyFraction ob) {
        return (MyNumber<T>) new MyFraction(ob.getNumerator(), ob.getDenumerator());
    }

    public MyNumber<T> copy(MyDouble ob) {
        return (MyNumber<T>) new MyDouble(ob.getValue());
    }

    public MyNumber<T> copy(MyFloat ob) {
        return (MyNumber<T>) new MyFloat(ob.getValue());
    }


//    public MyNumber<T> copy(Class<T> type,MyNumber<T> a){
//        return new MyDouble(a.getValue());
//    }
//
//    @Override
//    public Object clone() {
//        try {
//            return super.clone();
//        } catch (CloneNotSupportedException e) {
//            throw new AssertionError();
//        }
//    }

//    @Override
//    public MyNumber<T> clone() {
//        try {
//            return (MyNumber<T>) super.clone();
//        } catch (CloneNotSupportedException e) {
//            throw new AssertionError();
//        }
//    }
}
