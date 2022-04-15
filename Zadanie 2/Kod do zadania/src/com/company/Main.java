package com.company;

import com.company.types.MyDouble;
import com.company.types.MyFloat;
import com.company.types.MyFraction;

import java.io.IOException;

public class Main {


//    public static <T> void print_matrix(List<List<MyNumber<T>>> matrix) {
//        for (int i = 0; i < matrix.size(); i++) {
//            for (int j = 0; j < matrix.get(i).size(); j++) {
//                System.out.print(matrix.get(i).get(j).getValue() + " ");
//            }
//            System.out.println();
//        }
//    }

//    public static void print_fraction_matrix_big_dec(List<List<Fraction>> matrix) {
//        for (int i = 0; i < matrix.size(); i++) {
//            for (int j = 0; j < matrix.size(); j++) {
//                System.out.print(new BigDecimal(matrix.get(i).get(j).divide(matrix.get(i).get(j).getDenumerator())) + " ");
//            }
//            System.out.println();
//        }
//    }

    public static void main(String[] args) throws IOException {


        MatrixOperations<MyFloat> matrixOperationsFloat = new MatrixOperations<>();
        MatrixOperations<MyDouble> matrixOperationsDouble = new MatrixOperations<>();
        MatrixOperations<MyFraction> matrixOperationsFraction = new MatrixOperations<>();
        MatrixLibrary matrixLibrary = new MatrixLibrary();

        ReadMatrixData matrix10 = new ReadMatrixData("10").collectData();
        System.out.println(matrixOperationsFloat.calculate(matrix10.floatMyMatrixA, matrix10.floatMyMatrixB, matrix10.floatMyMatrixC, matrix10.floatMyMatrixX, "float10"));
        System.out.println(matrixOperationsDouble.calculate(matrix10.doubleMyMatrixA, matrix10.doubleMyMatrixB, matrix10.doubleMyMatrixC, matrix10.doubleMyMatrixX, "double10"));
        System.out.println(matrixOperationsFraction.calculate(matrix10.fractionMyMatrixA, matrix10.fractionMyMatrixB, matrix10.fractionMyMatrixC, matrix10.fractionMyMatrixX, "fraction10"));
        System.out.println(matrixLibrary.calculate(matrix10.libraryMatrixA, matrix10.libraryMatrixB, matrix10.libraryMatrixC, matrix10.libraryMatrixX, "library10"));
        matrix10 = null;

        ReadMatrixData matrix20 = new ReadMatrixData("20").collectData();
        System.out.println(matrixOperationsFloat.calculate(matrix20.floatMyMatrixA, matrix20.floatMyMatrixB, matrix20.floatMyMatrixC, matrix20.floatMyMatrixX, "float20"));
        System.out.println(matrixOperationsDouble.calculate(matrix20.doubleMyMatrixA, matrix20.doubleMyMatrixB, matrix20.doubleMyMatrixC, matrix20.doubleMyMatrixX, "double20"));
        System.out.println(matrixOperationsFraction.calculate(matrix20.fractionMyMatrixA, matrix20.fractionMyMatrixB, matrix20.fractionMyMatrixC, matrix20.fractionMyMatrixX, "fraction20"));
        System.out.println(matrixLibrary.calculate(matrix20.libraryMatrixA, matrix20.libraryMatrixB, matrix20.libraryMatrixC, matrix20.libraryMatrixX, "library20"));
        matrix20 = null;

        ReadMatrixData matrix30 = new ReadMatrixData("30").collectData();
        System.out.println(matrixOperationsFloat.calculate(matrix30.floatMyMatrixA, matrix30.floatMyMatrixB, matrix30.floatMyMatrixC, matrix30.floatMyMatrixX, "float30"));
        System.out.println(matrixOperationsDouble.calculate(matrix30.doubleMyMatrixA, matrix30.doubleMyMatrixB, matrix30.doubleMyMatrixC, matrix30.doubleMyMatrixX, "double30"));
        System.out.println(matrixOperationsFraction.calculate(matrix30.fractionMyMatrixA, matrix30.fractionMyMatrixB, matrix30.fractionMyMatrixC, matrix30.fractionMyMatrixX, "fraction30"));
        System.out.println(matrixLibrary.calculate(matrix30.libraryMatrixA, matrix30.libraryMatrixB, matrix30.libraryMatrixC, matrix30.libraryMatrixX, "library30"));
        matrix30 = null;


        ReadMatrixData matrix40 = new ReadMatrixData("40").collectData();
        System.out.println(matrixOperationsFloat.calculate(matrix40.floatMyMatrixA, matrix40.floatMyMatrixB, matrix40.floatMyMatrixC, matrix40.floatMyMatrixX, "float40"));
        System.out.println(matrixOperationsDouble.calculate(matrix40.doubleMyMatrixA, matrix40.doubleMyMatrixB, matrix40.doubleMyMatrixC, matrix40.doubleMyMatrixX, "double40"));
        System.out.println(matrixOperationsFraction.calculate(matrix40.fractionMyMatrixA, matrix40.fractionMyMatrixB, matrix40.fractionMyMatrixC, matrix40.fractionMyMatrixX, "fraction40"));
        System.out.println(matrixLibrary.calculate(matrix40.libraryMatrixA, matrix40.libraryMatrixB, matrix40.libraryMatrixC, matrix40.libraryMatrixX, "library40"));
        matrix40 = null;

        ReadMatrixData matrix50 = new ReadMatrixData("50").collectData();
        System.out.println(matrixOperationsFloat.calculate(matrix50.floatMyMatrixA, matrix50.floatMyMatrixB, matrix50.floatMyMatrixC, matrix50.floatMyMatrixX, "float50"));
        System.out.println(matrixOperationsDouble.calculate(matrix50.doubleMyMatrixA, matrix50.doubleMyMatrixB, matrix50.doubleMyMatrixC, matrix50.doubleMyMatrixX, "double50"));
        System.out.println(matrixOperationsFraction.calculate(matrix50.fractionMyMatrixA, matrix50.fractionMyMatrixB, matrix50.fractionMyMatrixC, matrix50.fractionMyMatrixX, "fraction50"));
        System.out.println(matrixLibrary.calculate(matrix50.libraryMatrixA, matrix50.libraryMatrixB, matrix50.libraryMatrixC, matrix50.libraryMatrixX, "library50"));
        matrix50 = null;

        ReadMatrixData matrix100 = new ReadMatrixData("100").collectData();
        System.out.println(matrixOperationsFloat.calculate(matrix100.floatMyMatrixA, matrix100.floatMyMatrixB, matrix100.floatMyMatrixC, matrix100.floatMyMatrixX, "float100"));
        System.out.println(matrixOperationsDouble.calculate(matrix100.doubleMyMatrixA, matrix100.doubleMyMatrixB, matrix100.doubleMyMatrixC, matrix100.doubleMyMatrixX, "double100"));
        System.out.println(matrixOperationsFraction.calculate(matrix100.fractionMyMatrixA, matrix100.fractionMyMatrixB, matrix100.fractionMyMatrixC, matrix100.fractionMyMatrixX, "fraction100"));
        System.out.println(matrixLibrary.calculate(matrix100.libraryMatrixA, matrix100.libraryMatrixB, matrix100.libraryMatrixC, matrix100.libraryMatrixX, "library100"));
        matrix100 = null;

        ReadMatrixData matrix300 = new ReadMatrixData("300").collectData();
        System.out.println(matrixOperationsFloat.calculate(matrix300.floatMyMatrixA, matrix300.floatMyMatrixB, matrix300.floatMyMatrixC, matrix300.floatMyMatrixX, "float300"));
        System.out.println(matrixOperationsDouble.calculate(matrix300.doubleMyMatrixA, matrix300.doubleMyMatrixB, matrix300.doubleMyMatrixC, matrix300.doubleMyMatrixX, "double300"));
        System.out.println(matrixLibrary.calculate(matrix300.libraryMatrixA, matrix300.libraryMatrixB, matrix300.libraryMatrixC, matrix300.libraryMatrixX, "library300"));
        matrix300 = null;

        ReadMatrixData matrix500 = new ReadMatrixData("500").collectData();
        System.out.println(matrixOperationsFloat.calculate(matrix500.floatMyMatrixA, matrix500.floatMyMatrixB, matrix500.floatMyMatrixC, matrix500.floatMyMatrixX, "float500"));
        System.out.println(matrixOperationsDouble.calculate(matrix500.doubleMyMatrixA, matrix500.doubleMyMatrixB, matrix500.doubleMyMatrixC, matrix500.doubleMyMatrixX, "double500"));
        System.out.println(matrixLibrary.calculate(matrix500.libraryMatrixA, matrix500.libraryMatrixB, matrix500.libraryMatrixC, matrix500.libraryMatrixX, "library500"));
        matrix500 = null;

        // Gauss
        matrix10 = new ReadMatrixData("10").collectData();
        System.out.println(matrixOperationsFloat.calculateGauss(matrix10.floatMyMatrixGaussP, matrix10.floatMyMatrixGaussPG, matrix10.floatMyMatrixGaussFG, "float10Gauss"));
        System.out.println(matrixOperationsDouble.calculateGauss(matrix10.doubleMyMatrixGaussP, matrix10.doubleMyMatrixGaussPG, matrix10.doubleMyMatrixGaussFG, "double10Gauss"));
        System.out.println(matrixOperationsFraction.calculateGauss(matrix10.fractionMyMatrixGaussP, matrix10.fractionMyMatrixGaussPG, matrix10.fractionMyMatrixGaussFG, "fraction10Gauss"));
        System.out.println(matrixLibrary.calculateGauss(matrix10.libraryMatrixGauss, "library10Gauss"));
        matrix10 = null;

        matrix20 = new ReadMatrixData("20").collectData();
        System.out.println(matrixOperationsFloat.calculateGauss(matrix20.floatMyMatrixGaussP, matrix20.floatMyMatrixGaussPG, matrix20.floatMyMatrixGaussFG, "float20Gauss"));
        System.out.println(matrixOperationsDouble.calculateGauss(matrix20.doubleMyMatrixGaussP, matrix20.doubleMyMatrixGaussPG, matrix20.doubleMyMatrixGaussFG, "double20Gauss"));
        System.out.println(matrixOperationsFraction.calculateGauss(matrix20.fractionMyMatrixGaussP, matrix20.fractionMyMatrixGaussPG, matrix20.fractionMyMatrixGaussFG, "fraction20Gauss"));
        System.out.println(matrixLibrary.calculateGauss(matrix20.libraryMatrixGauss, "library20Gauss"));
        matrix20 = null;

        matrix30 = new ReadMatrixData("30").collectData();
        System.out.println(matrixOperationsFloat.calculateGauss(matrix30.floatMyMatrixGaussP, matrix30.floatMyMatrixGaussPG, matrix30.floatMyMatrixGaussFG, "float30Gauss"));
        System.out.println(matrixOperationsDouble.calculateGauss(matrix30.doubleMyMatrixGaussP, matrix30.doubleMyMatrixGaussPG, matrix30.doubleMyMatrixGaussFG, "double30Gauss"));
        System.out.println(matrixOperationsFraction.calculateGauss(matrix30.fractionMyMatrixGaussP, matrix30.fractionMyMatrixGaussPG, matrix30.fractionMyMatrixGaussFG, "fraction30Gauss"));
        System.out.println(matrixLibrary.calculateGauss(matrix30.libraryMatrixGauss, "library30Gauss"));
        matrix30 = null;

        matrix40 = new ReadMatrixData("40").collectData();
        System.out.println(matrixOperationsFloat.calculateGauss(matrix40.floatMyMatrixGaussP, matrix40.floatMyMatrixGaussPG, matrix40.floatMyMatrixGaussFG, "float40Gauss"));
        System.out.println(matrixOperationsDouble.calculateGauss(matrix40.doubleMyMatrixGaussP, matrix40.doubleMyMatrixGaussPG, matrix40.doubleMyMatrixGaussFG, "double40Gauss"));
        System.out.println(matrixOperationsFraction.calculateGauss(matrix40.fractionMyMatrixGaussP, matrix40.fractionMyMatrixGaussPG, matrix40.fractionMyMatrixGaussFG, "fraction40Gauss"));
        System.out.println(matrixLibrary.calculateGauss(matrix40.libraryMatrixGauss, "library40Gauss"));
        matrix40 = null;

        matrix50 = new ReadMatrixData("50").collectData();
        System.out.println(matrixOperationsFloat.calculateGauss(matrix50.floatMyMatrixGaussP, matrix50.floatMyMatrixGaussPG, matrix50.floatMyMatrixGaussFG, "float50Gauss"));
        System.out.println(matrixOperationsDouble.calculateGauss(matrix50.doubleMyMatrixGaussP, matrix50.doubleMyMatrixGaussPG, matrix50.doubleMyMatrixGaussFG, "double50Gauss"));
        System.out.println(matrixOperationsFraction.calculateGauss(matrix50.fractionMyMatrixGaussP, matrix50.fractionMyMatrixGaussPG, matrix50.fractionMyMatrixGaussFG, "fraction50Gauss"));
        System.out.println(matrixLibrary.calculateGauss(matrix50.libraryMatrixGauss, "library50Gauss"));
        matrix50 = null;

        matrix100 = new ReadMatrixData("100").collectData();
        System.out.println(matrixOperationsFloat.calculateGauss(matrix100.floatMyMatrixGaussP, matrix100.floatMyMatrixGaussPG, matrix100.floatMyMatrixGaussFG, "float100Gauss"));
        System.out.println(matrixOperationsDouble.calculateGauss(matrix100.doubleMyMatrixGaussP, matrix100.doubleMyMatrixGaussPG, matrix100.doubleMyMatrixGaussFG, "double100Gauss"));
        System.out.println(matrixLibrary.calculateGauss(matrix100.libraryMatrixGauss, "library100Gauss"));
        matrix100 = null;


        matrix300 = new ReadMatrixData("300").collectData();
        System.out.println(matrixOperationsFloat.calculateGauss(matrix300.floatMyMatrixGaussP, matrix300.floatMyMatrixGaussPG, matrix300.floatMyMatrixGaussFG, "float300Gauss"));
        System.out.println(matrixOperationsDouble.calculateGauss(matrix300.doubleMyMatrixGaussP, matrix300.doubleMyMatrixGaussPG, matrix300.doubleMyMatrixGaussFG, "double300Gauss"));
        System.out.println(matrixLibrary.calculateGauss(matrix300.libraryMatrixGauss, "library300Gauss"));
        matrix300 = null;

        matrix500 = new ReadMatrixData("500").collectData();
        System.out.println(matrixOperationsFloat.calculateGauss(matrix500.floatMyMatrixGaussP, matrix500.floatMyMatrixGaussPG, matrix500.floatMyMatrixGaussFG, "float500Gauss"));
        System.out.println(matrixOperationsDouble.calculateGauss(matrix500.doubleMyMatrixGaussP, matrix500.doubleMyMatrixGaussPG, matrix500.doubleMyMatrixGaussFG, "double500Gauss"));
        System.out.println(matrixLibrary.calculateGauss(matrix500.libraryMatrixGauss, "library500Gauss"));
        matrix500 = null;
    }
}
