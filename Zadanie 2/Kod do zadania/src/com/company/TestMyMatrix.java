package com.company;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class TestMyMatrix {
    @Test
    public void testAddMatrixFloat() {
        List<Float> listToMat = new ArrayList<>();
        Collections.addAll(listToMat, 2F, 5F, 1F, -2F);
        MyMatrix<Float> sut = new MyMatrix<>(2, 2, listToMat);
        List<Float> listToMat2 = new ArrayList<>();
        Collections.addAll(listToMat2, 3F, -1F, 7F, 4F);
        MyMatrix<Float> sut2 = new MyMatrix<>(2, 2, listToMat2);
        List<List<Float>> res = new ArrayList<>();
        List<Float> row1 = new ArrayList<>();
        List<Float> row2 = new ArrayList<>();
        Collections.addAll(row1, 5F, 4F);
        Collections.addAll(row2, 8F, 2F);
        Collections.addAll(res, row1, row2);
        assertEquals("Add matrix float", res, sut.addingMatrix(sut2).getMatrix());
    }

    @Test
    public void testAddMatrixDouble() {
        List<Double> listToMat = new ArrayList<>();
        Collections.addAll(listToMat, 2.0, 5.0, 1.0, -2.0);
        MyMatrix<Double> sut = new MyMatrix<>(2, 2, listToMat);
        List<Double> listToMat2 = new ArrayList<>();
        Collections.addAll(listToMat2, 3.0, -1.0, 7.0, 4.0);
        MyMatrix<Double> sut2 = new MyMatrix<>(2, 2, listToMat2);
        List<List<Double>> res = new ArrayList<>();
        List<Double> row1 = new ArrayList<>();
        List<Double> row2 = new ArrayList<>();
        Collections.addAll(row1, 5.0, 4.0);
        Collections.addAll(row2, 8.0, 2.0);
        Collections.addAll(res, row1, row2);
        assertEquals("Add matrix double", res, sut.addingMatrix(sut2).getMatrix());
    }

    @Test
    public void testMulMatrixFloat() {
        List<Float> listToMat = new ArrayList<>();
        Collections.addAll(listToMat, 2F, 5F, 1F, -2F);
        MyMatrix<Float> sut = new MyMatrix<>(2, 2, listToMat);
        List<Float> listToMat2 = new ArrayList<>();
        Collections.addAll(listToMat2, 3F, -1F, 7F, 4F);
        MyMatrix<Float> sut2 = new MyMatrix<>(2, 2, listToMat2);
        List<List<Float>> res = new ArrayList<>();
        List<Float> row1 = new ArrayList<>();
        List<Float> row2 = new ArrayList<>();
        Collections.addAll(row1, 41F, 18F);
        Collections.addAll(row2, -11F, -9F);
        Collections.addAll(res, row1, row2);
        assertEquals("Add matrix float", res, sut.multiplyMatrix(sut2).getMatrix());
    }

    @Test
    public void testMulMatrixDouble() {
        List<Double> listToMat = new ArrayList<>();
        Collections.addAll(listToMat, 2.0, 5.0, 1.0, -2.0);
        MyMatrix<Double> sut = new MyMatrix<>(2, 2, listToMat);
        List<Double> listToMat2 = new ArrayList<>();
        Collections.addAll(listToMat2, 3.0, -1.0, 7.0, 4.0);
        MyMatrix<Double> sut2 = new MyMatrix<>(2, 2, listToMat2);
        List<List<Double>> res = new ArrayList<>();
        List<Double> row1 = new ArrayList<>();
        List<Double> row2 = new ArrayList<>();
        Collections.addAll(row1, 41.0, 18.0);
        Collections.addAll(row2, -11.0, -9.0);
        Collections.addAll(res, row1, row2);
        assertEquals("Add matrix double", res, sut.multiplyMatrix(sut2).getMatrix());
    }


}
