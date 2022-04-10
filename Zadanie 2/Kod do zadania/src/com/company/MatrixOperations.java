package com.company;

import com.company.types.MyFraction;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
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

    public String calculateGauss(MyMatrix<T> matrix, String fileName) {
        String timeResults = fileName + "\n";
        MyMatrix<T> matRes1 = new MyMatrix<>(matrix.getMatrix());
        List<T> resGauss1;
        start = Instant.now();
        resGauss1 = matRes1.gaussMatrixG();
        end = Instant.now();
        timeElapsed = Duration.between(start, end);
        timeResults = timeResults + "Gauss P: " + timeElapsed.toMillis() + " millisekund\n";
        saveResToFile(new MyMatrix<>(matrix.getMatrix().size(), 1, resGauss1), "gaussPRes" + fileName);

        MyMatrix<T> matRes2 = new MyMatrix<>(matrix.getMatrix());
        List<T> resGauss2;
        start = Instant.now();
        resGauss2 = matRes2.gaussMatrixPG();
        end = Instant.now();
        timeElapsed = Duration.between(start, end);
        timeResults = timeResults + "Gauss PG: " + timeElapsed.toMillis() + " millisekund\n";
        saveResToFile(new MyMatrix<>(matrix.getMatrix().size(), 1, resGauss2), "gaussPGRes" + fileName);

        MyMatrix<T> matRes3 = new MyMatrix<>(matrix.getMatrix());
        List<T> resGauss3;
        start = Instant.now();
        resGauss3 = matRes3.gaussMatrixFG();
        end = Instant.now();
        timeElapsed = Duration.between(start, end);
        timeResults = timeResults + "Gauss FG: " + timeElapsed.toMillis() + " millisekund\n";
        saveResToFile(new MyMatrix<>(matrix.getMatrix().size(), 1, resGauss3), "gaussFGRes" + fileName);

        return timeResults;
    }

}
