package com.company;//package com.company;
//
//import java.math.BigInteger;
//
//public class MyDouble implements MyNumber<MyDouble> {
//    private Double value;
//
//    public MyDouble(double value) {
//        this.value = value;
//    }
//
////    @Override
////    public Double getValue() {
////        return this.value;
////    }
//
//    @Override
//    public void shorten() {
//    }
//
//    @Override
//    public void setZero() {
//        this.value = 0.0;
//    }
//
//    public void setValue(Double another) {
//        this.value = another;
//    }
//
//    @Override
//    public void add(MyDouble another) {
//        this.value += another.value;
//    }
//
//    @Override
//    public void sub(MyDouble another) {
//        this.value = this.value - another.value;
//    }
//
//    @Override
//    public void mul(MyDouble another) {
//        this.value = this.value * another.value;
//    }
//
//    @Override
//    public void div(MyDouble another) {
//        this.value = this.value / another.value;
//    }
//
//    @Override
//    public Double initialize(Double another) {
//        return another;
//    }
//
//    @Override
//    public MyDouble return_new() {
//        return new MyDouble(value);
//    }
//
//    @Override
//    public void add(MyNumber<MyDouble> another) {
//
//    }
//
//    @Override
//    public void sub(MyNumber<MyDouble> another) {
//
//    }
//
//    @Override
//    public void mul(MyNumber<MyDouble> another) {
//
//    }
//
//    @Override
//    public void div(MyNumber<MyDouble> another) {
//
//    }
////
////    @Override
////    public Double initialize_zero(){
////        return 0.0;
////    }
//}

import java.math.BigDecimal;

public class MyDouble implements MyNumber<MyDouble> {
    public Double value;

    public MyDouble(Double value) {
        this.value = value;
    }

    @Override
    public void add(MyDouble a) {
        this.value = this.value + a.value;
    }

    @Override
    public void subtract(MyDouble a) {
        this.value = this.value - a.value;

    }

    @Override
    public void multiply(MyDouble a) {
        this.value = this.value * a.value;

    }

    @Override
    public void divide(MyDouble a) {
        this.value = this.value / a.value;

    }

    @Override
    public MyDouble initialize(MyDouble a) {
        return new MyDouble(a.value);
    }

    @Override
    public MyDouble absolute() {
        return new MyDouble(Math.abs(this.value));
    }

    @Override
    public MyDouble initializeWithZero() {
        return new MyDouble(0D);
    }

    @Override
    public Integer compare(MyDouble a) {
        return this.value.compareTo(a.value);
    }

    @Override
    public BigDecimal returnValue() {
        return BigDecimal.valueOf(this.value);
    }

    public Double getNumber() {
        return this.value;
    }

    public MyDouble getValue() {
        return this;
    }
}
