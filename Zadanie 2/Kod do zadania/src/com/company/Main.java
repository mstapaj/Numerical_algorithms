package com.company;

import com.company.types.MyDouble;
import com.company.types.MyFloat;
import com.company.types.MyFraction;
import org.ejml.simple.SimpleMatrix;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.time.Duration;
import java.time.Instant;
import java.util.*;

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


    public static <T extends MyNumber<T>> MyMatrix<T> readMatrixFromFile(String file, String type) {
        List<List<T>> toMat = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("data/" + file));
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
                            T temp = (T) new MyDouble(Double.parseDouble(read)).initialize();
                            row.add(temp);
                        } else if (Objects.equals(type, "float")) {
                            T temp = (T) new MyFloat(Float.parseFloat(read));
                            row.add(temp);
                        } else if (Objects.equals(type, "fraction")) {
//                            row.add((T) new Fraction(new BigInteger(read.split(";")[0]), new BigInteger(read.split(";")[1])));
                            T temp = (T) new MyFraction(new BigInteger(read.split(";")[0]), new BigInteger(read.split(";")[1]));
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
//        Double[][] array = new Double[list.size()][list.size()];
        double[][] resArray = new double[list.size()][list.get(0).size()];
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(0).size(); j++) {
                resArray[i][j] = list.get(i).get(j).doubleValue();
            }
        }
        return new SimpleMatrix(resArray);
    }

    public static <T extends MyNumber<T>> void saveResToFile(MyMatrix<T> resMatrix, String fileName) {
        try {
            FileWriter fileWriter = new FileWriter("results/" + fileName + ".txt");
            for (int i = 0; i < resMatrix.getMatrix().size(); i++) {
                for (int j = 0; j < resMatrix.getMatrix().get(i).size(); j++) {
                    if (resMatrix.getMatrix().get(i).get(j) instanceof MyFraction) {
                        fileWriter.write((resMatrix.getMatrix().get(i).get(j)).returnValue() + "\n");
                    } else {
                        fileWriter.write(resMatrix.getMatrix().get(i).get(j).getNumber() + "\n");
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
        MyMatrix<MyFloat> floatMyMatrixA = readMatrixFromFile("floatMatrixA.txt", "float");
        MyMatrix<MyFloat> floatMyMatrixB = readMatrixFromFile("floatMatrixB.txt", "float");
        MyMatrix<MyFloat> floatMyMatrixC = readMatrixFromFile("floatMatrixC.txt", "float");
        MyMatrix<MyFloat> floatMyMatrixX = readMatrixFromFile("floatMatrixX.txt", "float");
        MyMatrix<MyFloat> floatMyMatrixGauss = readMatrixFromFile("floatMatrixGauss.txt", "float");
        MyMatrix<MyFloat> floatMyMatrixGauss2 = readMatrixFromFile("floatMatrixGauss.txt", "float");
        MyMatrix<MyDouble> doubleMyMatrixA = readMatrixFromFile("doubleMatrixA.txt", "double");
        MyMatrix<MyDouble> doubleMyMatrixB = readMatrixFromFile("doubleMatrixB.txt", "double");
        MyMatrix<MyDouble> doubleMyMatrixC = readMatrixFromFile("doubleMatrixC.txt", "double");
        MyMatrix<MyDouble> doubleMyMatrixX = readMatrixFromFile("doubleMatrixX.txt", "double");
        MyMatrix<MyDouble> doubleMyMatrixGauss = readMatrixFromFile("doubleMatrixGauss.txt", "float");
        MyMatrix<MyDouble> doubleMyMatrixGauss2 = readMatrixFromFile("doubleMatrixGauss.txt", "double");
        MyMatrix<MyFraction> fractionMyMatrixA = readMatrixFromFile("fractionMatrixA.txt", "fraction");
        MyMatrix<MyFraction> fractionMyMatrixB = readMatrixFromFile("fractionMatrixB.txt", "fraction");
        MyMatrix<MyFraction> fractionMyMatrixC = readMatrixFromFile("fractionMatrixC.txt", "fraction");
        MyMatrix<MyFraction> fractionMyMatrixX = readMatrixFromFile("fractionMatrixX.txt", "fraction");
        MyMatrix<MyFraction> fractionMyMatrixGauss = readMatrixFromFile("fractionMatrixGauss.txt", "fraction");
        MyMatrix<MyFraction> fractionMyMatrixGauss2 = readMatrixFromFile("fractionMatrixGauss.txt", "fraction");
        fractionMyMatrixA = fractionMyMatrixA.shortenMatrix();
        fractionMyMatrixB = fractionMyMatrixB.shortenMatrix();
        fractionMyMatrixC = fractionMyMatrixC.shortenMatrix();
        fractionMyMatrixX = fractionMyMatrixX.shortenMatrix();
        fractionMyMatrixGauss = fractionMyMatrixGauss.shortenMatrix();
        fractionMyMatrixGauss2 = fractionMyMatrixGauss2.shortenMatrix();
        SimpleMatrix libraryMatrixA = makeLibraryMatrix(readMatrixFromFile("doubleMatrixA.txt", "double").getNumber());
        SimpleMatrix libraryMatrixB = makeLibraryMatrix(readMatrixFromFile("doubleMatrixB.txt", "double").getNumber());
        SimpleMatrix libraryMatrixC = makeLibraryMatrix(readMatrixFromFile("doubleMatrixC.txt", "double").getNumber());
        SimpleMatrix libraryMatrixX = makeLibraryMatrix(readMatrixFromFile("doubleMatrixX.txt", "double").getNumber());
        SimpleMatrix libraryMatrixGauss = makeLibraryMatrix(readMatrixFromFile("doubleMatrixGauss.txt", "double").getNumber());
        SimpleMatrix libraryMatrixGauss2 = makeLibraryMatrix(readMatrixFromFile("doubleMatrixGauss.txt", "double").getNumber());

//
        Instant start;
        Instant end;
        Duration timeElapsed;
//
        //A * X
        System.out.println("A * X");

        MyMatrix<MyFloat> floatRes1 = new MyMatrix<>(floatMyMatrixA.getMatrix());
        start = Instant.now();
        floatRes1 = floatRes1.multiplyMatrix(floatMyMatrixX);
        end = Instant.now();
        timeElapsed = Duration.between(start, end);
        System.out.println("Float: " + timeElapsed.toMillis() + " millisekund");
//        System.out.println(floatRes1.getMatrix());
        saveResToFile(floatRes1, "floatRes1");
//
        MyMatrix<MyDouble> doubleRes1 = new MyMatrix<>(doubleMyMatrixA.getMatrix());
        start = Instant.now();
        doubleRes1 = doubleRes1.multiplyMatrix(doubleMyMatrixX);
        end = Instant.now();
        timeElapsed = Duration.between(start, end);
        System.out.println("Double: " + timeElapsed.toMillis() + " millisekund");
//        System.out.println(doubleRes1.getMatrix());
        saveResToFile(doubleRes1, "doubleRes1");
//
        MyMatrix<MyFraction> fractionRes1 = new MyMatrix<>(fractionMyMatrixA.getMatrix());
        start = Instant.now();
        fractionRes1 = fractionRes1.multiplyMatrix(fractionMyMatrixX);
        end = Instant.now();
        timeElapsed = Duration.between(start, end);
        System.out.println("Fraction: " + timeElapsed.toMillis() + " millisekund");
//        System.out.println(fractionRes1.getMatrix());
        saveResToFile(fractionRes1, "fractionRes1");
////
        SimpleMatrix libraryRes1 = new SimpleMatrix(libraryMatrixA);
        start = Instant.now();
        libraryRes1 = libraryRes1.mult(libraryMatrixX);
        end = Instant.now();
        timeElapsed = Duration.between(start, end);
        System.out.println("Library: " + timeElapsed.toMillis() + " millisekund");
//        System.out.println(libraryRes1);
        libraryRes1.saveToFileCSV("results/libraryRes1.txt");
//
//
        // (A + B + C) * X
        System.out.println("(A + B + C) * X");

        MyMatrix<MyFloat> floatRes2 = new MyMatrix<>(floatMyMatrixA.getMatrix());
        start = Instant.now();
        floatRes2 = floatRes2.addingMatrix(floatMyMatrixB).addingMatrix(floatMyMatrixC).multiplyMatrix(floatMyMatrixX);
        end = Instant.now();
        timeElapsed = Duration.between(start, end);
        System.out.println("Float: " + timeElapsed.toMillis() + " millisekund");
//        System.out.println(floatRes2.getMyNumber());
        saveResToFile(floatRes2, "floatRes2");

        MyMatrix<MyDouble> doubleRes2 = new MyMatrix<>(doubleMyMatrixA.getMatrix());
        start = Instant.now();
        doubleRes2 = doubleRes2.addingMatrix(doubleMyMatrixB).addingMatrix(doubleMyMatrixC).multiplyMatrix(doubleMyMatrixX);
        end = Instant.now();
        timeElapsed = Duration.between(start, end);
        System.out.println("Double: " + timeElapsed.toMillis() + " millisekund");
//        System.out.println(doubleRes2.getMyNumber());
        saveResToFile(doubleRes2, "doubleRes2");

        MyMatrix<MyFraction> fractionRes2 = new MyMatrix<>(fractionMyMatrixA.getMatrix());
        start = Instant.now();
        fractionRes2 = fractionRes2.addingMatrix(fractionMyMatrixB).addingMatrix(fractionMyMatrixC).multiplyMatrix(fractionMyMatrixX);
        end = Instant.now();
        timeElapsed = Duration.between(start, end);
        System.out.println("Fraction: " + timeElapsed.toMillis() + " millisekund");
//        System.out.println(fractionRes2.getMyNumber());
        saveResToFile(fractionRes2, "fractionRes2");

        SimpleMatrix libraryRes2 = new SimpleMatrix(libraryMatrixA);
        start = Instant.now();
        libraryRes2 = libraryRes2.plus(libraryMatrixB).plus(libraryMatrixC).mult(libraryMatrixX);
        end = Instant.now();
        timeElapsed = Duration.between(start, end);
        System.out.println("Library: " + timeElapsed.toMillis() + " millisekund");
//        System.out.println(libraryRes2);
        libraryRes2.saveToFileCSV("results/libraryRes2.txt");

        // A * (B * C)
        System.out.println("A * (B * C)");

        MyMatrix<MyFloat> floatRes3 = new MyMatrix<>(floatMyMatrixB.getMatrix());
        start = Instant.now();
        floatRes3 = floatRes3.multiplyMatrix(floatMyMatrixC).multiplyMatrix(floatMyMatrixA);
        end = Instant.now();
        timeElapsed = Duration.between(start, end);
        System.out.println("Float: " + timeElapsed.toMillis() + " millisekund");
//        System.out.println(floatRes3.getMyNumber());
        saveResToFile(floatRes3, "floatRes3");

        MyMatrix<MyDouble> doubleRes3 = new MyMatrix<>(doubleMyMatrixB.getMatrix());
        start = Instant.now();
        doubleRes3 = doubleRes3.multiplyMatrix(doubleMyMatrixC).multiplyMatrix(doubleMyMatrixA);
        end = Instant.now();
        timeElapsed = Duration.between(start, end);
        System.out.println("Double: " + timeElapsed.toMillis() + " millisekund");
//        System.out.println(doubleRes3.getMyNumber());
        saveResToFile(doubleRes3, "doubleRes3");

        MyMatrix<MyFraction> fractionRes3 = new MyMatrix<>(fractionMyMatrixB.getMatrix());
        start = Instant.now();
        fractionRes3 = fractionRes3.multiplyMatrix(fractionMyMatrixC).shortenMatrix().multiplyMatrix(fractionMyMatrixA);
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
        libraryRes3.saveToFileCSV("results/libraryRes3.txt");


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

//        List<MyDouble> listToMat = new ArrayList<>();
//        MyDouble l1 = new MyDouble(1.2);
//        MyDouble l2 = new MyDouble(2.6);
//        MyDouble l3 = new MyDouble(-0.1);
//        MyDouble l4 = new MyDouble(1.5);
//        MyDouble l5 = new MyDouble(4.5);
//        MyDouble l6 = new MyDouble(9.8);
//        MyDouble l7 = new MyDouble(-0.4);
//        MyDouble l8 = new MyDouble(5.7);
//        MyDouble l9 = new MyDouble(0.1);
//        MyDouble l10 = new MyDouble(-0.1);
//        MyDouble l11 = new MyDouble(-0.3);
//        MyDouble l12 = new MyDouble(-3.5);
//        MyDouble l13 = new MyDouble(4.5);
//        MyDouble l14 = new MyDouble(-5.2);
//        MyDouble l15 = new MyDouble(4.2);
//        MyDouble l16 = new MyDouble(-3.4);
//        MyDouble p1 = new MyDouble(13.15);
//        MyDouble p2 = new MyDouble(49.84);
//        MyDouble p3 = new MyDouble(-14.08);
//        MyDouble p4 = new MyDouble(-46.51);
//        Collections.addAll(listToMat, l1, l2, l3, l4, p1, l5, l6, l7, l8, p2, l9, l10, l11, l12, p3, l13, l14, l15, l16, p4);
//        MyMatrix<MyDouble> sut = new MyMatrix<>(4, 5, listToMat);
////        print_matrix(sut.getMyNumber());
////        sut=sut.gaussMatrixG();
////        System.out.println();
////        System.out.println(sut.gaussMatrixG());
//        List<MyDouble> temp= sut.gaussMatrixG();
//        System.out.println(temp);
//        for (int i = 0; i < temp.size(); i++) {
//            System.out.println(temp.get(i).getNumber());
//        }

        // Gauss P
        System.out.println("Gauss P");

        MyMatrix<MyFloat> floatResGauss = new MyMatrix<>(floatMyMatrixGauss.getMatrix());
        List<MyFloat> resGaussF;
        start = Instant.now();
        resGaussF = floatResGauss.gaussMatrixG();
        end = Instant.now();
        timeElapsed = Duration.between(start, end);
        System.out.println("Float: " + timeElapsed.toMillis() + " millisekund");
//        System.out.println(floatResGauss.getMyNumber());
        saveResToFile(new MyMatrix<>(10, 1, resGaussF), "floatResGauss");

        MyMatrix<MyDouble> doubleResGauss = new MyMatrix<>(doubleMyMatrixGauss.getMatrix());
        List<MyDouble> resGaussD;
        start = Instant.now();
        resGaussD = doubleResGauss.gaussMatrixG();
        end = Instant.now();
        timeElapsed = Duration.between(start, end);
        System.out.println("Double: " + timeElapsed.toMillis() + " millisekund");
//        System.out.println(doubleResGauss.getMyNumber());
        saveResToFile(new MyMatrix<>(10, 1, resGaussD), "doubleResGauss");

        MyMatrix<MyFraction> fractionResGauss = new MyMatrix<>(fractionMyMatrixGauss.getMatrix());
        List<MyFraction> resGaussFr;
        start = Instant.now();
        resGaussFr = fractionResGauss.gaussMatrixG();
        end = Instant.now();
        timeElapsed = Duration.between(start, end);
        System.out.println("Fraction: " + timeElapsed.toMillis() + " millisekund");
//        System.out.println(fractionResGauss.getMyNumber());
        saveResToFile(new MyMatrix<>(10, 1, resGaussFr), "fractionResGauss");

        SimpleMatrix libraryResGauss = new SimpleMatrix(libraryMatrixGauss);
        start = Instant.now();
        libraryResGauss = libraryResGauss.cols(0, libraryResGauss.numCols() - 1).solve(libraryResGauss.cols(libraryResGauss.numCols() - 1, libraryResGauss.numCols()));
        end = Instant.now();
        timeElapsed = Duration.between(start, end);
        System.out.println("Library: " + timeElapsed.toMillis() + " millisekund");
//        System.out.println(libraryResGauss);
        libraryResGauss.saveToFileCSV("results/libraryResGauss.txt");

        // Gauss PG
        System.out.println("Gauss PG");
//
        MyMatrix<MyFloat> floatResGauss2 = new MyMatrix<>(floatMyMatrixGauss2.getMatrix());
        List<MyFloat> resGaussF2;
        start = Instant.now();
        resGaussF2 = floatResGauss2.gaussMatrixPG();
        end = Instant.now();
        timeElapsed = Duration.between(start, end);
        System.out.println("Float: " + timeElapsed.toMillis() + " millisekund");
//        System.out.println(floatResGauss.getMyNumber());
        saveResToFile(new MyMatrix<>(10, 1, resGaussF2), "floatResGauss2");

        MyMatrix<MyDouble> doubleResGauss2 = new MyMatrix<>(doubleMyMatrixGauss2.getMatrix());
        List<MyDouble> resGaussD2;
        start = Instant.now();
        resGaussD2 = doubleResGauss2.gaussMatrixPG();
        end = Instant.now();
        timeElapsed = Duration.between(start, end);
        System.out.println("Double: " + timeElapsed.toMillis() + " millisekund");
//        System.out.println(doubleResGauss.getMyNumber());
        saveResToFile(new MyMatrix<>(10, 1, resGaussD2), "doubleResGauss2");

        MyMatrix<MyFraction> fractionResGauss2 = new MyMatrix<>(fractionMyMatrixGauss2.getMatrix());
        List<MyFraction> resGaussFr2;
        start = Instant.now();
        resGaussFr2 = fractionResGauss2.gaussMatrixPG();
        end = Instant.now();
        timeElapsed = Duration.between(start, end);
        System.out.println("Fraction: " + timeElapsed.toMillis() + " millisekund");
//        System.out.println(fractionResGauss.getMyNumber());
        saveResToFile(new MyMatrix<>(10, 1, resGaussFr2), "fractionResGauss2");

        SimpleMatrix libraryResGauss2 = new SimpleMatrix(libraryMatrixGauss2);
        start = Instant.now();
        libraryResGauss2 = libraryResGauss2.cols(0, libraryResGauss2.numCols() - 1).solve(libraryResGauss2.cols(libraryResGauss2.numCols() - 1, libraryResGauss2.numCols()));
        end = Instant.now();
        timeElapsed = Duration.between(start, end);
        System.out.println("Library: " + timeElapsed.toMillis() + " millisekund");
//        System.out.println(libraryResGauss);
        libraryResGauss2.saveToFileCSV("results/libraryResGauss2.txt");

    }
}
