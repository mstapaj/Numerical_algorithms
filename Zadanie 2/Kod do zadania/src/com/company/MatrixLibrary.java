package com.company;

import org.ejml.simple.SimpleMatrix;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

public class MatrixLibrary {
    Instant start;
    Instant end;
    Duration timeElapsed;


    public String calculate(SimpleMatrix matrixA, SimpleMatrix matrixB, SimpleMatrix matrixC, SimpleMatrix matrixX, String fileName) throws IOException {
        String timeResults = fileName + "\n";

        SimpleMatrix matRes1 = new SimpleMatrix(matrixA);
        start = Instant.now();
        matRes1 = matRes1.mult(matrixX);
        end = Instant.now();
        timeElapsed = Duration.between(start, end);
        timeResults = timeResults + "A * X: " + timeElapsed.toMillis() + " millisekund\n";
        matRes1.saveToFileCSV("results/libraryRes1" + fileName + ".txt");

        SimpleMatrix matRes2 = new SimpleMatrix(matrixA);
        start = Instant.now();
        matRes2 = matRes2.plus(matrixB).plus(matrixC).mult(matrixX);
        end = Instant.now();
        timeElapsed = Duration.between(start, end);
        timeResults = timeResults + "(A + B + C) * X: " + timeElapsed.toMillis() + " millisekund\n";
        matRes2.saveToFileCSV("results/libraryRes2" + fileName + ".txt");

        SimpleMatrix matRes3 = new SimpleMatrix(matrixB);
        start = Instant.now();
        matRes3 = matRes3.mult(matrixC).mult(matrixA);
        end = Instant.now();
        timeElapsed = Duration.between(start, end);
        timeResults = timeResults + "A * (B * C): " + timeElapsed.toMillis() + " millisekund\n";
        matRes3.saveToFileCSV("results/libraryRes3" + fileName + ".txt");

        return timeResults;
    }

    public String calculateGauss(SimpleMatrix matrix, String fileName) throws IOException {
        String timeResults = fileName + "\n";

        SimpleMatrix matRes1 = new SimpleMatrix(matrix);
        start = Instant.now();
        matRes1 = matRes1.cols(0, matRes1.numCols() - 1).solve(matRes1.cols(matRes1.numCols() - 1, matRes1.numCols()));
        end = Instant.now();
        timeElapsed = Duration.between(start, end);
        timeResults = timeResults + "Gauss library: " + timeElapsed.toMillis() + " millisekund\n";
        matRes1.saveToFileCSV("results/libraryResGauss" + fileName + ".txt");

        return timeResults;
    }
}
