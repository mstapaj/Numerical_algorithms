package com.company;

import com.company.types.MyDouble;
import com.company.types.MyFloat;
import com.company.types.MyFraction;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

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
        // Wczytanie danych z plików
//        MyMatrix<MyFloat> floatMyMatrixA50 = readMatrixFromFile("floatMatrixA50.txt", "float");
//        MyMatrix<MyFloat> floatMyMatrixB50 = readMatrixFromFile("floatMatrixB50.txt", "float");
//        MyMatrix<MyFloat> floatMyMatrixC50 = readMatrixFromFile("floatMatrixC50.txt", "float");
//        MyMatrix<MyFloat> floatMyMatrixX50 = readMatrixFromFile("floatMatrixX50.txt", "float");
//        MyMatrix<MyFloat> floatMyMatrixGaussP = readMatrixFromFile("floatMatrixGauss.txt", "float");
//        MyMatrix<MyFloat> floatMyMatrixGaussPG = readMatrixFromFile("floatMatrixGauss.txt", "float");
//        MyMatrix<MyFloat> floatMyMatrixGaussFG = readMatrixFromFile("floatMatrixGauss.txt", "float");
//        MyMatrix<MyDouble> doubleMyMatrixA50 = readMatrixFromFile("doubleMatrixA50.txt", "double");
//        MyMatrix<MyDouble> doubleMyMatrixB50 = readMatrixFromFile("doubleMatrixB50.txt", "double");
//        MyMatrix<MyDouble> doubleMyMatrixC50 = readMatrixFromFile("doubleMatrixC50.txt", "double");
//        MyMatrix<MyDouble> doubleMyMatrixX50 = readMatrixFromFile("doubleMatrixX50.txt", "double");
//        MyMatrix<MyDouble> doubleMyMatrixGaussP = readMatrixFromFile("doubleMatrixGauss.txt", "double");
//        MyMatrix<MyDouble> doubleMyMatrixGaussPG = readMatrixFromFile("doubleMatrixGauss.txt", "double");
//        MyMatrix<MyDouble> doubleMyMatrixGaussFG = readMatrixFromFile("doubleMatrixGauss.txt", "double");
//        MyMatrix<MyFraction> fractionMyMatrixA50 = readMatrixFromFile("fractionMatrixA50.txt", "fraction");
//        MyMatrix<MyFraction> fractionMyMatrixB50 = readMatrixFromFile("fractionMatrixB50.txt", "fraction");
//        MyMatrix<MyFraction> fractionMyMatrixC50 = readMatrixFromFile("fractionMatrixC50.txt", "fraction");
//        MyMatrix<MyFraction> fractionMyMatrixX50 = readMatrixFromFile("fractionMatrixX50.txt", "fraction");
//        MyMatrix<MyFraction> fractionMyMatrixGaussP= readMatrixFromFile("fractionMatrixGauss.txt", "fraction");
//        MyMatrix<MyFraction> fractionMyMatrixGaussPG = readMatrixFromFile("fractionMatrixGauss.txt", "fraction");
//        MyMatrix<MyFraction> fractionMyMatrixGaussFG = readMatrixFromFile("fractionMatrixGauss.txt", "fraction");
//        fractionMyMatrixA50 = fractionMyMatrixA50.shortenMatrix();
//        fractionMyMatrixB50 = fractionMyMatrixB50.shortenMatrix();
//        fractionMyMatrixC50 = fractionMyMatrixC50.shortenMatrix();
//        fractionMyMatrixX50 = fractionMyMatrixX50.shortenMatrix();
//        fractionMyMatrixGaussP= fractionMyMatrixGaussP.shortenMatrix();
//        fractionMyMatrixGaussPG = fractionMyMatrixGaussPG.shortenMatrix();
//        fractionMyMatrixGaussFG = fractionMyMatrixGaussFG.shortenMatrix();
//        SimpleMatrix libraryMatrixA50 = makeLibraryMatrix(readMatrixFromFile("doubleMatrixA50.txt", "double").getNumber());
//        SimpleMatrix libraryMatrixB50 = makeLibraryMatrix(readMatrixFromFile("doubleMatrixB50.txt", "double").getNumber());
//        SimpleMatrix libraryMatrixC50 = makeLibraryMatrix(readMatrixFromFile("doubleMatrixC50.txt", "double").getNumber());
//        SimpleMatrix libraryMatrixX50 = makeLibraryMatrix(readMatrixFromFile("doubleMatrixX50.txt", "double").getNumber());
//        SimpleMatrix libraryMatrixGaussP = makeLibraryMatrix(readMatrixFromFile("doubleMatrixGauss.txt", "double").getNumber());
//        SimpleMatrix libraryMatrixGaussPG = makeLibraryMatrix(readMatrixFromFile("doubleMatrixGauss.txt", "double").getNumber());
//        SimpleMatrix libraryMatrixGaussFG = makeLibraryMatrix(readMatrixFromFile("doubleMatrixGauss.txt", "double").getNumber());

        ReadMatrixData matrix50 = new ReadMatrixData("50").collectData();
//        ReadMatrixData matrix100 = new ReadMatrixData("100").collectData();
//        ReadMatrixData matrix200 = new ReadMatrixData("200").collectData();

//
        Instant start;
        Instant end;
        Duration timeElapsed;
//
        MatrixOperations<MyFloat> matrixOperationsFloat = new MatrixOperations<>();
        MatrixOperations<MyDouble> matrixOperationsDouble = new MatrixOperations<>();
        MatrixOperations<MyFraction> matrixOperationsFraction = new MatrixOperations<>();
        MatrixLibrary matrixLibrary = new MatrixLibrary();

//        System.out.println(matrixOperationsFloat.calculate(matrix50.floatMyMatrixA, matrix50.floatMyMatrixB, matrix50.floatMyMatrixC, matrix50.floatMyMatrixX, "float50"));
//        System.out.println(matrixOperationsDouble.calculate(matrix50.doubleMyMatrixA, matrix50.doubleMyMatrixB, matrix50.doubleMyMatrixC, matrix50.doubleMyMatrixX, "double50"));
//        System.out.println(matrixOperationsFraction.calculate(matrix50.fractionMyMatrixA, matrix50.fractionMyMatrixB, matrix50.fractionMyMatrixC, matrix50.fractionMyMatrixX, "fraction50"));
//        System.out.println(matrixLibrary.calculate(matrix50.libraryMatrixA, matrix50.libraryMatrixB, matrix50.libraryMatrixC, matrix50.libraryMatrixX, "library50"));

        System.out.println(matrixOperationsFloat.calculateGauss(matrix50.floatMyMatrixGaussP, matrix50.floatMyMatrixGaussPG, matrix50.floatMyMatrixGaussFG, "float50Gauss"));
        System.out.println(matrixOperationsDouble.calculateGauss(matrix50.doubleMyMatrixGaussP, matrix50.doubleMyMatrixGaussPG, matrix50.doubleMyMatrixGaussFG, "double50Gauss"));
        System.out.println(matrixOperationsFraction.calculateGauss(matrix50.fractionMyMatrixGaussP, matrix50.fractionMyMatrixGaussPG, matrix50.fractionMyMatrixGaussFG, "fraction50Gauss"));
        System.out.println(matrixLibrary.calculateGauss(matrix50.libraryMatrixGauss, "library50Gauss"));
//
//        System.out.println(matrixOperationsFloat.calculate(matrix100.floatMyMatrixA, matrix100.floatMyMatrixB, matrix100.floatMyMatrixC, matrix100.floatMyMatrixX, "float100"));
//        System.out.println(matrixOperationsDouble.calculate(matrix100.doubleMyMatrixA, matrix100.doubleMyMatrixB, matrix100.doubleMyMatrixC, matrix100.doubleMyMatrixX, "double100"));
//        System.out.println(matrixOperationsFraction.calculate(matrix100.fractionMyMatrixA, matrix100.fractionMyMatrixB, matrix100.fractionMyMatrixC, matrix100.fractionMyMatrixX, "fraction100"));
//        System.out.println(matrixLibrary.calculate(matrix100.libraryMatrixA, matrix100.libraryMatrixB, matrix100.libraryMatrixC, matrix100.libraryMatrixX, "library100"));

//        System.out.println(matrixOperationsFloat.calculateGauss(matrix100.floatMyMatrixGaussP, matrix100.floatMyMatrixGaussPG, matrix100.floatMyMatrixGaussFG, "float100Gauss"));
//        System.out.println(matrixOperationsDouble.calculateGauss(matrix100.doubleMyMatrixGaussP, matrix100.doubleMyMatrixGaussPG, matrix100.doubleMyMatrixGaussFG, "double100Gauss"));
//        System.out.println(matrixOperationsFraction.calculateGauss(matrix100.fractionMyMatrixGaussP, matrix100.fractionMyMatrixGaussPG, matrix100.fractionMyMatrixGaussFG, "fraction100Gauss"));
//        System.out.println(matrixLibrary.calculateGauss(matrix100.libraryMatrixGauss, "library100Gauss"));

//        System.out.println(matrixOperationsFloat.calculate(matrix200.floatMyMatrixA, matrix200.floatMyMatrixB, matrix200.floatMyMatrixC, matrix200.floatMyMatrixX, "float200"));
//        System.out.println(matrixOperationsDouble.calculate(matrix200.doubleMyMatrixA, matrix200.doubleMyMatrixB, matrix200.doubleMyMatrixC, matrix200.doubleMyMatrixX, "double200"));
//        System.out.println(matrixOperationsFraction.calculate(matrix200.fractionMyMatrixA, matrix200.fractionMyMatrixB, matrix200.fractionMyMatrixC, matrix200.fractionMyMatrixX, "fraction200"));
//        System.out.println(matrixLibrary.calculate(matrix200.libraryMatrixA, matrix200.libraryMatrixB, matrix200.libraryMatrixC, matrix200.libraryMatrixX, "library200"));
//
//        System.out.println(matrixOperationsFloat.calculateGauss(matrix200.floatMyMatrixGaussP, matrix200.floatMyMatrixGaussPG, matrix200.floatMyMatrixGaussFG, "float200Gauss"));
//        System.out.println(matrixOperationsDouble.calculateGauss(matrix200.doubleMyMatrixGaussP, matrix200.doubleMyMatrixGaussPG, matrix200.doubleMyMatrixGaussFG, "double200Gauss"));
//        System.out.println(matrixOperationsFraction.calculateGauss(matrix200.fractionMyMatrixGaussP, matrix200.fractionMyMatrixGaussPG, matrix200.fractionMyMatrixGaussFG, "fraction200Gauss"));
//        System.out.println(matrixLibrary.calculateGauss(matrix200.libraryMatrixGauss, "library200Gauss"));


//        MyNumber<MyDouble> liczba1 = new MyDouble(2.0);
//        MyNumber<MyDouble> liczba2 = new MyDouble(4.0);
//        liczba1.add(liczba2.getValue());
//        System.out.println(liczba1.getValue().returnValue());
//
//        List<MyFloat> listToMat = new ArrayList<>();
//        MyFloat l1 = new MyFloat(2F);
//        MyFloat l2 = new MyFloat(5F);
//        MyFloat l3 = new MyFloat(1F);
//        MyFloat l4 = new MyFloat(-2F);
//        Collections.addAll(listToMat, l1, l2, l3, l4);
//        MyMatrix<MyFloat> sut = new MyMatrix<>(2, 2, listToMat);
//        System.out.println(sut.getNumber());
//        sut.
//        sut.getMatrix();


//        MyNumber<Float> liczba3 = new MyFloat(5F);
//        MyNumber<Float> liczba4 = new MyFloat(9F);
//        liczba3.add(liczba4.getValue());
//        System.out.println(liczba3.getValue());
//
//        MyFraction liczba5 = new MyFraction(BigInteger.ONE, BigInteger.TWO);
//        MyNumber<Fraction> liczba6 = new MyFraction(BigInteger.valueOf(2), BigInteger.valueOf(5));
//        liczba5.add(liczba6.getValue());
//        System.out.println(liczba5.getValue());
//        System.out.println(liczba5.getNumerator());
//        System.out.println(liczba5.getDenumerator());
//        System.out.println(liczba5.getDecimalValue());


    }
}
