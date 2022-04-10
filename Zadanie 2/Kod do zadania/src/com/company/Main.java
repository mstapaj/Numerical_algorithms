package com.company;

import com.company.types.MyDouble;
import com.company.types.MyFloat;
import com.company.types.MyFraction;

import java.io.FileWriter;
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
        ReadMatrixData matrix100 = new ReadMatrixData("100").collectData();
        ReadMatrixData matrix200 = new ReadMatrixData("200").collectData();

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
//
//        System.out.println(matrixOperationsFloat.calculateGauss(matrix50.floatMyMatrixGaussP, matrix50.floatMyMatrixGaussPG, matrix50.floatMyMatrixGaussFG, "float50Gauss"));
//        System.out.println(matrixOperationsDouble.calculateGauss(matrix50.doubleMyMatrixGaussP, matrix50.doubleMyMatrixGaussPG, matrix50.doubleMyMatrixGaussFG, "double50Gauss"));
//        System.out.println(matrixOperationsFraction.calculateGauss(matrix50.fractionMyMatrixGaussP, matrix50.fractionMyMatrixGaussPG, matrix50.fractionMyMatrixGaussFG, "fraction50Gauss"));
//        System.out.println(matrixLibrary.calculateGauss(matrix50.libraryMatrixGauss, "library50Gauss"));
//
//        System.out.println(matrixOperationsFloat.calculate(matrix100.floatMyMatrixA, matrix100.floatMyMatrixB, matrix100.floatMyMatrixC, matrix100.floatMyMatrixX, "float100"));
//        System.out.println(matrixOperationsDouble.calculate(matrix100.doubleMyMatrixA, matrix100.doubleMyMatrixB, matrix100.doubleMyMatrixC, matrix100.doubleMyMatrixX, "double100"));
//        System.out.println(matrixOperationsFraction.calculate(matrix100.fractionMyMatrixA, matrix100.fractionMyMatrixB, matrix100.fractionMyMatrixC, matrix100.fractionMyMatrixX, "fraction100"));
//        System.out.println(matrixLibrary.calculate(matrix100.libraryMatrixA, matrix100.libraryMatrixB, matrix100.libraryMatrixC, matrix100.libraryMatrixX, "library100"));

        System.out.println(matrixOperationsFloat.calculateGauss(matrix100.floatMyMatrixGaussP, matrix100.floatMyMatrixGaussPG, matrix100.floatMyMatrixGaussFG, "float100Gauss"));
        System.out.println(matrixOperationsDouble.calculateGauss(matrix100.doubleMyMatrixGaussP, matrix100.doubleMyMatrixGaussPG, matrix100.doubleMyMatrixGaussFG, "double100Gauss"));
        System.out.println(matrixOperationsFraction.calculateGauss(matrix100.fractionMyMatrixGaussP, matrix100.fractionMyMatrixGaussPG, matrix100.fractionMyMatrixGaussFG, "fraction100Gauss"));
        System.out.println(matrixLibrary.calculateGauss(matrix100.libraryMatrixGauss, "library100Gauss"));

//        System.out.println(matrixOperationsFloat.calculate(matrix200.floatMyMatrixA, matrix200.floatMyMatrixB, matrix200.floatMyMatrixC, matrix200.floatMyMatrixX, "float200"));
//        System.out.println(matrixOperationsDouble.calculate(matrix200.doubleMyMatrixA, matrix200.doubleMyMatrixB, matrix200.doubleMyMatrixC, matrix200.doubleMyMatrixX, "double200"));
//        System.out.println(matrixOperationsFraction.calculate(matrix200.fractionMyMatrixA, matrix200.fractionMyMatrixB, matrix200.fractionMyMatrixC, matrix200.fractionMyMatrixX, "fraction200"));
//        System.out.println(matrixLibrary.calculate(matrix200.libraryMatrixA, matrix200.libraryMatrixB, matrix200.libraryMatrixC, matrix200.libraryMatrixX, "library200"));
//
//        System.out.println(matrixOperationsFloat.calculateGauss(matrix200.floatMyMatrixGaussP, matrix200.floatMyMatrixGaussPG, matrix200.floatMyMatrixGaussFG, "float200Gauss"));
//        System.out.println(matrixOperationsDouble.calculateGauss(matrix200.doubleMyMatrixGaussP, matrix200.doubleMyMatrixGaussPG, matrix200.doubleMyMatrixGaussFG, "double200Gauss"));
//        System.out.println(matrixOperationsFraction.calculateGauss(matrix200.fractionMyMatrixGaussP, matrix200.fractionMyMatrixGaussPG, matrix200.fractionMyMatrixGaussFG, "fraction200Gauss"));
//        System.out.println(matrixLibrary.calculateGauss(matrix200.libraryMatrixGauss, "library200Gauss"));

        //A * X
//        System.out.println("A * X");
//
//        MyMatrix<MyFloat> floatRes1 = new MyMatrix<>(floatMyMatrixA.getMatrix());
//        start = Instant.now();
//        floatRes1 = floatRes1.multiplyMatrix(floatMyMatrixX);
//        end = Instant.now();
//        timeElapsed = Duration.between(start, end);
//        System.out.println("Float: " + timeElapsed.toMillis() + " millisekund");
////        System.out.println(floatRes1.getMatrix());
//        saveResToFile(floatRes1, "floatRes1");
////
//        MyMatrix<MyDouble> doubleRes1 = new MyMatrix<>(doubleMyMatrixA.getMatrix());
//        start = Instant.now();
//        doubleRes1 = doubleRes1.multiplyMatrix(doubleMyMatrixX);
//        end = Instant.now();
//        timeElapsed = Duration.between(start, end);
//        System.out.println("Double: " + timeElapsed.toMillis() + " millisekund");
////        System.out.println(doubleRes1.getMatrix());
//        saveResToFile(doubleRes1, "doubleRes1");
////
//        MyMatrix<MyFraction> fractionRes1 = new MyMatrix<>(fractionMyMatrixA.getMatrix());
//        start = Instant.now();
//        fractionRes1 = fractionRes1.multiplyMatrix(fractionMyMatrixX);
//        end = Instant.now();
//        timeElapsed = Duration.between(start, end);
//        System.out.println("Fraction: " + timeElapsed.toMillis() + " millisekund");
////        System.out.println(fractionRes1.getMatrix());
//        saveResToFile(fractionRes1, "fractionRes1");
//////
//        SimpleMatrix libraryRes1 = new SimpleMatrix(libraryMatrixA);
//        start = Instant.now();
//        libraryRes1 = libraryRes1.mult(libraryMatrixX);
//        end = Instant.now();
//        timeElapsed = Duration.between(start, end);
//        System.out.println("Library: " + timeElapsed.toMillis() + " millisekund");
////        System.out.println(libraryRes1);
//        libraryRes1.saveToFileCSV("results/libraryRes1.txt");
////
////
//        // (A + B + C) * X
//        System.out.println("(A + B + C) * X");
//
//        MyMatrix<MyFloat> floatRes2 = new MyMatrix<>(floatMyMatrixA.getMatrix());
//        start = Instant.now();
//        floatRes2 = floatRes2.addingMatrix(floatMyMatrixB).addingMatrix(floatMyMatrixC).multiplyMatrix(floatMyMatrixX);
//        end = Instant.now();
//        timeElapsed = Duration.between(start, end);
//        System.out.println("Float: " + timeElapsed.toMillis() + " millisekund");
////        System.out.println(floatRes2.getMyNumber());
//        saveResToFile(floatRes2, "floatRes2");
//
//        MyMatrix<MyDouble> doubleRes2 = new MyMatrix<>(doubleMyMatrixA.getMatrix());
//        start = Instant.now();
//        doubleRes2 = doubleRes2.addingMatrix(doubleMyMatrixB).addingMatrix(doubleMyMatrixC).multiplyMatrix(doubleMyMatrixX);
//        end = Instant.now();
//        timeElapsed = Duration.between(start, end);
//        System.out.println("Double: " + timeElapsed.toMillis() + " millisekund");
////        System.out.println(doubleRes2.getMyNumber());
//        saveResToFile(doubleRes2, "doubleRes2");
//
//        MyMatrix<MyFraction> fractionRes2 = new MyMatrix<>(fractionMyMatrixA.getMatrix());
//        start = Instant.now();
//        fractionRes2 = fractionRes2.addingMatrix(fractionMyMatrixB).addingMatrix(fractionMyMatrixC).multiplyMatrix(fractionMyMatrixX);
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
//        libraryRes2.saveToFileCSV("results/libraryRes2.txt");
//
//        // A * (B * C)
//        System.out.println("A * (B * C)");
//
//        MyMatrix<MyFloat> floatRes3 = new MyMatrix<>(floatMyMatrixB.getMatrix());
//        start = Instant.now();
//        floatRes3 = floatRes3.multiplyMatrix(floatMyMatrixC).multiplyMatrix(floatMyMatrixA);
//        end = Instant.now();
//        timeElapsed = Duration.between(start, end);
//        System.out.println("Float: " + timeElapsed.toMillis() + " millisekund");
////        System.out.println(floatRes3.getMyNumber());
//        saveResToFile(floatRes3, "floatRes3");
//
//        MyMatrix<MyDouble> doubleRes3 = new MyMatrix<>(doubleMyMatrixB.getMatrix());
//        start = Instant.now();
//        doubleRes3 = doubleRes3.multiplyMatrix(doubleMyMatrixC).multiplyMatrix(doubleMyMatrixA);
//        end = Instant.now();
//        timeElapsed = Duration.between(start, end);
//        System.out.println("Double: " + timeElapsed.toMillis() + " millisekund");
////        System.out.println(doubleRes3.getMyNumber());
//        saveResToFile(doubleRes3, "doubleRes3");
//
//        MyMatrix<MyFraction> fractionRes3 = new MyMatrix<>(fractionMyMatrixB.getMatrix());
//        start = Instant.now();
//        fractionRes3 = fractionRes3.multiplyMatrix(fractionMyMatrixC).shortenMatrix().multiplyMatrix(fractionMyMatrixA);
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
//        libraryRes3.saveToFileCSV("results/libraryRes3.txt");


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

//         Gauss P
//        System.out.println("Gauss P");
//
//        MyMatrix<MyFloat> floatResGauss = new MyMatrix<>(floatMyMatrixGauss.getMatrix());
//        List<MyFloat> resGaussF;
//        start = Instant.now();
//        resGaussF = floatResGauss.gaussMatrixG();
//        end = Instant.now();
//        timeElapsed = Duration.between(start, end);
//        System.out.println("Float: " + timeElapsed.toMillis() + " millisekund");
////        System.out.println(floatResGauss.getMyNumber());
//        saveResToFile(new MyMatrix<>(25, 1, resGaussF), "floatResGauss");
//
//        MyMatrix<MyDouble> doubleResGauss = new MyMatrix<>(doubleMyMatrixGauss.getMatrix());
//        List<MyDouble> resGaussD;
//        start = Instant.now();
//        resGaussD = doubleResGauss.gaussMatrixG();
//        end = Instant.now();
//        timeElapsed = Duration.between(start, end);
//        System.out.println("Double: " + timeElapsed.toMillis() + " millisekund");
////        System.out.println(doubleResGauss.getMyNumber());
//        saveResToFile(new MyMatrix<>(25, 1, resGaussD), "doubleResGauss");
//
//        MyMatrix<MyFraction> fractionResGauss = new MyMatrix<>(fractionMyMatrixGauss.getMatrix());
//        List<MyFraction> resGaussFr;
//        start = Instant.now();
//        resGaussFr = fractionResGauss.gaussMatrixG();
//        end = Instant.now();
//        timeElapsed = Duration.between(start, end);
//        System.out.println("Fraction: " + timeElapsed.toMillis() + " millisekund");
////        System.out.println(fractionResGauss.getMyNumber());
//        saveResToFile(new MyMatrix<>(25, 1, resGaussFr), "fractionResGauss");
//
//        SimpleMatrix libraryResGauss = new SimpleMatrix(libraryMatrixGauss);
//        start = Instant.now();
//        libraryResGauss = libraryResGauss.cols(0, libraryResGauss.numCols() - 1).solve(libraryResGauss.cols(libraryResGauss.numCols() - 1, libraryResGauss.numCols()));
//        end = Instant.now();
//        timeElapsed = Duration.between(start, end);
//        System.out.println("Library: " + timeElapsed.toMillis() + " millisekund");
////        System.out.println(libraryResGauss);
//        libraryResGauss.saveToFileCSV("results/libraryResGauss.txt");
//
//        // Gauss PG
//        System.out.println("Gauss PG");
////
//        MyMatrix<MyFloat> floatResGauss2 = new MyMatrix<>(floatMyMatrixGauss2.getMatrix());
//        List<MyFloat> resGaussF2;
//        start = Instant.now();
//        resGaussF2 = floatResGauss2.gaussMatrixPG();
//        end = Instant.now();
//        timeElapsed = Duration.between(start, end);
//        System.out.println("Float: " + timeElapsed.toMillis() + " millisekund");
////        System.out.println(floatResGauss.getMyNumber());
//        saveResToFile(new MyMatrix<>(25, 1, resGaussF2), "floatResGauss2");
//
//        MyMatrix<MyDouble> doubleResGauss2 = new MyMatrix<>(doubleMyMatrixGauss2.getMatrix());
//        List<MyDouble> resGaussD2;
//        start = Instant.now();
//        resGaussD2 = doubleResGauss2.gaussMatrixPG();
//        end = Instant.now();
//        timeElapsed = Duration.between(start, end);
//        System.out.println("Double: " + timeElapsed.toMillis() + " millisekund");
////        System.out.println(doubleResGauss.getMyNumber());
//        saveResToFile(new MyMatrix<>(25, 1, resGaussD2), "doubleResGauss2");
//
//        MyMatrix<MyFraction> fractionResGauss2 = new MyMatrix<>(fractionMyMatrixGauss2.getMatrix());
//        List<MyFraction> resGaussFr2;
//        start = Instant.now();
//        resGaussFr2 = fractionResGauss2.gaussMatrixPG();
//        end = Instant.now();
//        timeElapsed = Duration.between(start, end);
//        System.out.println("Fraction: " + timeElapsed.toMillis() + " millisekund");
////        System.out.println(fractionResGauss.getMyNumber());
//        saveResToFile(new MyMatrix<>(25, 1, resGaussFr2), "fractionResGauss2");
//
//        SimpleMatrix libraryResGauss2 = new SimpleMatrix(libraryMatrixGauss2);
//        start = Instant.now();
//        libraryResGauss2 = libraryResGauss2.cols(0, libraryResGauss2.numCols() - 1).solve(libraryResGauss2.cols(libraryResGauss2.numCols() - 1, libraryResGauss2.numCols()));
//        end = Instant.now();
//        timeElapsed = Duration.between(start, end);
//        System.out.println("Library: " + timeElapsed.toMillis() + " millisekund");
////        System.out.println(libraryResGauss);
//        libraryResGauss2.saveToFileCSV("results/libraryResGauss2.txt");
//
//        // Gauss FG
//        System.out.println("Gauss FG");
////
//        MyMatrix<MyFloat> floatResGauss3 = new MyMatrix<>(floatMyMatrixGauss3.getMatrix());
//        List<MyFloat> resGaussF3;
//        start = Instant.now();
//        resGaussF3 = floatResGauss3.gaussMatrixFG();
//        end = Instant.now();
//        timeElapsed = Duration.between(start, end);
//        System.out.println("Float: " + timeElapsed.toMillis() + " millisekund");
////        System.out.println(floatResGauss.getMyNumber());
//        saveResToFile(new MyMatrix<>(25, 1, resGaussF3), "floatResGauss3");
//
//        MyMatrix<MyDouble> doubleResGauss3 = new MyMatrix<>(doubleMyMatrixGauss3.getMatrix());
//        List<MyDouble> resGaussD3;
//        start = Instant.now();
//        resGaussD3 = doubleResGauss3.gaussMatrixFG();
//        end = Instant.now();
//        timeElapsed = Duration.between(start, end);
//        System.out.println("Double: " + timeElapsed.toMillis() + " millisekund");
////        System.out.println(doubleResGauss.getMyNumber());
//        saveResToFile(new MyMatrix<>(25, 1, resGaussD3), "doubleResGauss3");
//
//        MyMatrix<MyFraction> fractionResGauss3 = new MyMatrix<>(fractionMyMatrixGauss3.getMatrix());
//        List<MyFraction> resGaussFr3;
//        start = Instant.now();
//        resGaussFr3 = fractionResGauss3.gaussMatrixFG();
//        end = Instant.now();
//        timeElapsed = Duration.between(start, end);
//        System.out.println("Fraction: " + timeElapsed.toMillis() + " millisekund");
////        System.out.println(fractionResGauss.getMyNumber());
//        saveResToFile(new MyMatrix<>(25, 1, resGaussFr3), "fractionResGauss3");
//
//        SimpleMatrix libraryResGauss3 = new SimpleMatrix(libraryMatrixGauss3);
//        start = Instant.now();
//        libraryResGauss3 = libraryResGauss3.cols(0, libraryResGauss3.numCols() - 1).solve(libraryResGauss3.cols(libraryResGauss3.numCols() - 1, libraryResGauss3.numCols()));
//        end = Instant.now();
//        timeElapsed = Duration.between(start, end);
//        System.out.println("Library: " + timeElapsed.toMillis() + " millisekund");
////        System.out.println(libraryResGauss);
//        libraryResGauss3.saveToFileCSV("results/libraryResGauss3.txt");

    }
}
