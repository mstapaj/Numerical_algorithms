package com.company;

import com.company.types.MyDouble;
import com.company.types.MyFloat;
import com.company.types.MyFraction;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        MatrixOperations<MyFloat> matrixOperationsFloat = new MatrixOperations<>();
        MatrixOperations<MyDouble> matrixOperationsDouble = new MatrixOperations<>();
        MatrixOperations<MyFraction> matrixOperationsFraction = new MatrixOperations<>();
        MatrixLibrary matrixLibrary = new MatrixLibrary();
        ResultToSave resToSave = new ResultToSave();

//        ReadMatrixData matrix10 = new ReadMatrixData("10").collectData();
//        System.out.println(matrixOperationsFloat.calculate(matrix10.floatMyMatrixA, matrix10.floatMyMatrixB, matrix10.floatMyMatrixC, matrix10.floatMyMatrixX, "float10"));
//        System.out.println(matrixOperationsDouble.calculate(matrix10.doubleMyMatrixA, matrix10.doubleMyMatrixB, matrix10.doubleMyMatrixC, matrix10.doubleMyMatrixX, "double10"));
//        System.out.println(matrixOperationsFraction.calculate(matrix10.fractionMyMatrixA, matrix10.fractionMyMatrixB, matrix10.fractionMyMatrixC, matrix10.fractionMyMatrixX, "fraction10"));
//        System.out.println(matrixLibrary.calculate(matrix10.libraryMatrixA, matrix10.libraryMatrixB, matrix10.libraryMatrixC, matrix10.libraryMatrixX, "library10"));
//        matrix10 = null;
//
//        ReadMatrixData matrix30 = new ReadMatrixData("30").collectData();
//        System.out.println(matrixOperationsFloat.calculate(matrix30.floatMyMatrixA, matrix30.floatMyMatrixB, matrix30.floatMyMatrixC, matrix30.floatMyMatrixX, "float30"));
//        System.out.println(matrixOperationsDouble.calculate(matrix30.doubleMyMatrixA, matrix30.doubleMyMatrixB, matrix30.doubleMyMatrixC, matrix30.doubleMyMatrixX, "double30"));
//        System.out.println(matrixOperationsFraction.calculate(matrix30.fractionMyMatrixA, matrix30.fractionMyMatrixB, matrix30.fractionMyMatrixC, matrix30.fractionMyMatrixX, "fraction30"));
//        System.out.println(matrixLibrary.calculate(matrix30.libraryMatrixA, matrix30.libraryMatrixB, matrix30.libraryMatrixC, matrix30.libraryMatrixX, "library30"));
//        matrix30 = null;
//
//        ReadMatrixData matrix50 = new ReadMatrixData("50").collectData();
//        System.out.println(matrixOperationsFloat.calculate(matrix50.floatMyMatrixA, matrix50.floatMyMatrixB, matrix50.floatMyMatrixC, matrix50.floatMyMatrixX, "float50"));
//        System.out.println(matrixOperationsDouble.calculate(matrix50.doubleMyMatrixA, matrix50.doubleMyMatrixB, matrix50.doubleMyMatrixC, matrix50.doubleMyMatrixX, "double50"));
//        System.out.println(matrixOperationsFraction.calculate(matrix50.fractionMyMatrixA, matrix50.fractionMyMatrixB, matrix50.fractionMyMatrixC, matrix50.fractionMyMatrixX, "fraction50"));
//        System.out.println(matrixLibrary.calculate(matrix50.libraryMatrixA, matrix50.libraryMatrixB, matrix50.libraryMatrixC, matrix50.libraryMatrixX, "library50"));
//        matrix50 = null;
//
//        ReadMatrixData matrix100 = new ReadMatrixData("100").collectData();
//        System.out.println(matrixOperationsFloat.calculate(matrix100.floatMyMatrixA, matrix100.floatMyMatrixB, matrix100.floatMyMatrixC, matrix100.floatMyMatrixX, "float100"));
//        System.out.println(matrixOperationsDouble.calculate(matrix100.doubleMyMatrixA, matrix100.doubleMyMatrixB, matrix100.doubleMyMatrixC, matrix100.doubleMyMatrixX, "double100"));
//        System.out.println(matrixOperationsFraction.calculate(matrix100.fractionMyMatrixA, matrix100.fractionMyMatrixB, matrix100.fractionMyMatrixC, matrix100.fractionMyMatrixX, "fraction100"));
//        System.out.println(matrixLibrary.calculate(matrix100.libraryMatrixA, matrix100.libraryMatrixB, matrix100.libraryMatrixC, matrix100.libraryMatrixX, "library100"));
//        matrix100 = null;
//
//        ReadMatrixData matrix300 = new ReadMatrixData("300").collectData();
//        System.out.println(matrixOperationsFloat.calculate(matrix300.floatMyMatrixA, matrix300.floatMyMatrixB, matrix300.floatMyMatrixC, matrix300.floatMyMatrixX, "float300"));
//        System.out.println(matrixOperationsDouble.calculate(matrix300.doubleMyMatrixA, matrix300.doubleMyMatrixB, matrix300.doubleMyMatrixC, matrix300.doubleMyMatrixX, "double300"));
//        System.out.println(matrixLibrary.calculate(matrix300.libraryMatrixA, matrix300.libraryMatrixB, matrix300.libraryMatrixC, matrix300.libraryMatrixX, "library300"));
//        matrix300 = null;
//
//        ReadMatrixData matrix500 = new ReadMatrixData("500").collectData();
//        System.out.println(matrixOperationsFloat.calculate(matrix500.floatMyMatrixA, matrix500.floatMyMatrixB, matrix500.floatMyMatrixC, matrix500.floatMyMatrixX, "float500"));
//        System.out.println(matrixOperationsDouble.calculate(matrix500.doubleMyMatrixA, matrix500.doubleMyMatrixB, matrix500.doubleMyMatrixC, matrix500.doubleMyMatrixX, "double500"));
//        System.out.println(matrixLibrary.calculate(matrix500.libraryMatrixA, matrix500.libraryMatrixB, matrix500.libraryMatrixC, matrix500.libraryMatrixX, "library500"));
//        matrix500 = null;

        // Gauss
//        ReadMatrixData matrix10 = new ReadMatrixData("10").collectData();
//        resToSave.addMatrixSize("matrix10");
//        resToSave.addResults(matrixOperationsFloat.calculateGauss(matrix10.floatMyMatrixA, matrix10.floatMyMatrixX, "float10Gauss"),"Float");
//        resToSave.addResults(matrixOperationsDouble.calculateGauss(matrix10.doubleMyMatrixA, matrix10.doubleMyMatrixX, "double10Gauss"),"Double");
//        resToSave.addResults(matrixOperationsFraction.calculateGauss(matrix10.fractionMyMatrixA, matrix10.fractionMyMatrixX, "fraction10Gauss"),"Fraction");
//        resToSave.addResults(matrixLibrary.calculateGauss(matrix10.libraryMatrixA, matrix10.libraryMatrixX, "library10Gauss"),"Library");
//        matrix10 = null;
//
//        ReadMatrixData matrix15 = new ReadMatrixData("15").collectData();
//        resToSave.addMatrixSize("matrix15");
//        resToSave.addResults(matrixOperationsFloat.calculateGauss(matrix15.floatMyMatrixA, matrix15.floatMyMatrixX, "float15Gauss"),"Float");
//        resToSave.addResults(matrixOperationsDouble.calculateGauss(matrix15.doubleMyMatrixA, matrix15.doubleMyMatrixX, "double15Gauss"),"Double");
//        resToSave.addResults(matrixOperationsFraction.calculateGauss(matrix15.fractionMyMatrixA, matrix15.fractionMyMatrixX, "fraction15Gauss"),"Fraction");
//        resToSave.addResults(matrixLibrary.calculateGauss(matrix15.libraryMatrixA, matrix15.libraryMatrixX, "library15Gauss"),"Library");
//        matrix15 = null;
//
//        ReadMatrixData matrix20 = new ReadMatrixData("20").collectData();
//        resToSave.addMatrixSize("matrix20");
//        resToSave.addResults(matrixOperationsFloat.calculateGauss(matrix20.floatMyMatrixA, matrix20.floatMyMatrixX, "float20Gauss"),"Float");
//        resToSave.addResults(matrixOperationsDouble.calculateGauss(matrix20.doubleMyMatrixA, matrix20.doubleMyMatrixX, "double20Gauss"),"Double");
//        resToSave.addResults(matrixOperationsFraction.calculateGauss(matrix20.fractionMyMatrixA, matrix20.fractionMyMatrixX, "fraction20Gauss"),"Fraction");
//        resToSave.addResults(matrixLibrary.calculateGauss(matrix20.libraryMatrixA, matrix20.libraryMatrixX, "library20Gauss"),"Library");
//        matrix20 = null;
//
//        ReadMatrixData matrix25 = new ReadMatrixData("25").collectData();
//        resToSave.addMatrixSize("matrix25");
//        resToSave.addResults(matrixOperationsFloat.calculateGauss(matrix25.floatMyMatrixA, matrix25.floatMyMatrixX, "float25Gauss"),"Float");
//        resToSave.addResults(matrixOperationsDouble.calculateGauss(matrix25.doubleMyMatrixA, matrix25.doubleMyMatrixX, "double25Gauss"),"Double");
//        resToSave.addResults(matrixOperationsFraction.calculateGauss(matrix25.fractionMyMatrixA, matrix25.fractionMyMatrixX, "fraction25Gauss"),"Fraction");
//        resToSave.addResults(matrixLibrary.calculateGauss(matrix25.libraryMatrixA, matrix25.libraryMatrixX, "library25Gauss"),"Library");
//        matrix25 = null;
//
//        ReadMatrixData matrix30 = new ReadMatrixData("30").collectData();
//        resToSave.addMatrixSize("matrix30");
//        resToSave.addResults(matrixOperationsFloat.calculateGauss(matrix30.floatMyMatrixA, matrix30.floatMyMatrixX, "float30Gauss"),"Float");
//        resToSave.addResults(matrixOperationsDouble.calculateGauss(matrix30.doubleMyMatrixA, matrix30.doubleMyMatrixX, "double30Gauss"),"Double");
//        resToSave.addResults(matrixOperationsFraction.calculateGauss(matrix30.fractionMyMatrixA, matrix30.fractionMyMatrixX, "fraction30Gauss"),"Fraction");
//        resToSave.addResults(matrixLibrary.calculateGauss(matrix30.libraryMatrixA, matrix30.libraryMatrixX, "library30Gauss"),"Library");
//        matrix30 = null;
//
//        ReadMatrixData matrix35 = new ReadMatrixData("35").collectData();
//        resToSave.addMatrixSize("matrix35");
//        resToSave.addResults(matrixOperationsFloat.calculateGauss(matrix35.floatMyMatrixA, matrix35.floatMyMatrixX, "float35Gauss"),"Float");
//        resToSave.addResults(matrixOperationsDouble.calculateGauss(matrix35.doubleMyMatrixA, matrix35.doubleMyMatrixX, "double35Gauss"),"Double");
//        resToSave.addResults(matrixOperationsFraction.calculateGauss(matrix35.fractionMyMatrixA, matrix35.fractionMyMatrixX, "fraction35Gauss"),"Fraction");
//        resToSave.addResults(matrixLibrary.calculateGauss(matrix35.libraryMatrixA, matrix35.libraryMatrixX, "library35Gauss"),"Library");
//        matrix35 = null;
//
//        ReadMatrixData matrix40 = new ReadMatrixData("40").collectData();
//        resToSave.addMatrixSize("matrix40");
//        resToSave.addResults(matrixOperationsFloat.calculateGauss(matrix40.floatMyMatrixA, matrix40.floatMyMatrixX, "float40Gauss"),"Float");
//        resToSave.addResults(matrixOperationsDouble.calculateGauss(matrix40.doubleMyMatrixA, matrix40.doubleMyMatrixX, "double40Gauss"),"Double");
//        resToSave.addResults(matrixOperationsFraction.calculateGauss(matrix40.fractionMyMatrixA, matrix40.fractionMyMatrixX, "fraction40Gauss"),"Fraction");
//        resToSave.addResults(matrixLibrary.calculateGauss(matrix40.libraryMatrixA, matrix40.libraryMatrixX, "library40Gauss"),"Library");
//        matrix40 = null;
//
//        ReadMatrixData matrix45 = new ReadMatrixData("45").collectData();
//        resToSave.addMatrixSize("matrix45");
//        resToSave.addResults(matrixOperationsFloat.calculateGauss(matrix45.floatMyMatrixA, matrix45.floatMyMatrixX, "float45Gauss"),"Float");
//        resToSave.addResults(matrixOperationsDouble.calculateGauss(matrix45.doubleMyMatrixA, matrix45.doubleMyMatrixX, "double45Gauss"),"Double");
//        resToSave.addResults(matrixOperationsFraction.calculateGauss(matrix45.fractionMyMatrixA, matrix45.fractionMyMatrixX, "fraction45Gauss"),"Fraction");
//        resToSave.addResults(matrixLibrary.calculateGauss(matrix45.libraryMatrixA, matrix45.libraryMatrixX, "library45Gauss"),"Library");
//        matrix45 = null;
//
//        ReadMatrixData matrix50 = new ReadMatrixData("50").collectData();
//        resToSave.addMatrixSize("matrix50");
//        resToSave.addResults(matrixOperationsFloat.calculateGauss(matrix50.floatMyMatrixA, matrix50.floatMyMatrixX, "float50Gauss"),"Float");
//        resToSave.addResults(matrixOperationsDouble.calculateGauss(matrix50.doubleMyMatrixA, matrix50.doubleMyMatrixX, "double50Gauss"),"Double");
//        resToSave.addResults(matrixOperationsFraction.calculateGauss(matrix50.fractionMyMatrixA, matrix50.fractionMyMatrixX, "fraction50Gauss"),"Fraction");
//        resToSave.addResults(matrixLibrary.calculateGauss(matrix50.libraryMatrixA, matrix50.libraryMatrixX, "library50Gauss"),"Library");
//        matrix50 = null;

        ReadMatrixData matrix100 = new ReadMatrixData("100").collectData();
        resToSave.addMatrixSize("matrix100");
        resToSave.addResults(matrixOperationsFloat.calculateGauss(matrix100.floatMyMatrixA, matrix100.floatMyMatrixX, "float100Gauss"), "Float");
        resToSave.addResults(matrixOperationsDouble.calculateGauss(matrix100.doubleMyMatrixA, matrix100.doubleMyMatrixX, "double100Gauss"), "Double");
        resToSave.addResults(matrixLibrary.calculateGauss(matrix100.libraryMatrixA, matrix100.libraryMatrixX, "library100Gauss"), "Library");
        matrix100 = null;

        ReadMatrixData matrix150 = new ReadMatrixData("150").collectData();
        resToSave.addMatrixSize("matrix150");
        resToSave.addResults(matrixOperationsFloat.calculateGauss(matrix150.floatMyMatrixA, matrix150.floatMyMatrixX, "float150Gauss"), "Float");
        resToSave.addResults(matrixOperationsDouble.calculateGauss(matrix150.doubleMyMatrixA, matrix150.doubleMyMatrixX, "double150Gauss"), "Double");
        resToSave.addResults(matrixLibrary.calculateGauss(matrix150.libraryMatrixA, matrix150.libraryMatrixX, "library150Gauss"), "Library");
        matrix150 = null;

        ReadMatrixData matrix200 = new ReadMatrixData("200").collectData();
        resToSave.addMatrixSize("matrix200");
        resToSave.addResults(matrixOperationsFloat.calculateGauss(matrix200.floatMyMatrixA, matrix200.floatMyMatrixX, "float200Gauss"), "Float");
        resToSave.addResults(matrixOperationsDouble.calculateGauss(matrix200.doubleMyMatrixA, matrix200.doubleMyMatrixX, "double200Gauss"), "Double");
        resToSave.addResults(matrixLibrary.calculateGauss(matrix200.libraryMatrixA, matrix200.libraryMatrixX, "library200Gauss"), "Library");
        matrix200 = null;

//        ReadMatrixData matrix250 = new ReadMatrixData("250").collectData();
//        resToSave.addMatrixSize("matrix250");
//        resToSave.addResults(matrixOperationsFloat.calculateGauss(matrix250.floatMyMatrixA, matrix250.floatMyMatrixX, "float250Gauss"),"Float");
//        resToSave.addResults(matrixOperationsDouble.calculateGauss(matrix250.doubleMyMatrixA, matrix250.doubleMyMatrixX, "double250Gauss"),"Double");
//        resToSave.addResults(matrixLibrary.calculateGauss(matrix250.libraryMatrixA, matrix250.libraryMatrixX, "library250Gauss"),"Library");
//        matrix250 = null;
//
//        ReadMatrixData matrix300 = new ReadMatrixData("300").collectData();
//        resToSave.addMatrixSize("matrix300");
//        resToSave.addResults(matrixOperationsFloat.calculateGauss(matrix300.floatMyMatrixA, matrix300.floatMyMatrixX, "float300Gauss"),"Float");
//        resToSave.addResults(matrixOperationsDouble.calculateGauss(matrix300.doubleMyMatrixA, matrix300.doubleMyMatrixX, "double300Gauss"),"Double");
//        resToSave.addResults(matrixLibrary.calculateGauss(matrix300.libraryMatrixA, matrix300.libraryMatrixX, "library300Gauss"),"Library");
//        matrix300 = null;
//
//        ReadMatrixData matrix350 = new ReadMatrixData("350").collectData();
//        resToSave.addMatrixSize("matrix350");
//        resToSave.addResults(matrixOperationsFloat.calculateGauss(matrix350.floatMyMatrixA, matrix350.floatMyMatrixX, "float350Gauss"),"Float");
//        resToSave.addResults(matrixOperationsDouble.calculateGauss(matrix350.doubleMyMatrixA, matrix350.doubleMyMatrixX, "double350Gauss"),"Double");
//        resToSave.addResults(matrixLibrary.calculateGauss(matrix350.libraryMatrixA, matrix350.libraryMatrixX, "library350Gauss"),"Library");
//        matrix350 = null;
//
//        ReadMatrixData matrix400 = new ReadMatrixData("400").collectData();
//        resToSave.addMatrixSize("matrix400");
//        resToSave.addResults(matrixOperationsFloat.calculateGauss(matrix400.floatMyMatrixA, matrix400.floatMyMatrixX, "float400Gauss"),"Float");
//        resToSave.addResults(matrixOperationsDouble.calculateGauss(matrix400.doubleMyMatrixA, matrix400.doubleMyMatrixX, "double400Gauss"),"Double");
//        resToSave.addResults(matrixLibrary.calculateGauss(matrix400.libraryMatrixA, matrix400.libraryMatrixX, "library400Gauss"),"Library");
//        matrix400 = null;
//
//        ReadMatrixData matrix450 = new ReadMatrixData("450").collectData();
//        resToSave.addMatrixSize("matrix450");
//        resToSave.addResults(matrixOperationsFloat.calculateGauss(matrix450.floatMyMatrixA, matrix450.floatMyMatrixX, "float450Gauss"),"Float");
//        resToSave.addResults(matrixOperationsDouble.calculateGauss(matrix450.doubleMyMatrixA, matrix450.doubleMyMatrixX, "double450Gauss"),"Double");
//        resToSave.addResults(matrixLibrary.calculateGauss(matrix450.libraryMatrixA, matrix450.libraryMatrixX, "library450Gauss"),"Library");
//        matrix450 = null;
//
//        ReadMatrixData matrix500 = new ReadMatrixData("500").collectData();
//        resToSave.addMatrixSize("matrix500");
//        resToSave.addResults(matrixOperationsFloat.calculateGauss(matrix500.floatMyMatrixA, matrix500.floatMyMatrixX, "float500Gauss"),"Float");
//        resToSave.addResults(matrixOperationsDouble.calculateGauss(matrix500.doubleMyMatrixA, matrix500.doubleMyMatrixX, "double500Gauss"),"Double");
//        resToSave.addResults(matrixLibrary.calculateGauss(matrix500.libraryMatrixA, matrix500.libraryMatrixX, "library500Gauss"),"Library");
//        matrix500 = null;


        resToSave.saveToFileResults();
    }
}
