package com.company;

import org.ejml.simple.SimpleMatrix;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.*;
import java.util.stream.Stream;

public class Main {


    public static void print_fraction_matrix(List<List<Fraction>> matrix) {
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.size(); j++) {
                System.out.print(matrix.get(i).get(j).getFraction() + " ");
            }
            System.out.println();
        }
    }

    public static void print_fraction_matrix_big_dec(List<List<Fraction>> matrix) {
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.size(); j++) {
                System.out.print(new BigDecimal(matrix.get(i).get(j).getNumerator().divide(matrix.get(i).get(j).getDenumerator())) + " ");
            }
            System.out.println();
        }
    }


    public static <T extends Number> MyMatrix<T> readMatrixFromFile(String file, String type) {
        List<List<T>> toMat = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(file));
            scanner.useDelimiter(",");
            List<T> row = new ArrayList<>();
            while (true) {
                try {
                    scanner.useDelimiter(",");
                    String read = scanner.next();
                    if (Objects.equals(read, "&")) {
                        toMat.add(row);
                        row = new ArrayList<>();
                    } else {
                        if (Objects.equals(type, "double")) {
                            row.add((T) new Double(read));
                        } else if (Objects.equals(type, "float")) {
                            row.add((T) new Float(read));
                        } else if (Objects.equals(type, "fraction")) {
                            row.add((T) new Fraction(new BigInteger(read.split(";")[0]), new BigInteger(read.split(";")[1])));
                        } else {
                            throw new IllegalArgumentException("Type " + type + " is not supported by this method");
                        }
                    }
                } catch (NumberFormatException | NoSuchElementException e) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new MyMatrix<>(toMat);
    }

    public static SimpleMatrix makeLibraryMatrix(List<List<Number>> list) {
        Double[][] array = new Double[list.size()][list.size()];
        Double[] blankArray = new Double[0];
        double[][] resArray = new double[array.length][array.length];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i).toArray(blankArray);
            for (int j = 0; j < array[i].length; j++) {
                resArray[i][j] = array[i][j].doubleValue();
            }
        }
        return new SimpleMatrix(resArray);
    }

    public static void main(String[] args) {
        // Wczytanie danych z plików
        MyMatrix<Float> floatMyMatrixA = readMatrixFromFile("floatMatrixA.txt", "float");
        MyMatrix<Float> floatMyMatrixB = readMatrixFromFile("floatMatrixB.txt", "float");
        MyMatrix<Float> floatMyMatrixC = readMatrixFromFile("floatMatrixC.txt", "float");
        MyMatrix<Float> floatMyMatrixX = readMatrixFromFile("floatMatrixX.txt", "float");
        MyMatrix<Double> doubleMyMatrixA = readMatrixFromFile("doubleMatrixA.txt", "double");
        MyMatrix<Double> doubleMyMatrixB = readMatrixFromFile("doubleMatrixB.txt", "double");
        MyMatrix<Double> doubleMyMatrixC = readMatrixFromFile("doubleMatrixC.txt", "double");
        MyMatrix<Double> doubleMyMatrixX = readMatrixFromFile("doubleMatrixX.txt", "double");
        MyMatrix<Fraction> fractionMyMatrixA = readMatrixFromFile("fractionMatrixA.txt", "fraction");
        MyMatrix<Fraction> fractionMyMatrixB = readMatrixFromFile("fractionMatrixB.txt", "fraction");
        MyMatrix<Fraction> fractionMyMatrixC = readMatrixFromFile("fractionMatrixC.txt", "fraction");
        MyMatrix<Fraction> fractionMyMatrixX = readMatrixFromFile("fractionMatrixX.txt", "fraction");
        SimpleMatrix libraryMatrixA = makeLibraryMatrix(readMatrixFromFile("doubleMatrixA.txt", "double").getMatrix());
        SimpleMatrix libraryMatrixB = makeLibraryMatrix(readMatrixFromFile("doubleMatrixB.txt", "double").getMatrix());
        SimpleMatrix libraryMatrixC = makeLibraryMatrix(readMatrixFromFile("doubleMatrixC.txt", "double").getMatrix());
        SimpleMatrix libraryMatrixX = makeLibraryMatrix(readMatrixFromFile("doubleMatrixX.txt", "double").getMatrix());


        // A * X
//        System.out.println(floatMyMatrixA.multiplyMatrix(floatMyMatrixX).getMatrix());
//        System.out.println(doubleMyMatrixA.multiplyMatrix(doubleMyMatrixX).getMatrix());
//        BigDecimal res3= new BigDecimal(fractionMyMatrixA.multiplyMatrix(fractionMyMatrixX).getMatrix().get(0).get(0).getNumerator()).divide(new BigDecimal(fractionMyMatrixA.multiplyMatrix(fractionMyMatrixX).getMatrix().get(0).get(0).getDenumerator()),MathContext.DECIMAL128);
//        System.out.println(fractionMyMatrixA.multiplyMatrix(fractionMyMatrixX).getMatrix());
//        System.out.println(res3);
//        System.out.println(libraryMatrixA.mult(libraryMatrixX));


        // (A + B + C) * X
//        MyMatrix <Float> tempFloat= floatMyMatrixA.addingMatrix(floatMyMatrixB).addingMatrix(floatMyMatrixC);
//        System.out.println(tempFloat.multiplyMatrix(floatMyMatrixX).getMatrix());
//        MyMatrix <Double> tempDouble= doubleMyMatrixA.addingMatrix(doubleMyMatrixB).addingMatrix(doubleMyMatrixC);
//        System.out.println(tempDouble.multiplyMatrix(doubleMyMatrixX).getMatrix());
//        MyMatrix <Fraction> tempFraction= fractionMyMatrixA.addingMatrix(fractionMyMatrixB).addingMatrix(fractionMyMatrixC);
//        BigDecimal res= new BigDecimal(tempFraction.multiplyMatrix(fractionMyMatrixX).getMatrix().get(0).get(0).getFraction().get(0)).divide(new BigDecimal(tempFraction.multiplyMatrix(fractionMyMatrixX).getMatrix().get(0).get(0).getFraction().get(1)), MathContext.DECIMAL128);
////        System.out.println(tempFraction.multiplyMatrix(fractionMyMatrixX).getMatrix().get(0).get(0).getFraction().get(0));
//        System.out.println(res);
//        SimpleMatrix tempLibMat= libraryMatrixA.plus(libraryMatrixB).plus(libraryMatrixC);
//        System.out.println(tempLibMat.mult(libraryMatrixX));

        // A * (B * C)
//        MyMatrix<Float> tempFloat2 = floatMyMatrixB.multiplyMatrix(floatMyMatrixC);
//        System.out.println(tempFloat2.multiplyMatrix(floatMyMatrixA).getMatrix().get(0));
//        MyMatrix<Double> tempDouble2 = doubleMyMatrixB.multiplyMatrix(doubleMyMatrixC);
//        System.out.println(tempDouble2.multiplyMatrix(doubleMyMatrixA).getMatrix().get(0));
//        MyMatrix<Fraction> tempFraction2 = fractionMyMatrixB.multiplyMatrix(fractionMyMatrixC);
//        BigDecimal res2 = new BigDecimal(tempFraction2.multiplyMatrix(fractionMyMatrixA).getMatrix().get(0).get(0).getFraction().get(0)).divide(new BigDecimal(tempFraction2.multiplyMatrix(fractionMyMatrixA).getMatrix().get(0).get(0).getFraction().get(1)), MathContext.DECIMAL128);
////        System.out.println(tempFraction.multiplyMatrix(fractionMyMatrixX).getMatrix().get(0).get(0).getFraction().get(0));
//        System.out.println(res2);
//        SimpleMatrix res4= libraryMatrixB.mult(libraryMatrixC);
//        System.out.println(res4.mult(libraryMatrixA).get(0,0));
    }
}
