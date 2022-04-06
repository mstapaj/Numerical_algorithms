package com.company;

import org.ejml.simple.SimpleMatrix;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class Main {


//    public static void print_fraction_matrix(List<List<Fraction>> matrix) {
//        for (int i = 0; i < matrix.size(); i++) {
//            for (int j = 0; j < matrix.size(); j++) {
//                System.out.print(matrix.get(i).get(j).getFraction() + " ");
//            }
//            System.out.println();
//        }
//    }
//
//    public static void print_fraction_matrix_big_dec(List<List<Fraction>> matrix) {
//        for (int i = 0; i < matrix.size(); i++) {
//            for (int j = 0; j < matrix.size(); j++) {
//                System.out.print(new BigDecimal(matrix.get(i).get(j).getNumerator().divide(matrix.get(i).get(j).getDenumerator())) + " ");
//            }
//            System.out.println();
//        }
//    }


    public static <T> MyMatrix<T> readMatrixFromFile(String file, String type) {
        List<List<MyNumber<T>>> toMat = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(file));
            scanner.useDelimiter(",");
            List<MyNumber<T>> row = new ArrayList<>();
            while (true) {
                try {
                    scanner.useDelimiter(",");
                    String read = scanner.next();
                    if (Objects.equals(read, "&")) {
                        toMat.add(row);
                        row = new ArrayList<>();
                    } else {
                        if (Objects.equals(type, "double")) {
                            MyNumber<T> temp = (MyNumber<T>) new MyDouble(Double.parseDouble(read));
                            row.add(temp);
                        } else if (Objects.equals(type, "float")) {
                            MyNumber<T> temp = (MyNumber<T>) new MyFloat(Float.parseFloat(read));
                            row.add(temp);
                        } else if (Objects.equals(type, "fraction")) {
//                            row.add((T) new Fraction(new BigInteger(read.split(";")[0]), new BigInteger(read.split(";")[1])));
                            MyNumber<T> temp = (MyNumber<T>) new MyFraction(new BigInteger(read.split(";")[0]), new BigInteger(read.split(";")[1]));
                            row.add(temp);
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
                resArray[i][j] = array[i][j];
            }
        }
        return new SimpleMatrix(resArray);
    }

    public static <T> void saveResToFile(MyMatrix<T> resMatrix, String fileName) {
        try {
            FileWriter fileWriter = new FileWriter(fileName + ".txt");
            for (int i = 0; i < resMatrix.getMatrix().size(); i++) {
                for (int j = 0; j < resMatrix.getMatrix().get(i).size(); j++) {
                    if (resMatrix.getMatrix().get(i).get(j) instanceof Fraction) {
                        fileWriter.write(new BigDecimal(((Fraction) resMatrix.getMatrix().get(i).get(j)).getNumerator()).divide(new BigDecimal(((Fraction) resMatrix.getMatrix().get(i).get(j)).getDenumerator()), MathContext.DECIMAL128) + "\n");
                    } else {
                        fileWriter.write(resMatrix.getMatrix().get(i).get(j) + "\n");
                    }
                }
            }
            fileWriter.close();
        } catch (IOException err) {
            err.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
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
        SimpleMatrix libraryMatrixA = makeLibraryMatrix(readMatrixFromFile("doubleMatrixA.txt", "double").getNumber());
        SimpleMatrix libraryMatrixB = makeLibraryMatrix(readMatrixFromFile("doubleMatrixB.txt", "double").getNumber());
        SimpleMatrix libraryMatrixC = makeLibraryMatrix(readMatrixFromFile("doubleMatrixC.txt", "double").getNumber());
        SimpleMatrix libraryMatrixX = makeLibraryMatrix(readMatrixFromFile("doubleMatrixX.txt", "double").getNumber());


        Instant start;
        Instant end;
        Duration timeElapsed;

        //A * X
        System.out.println("A * X");

        MyMatrix<Float> floatRes1 = new MyMatrix<>(floatMyMatrixA.getMyNumber());
        start = Instant.now();
        floatRes1.multiplyMatrix(floatMyMatrixX);
        end = Instant.now();
        timeElapsed = Duration.between(start, end);
        System.out.println("Float: " + timeElapsed.toMillis() + " millisekund");
//        System.out.println(floatRes1.getMatrix());
        saveResToFile(floatRes1, "floatRes1");

        MyMatrix<Double> doubleRes1 = new MyMatrix<>(doubleMyMatrixA.getMyNumber());
        start = Instant.now();
        doubleRes1.multiplyMatrix(doubleMyMatrixX);
        end = Instant.now();
        timeElapsed = Duration.between(start, end);
        System.out.println("Double: " + timeElapsed.toMillis() + " millisekund");
//        System.out.println(doubleRes1.getMatrix());
        saveResToFile(doubleRes1, "doubleRes1");

        MyMatrix<Fraction> fractionRes1 = new MyMatrix<>(fractionMyMatrixA.getMyNumber());
        start = Instant.now();
        fractionMyMatrixA.multiplyMatrix(fractionMyMatrixX);
        end = Instant.now();
        timeElapsed = Duration.between(start, end);
        System.out.println("Fraction: " + timeElapsed.toMillis() + " millisekund");
//        System.out.println(fractionRes1.getMatrix());
        saveResToFile(fractionRes1, "fractionRes1");

        SimpleMatrix libraryRes1 = new SimpleMatrix(libraryMatrixA);
        start = Instant.now();
        libraryRes1 = libraryRes1.mult(libraryMatrixX);
        end = Instant.now();
        timeElapsed = Duration.between(start, end);
        System.out.println("Library: " + timeElapsed.toMillis() + " millisekund");
//        System.out.println(libraryRes1);
        libraryRes1.saveToFileCSV("libraryRes1.txt");
//
//
//        // (A + B + C) * X
        System.out.println("(A + B + C) * X");

        MyMatrix<Float> floatRes2 = new MyMatrix<>(floatMyMatrixA.getMyNumber());
        start = Instant.now();
        floatRes2.addingMatrix(floatMyMatrixB);
        floatRes2.addingMatrix(floatMyMatrixC);
        floatRes2.multiplyMatrix(floatMyMatrixX);
        end = Instant.now();
        timeElapsed = Duration.between(start, end);
        System.out.println("Float: " + timeElapsed.toMillis() + " millisekund");
//        System.out.println(floatRes2.getMyNumber());
        saveResToFile(floatRes2, "floatRes2");

        MyMatrix<Double> doubleRes2 = new MyMatrix<>(doubleMyMatrixA.getMyNumber());
        start = Instant.now();
        doubleRes2.addingMatrix(doubleMyMatrixB);
        doubleRes2.addingMatrix(doubleMyMatrixC);
        doubleRes2.multiplyMatrix(doubleMyMatrixX);
        end = Instant.now();
        timeElapsed = Duration.between(start, end);
        System.out.println("Double: " + timeElapsed.toMillis() + " millisekund");
//        System.out.println(doubleRes2.getMyNumber());
        saveResToFile(doubleRes2, "doubleRes2");

//        MyMatrix<Fraction> fractionRes2 = new MyMatrix<>(fractionMyMatrixA.getMyNumber());
//        start = Instant.now();
//        fractionRes2.addingMatrix(fractionMyMatrixB);
//        fractionRes2.addingMatrix(fractionMyMatrixC);
//        fractionRes2.multiplyMatrix(fractionMyMatrixX);
//        end = Instant.now();
//        timeElapsed = Duration.between(start, end);
//        System.out.println("Fraction: " + timeElapsed.toMillis() + " millisekund");
////        System.out.println(fractionRes2.getMyNumber());
//        saveResToFile(fractionRes2, "fractionRes2");

        SimpleMatrix libraryRes2 = new SimpleMatrix(libraryMatrixA);
        start = Instant.now();
        libraryRes2 = libraryRes2.plus(libraryMatrixB).plus(libraryMatrixC).mult(libraryMatrixX);
        end = Instant.now();
        timeElapsed = Duration.between(start, end);
        System.out.println("Library: " + timeElapsed.toMillis() + " millisekund");
//        System.out.println(libraryRes2);
        libraryRes2.saveToFileCSV("libraryRes2.txt");

        // A * (B * C)
        System.out.println("A * (B * C)");

        MyMatrix<Float> floatRes3 = new MyMatrix<>(floatMyMatrixB.getMyNumber());
        start = Instant.now();
        floatRes3.multiplyMatrix(floatMyMatrixC);
        floatRes3.multiplyMatrix(floatMyMatrixA);
        end = Instant.now();
        timeElapsed = Duration.between(start, end);
        System.out.println("Float: " + timeElapsed.toMillis() + " millisekund");
//        System.out.println(floatRes3.getMyNumber());
        saveResToFile(floatRes3, "floatRes3");

        MyMatrix<Double> doubleRes3 = new MyMatrix<>(doubleMyMatrixB.getMyNumber());
        start = Instant.now();
        doubleRes3.multiplyMatrix(doubleMyMatrixC);
        doubleRes3.multiplyMatrix(doubleMyMatrixA);
        end = Instant.now();
        timeElapsed = Duration.between(start, end);
        System.out.println("Double: " + timeElapsed.toMillis() + " millisekund");
//        System.out.println(doubleRes3.getMyNumber());
        saveResToFile(doubleRes3, "doubleRes3");

        MyMatrix<Fraction> fractionRes3 = new MyMatrix<>(fractionMyMatrixB.getMyNumber());
        start = Instant.now();
        fractionRes3.multiplyMatrix(fractionMyMatrixC);
        fractionRes3.multiplyMatrix(fractionMyMatrixA);
        end = Instant.now();
        timeElapsed = Duration.between(start, end);
        System.out.println("Fraction: " + timeElapsed.toMillis() + " millisekund");
//        System.out.println(fractionRes3.getMyNumber());
        saveResToFile(fractionRes3, "fractionRes3");

        SimpleMatrix libraryRes3 = new SimpleMatrix(libraryMatrixB);
        start = Instant.now();
        libraryRes3 = libraryRes3.mult(libraryMatrixC).mult(libraryMatrixA);
        end = Instant.now();
        timeElapsed = Duration.between(start, end);
        System.out.println("Library: " + timeElapsed.toMillis() + " millisekund");
//        System.out.println(libraryRes3);
        libraryRes3.saveToFileCSV("libraryRes3.txt");


        MyNumber<Double> liczba1 = new MyDouble(2.0);
        MyNumber<Double> liczba2 = new MyDouble(4.0);
        liczba1.add(liczba2.getValue());
        System.out.println(liczba1.getValue());

        MyNumber<Float> liczba3 = new MyFloat(5F);
        MyNumber<Float> liczba4 = new MyFloat(9F);
        liczba3.add(liczba4.getValue());
        System.out.println(liczba3.getValue());

        MyFraction liczba5 = new MyFraction(BigInteger.ONE, BigInteger.TWO);
        MyNumber<Fraction> liczba6 = new MyFraction(BigInteger.valueOf(2), BigInteger.valueOf(5));
        liczba5.add(liczba6.getValue());
        System.out.println(liczba5.getValue());
        System.out.println(liczba5.getNumerator());
        System.out.println(liczba5.getDenumerator());
        System.out.println(liczba5.getDecimalValue());
    }
}
