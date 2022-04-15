package com.company.tests;

import com.company.MyMatrix;
import com.company.types.MyDouble;
import com.company.types.MyFloat;
import com.company.types.MyFraction;
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
        List<MyFloat> listToMat = new ArrayList<>();
        MyFloat l1 = new MyFloat(2F);
        MyFloat l2 = new MyFloat(5F);
        MyFloat l3 = new MyFloat(1F);
        MyFloat l4 = new MyFloat(-2F);
        Collections.addAll(listToMat, l1, l2, l3, l4);
        MyMatrix<MyFloat> sut = new MyMatrix<>(2, 2, listToMat);
        List<MyFloat> listToMat2 = new ArrayList<>();
        MyFloat l5 = new MyFloat(3F);
        MyFloat l6 = new MyFloat(-1F);
        MyFloat l7 = new MyFloat(7F);
        MyFloat l8 = new MyFloat(4F);
        Collections.addAll(listToMat2, l5, l6, l7, l8);
        MyMatrix<MyFloat> sut2 = new MyMatrix<>(2, 2, listToMat2);
        List<List<Float>> res = new ArrayList<>();
        List<Float> row1 = new ArrayList<>();
        List<Float> row2 = new ArrayList<>();
        Collections.addAll(row1, 5F, 4F);
        Collections.addAll(row2, 8F, 2F);
        Collections.addAll(res, row1, row2);
        sut = sut.addingMatrix(sut2);
        assertEquals("Add matrix float", res, sut.getNumber());
    }

    @Test
    public void testAddMatrixDouble() {
        List<MyDouble> listToMat = new ArrayList<>();
        MyDouble l1 = new MyDouble(2.0);
        MyDouble l2 = new MyDouble(5.0);
        MyDouble l3 = new MyDouble(1.0);
        MyDouble l4 = new MyDouble(-2.0);
        Collections.addAll(listToMat, l1, l2, l3, l4);
        MyMatrix<MyDouble> sut = new MyMatrix<>(2, 2, listToMat);
        List<MyDouble> listToMat2 = new ArrayList<>();
        MyDouble l5 = new MyDouble(3.0);
        MyDouble l6 = new MyDouble(-1.0);
        MyDouble l7 = new MyDouble(7.0);
        MyDouble l8 = new MyDouble(4.0);
        Collections.addAll(listToMat2, l5, l6, l7, l8);
        MyMatrix<MyDouble> sut2 = new MyMatrix<>(2, 2, listToMat2);
        List<List<Double>> res = new ArrayList<>();
        List<Double> row1 = new ArrayList<>();
        List<Double> row2 = new ArrayList<>();
        Collections.addAll(row1, 5.0, 4.0);
        Collections.addAll(row2, 8.0, 2.0);
        Collections.addAll(res, row1, row2);
        sut = sut.addingMatrix(sut2);
        assertEquals("Add matrix double", res, sut.getNumber());
    }

    @Test
    public void testAddMatrixFraction() {
        List<MyFraction> listToMat = new ArrayList<>();
        MyFraction l1 = new MyFraction(BigInteger.ONE, BigInteger.valueOf(4));
        MyFraction l2 = new MyFraction(BigInteger.valueOf(3), BigInteger.valueOf(4));
        MyFraction l3 = new MyFraction(BigInteger.valueOf(2), BigInteger.valueOf(3));
        MyFraction l4 = new MyFraction(BigInteger.valueOf(1), BigInteger.valueOf(6));
        Collections.addAll(listToMat, l1, l2, l3, l4);
        MyMatrix<MyFraction> sut = new MyMatrix<>(2, 2, listToMat);
        List<MyFraction> listToMat2 = new ArrayList<>();
        MyFraction l5 = new MyFraction(BigInteger.valueOf(3), BigInteger.valueOf(4));
        MyFraction l6 = new MyFraction(BigInteger.valueOf(1), BigInteger.valueOf(3));
        MyFraction l7 = new MyFraction(BigInteger.valueOf(4), BigInteger.valueOf(6));
        MyFraction l8 = new MyFraction(BigInteger.valueOf(3), BigInteger.valueOf(4));
        Collections.addAll(listToMat2, l5, l6, l7, l8);
        MyMatrix<MyFraction> sut2 = new MyMatrix<>(2, 2, listToMat2);
        List<List<BigDecimal>> res = new ArrayList<>();
        List<BigDecimal> row1 = new ArrayList<>();
        List<BigDecimal> row2 = new ArrayList<>();
        Collections.addAll(row1, new MyFraction(BigInteger.ONE, BigInteger.ONE).returnValue(), new MyFraction(BigInteger.valueOf(13), BigInteger.valueOf(12)).returnValue());
        Collections.addAll(row2, new MyFraction(BigInteger.valueOf(4), BigInteger.valueOf(3)).returnValue(), new MyFraction(BigInteger.valueOf(11), BigInteger.valueOf(12)).returnValue());
        Collections.addAll(res, row1, row2);
        sut = sut.addingMatrix(sut2);
        List<List<BigDecimal>> result = new ArrayList<>();
        for (int i = 0; i < sut.getMatrix().size(); i++) {
            List<BigDecimal> temp = new ArrayList<>();
            for (int j = 0; j < sut.getMatrix().get(i).size(); j++) {
                temp.add(sut.getMatrix().get(i).get(j).getNumber());
            }
            result.add(temp);
        }
        assertEquals("Add matrix fraction", res, result);
    }

    @Test
    public void testMulMatrixFloat() {
        List<MyFloat> listToMat = new ArrayList<>();
        MyFloat l1 = new MyFloat(2F);
        MyFloat l2 = new MyFloat(5F);
        MyFloat l3 = new MyFloat(1F);
        MyFloat l4 = new MyFloat(-2F);
        Collections.addAll(listToMat, l1, l2, l3, l4);
        MyMatrix<MyFloat> sut = new MyMatrix<>(2, 2, listToMat);
        List<MyFloat> listToMat2 = new ArrayList<>();
        MyFloat l5 = new MyFloat(3F);
        MyFloat l6 = new MyFloat(-1F);
        MyFloat l7 = new MyFloat(7F);
        MyFloat l8 = new MyFloat(4F);
        Collections.addAll(listToMat2, l5, l6, l7, l8);
        MyMatrix<MyFloat> sut2 = new MyMatrix<>(2, 2, listToMat2);
        List<List<Float>> res = new ArrayList<>();
        List<Float> row1 = new ArrayList<>();
        List<Float> row2 = new ArrayList<>();
        Collections.addAll(row1, 41F, 18F);
        Collections.addAll(row2, -11F, -9F);
        Collections.addAll(res, row1, row2);
        MyMatrix<MyFloat> result = sut.multiplyMatrix(sut2);
        assertEquals("Multiply matrix float", res, result.getNumber());
    }

    @Test
    public void testMulMatrixDouble() {
        List<MyDouble> listToMat = new ArrayList<>();
        MyDouble l1 = new MyDouble(2.0);
        MyDouble l2 = new MyDouble(5.0);
        MyDouble l3 = new MyDouble(1.0);
        MyDouble l4 = new MyDouble(-2.0);
        Collections.addAll(listToMat, l1, l2, l3, l4);
        MyMatrix<MyDouble> sut = new MyMatrix<>(2, 2, listToMat);
        List<MyDouble> listToMat2 = new ArrayList<>();
        MyDouble l5 = new MyDouble(3.0);
        MyDouble l6 = new MyDouble(-1.0);
        MyDouble l7 = new MyDouble(7.0);
        MyDouble l8 = new MyDouble(4.0);
        Collections.addAll(listToMat2, l5, l6, l7, l8);
        MyMatrix<MyDouble> sut2 = new MyMatrix<>(2, 2, listToMat2);
        List<List<Double>> res = new ArrayList<>();
        List<Double> row1 = new ArrayList<>();
        List<Double> row2 = new ArrayList<>();
        Collections.addAll(row1, 41.0, 18.0);
        Collections.addAll(row2, -11.0, -9.0);
        Collections.addAll(res, row1, row2);
        MyMatrix<MyDouble> result = sut.multiplyMatrix(sut2);
        assertEquals("Multiply matrix double", res, result.getNumber());
    }

    @Test
    public void testMulMatrixFraction() {
        List<MyFraction> listToMat = new ArrayList<>();
        MyFraction l1 = new MyFraction(BigInteger.ONE, BigInteger.valueOf(4));
        MyFraction l2 = new MyFraction(BigInteger.valueOf(3), BigInteger.valueOf(4));
        MyFraction l3 = new MyFraction(BigInteger.valueOf(2), BigInteger.valueOf(3));
        MyFraction l4 = new MyFraction(BigInteger.valueOf(1), BigInteger.valueOf(6));
        Collections.addAll(listToMat, l1, l2, l3, l4);
        MyMatrix<MyFraction> sut = new MyMatrix<>(2, 2, listToMat);
        List<MyFraction> listToMat2 = new ArrayList<>();
        MyFraction l5 = new MyFraction(BigInteger.valueOf(3), BigInteger.valueOf(4));
        MyFraction l6 = new MyFraction(BigInteger.valueOf(1), BigInteger.valueOf(3));
        MyFraction l7 = new MyFraction(BigInteger.valueOf(4), BigInteger.valueOf(6));
        MyFraction l8 = new MyFraction(BigInteger.valueOf(3), BigInteger.valueOf(4));
        Collections.addAll(listToMat2, l5, l6, l7, l8);
        MyMatrix<MyFraction> sut2 = new MyMatrix<>(2, 2, listToMat2);
        List<List<BigDecimal>> res = new ArrayList<>();
        List<BigDecimal> row1 = new ArrayList<>();
        List<BigDecimal> row2 = new ArrayList<>();
        Collections.addAll(row1, new MyFraction(BigInteger.valueOf(11), BigInteger.valueOf(16)).getNumber(), new MyFraction(BigInteger.valueOf(31), BigInteger.valueOf(48)).getNumber());
        Collections.addAll(row2, new MyFraction(BigInteger.valueOf(11), BigInteger.valueOf(18)).getNumber(), new MyFraction(BigInteger.valueOf(25), BigInteger.valueOf(72)).getNumber());
        Collections.addAll(res, row1, row2);
        MyMatrix<MyFraction> resultM = sut.multiplyMatrix(sut2);
        List<List<BigDecimal>> result = new ArrayList<>();
        for (int i = 0; i < sut.getMatrix().size(); i++) {
            List<BigDecimal> temp = new ArrayList<>();
            for (int j = 0; j < sut.getMatrix().get(i).size(); j++) {
                temp.add(sut.getMatrix().get(i).get(j).getNumber());
            }
            result.add(temp);
        }
        assertEquals("Multiply matrix fraction", res, resultM.getNumber());
    }

    @Test
    public void testMyMatrixGaussG() {
        List<MyDouble> listToMat = new ArrayList<>();
        MyDouble l1 = new MyDouble(1.2);
        MyDouble l2 = new MyDouble(2.6);
        MyDouble l3 = new MyDouble(-0.1);
        MyDouble l4 = new MyDouble(1.5);
        MyDouble l5 = new MyDouble(4.5);
        MyDouble l6 = new MyDouble(9.8);
        MyDouble l7 = new MyDouble(-0.4);
        MyDouble l8 = new MyDouble(5.7);
        MyDouble l9 = new MyDouble(0.1);
        MyDouble l10 = new MyDouble(-0.1);
        MyDouble l11 = new MyDouble(-0.3);
        MyDouble l12 = new MyDouble(-3.5);
        MyDouble l13 = new MyDouble(4.5);
        MyDouble l14 = new MyDouble(-5.2);
        MyDouble l15 = new MyDouble(4.2);
        MyDouble l16 = new MyDouble(-3.4);
        MyDouble p1 = new MyDouble(13.15);
        MyDouble p2 = new MyDouble(49.84);
        MyDouble p3 = new MyDouble(-14.08);
        MyDouble p4 = new MyDouble(-46.51);
        Collections.addAll(listToMat, l1, l2, l3, l4, p1, l5, l6, l7, l8, p2, l9, l10, l11, l12, p3, l13, l14, l15, l16, p4);
        MyMatrix<MyDouble> sut = new MyMatrix<>(4, 5, listToMat);
        List<MyDouble> temp = sut.gaussMatrixG();
        List<Double> temp2 = new ArrayList<>();
        for (int i = 0; i < temp.size(); i++) {
            temp2.add(temp.get(i).getNumber());
        }
        List<Double> res = new ArrayList<>();
        Collections.addAll(res, -1.3, 3.2, -2.4, 4.1);
        assertEquals("Gauss G 1 value", res.get(0), temp2.get(0), 0.000000000001);
        assertEquals("Gauss G 2 value", res.get(1), temp2.get(1), 0.000000000001);
        assertEquals("Gauss G 3 value", res.get(2), temp2.get(2), 0.000000000001);
        assertEquals("Gauss G 4 value", res.get(3), temp2.get(3), 0.000000000001);
    }

    @Test
    public void testMyMatrixGaussPG() {
        List<MyDouble> listToMat = new ArrayList<>();
        MyDouble l1 = new MyDouble(1.2);
        MyDouble l2 = new MyDouble(2.6);
        MyDouble l3 = new MyDouble(-0.1);
        MyDouble l4 = new MyDouble(1.5);
        MyDouble l5 = new MyDouble(4.5);
        MyDouble l6 = new MyDouble(9.8);
        MyDouble l7 = new MyDouble(-0.4);
        MyDouble l8 = new MyDouble(5.7);
        MyDouble l9 = new MyDouble(0.1);
        MyDouble l10 = new MyDouble(-0.1);
        MyDouble l11 = new MyDouble(-0.3);
        MyDouble l12 = new MyDouble(-3.5);
        MyDouble l13 = new MyDouble(4.5);
        MyDouble l14 = new MyDouble(-5.2);
        MyDouble l15 = new MyDouble(4.2);
        MyDouble l16 = new MyDouble(-3.4);
        MyDouble p1 = new MyDouble(13.15);
        MyDouble p2 = new MyDouble(49.84);
        MyDouble p3 = new MyDouble(-14.08);
        MyDouble p4 = new MyDouble(-46.51);
        Collections.addAll(listToMat, l1, l2, l3, l4, p1, l5, l6, l7, l8, p2, l9, l10, l11, l12, p3, l13, l14, l15, l16, p4);
        MyMatrix<MyDouble> sut = new MyMatrix<>(4, 5, listToMat);
        List<MyDouble> temp = sut.gaussMatrixPG();
        List<Double> temp2 = new ArrayList<>();
        for (int i = 0; i < temp.size(); i++) {
            temp2.add(temp.get(i).getNumber());
        }
        List<Double> res = new ArrayList<>();
        Collections.addAll(res, -1.3, 3.2, -2.4, 4.1);
        assertEquals("Gauss PG 1 value", res.get(0), temp2.get(0), 0.000000000001);
        assertEquals("Gauss PG 2 value", res.get(1), temp2.get(1), 0.000000000001);
        assertEquals("Gauss PG 3 value", res.get(2), temp2.get(2), 0.000000000001);
        assertEquals("Gauss PG 4 value", res.get(3), temp2.get(3), 0.000000000001);
    }

    @Test
    public void testMyMatrixGaussFG() {
        List<MyDouble> listToMat = new ArrayList<>();
        MyDouble l1 = new MyDouble(1.2);
        MyDouble l2 = new MyDouble(2.6);
        MyDouble l3 = new MyDouble(-0.1);
        MyDouble l4 = new MyDouble(1.5);
        MyDouble l5 = new MyDouble(4.5);
        MyDouble l6 = new MyDouble(9.8);
        MyDouble l7 = new MyDouble(-0.4);
        MyDouble l8 = new MyDouble(5.7);
        MyDouble l9 = new MyDouble(0.1);
        MyDouble l10 = new MyDouble(-0.1);
        MyDouble l11 = new MyDouble(-0.3);
        MyDouble l12 = new MyDouble(-3.5);
        MyDouble l13 = new MyDouble(4.5);
        MyDouble l14 = new MyDouble(-5.2);
        MyDouble l15 = new MyDouble(4.2);
        MyDouble l16 = new MyDouble(-3.4);
        MyDouble p1 = new MyDouble(13.15);
        MyDouble p2 = new MyDouble(49.84);
        MyDouble p3 = new MyDouble(-14.08);
        MyDouble p4 = new MyDouble(-46.51);
        Collections.addAll(listToMat, l1, l2, l3, l4, p1, l5, l6, l7, l8, p2, l9, l10, l11, l12, p3, l13, l14, l15, l16, p4);
        MyMatrix<MyDouble> sut = new MyMatrix<>(4, 5, listToMat);
        List<MyDouble> temp = sut.gaussMatrixFG();
        List<Double> temp2 = new ArrayList<>();
        for (int i = 0; i < temp.size(); i++) {
            temp2.add(temp.get(i).getNumber());
        }
        List<Double> res = new ArrayList<>();
        Collections.addAll(res, -1.3, 3.2, -2.4, 4.1);
        assertEquals("Gauss FG 1 value", res.get(0), temp2.get(0), 0.000000000001);
        assertEquals("Gauss FG 2 value", res.get(1), temp2.get(1), 0.000000000001);
        assertEquals("Gauss FG 3 value", res.get(2), temp2.get(2), 0.000000000001);
        assertEquals("Gauss FG 4 value", res.get(3), temp2.get(3), 0.000000000001);
    }
}
