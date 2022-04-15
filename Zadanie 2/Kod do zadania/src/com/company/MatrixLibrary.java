package com.company;

import org.ejml.simple.SimpleMatrix;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

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

    public String calculate(SimpleMatrix matrixA, SimpleMatrix matrixB, SimpleMatrix matrixC, SimpleMatrix matrixX, String fileName) throws IOException {
        String timeResults = fileName + "\n";

        SimpleMatrix matRes1 = new SimpleMatrix(matrixA);
        start = Instant.now();
        matRes1 = matRes1.mult(matrixX);
        end = Instant.now();
        timeElapsed = Duration.between(start, end);
        timeResults = timeResults + "A * X: " + timeElapsed.toMillis() + " millisekund\n";
        saveResToFile(matRes1, "matRes1" + fileName);

        SimpleMatrix matRes2 = new SimpleMatrix(matrixA);
        start = Instant.now();
        matRes2 = matRes2.plus(matrixB).plus(matrixC).mult(matrixX);
        end = Instant.now();
        timeElapsed = Duration.between(start, end);
        timeResults = timeResults + "(A + B + C) * X: " + timeElapsed.toMillis() + " millisekund\n";
        saveResToFile(matRes2, "matRes2" + fileName);

        SimpleMatrix matRes3 = new SimpleMatrix(matrixB);
        start = Instant.now();
        matRes3 = matRes3.mult(matrixC).mult(matrixA);
        end = Instant.now();
        timeElapsed = Duration.between(start, end);
        timeResults = timeResults + "A * (B * C): " + timeElapsed.toMillis() + " millisekund\n";
        saveResToFile(matRes3, "matRes3" + fileName);

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
        saveResToFile(matRes1, "matResGauss" + fileName);

        return timeResults;
    }
}
