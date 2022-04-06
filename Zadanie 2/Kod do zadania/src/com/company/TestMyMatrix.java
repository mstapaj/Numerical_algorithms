package com.company;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class TestMyMatrix {
    @Test
    public void testAddMatrixFloat() {
        List<MyNumber<Float>> listToMat = new ArrayList<>();
        MyNumber<Float> l1 = new MyFloat(2F);
        MyNumber<Float> l2 = new MyFloat(5F);
        MyNumber<Float> l3 = new MyFloat(1F);
        MyNumber<Float> l4 = new MyFloat(-2F);
        Collections.addAll(listToMat, l1, l2, l3, l4);
        MyMatrix<Float> sut = new MyMatrix<>(2, 2, listToMat);
        List<MyNumber<Float>> listToMat2 = new ArrayList<>();
        MyNumber<Float> l5 = new MyFloat(3F);
        MyNumber<Float> l6 = new MyFloat(-1F);
        MyNumber<Float> l7 = new MyFloat(7F);
        MyNumber<Float> l8 = new MyFloat(4F);
        Collections.addAll(listToMat2, l5, l6, l7, l8);
        MyMatrix<Float> sut2 = new MyMatrix<>(2, 2, listToMat2);
        List<List<Float>> res = new ArrayList<>();
        List<Float> row1 = new ArrayList<>();
        List<Float> row2 = new ArrayList<>();
        Collections.addAll(row1, 5F, 4F);
        Collections.addAll(row2, 8F, 2F);
        Collections.addAll(res, row1, row2);
        sut.addingMatrix(sut2);
        assertEquals("Add matrix float", res, sut.getMatrix());
    }

    @Test
    public void testAddMatrixDouble() {
        List<MyNumber<Double>> listToMat = new ArrayList<>();
        MyNumber<Double> l1 = new MyDouble(2.0);
        MyNumber<Double> l2 = new MyDouble(5.0);
        MyNumber<Double> l3 = new MyDouble(1.0);
        MyNumber<Double> l4 = new MyDouble(-2.0);
        Collections.addAll(listToMat, l1, l2, l3, l4);
        MyMatrix<Double> sut = new MyMatrix<>(2, 2, listToMat);
        List<MyNumber<Double>> listToMat2 = new ArrayList<>();
        MyNumber<Double> l5 = new MyDouble(3.0);
        MyNumber<Double> l6 = new MyDouble(-1.0);
        MyNumber<Double> l7 = new MyDouble(7.0);
        MyNumber<Double> l8 = new MyDouble(4.0);
        Collections.addAll(listToMat2, l5, l6, l7, l8);
        MyMatrix<Double> sut2 = new MyMatrix<>(2, 2, listToMat2);
        List<List<Double>> res = new ArrayList<>();
        List<Double> row1 = new ArrayList<>();
        List<Double> row2 = new ArrayList<>();
        Collections.addAll(row1, 5.0, 4.0);
        Collections.addAll(row2, 8.0, 2.0);
        Collections.addAll(res, row1, row2);
        sut.addingMatrix(sut2);
        assertEquals("Add matrix double", res, sut.getMatrix());
    }

    @Test
    public void testAddMatrixFraction() {
        List<MyNumber<Fraction>> listToMat = new ArrayList<>();
        MyNumber<Fraction> l1 = new MyFraction(BigInteger.ONE, BigInteger.valueOf(4));
        MyNumber<Fraction> l2 = new MyFraction(BigInteger.valueOf(3), BigInteger.valueOf(4));
        MyNumber<Fraction> l3 = new MyFraction(BigInteger.valueOf(2), BigInteger.valueOf(3));
        MyNumber<Fraction> l4 = new MyFraction(BigInteger.valueOf(1), BigInteger.valueOf(6));
        Collections.addAll(listToMat, l1, l2, l3, l4);
        MyMatrix<Fraction> sut = new MyMatrix<>(2, 2, listToMat);
        List<MyNumber<Fraction>> listToMat2 = new ArrayList<>();
        MyNumber<Fraction> l5 = new MyFraction(BigInteger.valueOf(3), BigInteger.valueOf(4));
        MyNumber<Fraction> l6 = new MyFraction(BigInteger.valueOf(1), BigInteger.valueOf(3));
        MyNumber<Fraction> l7 = new MyFraction(BigInteger.valueOf(4), BigInteger.valueOf(6));
        MyNumber<Fraction> l8 = new MyFraction(BigInteger.valueOf(3), BigInteger.valueOf(4));
        Collections.addAll(listToMat2, l5, l6, l7, l8);
        MyMatrix<Fraction> sut2 = new MyMatrix<>(2, 2, listToMat2);
        List<List<BigDecimal>> res = new ArrayList<>();
        List<BigDecimal> row1 = new ArrayList<>();
        List<BigDecimal> row2 = new ArrayList<>();
        Collections.addAll(row1, new Fraction(BigInteger.ONE, BigInteger.ONE).getFraction(), new Fraction(BigInteger.valueOf(13), BigInteger.valueOf(12)).getFraction());
        Collections.addAll(row2, new Fraction(BigInteger.valueOf(4), BigInteger.valueOf(3)).getFraction(), new Fraction(BigInteger.valueOf(11), BigInteger.valueOf(12)).getFraction());
        Collections.addAll(res, row1, row2);
        sut.addingMatrix(sut2);
        List<List<BigDecimal>> result = new ArrayList<>();
        for (int i = 0; i < sut.getMatrix().size(); i++) {
            List<BigDecimal> temp = new ArrayList<>();
            for (int j = 0; j < sut.getMatrix().get(i).size(); j++) {
                temp.add(sut.getMatrix().get(i).get(j).getFraction());
            }
            result.add(temp);
        }
        assertEquals("Add matrix fraction", res, result);
    }

    @Test
    public void testMulMatrixFloat() {
        List<MyNumber<Float>> listToMat = new ArrayList<>();
        MyNumber<Float> l1 = new MyFloat(2F);
        MyNumber<Float> l2 = new MyFloat(5F);
        MyNumber<Float> l3 = new MyFloat(1F);
        MyNumber<Float> l4 = new MyFloat(-2F);
        Collections.addAll(listToMat, l1, l2, l3, l4);
        MyMatrix<Float> sut = new MyMatrix<>(2, 2, listToMat);
        List<MyNumber<Float>> listToMat2 = new ArrayList<>();
        MyNumber<Float> l5 = new MyFloat(3F);
        MyNumber<Float> l6 = new MyFloat(-1F);
        MyNumber<Float> l7 = new MyFloat(7F);
        MyNumber<Float> l8 = new MyFloat(4F);
        Collections.addAll(listToMat2, l5, l6, l7, l8);
        MyMatrix<Float> sut2 = new MyMatrix<>(2, 2, listToMat2);
        List<List<Float>> res = new ArrayList<>();
        List<Float> row1 = new ArrayList<>();
        List<Float> row2 = new ArrayList<>();
        Collections.addAll(row1, 41F, 18F);
        Collections.addAll(row2, -11F, -9F);
        Collections.addAll(res, row1, row2);
        sut.multiplyMatrix(sut2);
        assertEquals("Multiply matrix float", res, sut.getMatrix());
    }

    @Test
    public void testMulMatrixDouble() {
        List<MyNumber<Double>> listToMat = new ArrayList<>();
        MyNumber<Double> l1 = new MyDouble(2.0);
        MyNumber<Double> l2 = new MyDouble(5.0);
        MyNumber<Double> l3 = new MyDouble(1.0);
        MyNumber<Double> l4 = new MyDouble(-2.0);
        Collections.addAll(listToMat, l1, l2, l3, l4);
        MyMatrix<Double> sut = new MyMatrix<>(2, 2, listToMat);
        List<MyNumber<Double>> listToMat2 = new ArrayList<>();
        MyNumber<Double> l5 = new MyDouble(3.0);
        MyNumber<Double> l6 = new MyDouble(-1.0);
        MyNumber<Double> l7 = new MyDouble(7.0);
        MyNumber<Double> l8 = new MyDouble(4.0);
        Collections.addAll(listToMat2, l5, l6, l7, l8);
        MyMatrix<Double> sut2 = new MyMatrix<>(2, 2, listToMat2);
        List<List<Double>> res = new ArrayList<>();
        List<Double> row1 = new ArrayList<>();
        List<Double> row2 = new ArrayList<>();
        Collections.addAll(row1, 41.0, 18.0);
        Collections.addAll(row2, -11.0, -9.0);
        Collections.addAll(res, row1, row2);
        sut.multiplyMatrix(sut2);
        assertEquals("Multiply matrix double", res, sut.getMatrix());
    }

    @Test
    public void testMulMatrixFraction() {
        List<MyNumber<Fraction>> listToMat = new ArrayList<>();
        MyNumber<Fraction> l1 = new MyFraction(BigInteger.ONE, BigInteger.valueOf(4));
        MyNumber<Fraction> l2 = new MyFraction(BigInteger.valueOf(3), BigInteger.valueOf(4));
        MyNumber<Fraction> l3 = new MyFraction(BigInteger.valueOf(2), BigInteger.valueOf(3));
        MyNumber<Fraction> l4 = new MyFraction(BigInteger.valueOf(1), BigInteger.valueOf(6));
        Collections.addAll(listToMat, l1, l2, l3, l4);
        MyMatrix<Fraction> sut = new MyMatrix<>(2, 2, listToMat);
        List<MyNumber<Fraction>> listToMat2 = new ArrayList<>();
        MyNumber<Fraction> l5 = new MyFraction(BigInteger.valueOf(3), BigInteger.valueOf(4));
        MyNumber<Fraction> l6 = new MyFraction(BigInteger.valueOf(1), BigInteger.valueOf(3));
        MyNumber<Fraction> l7 = new MyFraction(BigInteger.valueOf(4), BigInteger.valueOf(6));
        MyNumber<Fraction> l8 = new MyFraction(BigInteger.valueOf(3), BigInteger.valueOf(4));
        Collections.addAll(listToMat2, l5, l6, l7, l8);
        MyMatrix<Fraction> sut2 = new MyMatrix<>(2, 2, listToMat2);
        List<List<BigDecimal>> res = new ArrayList<>();
        List<BigDecimal> row1 = new ArrayList<>();
        List<BigDecimal> row2 = new ArrayList<>();
        Collections.addAll(row1, new Fraction(BigInteger.valueOf(11), BigInteger.valueOf(16)).getFraction(), new Fraction(BigInteger.valueOf(31), BigInteger.valueOf(48)).getFraction());
        Collections.addAll(row2, new Fraction(BigInteger.valueOf(11), BigInteger.valueOf(18)).getFraction(), new Fraction(BigInteger.valueOf(25), BigInteger.valueOf(72)).getFraction());
        Collections.addAll(res, row1, row2);
        sut.multiplyMatrix(sut2);
        List<List<BigDecimal>> result = new ArrayList<>();
        for (int i = 0; i < sut.getMatrix().size(); i++) {
            List<BigDecimal> temp = new ArrayList<>();
            for (int j = 0; j < sut.getMatrix().get(i).size(); j++) {
                temp.add(sut.getMatrix().get(i).get(j).getFraction());
            }
            result.add(temp);
        }
        assertEquals("Multiply matrix fraction", res, result);
    }

//    @Test
//    public void testAddMatrixDouble() {
//        List<MyNumber<Double>> listToMat = new ArrayList<>();
//        MyNumber<Double> l1 = new MyDouble(2.0);
//        MyNumber<Double> l2 = new MyDouble(5.0);
//        MyNumber<Double> l3 = new MyDouble(1.0);
//        MyNumber<Double> l4 = new MyDouble(-2.0);
//        Collections.addAll(listToMat, l1, l2, l3, l4);
//        MyMatrix<Double> sut = new MyMatrix<>(2, 2, listToMat);
//        List<MyNumber<Double>> listToMat2 = new ArrayList<>();
//        MyNumber<Double> l5 = new MyDouble(3.0);
//        MyNumber<Double> l6 = new MyDouble(-1.0);
//        MyNumber<Double> l7 = new MyDouble(7.0);
//        MyNumber<Double> l8 = new MyDouble(4.0);
//        Collections.addAll(listToMat2, l5, l6, l7, l8);
//        MyMatrix<Double> sut2 = new MyMatrix<>(2, 2, listToMat2);
//        List<List<Double>> res = new ArrayList<>();
//        List<Double> row1 = new ArrayList<>();
//        List<Double> row2 = new ArrayList<>();
//        Collections.addAll(row1, 5.0, 4.0);
//        Collections.addAll(row2, 8.0, 2.0);
//        Collections.addAll(res, row1, row2);
//        sut.addingMatrix(sut2);
//        assertEquals("Add matrix float", res, sut.getMatrix());
//    }
//
//    @Test
//    public void testAddMatrixFraction() {
//        List<MyNumber<Fraction>> listToMat = new ArrayList<>();
//        MyNumber<Fraction> l1 = new MyFraction(BigInteger.ONE, BigInteger.valueOf(4));
//        MyNumber<Fraction> l2 = new MyFraction(BigInteger.valueOf(3), BigInteger.valueOf(4));
//        MyNumber<Fraction> l3 = new MyFraction(BigInteger.valueOf(2), BigInteger.valueOf(3));
//        MyNumber<Fraction> l4 = new MyFraction(BigInteger.valueOf(1), BigInteger.valueOf(6));
//        Collections.addAll(listToMat, l1, l2, l3, l4);
//        MyMatrix<Fraction> sut = new MyMatrix<>(2, 2, listToMat);
//        List<MyNumber<Fraction>> listToMat2 = new ArrayList<>();
//        MyNumber<Fraction> l5 = new MyFraction(BigInteger.valueOf(3), BigInteger.valueOf(4));
//        MyNumber<Fraction> l6 = new MyFraction(BigInteger.valueOf(1), BigInteger.valueOf(3));
//        MyNumber<Fraction> l7 = new MyFraction(BigInteger.valueOf(4), BigInteger.valueOf(6));
//        MyNumber<Fraction> l8 = new MyFraction(BigInteger.valueOf(3), BigInteger.valueOf(4));
//        Collections.addAll(listToMat2, l5, l6, l7, l8);
//        MyMatrix<Fraction> sut2 = new MyMatrix<>(2, 2, listToMat2);
//        List<List<BigDecimal>> res = new ArrayList<>();
//        List<BigDecimal> row1 = new ArrayList<>();
//        List<BigDecimal> row2 = new ArrayList<>();
//        Collections.addAll(row1, new Fraction(BigInteger.ONE, BigInteger.ONE).getFraction(), new Fraction(BigInteger.valueOf(13), BigInteger.valueOf(12)).getFraction());
//        Collections.addAll(row2, new Fraction(BigInteger.valueOf(4), BigInteger.valueOf(3)).getFraction(), new Fraction(BigInteger.valueOf(11), BigInteger.valueOf(12)).getFraction());
//        Collections.addAll(res, row1, row2);
//        sut.addingMatrix(sut2);
//        List<List<BigDecimal>> result = new ArrayList<>();
//        for (int i = 0; i < sut.getMatrix().size(); i++) {
//            List<BigDecimal> temp = new ArrayList<>();
//            for (int j = 0; j < sut.getMatrix().get(i).size(); j++) {
//                temp.add(sut.getMatrix().get(i).get(j).getFraction());
//            }
//            result.add(temp);
//        }
//        assertEquals("Add matrix float", res, result);
//    }
}
