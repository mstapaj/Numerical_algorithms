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

    public String calculate(MyMatrix<T> matrixA, MyMatrix<T> matrixB, MyMatrix<T> matrixC, MyMatrix<T> matrixX, String fileName) {
        String timeResults = fileName + "\n";
        MyMatrix<T> matRes1 = new MyMatrix<>(matrixA.getMatrix());
        start = Instant.now();
        matRes1 = matRes1.multiplyMatrix(matrixX);
        end = Instant.now();
        timeElapsed = Duration.between(start, end);
        timeResults = timeResults + "A * X: " + timeElapsed.toMillis() + " millisekund\n";
        saveResToFile(matRes1, "matRes1" + fileName);

        MyMatrix<T> matRes2 = new MyMatrix<>(matrixA.getMatrix());
        start = Instant.now();
        matRes2 = matRes2.addingMatrix(matrixB).addingMatrix(matrixC).multiplyMatrix(matrixX);
        end = Instant.now();
        timeElapsed = Duration.between(start, end);
        timeResults = timeResults + "(A + B + C) * X: " + timeElapsed.toMillis() + " millisekund\n";
        saveResToFile(matRes2, "matRes2" + fileName);

        MyMatrix<T> matRes3 = new MyMatrix<>(matrixB.getMatrix());
        start = Instant.now();
        matRes3 = matRes3.multiplyMatrix(matrixC).multiplyMatrix(matrixA);
        end = Instant.now();
        timeElapsed = Duration.between(start, end);
        timeResults = timeResults + "A * (B * C): " + timeElapsed.toMillis() + " millisekund\n";
        saveResToFile(matRes3, "matRes3" + fileName);
        return timeResults;
    }

    public String calculateGauss(MyMatrix<T> matrixA, MyMatrix<T> matrixX, String fileName) {

        BigDecimal normX = matrixX.calculateNorm();
        List<BigDecimal> listOfDiff = new ArrayList<>();
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

            MyMatrix<T> matRes2 = new MyMatrix<>(matrixA.getMatrix());
            MyMatrix<T> temp2 = matRes2.multiplyMatrix(matrixX);
            matRes2 = matRes2.makeMatrixToGauss(temp2);
            start = Instant.now();
            resGauss2 = matRes2.gaussMatrixPG();
            end = Instant.now();
            timeElapsed = Duration.between(start, end);
            listOfTimesPG.add(timeElapsed.toMillis());
            saveResToFile(new MyMatrix<>(matrixA.getMatrix().size(), 1, resGauss2), "gaussPGRes" + fileName);

            MyMatrix<T> matRes3 = new MyMatrix<>(matrixA.getMatrix());
            MyMatrix<T> temp3 = matRes3.multiplyMatrix(matrixX);
            matRes3 = matRes3.makeMatrixToGauss(temp3);
            start = Instant.now();
            resGauss3 = matRes3.gaussMatrixFG();
            end = Instant.now();
            timeElapsed = Duration.between(start, end);
            listOfTimesFG.add(timeElapsed.toMillis());
            saveResToFile(new MyMatrix<>(matrixA.getMatrix().size(), 1, resGauss3), "gaussFGRes" + fileName);
        }

        listOfDiff.add(normX.subtract(new MyMatrix<>(matrixA.getMatrix().size(), 1, resGauss1).calculateNorm()).abs());
        listOfDiff.add(normX.subtract(new MyMatrix<>(matrixA.getMatrix().size(), 1, resGauss2).calculateNorm()).abs());
        listOfDiff.add(normX.subtract(new MyMatrix<>(matrixA.getMatrix().size(), 1, resGauss3).calculateNorm()).abs());
        saveDiffToFile(listOfDiff, fileName);

        listOfTimes.add(Collections.min(listOfTimesG));
        listOfTimes.add(Collections.min(listOfTimesPG));
        listOfTimes.add(Collections.min(listOfTimesFG));
        saveTimesToFile(listOfTimes, fileName);

        return "Policzono " + fileName;
    }

}
