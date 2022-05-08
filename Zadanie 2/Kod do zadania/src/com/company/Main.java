package com.company;

import com.company.types.MyDouble;
import com.company.types.MyFloat;
import com.company.types.MyFraction;

import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void measureOperations(Integer[] forFraction, Integer[] forOtherTypes, MatrixOperations<MyFloat> matrixOperationsFloat, MatrixOperations<MyDouble> matrixOperationsDouble, MatrixOperations<MyFraction> matrixOperationsFraction, MatrixLibrary matrixLibrary) throws IOException {
        for (Integer iter : forOtherTypes) {
            ReadMatrixData matrix = new ReadMatrixData("500", iter).collectData();
            matrixOperationsFloat.calculate(matrix.floatMyMatrixA, matrix.floatMyMatrixB, matrix.floatMyMatrixC, matrix.floatMyMatrixX, "float" + iter);
            matrixOperationsDouble.calculate(matrix.doubleMyMatrixA, matrix.doubleMyMatrixB, matrix.doubleMyMatrixC, matrix.doubleMyMatrixX, "double" + iter);
            if (Arrays.asList(forFraction).contains(iter)) {
                matrixOperationsFraction.calculate(matrix.fractionMyMatrixA, matrix.fractionMyMatrixB, matrix.fractionMyMatrixC, matrix.fractionMyMatrixX, "fraction" + iter);
            }
            matrixLibrary.calculate(matrix.libraryMatrixA, matrix.libraryMatrixB, matrix.libraryMatrixC, matrix.libraryMatrixX, "library" + iter);
            matrix = null;
        }
    }

    public static void measureGauss(Integer[] forFraction, Integer[] forOtherTypes, MatrixOperations<MyFloat> matrixOperationsFloat, MatrixOperations<MyDouble> matrixOperationsDouble, MatrixOperations<MyFraction> matrixOperationsFraction, MatrixLibrary matrixLibrary, ResultToSave resToSave) throws IOException {
        for (Integer iter : forOtherTypes) {
            ReadMatrixData matrix = new ReadMatrixData("500", iter).collectData();
            resToSave.addMatrixSize("matrix" + iter);
            resToSave.addResults(matrixOperationsFloat.calculateGauss(matrix.floatMyMatrixA, matrix.floatMyMatrixX, "float" + iter + "Gauss"), "Float");
            resToSave.addResults(matrixOperationsDouble.calculateGauss(matrix.doubleMyMatrixA, matrix.doubleMyMatrixX, "double" + iter + "Gauss"), "Double");
            if (Arrays.asList(forFraction).contains(iter)) {
                resToSave.addResults(matrixOperationsFraction.calculateGauss(matrix.fractionMyMatrixA, matrix.fractionMyMatrixX, "fraction" + iter + "Gauss"), "Fraction");
            }
            resToSave.addResults(matrixLibrary.calculateGauss(matrix.libraryMatrixA, matrix.libraryMatrixX, "library" + iter + "Gauss"), "Library");
            System.out.println("Policzono Gauss matrix" + iter);
            matrix = null;
        }
        resToSave.saveToFileResults();
    }


    public static void main(String[] args) throws IOException {

        MatrixOperations<MyFloat> matrixOperationsFloat = new MatrixOperations<>();
        MatrixOperations<MyDouble> matrixOperationsDouble = new MatrixOperations<>();
        MatrixOperations<MyFraction> matrixOperationsFraction = new MatrixOperations<>();
        MatrixLibrary matrixLibrary = new MatrixLibrary();
        ResultToSave resToSave = new ResultToSave();

        Integer[] forOtherTypes = new Integer[]{
                10, 15, 20, 25, 30, 35, 40, 45, 50, 100, 150, 200, 250, 300, 350, 400, 450, 500
        };
        Integer[] forFraction = new Integer[]{
                10, 15, 20, 25, 30, 35, 40, 45, 50
        };

//        Integer[] forOtherTypes = new Integer[]{
//                10, 15, 20, 25
//        };
//        Integer[] forFraction = new Integer[]{
//                10, 15
//        };

        measureOperations(forFraction, forOtherTypes, matrixOperationsFloat, matrixOperationsDouble, matrixOperationsFraction, matrixLibrary);
        measureGauss(forFraction, forOtherTypes, matrixOperationsFloat, matrixOperationsDouble, matrixOperationsFraction, matrixLibrary, resToSave);
    }
}
