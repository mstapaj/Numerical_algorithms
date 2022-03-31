package com.company;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class Main {


    public static BigInteger LCM(BigInteger a, BigInteger b) {
        if (a.signum() == 0 || b.signum() == 0) {
            return BigInteger.ZERO;
        }
        return a.divide(a.gcd(b)).multiply(b).abs();
    }

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

        // A * X
        System.out.println(floatMyMatrixA.multiplyMatrix(floatMyMatrixX).getMatrix());
        System.out.println(doubleMyMatrixA.multiplyMatrix(doubleMyMatrixX).getMatrix());
//        print_fraction_matrix(fractionMyMatrixA.multiplyMatrix(fractionMyMatrixX).getMatrix());
//        print_fraction_matrix_big_dec(fractionMyMatrixA.multiplyMatrix(fractionMyMatrixX).getMatrix());
//        System.out.println(fractionMyMatrixA.multiplyMatrix(fractionMyMatrixX).getMatrix().get(0).get(0));
        System.out.println(fractionMyMatrixA.multiplyMatrix(fractionMyMatrixX).getMatrix());
    }
}
