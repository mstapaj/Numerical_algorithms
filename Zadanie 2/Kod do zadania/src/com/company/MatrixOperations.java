package com.company;

import com.company.types.MyFraction;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MatrixOperations<T extends MyNumber<T>> {
    Instant start;
    Instant end;
    Duration timeElapsed;

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

    public static void saveDiffToFile(List<BigDecimal> listOfDiff, String fileName) {
        try {
            FileWriter fileWriter = new FileWriter("resultsNormDiff/" + fileName + ".txt");
            for (int i = 0; i < listOfDiff.size(); i++) {
                fileWriter.write((listOfDiff.get(i) + "\n"));
            }
            fileWriter.close();
        } catch (IOException err) {
            err.printStackTrace();
        }
    }

    public static void saveTimesToFile(List<Long> listOfDiff, String fileName) {
        try {
            FileWriter fileWriter = new FileWriter("resultsTimes/" + fileName + ".txt");
            for (int i = 0; i < listOfDiff.size(); i++) {
                fileWriter.write((listOfDiff.get(i) + "\n"));
            }
            fileWriter.close();
        } catch (IOException err) {
            err.printStackTrace();
        }
    }

    public void calculate(MyMatrix<T> matrixA, MyMatrix<T> matrixB, MyMatrix<T> matrixC, MyMatrix<T> matrixX, String fileName) {

        List<Long> listOfTimes1 = new ArrayList<>();
        List<Long> listOfTimes2 = new ArrayList<>();
        List<Long> listOfTimes3 = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            MyMatrix<T> matRes1 = new MyMatrix<>(matrixA.getMatrix());
            start = Instant.now();
            matRes1 = matRes1.multiplyMatrix(matrixX);
            end = Instant.now();
            timeElapsed = Duration.between(start, end);
            listOfTimes1.add(timeElapsed.toMillis());
            saveResToFile(matRes1, "matRes1" + fileName);

            MyMatrix<T> matRes2 = new MyMatrix<>(matrixA.getMatrix());
            start = Instant.now();
            matRes2 = matRes2.addingMatrix(matrixB).addingMatrix(matrixC).multiplyMatrix(matrixX);
            end = Instant.now();
            timeElapsed = Duration.between(start, end);
            listOfTimes2.add(timeElapsed.toMillis());
            saveResToFile(matRes2, "matRes2" + fileName);

            MyMatrix<T> matRes3 = new MyMatrix<>(matrixB.getMatrix());
            start = Instant.now();
            matRes3 = matRes3.multiplyMatrix(matrixC).multiplyMatrix(matrixA);
            end = Instant.now();
            timeElapsed = Duration.between(start, end);
            listOfTimes3.add(timeElapsed.toMillis());
            saveResToFile(matRes3, "matRes3" + fileName);
        }

        System.out.println(fileName);
        System.out.println("A * X: " + Collections.min(listOfTimes1));
        System.out.println("(A + B + C) * X: " + Collections.min(listOfTimes2));
        System.out.println("A * (B * C): " + Collections.min(listOfTimes3));

    }

    public List<String> calculateGauss(MyMatrix<T> matrixA, MyMatrix<T> matrixX, String fileName) {

        T normX1 = matrixX.calculateNorm();
        T normX2 = matrixX.calculateNorm();
        T normX3 = matrixX.calculateNorm();
        List<Number> listOfDiff = new ArrayList<>();
        List<Long> listOfTimesG = new ArrayList<>();
        List<Long> listOfTimesPG = new ArrayList<>();
        List<Long> listOfTimesFG = new ArrayList<>();
        List<Long> listOfTimes = new ArrayList<>();

        List<T> resGauss1 = null;
        List<T> resGauss2 = null;
        List<T> resGauss3 = null;
        for (int i = 0; i < 10; i++) {
            MyMatrix<T> matRes1 = new MyMatrix<>(matrixA.getMatrix());
            MyMatrix<T> temp1 = matRes1.multiplyMatrix(matrixX);
            matRes1 = matRes1.makeMatrixToGauss(temp1);
            start = Instant.now();
            resGauss1 = matRes1.gaussMatrixG();
            end = Instant.now();
            timeElapsed = Duration.between(start, end);
            listOfTimesG.add(timeElapsed.toMillis());
            saveResToFile(new MyMatrix<>(matrixA.getMatrix().size(), 1, resGauss1), "gaussPRes" + fileName);
            saveResToFile(matrixX, "gaussPResX" + fileName);

            MyMatrix<T> matRes2 = new MyMatrix<>(matrixA.getMatrix());
            MyMatrix<T> temp2 = matRes2.multiplyMatrix(matrixX);
            matRes2 = matRes2.makeMatrixToGauss(temp2);
            start = Instant.now();
            resGauss2 = matRes2.gaussMatrixPG();
            end = Instant.now();
            timeElapsed = Duration.between(start, end);
            listOfTimesPG.add(timeElapsed.toMillis());
            saveResToFile(new MyMatrix<>(matrixA.getMatrix().size(), 1, resGauss2), "gaussPGRes" + fileName);
            saveResToFile(matrixX, "gaussPGResX" + fileName);

            MyMatrix<T> matRes3 = new MyMatrix<>(matrixA.getMatrix());
            MyMatrix<T> temp3 = matRes3.multiplyMatrix(matrixX);
            matRes3 = matRes3.makeMatrixToGauss(temp3);
            start = Instant.now();
            resGauss3 = matRes3.gaussMatrixFG();
            end = Instant.now();
            timeElapsed = Duration.between(start, end);
            listOfTimesFG.add(timeElapsed.toMillis());
            saveResToFile(new MyMatrix<>(matrixA.getMatrix().size(), 1, resGauss3), "gaussFGRes" + fileName);
            saveResToFile(matrixX, "gaussFGResX" + fileName);
        }

        normX1.sub(new MyMatrix<>(matrixA.getMatrix().size(), 1, resGauss1).calculateNorm());
        normX2.sub(new MyMatrix<>(matrixA.getMatrix().size(), 1, resGauss2).calculateNorm());
        normX3.sub(new MyMatrix<>(matrixA.getMatrix().size(), 1, resGauss3).calculateNorm());

        Collections.addAll(listOfDiff, normX1.absolute().getNumber(), normX2.absolute().getNumber(), normX3.absolute().getNumber());

        listOfTimes.add(Collections.min(listOfTimesG));
        listOfTimes.add(Collections.min(listOfTimesPG));
        listOfTimes.add(Collections.min(listOfTimesFG));

        List<String> result = new ArrayList<>();
        result.add(String.valueOf(listOfDiff));
        result.add(String.valueOf(listOfTimes));

        return result;
    }

}
