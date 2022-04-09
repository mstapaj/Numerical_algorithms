package com.company;

import org.ejml.simple.SimpleMatrix;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {


//    public static <T> void print_matrix(List<List<MyNumber<T>>> matrix) {
//        for (int i = 0; i < matrix.size(); i++) {
//            for (int j = 0; j < matrix.get(i).size(); j++) {
//                System.out.print(matrix.get(i).get(j).getValue() + " ");
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


//    public static <T> MyMatrix<T> readMatrixFromFile(String file, String type) {
//        List<List<MyNumber<T>>> toMat = new ArrayList<>();
//        try {
//            Scanner scanner = new Scanner(new File("data/"+file));
//            scanner.useDelimiter(",");
//            List<MyNumber<T>> row = new ArrayList<>();
//            while (true) {
//                try {
//                    scanner.useDelimiter(",");
//                    String read = scanner.next();
//                    if (Objects.equals(read, "&")) {
//                        toMat.add(row);
//                        row = new ArrayList<>();
//                    } else {
//                        if (Objects.equals(type, "double")) {
//                            MyNumber<T> temp = (MyNumber<T>) new MyDouble(Double.parseDouble(read));
//                            row.add(temp);
//                        } else if (Objects.equals(type, "float")) {
//                            MyNumber<T> temp = (MyNumber<T>) new MyFloat(Float.parseFloat(read));
//                            row.add(temp);
//                        } else if (Objects.equals(type, "fraction")) {
////                            row.add((T) new Fraction(new BigInteger(read.split(";")[0]), new BigInteger(read.split(";")[1])));
//                            MyNumber<T> temp = (MyNumber<T>) new MyFraction(new BigInteger(read.split(";")[0]), new BigInteger(read.split(";")[1]));
//                            row.add(temp);
//                        } else {
//                            throw new IllegalArgumentException("Type " + type + " is not supported by this method");
//                        }
//                    }
//                } catch (NumberFormatException | NoSuchElementException e) {
//                    break;
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return new MyMatrix<>(toMat);
//    }

    public static SimpleMatrix makeLibraryMatrix(List<List<Number>> list) {
        Double[][] array = new Double[list.size()][list.size()];
        Double[] blankArray = new Double[0];
        double[][] resArray = new double[array.length][array.length];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i).toArray(blankArray);
            for (int j = 0; j < array[i].length - 1; j++) {
                resArray[i][j] = array[i][j];
            }
        }
        return new SimpleMatrix(resArray);
    }

//    public static <T> void saveResToFile(MyMatrix<T> resMatrix, String fileName) {
//        try {
//            FileWriter fileWriter = new FileWriter("results/"+fileName + ".txt");
//            for (int i = 0; i < resMatrix.getMatrix().size(); i++) {
//                for (int j = 0; j < resMatrix.getMatrix().get(i).size(); j++) {
//                    if (resMatrix.getMatrix().get(i).get(j) instanceof Fraction) {
//                        fileWriter.write(new BigDecimal(((Fraction) resMatrix.getMatrix().get(i).get(j)).getNumerator()).divide(new BigDecimal(((Fraction) resMatrix.getMatrix().get(i).get(j)).getDenumerator()), MathContext.DECIMAL128) + "\n");
//                    } else {
//                        fileWriter.write(resMatrix.getMatrix().get(i).get(j) + "\n");
//                    }
//                }
//            }
//            fileWriter.close();
//        } catch (IOException err) {
//            err.printStackTrace();
//        }
//    }

    public static void main(String[] args) throws IOException {
        // Wczytanie danych z plików
//        MyMatrix<> floatMyMatrixA = readMatrixFromFile("floatMatrixA.txt", "float");
//        MyMatrix<> floatMyMatrixB = readMatrixFromFile("floatMatrixB.txt", "float");
//        MyMatrix<> floatMyMatrixC = readMatrixFromFile("floatMatrixC.txt", "float");
//        MyMatrix<> floatMyMatrixX = readMatrixFromFile("floatMatrixX.txt", "float");
//        MyMatrix<Float> floatMyMatrixGauss = readMatrixFromFile("floatMatrixGauss.txt", "float");
//        MyMatrix<Double> doubleMyMatrixA = readMatrixFromFile("doubleMatrixA.txt", "double");
//        MyMatrix<Double> doubleMyMatrixB = readMatrixFromFile("doubleMatrixB.txt", "double");
//        MyMatrix<Double> doubleMyMatrixC = readMatrixFromFile("doubleMatrixC.txt", "double");
//        MyMatrix<Double> doubleMyMatrixX = readMatrixFromFile("doubleMatrixX.txt", "double");
//        MyMatrix<Double> doubleMyMatrixGauss = readMatrixFromFile("doubleMatrixGauss.txt", "float");
//        MyMatrix<Fraction> fractionMyMatrixA = readMatrixFromFile("fractionMatrixA.txt", "fraction");
//        MyMatrix<Fraction> fractionMyMatrixB = readMatrixFromFile("fractionMatrixB.txt", "fraction");
//        MyMatrix<Fraction> fractionMyMatrixC = readMatrixFromFile("fractionMatrixC.txt", "fraction");
//        MyMatrix<Fraction> fractionMyMatrixX = readMatrixFromFile("fractionMatrixX.txt", "fraction");
//        MyMatrix<Fraction> fractionMyMatrixGauss = readMatrixFromFile("fractionMatrixGauss.txt", "fraction");
//        fractionMyMatrixA.shortenMatrix();
//        fractionMyMatrixB.shortenMatrix();
//        fractionMyMatrixC.shortenMatrix();
//        fractionMyMatrixX.shortenMatrix();
//        SimpleMatrix libraryMatrixA = makeLibraryMatrix(readMatrixFromFile("doubleMatrixA.txt", "double").getNumber());
//        SimpleMatrix libraryMatrixB = makeLibraryMatrix(readMatrixFromFile("doubleMatrixB.txt", "double").getNumber());
//        SimpleMatrix libraryMatrixC = makeLibraryMatrix(readMatrixFromFile("doubleMatrixC.txt", "double").getNumber());
//        SimpleMatrix libraryMatrixX = makeLibraryMatrix(readMatrixFromFile("doubleMatrixX.txt", "double").getNumber());
//        SimpleMatrix libraryMatrixGauss = makeLibraryMatrix(readMatrixFromFile("doubleMatrixGauss.txt", "double").getNumber());
//
//
//        Instant start;
//        Instant end;
//        Duration timeElapsed;

        //A * X
//        System.out.println("A * X");
//
//        MyMatrix<T> floatRes1 = new MyMatrix<T>(floatMyMatrixA);
//        start = Instant.now();
//        floatRes1.multiplyMatrix(floatMyMatrixX);
//        end = Instant.now();
//        timeElapsed = Duration.between(start, end);
//        System.out.println("Float: " + timeElapsed.toMillis() + " millisekund");
////        System.out.println(floatRes1.getMatrix());
//        saveResToFile(floatRes1, "floatRes1");
//
//        MyMatrix<Double> doubleRes1 = new MyMatrix<>(doubleMyMatrixA.getMyNumber());
//        start = Instant.now();
//        doubleRes1.multiplyMatrix(doubleMyMatrixX);
//        end = Instant.now();
//        timeElapsed = Duration.between(start, end);
//        System.out.println("Double: " + timeElapsed.toMillis() + " millisekund");
////        System.out.println(doubleRes1.getMatrix());
//        saveResToFile(doubleRes1, "doubleRes1");
////
//        MyMatrix<Fraction> fractionRes1 = new MyMatrix<>(fractionMyMatrixA.getMyNumber());
//        start = Instant.now();
//        fractionRes1.multiplyMatrix(fractionMyMatrixX);
//        end = Instant.now();
//        timeElapsed = Duration.between(start, end);
//        System.out.println("Fraction: " + timeElapsed.toMillis() + " millisekund");
////        System.out.println(fractionRes1.getMatrix());
//        saveResToFile(fractionRes1, "fractionRes1");
////
//        SimpleMatrix libraryRes1 = new SimpleMatrix(libraryMatrixA);
//        start = Instant.now();
//        libraryRes1 = libraryRes1.mult(libraryMatrixX);
//        end = Instant.now();
//        timeElapsed = Duration.between(start, end);
//        System.out.println("Library: " + timeElapsed.toMillis() + " millisekund");
////        System.out.println(libraryRes1);
//        libraryRes1.saveToFileCSV("libraryRes1.txt");
//
//
//        // (A + B + C) * X
//        System.out.println("(A + B + C) * X");
//
//        MyMatrix<T> floatRes2 = new MyMatrix<>(floatMyMatrixA.getMyNumber());
//        start = Instant.now();
//        floatRes2.addingMatrix(floatMyMatrixB);
//        floatRes2.addingMatrix(floatMyMatrixC);
//        floatRes2.multiplyMatrix(floatMyMatrixX);
//        end = Instant.now();
//        timeElapsed = Duration.between(start, end);
//        System.out.println("Float: " + timeElapsed.toMillis() + " millisekund");
////        System.out.println(floatRes2.getMyNumber());
//        saveResToFile(floatRes2, "floatRes2");
//
//        MyMatrix<Double> doubleRes2 = new MyMatrix<>(doubleMyMatrixA.getMyNumber());
//        start = Instant.now();
//        doubleRes2.addingMatrix(doubleMyMatrixB);
//        doubleRes2.addingMatrix(doubleMyMatrixC);
//        doubleRes2.multiplyMatrix(doubleMyMatrixX);
//        end = Instant.now();
//        timeElapsed = Duration.between(start, end);
//        System.out.println("Double: " + timeElapsed.toMillis() + " millisekund");
////        System.out.println(doubleRes2.getMyNumber());
//        saveResToFile(doubleRes2, "doubleRes2");
//
//        MyMatrix<Fraction> fractionRes2 = new MyMatrix<>(fractionMyMatrixA.getMyNumber());
//        start = Instant.now();
//        fractionRes2.addingMatrix(fractionMyMatrixB);
//        fractionRes2.shortenMatrix();
//        fractionRes2.addingMatrix(fractionMyMatrixC);
//        fractionRes2.shortenMatrix();
//        fractionRes2.multiplyMatrix(fractionMyMatrixX);
//        end = Instant.now();
//        timeElapsed = Duration.between(start, end);
//        System.out.println("Fraction: " + timeElapsed.toMillis() + " millisekund");
////        System.out.println(fractionRes2.getMyNumber());
//        saveResToFile(fractionRes2, "fractionRes2");
//
//        SimpleMatrix libraryRes2 = new SimpleMatrix(libraryMatrixA);
//        start = Instant.now();
//        libraryRes2 = libraryRes2.plus(libraryMatrixB).plus(libraryMatrixC).mult(libraryMatrixX);
//        end = Instant.now();
//        timeElapsed = Duration.between(start, end);
//        System.out.println("Library: " + timeElapsed.toMillis() + " millisekund");
////        System.out.println(libraryRes2);
//        libraryRes2.saveToFileCSV("libraryRes2.txt");
//
//        // A * (B * C)
//        System.out.println("A * (B * C)");
//
//        MyMatrix<T> floatRes3 = new MyMatrix<T>(floatMyMatrixB.getMyNumber());
//        start = Instant.now();
//        floatRes3.multiplyMatrix(floatMyMatrixC);
//        floatRes3.multiplyMatrix(floatMyMatrixA);
//        end = Instant.now();
//        timeElapsed = Duration.between(start, end);
//        System.out.println("Float: " + timeElapsed.toMillis() + " millisekund");
////        System.out.println(floatRes3.getMyNumber());
//        saveResToFile(floatRes3, "floatRes3");
//
//        MyMatrix<Double> doubleRes3 = new MyMatrix<>(doubleMyMatrixB.getMyNumber());
//        start = Instant.now();
//        doubleRes3.multiplyMatrix(doubleMyMatrixC);
//        doubleRes3.multiplyMatrix(doubleMyMatrixA);
//        end = Instant.now();
//        timeElapsed = Duration.between(start, end);
//        System.out.println("Double: " + timeElapsed.toMillis() + " millisekund");
////        System.out.println(doubleRes3.getMyNumber());
//        saveResToFile(doubleRes3, "doubleRes3");
//
//        MyMatrix<Fraction> fractionRes3 = new MyMatrix<>(fractionMyMatrixB.getMyNumber());
//        start = Instant.now();
//        fractionRes3.multiplyMatrix(fractionMyMatrixC);
//        fractionRes3.shortenMatrix();
//        fractionRes3.multiplyMatrix(fractionMyMatrixA);
//        end = Instant.now();
//        timeElapsed = Duration.between(start, end);
//        System.out.println("Fraction: " + timeElapsed.toMillis() + " millisekund");
////        System.out.println(fractionRes3.getMyNumber());
//        saveResToFile(fractionRes3, "fractionRes3");
//
//        SimpleMatrix libraryRes3 = new SimpleMatrix(libraryMatrixB);
//        start = Instant.now();
//        libraryRes3 = libraryRes3.mult(libraryMatrixC).mult(libraryMatrixA);
//        end = Instant.now();
//        timeElapsed = Duration.between(start, end);
//        System.out.println("Library: " + timeElapsed.toMillis() + " millisekund");
////        System.out.println(libraryRes3);
//        libraryRes3.saveToFileCSV("libraryRes3.txt");
//
//
        MyNumber<MyDouble> liczba1 = new MyDouble(2.0);
        MyNumber<MyDouble> liczba2 = new MyDouble(4.0);
        liczba1.add(liczba2.getValue());
        System.out.println(liczba1.getValue().returnValue());

        List<MyFloat> listToMat = new ArrayList<>();
        MyFloat l1 = new MyFloat(2F);
        MyFloat l2 = new MyFloat(5F);
        MyFloat l3 = new MyFloat(1F);
        MyFloat l4 = new MyFloat(-2F);
        Collections.addAll(listToMat, l1, l2, l3, l4);
        MyMatrix<MyFloat> sut = new MyMatrix<>(2, 2, listToMat);
        System.out.println(sut.getNumber());
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

//        List<MyNumber<Double>> listToMat = new ArrayList<>();
//        MyNumber<Double> l1 = new MyDouble(1.2);
//        MyNumber<Double> l2 = new MyDouble(2.6);
//        MyNumber<Double> l3 = new MyDouble(-0.1);
//        MyNumber<Double> l4 = new MyDouble(1.5);
//        MyNumber<Double> l5 = new MyDouble(4.5);
//        MyNumber<Double> l6 = new MyDouble(9.8);
//        MyNumber<Double> l7 = new MyDouble(-0.4);
//        MyNumber<Double> l8 = new MyDouble(5.7);
//        MyNumber<Double> l9 = new MyDouble(0.1);
//        MyNumber<Double> l10 = new MyDouble(-0.1);
//        MyNumber<Double> l11 = new MyDouble(-0.3);
//        MyNumber<Double> l12 = new MyDouble(-3.5);
//        MyNumber<Double> l13 = new MyDouble(4.5);
//        MyNumber<Double> l14 = new MyDouble(-5.2);
//        MyNumber<Double> l15 = new MyDouble(4.2);
//        MyNumber<Double> l16 = new MyDouble(-3.4);
//        MyNumber<Double> p1 = new MyDouble(13.15);
//        MyNumber<Double> p2 = new MyDouble(49.84);
//        MyNumber<Double> p3 = new MyDouble(-14.08);
//        MyNumber<Double> p4 = new MyDouble(-46.51);
//        Collections.addAll(listToMat, l1, l2, l3, l4, p1, l5, l6, l7, l8, p2, l9, l10, l11, l12, p3, l13, l14, l15, l16, p4);
//        MyMatrix<Double> sut = new MyMatrix<>(4, 5, listToMat);
//        print_matrix(sut.getMyNumber());
//        sut.gaussMatrixG();
//        System.out.println();
//        System.out.println(sut.gaussMatrixG());
//
//        // Gauss P
//        System.out.println("Gauss P");
////
//        MyMatrix<Float> floatResGauss = new MyMatrix<>(floatMyMatrixGauss.getMyNumber());
//        List<MyNumber<Float>> resGaussF = new ArrayList<>();
//        start = Instant.now();
//        resGaussF = floatResGauss.gaussMatrixG();
//        end = Instant.now();
//        timeElapsed = Duration.between(start, end);
//        System.out.println("Float: " + timeElapsed.toMillis() + " millisekund");
////        System.out.println(floatResGauss.getMyNumber());
////        saveResToFile(floatResGauss, "floatResGauss");
//
//        MyMatrix<Double> doubleResGauss = new MyMatrix<>(doubleMyMatrixGauss.getMyNumber());
//        List<MyNumber<Double>> resGaussD = new ArrayList<>();
//        start = Instant.now();
//        resGaussD = doubleResGauss.gaussMatrixG();
//        end = Instant.now();
//        timeElapsed = Duration.between(start, end);
//        System.out.println("Double: " + timeElapsed.toMillis() + " millisekund");
////        System.out.println(doubleResGauss.getMyNumber());
////        saveResToFile(doubleResGauss, "doubleResGauss");
//
//        MyMatrix<Fraction> fractionResGauss = new MyMatrix<>(fractionMyMatrixGauss.getMyNumber());
//        List<MyNumber<Fraction>> resGaussFr = new ArrayList<>();
//        start = Instant.now();
//        resGaussFr = fractionResGauss.gaussMatrixG();
//        end = Instant.now();
//        timeElapsed = Duration.between(start, end);
//        System.out.println("Fraction: " + timeElapsed.toMillis() + " millisekund");
//        System.out.println(fractionResGauss.getMyNumber());
//        saveResToFile(fractionResGauss, "fractionResGauss");

//        SimpleMatrix libraryResGauss = new SimpleMatrix(libraryMatrixB);
//        start = Instant.now();
//        libraryResGauss = libraryResGauss.mult(libraryMatrixC).mult(libraryMatrixA);
//        end = Instant.now();
//        timeElapsed = Duration.between(start, end);
//        System.out.println("Library: " + timeElapsed.toMillis() + " millisekund");
////        System.out.println(libraryResGauss);
//        libraryResGauss.saveToFileCSV("libraryResGauss.txt");
    }
}
