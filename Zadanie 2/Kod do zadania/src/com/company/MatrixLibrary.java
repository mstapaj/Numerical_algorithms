package com.company;

import org.ejml.simple.SimpleMatrix;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MatrixLibrary {
    Instant start;
    Instant end;
    Duration timeElapsed;


    public static void saveResToFile(SimpleMatrix resMatrix, String fileName) {
        try {
            FileWriter fileWriter = new FileWriter("results/" + fileName + ".txt");
            for (int i = 0; i < resMatrix.numRows(); i++) {
                for (int j = 0; j < resMatrix.numCols(); j++) {
                    fileWriter.write(resMatrix.get(i, j) + "\n");
                }
            }
            fileWriter.close();
        } catch (IOException err) {
            err.printStackTrace();
        }
    }

    public static BigDecimal calculateNorm(SimpleMatrix matrix) {
        BigDecimal sum = new BigDecimal(0);
        for (int i = 0; i < matrix.numRows(); i++) {
            sum = sum.add(BigDecimal.valueOf(matrix.get(i, 0)).abs());
        }
        return sum;
    }

    public void calculate(SimpleMatrix matrixA, SimpleMatrix matrixB, SimpleMatrix matrixC, SimpleMatrix matrixX, String fileName) throws IOException {

        List<Long> listOfTimes1 = new ArrayList<>();
        List<Long> listOfTimes2 = new ArrayList<>();
        List<Long> listOfTimes3 = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            SimpleMatrix matRes1 = new SimpleMatrix(matrixA);
            start = Instant.now();
            matRes1 = matRes1.mult(matrixX);
            end = Instant.now();
            timeElapsed = Duration.between(start, end);
            listOfTimes1.add(timeElapsed.toMillis());
            saveResToFile(matRes1, "matRes1" + fileName);

            SimpleMatrix matRes2 = new SimpleMatrix(matrixA);
            start = Instant.now();
            matRes2 = matRes2.plus(matrixB).plus(matrixC).mult(matrixX);
            end = Instant.now();
            timeElapsed = Duration.between(start, end);
            listOfTimes2.add(timeElapsed.toMillis());
            saveResToFile(matRes2, "matRes2" + fileName);

            SimpleMatrix matRes3 = new SimpleMatrix(matrixB);
            start = Instant.now();
            matRes3 = matRes3.mult(matrixC).mult(matrixA);
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

    public List<String> calculateGauss(SimpleMatrix matrixA, SimpleMatrix matrixX, String fileName) throws IOException {
        BigDecimal normX = calculateNorm(matrixX);
        List<BigDecimal> listOfDiff = new ArrayList<>();
        List<Long> listOfTimes = new ArrayList<>();

        SimpleMatrix matRes1 = null;
        for (int i = 0; i < 10; i++) {
            matRes1 = new SimpleMatrix(matrixA);
            SimpleMatrix temp1 = matRes1.mult(matrixX);
            start = Instant.now();
            matRes1 = matRes1.solve(temp1);
            end = Instant.now();
            timeElapsed = Duration.between(start, end);
            listOfTimes.add(timeElapsed.toMillis());
            saveResToFile(matRes1, "matResGauss" + fileName);
        }

        listOfDiff.add(normX.subtract(calculateNorm(matRes1)).abs());

        List<String> result = new ArrayList<>();
        result.add(String.valueOf(listOfDiff));
        result.add("[" + Collections.min(listOfTimes) + "]");

        return result;
    }
}
