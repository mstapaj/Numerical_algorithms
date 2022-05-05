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

        // Operacje

        ReadMatrixData matrix10 = new ReadMatrixData("500", 10).collectData();
        matrixOperationsFloat.calculate(matrix10.floatMyMatrixA, matrix10.floatMyMatrixB, matrix10.floatMyMatrixC, matrix10.floatMyMatrixX, "float10");
        matrixOperationsDouble.calculate(matrix10.doubleMyMatrixA, matrix10.doubleMyMatrixB, matrix10.doubleMyMatrixC, matrix10.doubleMyMatrixX, "double10");
        matrixOperationsFraction.calculate(matrix10.fractionMyMatrixA, matrix10.fractionMyMatrixB, matrix10.fractionMyMatrixC, matrix10.fractionMyMatrixX, "fraction10");
        matrixLibrary.calculate(matrix10.libraryMatrixA, matrix10.libraryMatrixB, matrix10.libraryMatrixC, matrix10.libraryMatrixX, "library10");
        matrix10 = null;

        ReadMatrixData matrix15 = new ReadMatrixData("500", 15).collectData();
        matrixOperationsFloat.calculate(matrix15.floatMyMatrixA, matrix15.floatMyMatrixB, matrix15.floatMyMatrixC, matrix15.floatMyMatrixX, "float15");
        matrixOperationsDouble.calculate(matrix15.doubleMyMatrixA, matrix15.doubleMyMatrixB, matrix15.doubleMyMatrixC, matrix15.doubleMyMatrixX, "double15");
        matrixOperationsFraction.calculate(matrix15.fractionMyMatrixA, matrix15.fractionMyMatrixB, matrix15.fractionMyMatrixC, matrix15.fractionMyMatrixX, "fraction15");
        matrixLibrary.calculate(matrix15.libraryMatrixA, matrix15.libraryMatrixB, matrix15.libraryMatrixC, matrix15.libraryMatrixX, "library15");
        matrix15 = null;

        ReadMatrixData matrix20 = new ReadMatrixData("500", 20).collectData();
        matrixOperationsFloat.calculate(matrix20.floatMyMatrixA, matrix20.floatMyMatrixB, matrix20.floatMyMatrixC, matrix20.floatMyMatrixX, "float20");
        matrixOperationsDouble.calculate(matrix20.doubleMyMatrixA, matrix20.doubleMyMatrixB, matrix20.doubleMyMatrixC, matrix20.doubleMyMatrixX, "double20");
        matrixOperationsFraction.calculate(matrix20.fractionMyMatrixA, matrix20.fractionMyMatrixB, matrix20.fractionMyMatrixC, matrix20.fractionMyMatrixX, "fraction20");
        matrixLibrary.calculate(matrix20.libraryMatrixA, matrix20.libraryMatrixB, matrix20.libraryMatrixC, matrix20.libraryMatrixX, "library20");
        matrix20 = null;

        ReadMatrixData matrix25 = new ReadMatrixData("500", 25).collectData();
        matrixOperationsFloat.calculate(matrix25.floatMyMatrixA, matrix25.floatMyMatrixB, matrix25.floatMyMatrixC, matrix25.floatMyMatrixX, "float25");
        matrixOperationsDouble.calculate(matrix25.doubleMyMatrixA, matrix25.doubleMyMatrixB, matrix25.doubleMyMatrixC, matrix25.doubleMyMatrixX, "double25");
        matrixOperationsFraction.calculate(matrix25.fractionMyMatrixA, matrix25.fractionMyMatrixB, matrix25.fractionMyMatrixC, matrix25.fractionMyMatrixX, "fraction25");
        matrixLibrary.calculate(matrix25.libraryMatrixA, matrix25.libraryMatrixB, matrix25.libraryMatrixC, matrix25.libraryMatrixX, "library25");
        matrix25 = null;

        ReadMatrixData matrix30 = new ReadMatrixData("500", 30).collectData();
        matrixOperationsFloat.calculate(matrix30.floatMyMatrixA, matrix30.floatMyMatrixB, matrix30.floatMyMatrixC, matrix30.floatMyMatrixX, "float30");
        matrixOperationsDouble.calculate(matrix30.doubleMyMatrixA, matrix30.doubleMyMatrixB, matrix30.doubleMyMatrixC, matrix30.doubleMyMatrixX, "double30");
        matrixOperationsFraction.calculate(matrix30.fractionMyMatrixA, matrix30.fractionMyMatrixB, matrix30.fractionMyMatrixC, matrix30.fractionMyMatrixX, "fraction30");
        matrixLibrary.calculate(matrix30.libraryMatrixA, matrix30.libraryMatrixB, matrix30.libraryMatrixC, matrix30.libraryMatrixX, "library30");
        matrix30 = null;

        ReadMatrixData matrix35 = new ReadMatrixData("500", 35).collectData();
        matrixOperationsFloat.calculate(matrix35.floatMyMatrixA, matrix35.floatMyMatrixB, matrix35.floatMyMatrixC, matrix35.floatMyMatrixX, "float35");
        matrixOperationsDouble.calculate(matrix35.doubleMyMatrixA, matrix35.doubleMyMatrixB, matrix35.doubleMyMatrixC, matrix35.doubleMyMatrixX, "double35");
        matrixOperationsFraction.calculate(matrix35.fractionMyMatrixA, matrix35.fractionMyMatrixB, matrix35.fractionMyMatrixC, matrix35.fractionMyMatrixX, "fraction35");
        matrixLibrary.calculate(matrix35.libraryMatrixA, matrix35.libraryMatrixB, matrix35.libraryMatrixC, matrix35.libraryMatrixX, "library35");
        matrix35 = null;

        ReadMatrixData matrix40 = new ReadMatrixData("500", 40).collectData();
        matrixOperationsFloat.calculate(matrix40.floatMyMatrixA, matrix40.floatMyMatrixB, matrix40.floatMyMatrixC, matrix40.floatMyMatrixX, "float40");
        matrixOperationsDouble.calculate(matrix40.doubleMyMatrixA, matrix40.doubleMyMatrixB, matrix40.doubleMyMatrixC, matrix40.doubleMyMatrixX, "double40");
        matrixOperationsFraction.calculate(matrix40.fractionMyMatrixA, matrix40.fractionMyMatrixB, matrix40.fractionMyMatrixC, matrix40.fractionMyMatrixX, "fraction40");
        matrixLibrary.calculate(matrix40.libraryMatrixA, matrix40.libraryMatrixB, matrix40.libraryMatrixC, matrix40.libraryMatrixX, "library40");
        matrix40 = null;

        ReadMatrixData matrix45 = new ReadMatrixData("500", 45).collectData();
        matrixOperationsFloat.calculate(matrix45.floatMyMatrixA, matrix45.floatMyMatrixB, matrix45.floatMyMatrixC, matrix45.floatMyMatrixX, "float45");
        matrixOperationsDouble.calculate(matrix45.doubleMyMatrixA, matrix45.doubleMyMatrixB, matrix45.doubleMyMatrixC, matrix45.doubleMyMatrixX, "double45");
        matrixOperationsFraction.calculate(matrix45.fractionMyMatrixA, matrix45.fractionMyMatrixB, matrix45.fractionMyMatrixC, matrix45.fractionMyMatrixX, "fraction45");
        matrixLibrary.calculate(matrix45.libraryMatrixA, matrix45.libraryMatrixB, matrix45.libraryMatrixC, matrix45.libraryMatrixX, "library45");
        matrix45 = null;

        ReadMatrixData matrix50 = new ReadMatrixData("500", 50).collectData();
        matrixOperationsFloat.calculate(matrix50.floatMyMatrixA, matrix50.floatMyMatrixB, matrix50.floatMyMatrixC, matrix50.floatMyMatrixX, "float50");
        matrixOperationsDouble.calculate(matrix50.doubleMyMatrixA, matrix50.doubleMyMatrixB, matrix50.doubleMyMatrixC, matrix50.doubleMyMatrixX, "double50");
        matrixOperationsFraction.calculate(matrix50.fractionMyMatrixA, matrix50.fractionMyMatrixB, matrix50.fractionMyMatrixC, matrix50.fractionMyMatrixX, "fraction50");
        matrixLibrary.calculate(matrix50.libraryMatrixA, matrix50.libraryMatrixB, matrix50.libraryMatrixC, matrix50.libraryMatrixX, "library50");
        matrix50 = null;

        ReadMatrixData matrix100 = new ReadMatrixData("500", 100).collectData();
        matrixOperationsFloat.calculate(matrix100.floatMyMatrixA, matrix100.floatMyMatrixB, matrix100.floatMyMatrixC, matrix100.floatMyMatrixX, "float100");
        matrixOperationsDouble.calculate(matrix100.doubleMyMatrixA, matrix100.doubleMyMatrixB, matrix100.doubleMyMatrixC, matrix100.doubleMyMatrixX, "double100");
        matrixLibrary.calculate(matrix100.libraryMatrixA, matrix100.libraryMatrixB, matrix100.libraryMatrixC, matrix100.libraryMatrixX, "library100");
        matrix100 = null;

        ReadMatrixData matrix150 = new ReadMatrixData("500", 150).collectData();
        matrixOperationsFloat.calculate(matrix150.floatMyMatrixA, matrix150.floatMyMatrixB, matrix150.floatMyMatrixC, matrix150.floatMyMatrixX, "float150");
        matrixOperationsDouble.calculate(matrix150.doubleMyMatrixA, matrix150.doubleMyMatrixB, matrix150.doubleMyMatrixC, matrix150.doubleMyMatrixX, "double150");
        matrixLibrary.calculate(matrix150.libraryMatrixA, matrix150.libraryMatrixB, matrix150.libraryMatrixC, matrix150.libraryMatrixX, "library150");
        matrix150 = null;

        ReadMatrixData matrix200 = new ReadMatrixData("500", 200).collectData();
        matrixOperationsFloat.calculate(matrix200.floatMyMatrixA, matrix200.floatMyMatrixB, matrix200.floatMyMatrixC, matrix200.floatMyMatrixX, "float200");
        matrixOperationsDouble.calculate(matrix200.doubleMyMatrixA, matrix200.doubleMyMatrixB, matrix200.doubleMyMatrixC, matrix200.doubleMyMatrixX, "double200");
        matrixLibrary.calculate(matrix200.libraryMatrixA, matrix200.libraryMatrixB, matrix200.libraryMatrixC, matrix200.libraryMatrixX, "library200");
        matrix200 = null;

        ReadMatrixData matrix250 = new ReadMatrixData("500", 250).collectData();
        matrixOperationsFloat.calculate(matrix250.floatMyMatrixA, matrix250.floatMyMatrixB, matrix250.floatMyMatrixC, matrix250.floatMyMatrixX, "float250");
        matrixOperationsDouble.calculate(matrix250.doubleMyMatrixA, matrix250.doubleMyMatrixB, matrix250.doubleMyMatrixC, matrix250.doubleMyMatrixX, "double250");
        matrixLibrary.calculate(matrix250.libraryMatrixA, matrix250.libraryMatrixB, matrix250.libraryMatrixC, matrix250.libraryMatrixX, "library250");
        matrix250 = null;

        ReadMatrixData matrix300 = new ReadMatrixData("500", 300).collectData();
        matrixOperationsFloat.calculate(matrix300.floatMyMatrixA, matrix300.floatMyMatrixB, matrix300.floatMyMatrixC, matrix300.floatMyMatrixX, "float300");
        matrixOperationsDouble.calculate(matrix300.doubleMyMatrixA, matrix300.doubleMyMatrixB, matrix300.doubleMyMatrixC, matrix300.doubleMyMatrixX, "double300");
        matrixLibrary.calculate(matrix300.libraryMatrixA, matrix300.libraryMatrixB, matrix300.libraryMatrixC, matrix300.libraryMatrixX, "library300");
        matrix300 = null;

        ReadMatrixData matrix350 = new ReadMatrixData("500", 350).collectData();
        matrixOperationsFloat.calculate(matrix350.floatMyMatrixA, matrix350.floatMyMatrixB, matrix350.floatMyMatrixC, matrix350.floatMyMatrixX, "float350");
        matrixOperationsDouble.calculate(matrix350.doubleMyMatrixA, matrix350.doubleMyMatrixB, matrix350.doubleMyMatrixC, matrix350.doubleMyMatrixX, "double350");
        matrixLibrary.calculate(matrix350.libraryMatrixA, matrix350.libraryMatrixB, matrix350.libraryMatrixC, matrix350.libraryMatrixX, "library350");
        matrix350 = null;

        ReadMatrixData matrix400 = new ReadMatrixData("500", 400).collectData();
        matrixOperationsFloat.calculate(matrix400.floatMyMatrixA, matrix400.floatMyMatrixB, matrix400.floatMyMatrixC, matrix400.floatMyMatrixX, "float400");
        matrixOperationsDouble.calculate(matrix400.doubleMyMatrixA, matrix400.doubleMyMatrixB, matrix400.doubleMyMatrixC, matrix400.doubleMyMatrixX, "double400");
        matrixLibrary.calculate(matrix400.libraryMatrixA, matrix400.libraryMatrixB, matrix400.libraryMatrixC, matrix400.libraryMatrixX, "library400");
        matrix400 = null;

        ReadMatrixData matrix450 = new ReadMatrixData("500", 450).collectData();
        matrixOperationsFloat.calculate(matrix450.floatMyMatrixA, matrix450.floatMyMatrixB, matrix450.floatMyMatrixC, matrix450.floatMyMatrixX, "float450");
        matrixOperationsDouble.calculate(matrix450.doubleMyMatrixA, matrix450.doubleMyMatrixB, matrix450.doubleMyMatrixC, matrix450.doubleMyMatrixX, "double450");
        matrixLibrary.calculate(matrix450.libraryMatrixA, matrix450.libraryMatrixB, matrix450.libraryMatrixC, matrix450.libraryMatrixX, "library450");
        matrix450 = null;

        ReadMatrixData matrix500 = new ReadMatrixData("500", 500).collectData();
        matrixOperationsFloat.calculate(matrix500.floatMyMatrixA, matrix500.floatMyMatrixB, matrix500.floatMyMatrixC, matrix500.floatMyMatrixX, "float500");
        matrixOperationsDouble.calculate(matrix500.doubleMyMatrixA, matrix500.doubleMyMatrixB, matrix500.doubleMyMatrixC, matrix500.doubleMyMatrixX, "double500");
        matrixLibrary.calculate(matrix500.libraryMatrixA, matrix500.libraryMatrixB, matrix500.libraryMatrixC, matrix500.libraryMatrixX, "library500");
        matrix500 = null;


        // Gauss
        matrix10 = new ReadMatrixData("500", 10).collectData();
        resToSave.addMatrixSize("matrix10");
        resToSave.addResults(matrixOperationsFloat.calculateGauss(matrix10.floatMyMatrixA, matrix10.floatMyMatrixX, "float10Gauss"), "Float");
        resToSave.addResults(matrixOperationsDouble.calculateGauss(matrix10.doubleMyMatrixA, matrix10.doubleMyMatrixX, "double10Gauss"), "Double");
        resToSave.addResults(matrixOperationsFraction.calculateGauss(matrix10.fractionMyMatrixA, matrix10.fractionMyMatrixX, "fraction10Gauss"), "Fraction");
        resToSave.addResults(matrixLibrary.calculateGauss(matrix10.libraryMatrixA, matrix10.libraryMatrixX, "library10Gauss"), "Library");
        System.out.println("Policzono Gauss matrix10");
        matrix10 = null;

        matrix15 = new ReadMatrixData("500", 15).collectData();
        resToSave.addMatrixSize("matrix15");
        resToSave.addResults(matrixOperationsFloat.calculateGauss(matrix15.floatMyMatrixA, matrix15.floatMyMatrixX, "float15Gauss"), "Float");
        resToSave.addResults(matrixOperationsDouble.calculateGauss(matrix15.doubleMyMatrixA, matrix15.doubleMyMatrixX, "double15Gauss"), "Double");
        resToSave.addResults(matrixOperationsFraction.calculateGauss(matrix15.fractionMyMatrixA, matrix15.fractionMyMatrixX, "fraction15Gauss"), "Fraction");
        resToSave.addResults(matrixLibrary.calculateGauss(matrix15.libraryMatrixA, matrix15.libraryMatrixX, "library15Gauss"), "Library");
        System.out.println("Policzono Gauss matrix15");
        matrix15 = null;

        matrix20 = new ReadMatrixData("500", 20).collectData();
        resToSave.addMatrixSize("matrix20");
        resToSave.addResults(matrixOperationsFloat.calculateGauss(matrix20.floatMyMatrixA, matrix20.floatMyMatrixX, "float20Gauss"), "Float");
        resToSave.addResults(matrixOperationsDouble.calculateGauss(matrix20.doubleMyMatrixA, matrix20.doubleMyMatrixX, "double20Gauss"), "Double");
        resToSave.addResults(matrixOperationsFraction.calculateGauss(matrix20.fractionMyMatrixA, matrix20.fractionMyMatrixX, "fraction20Gauss"), "Fraction");
        resToSave.addResults(matrixLibrary.calculateGauss(matrix20.libraryMatrixA, matrix20.libraryMatrixX, "library20Gauss"), "Library");
        System.out.println("Policzono Gauss matrix20");
        matrix20 = null;

        matrix25 = new ReadMatrixData("500", 25).collectData();
        resToSave.addMatrixSize("matrix25");
        resToSave.addResults(matrixOperationsFloat.calculateGauss(matrix25.floatMyMatrixA, matrix25.floatMyMatrixX, "float25Gauss"), "Float");
        resToSave.addResults(matrixOperationsDouble.calculateGauss(matrix25.doubleMyMatrixA, matrix25.doubleMyMatrixX, "double25Gauss"), "Double");
        resToSave.addResults(matrixOperationsFraction.calculateGauss(matrix25.fractionMyMatrixA, matrix25.fractionMyMatrixX, "fraction25Gauss"), "Fraction");
        resToSave.addResults(matrixLibrary.calculateGauss(matrix25.libraryMatrixA, matrix25.libraryMatrixX, "library25Gauss"), "Library");
        System.out.println("Policzono Gauss matrix25");
        matrix25 = null;

        matrix30 = new ReadMatrixData("500", 30).collectData();
        resToSave.addMatrixSize("matrix30");
        resToSave.addResults(matrixOperationsFloat.calculateGauss(matrix30.floatMyMatrixA, matrix30.floatMyMatrixX, "float30Gauss"), "Float");
        resToSave.addResults(matrixOperationsDouble.calculateGauss(matrix30.doubleMyMatrixA, matrix30.doubleMyMatrixX, "double30Gauss"), "Double");
        resToSave.addResults(matrixOperationsFraction.calculateGauss(matrix30.fractionMyMatrixA, matrix30.fractionMyMatrixX, "fraction30Gauss"), "Fraction");
        resToSave.addResults(matrixLibrary.calculateGauss(matrix30.libraryMatrixA, matrix30.libraryMatrixX, "library30Gauss"), "Library");
        System.out.println("Policzono Gauss matrix30");
        matrix30 = null;

        matrix35 = new ReadMatrixData("500", 35).collectData();
        resToSave.addMatrixSize("matrix35");
        resToSave.addResults(matrixOperationsFloat.calculateGauss(matrix35.floatMyMatrixA, matrix35.floatMyMatrixX, "float35Gauss"), "Float");
        resToSave.addResults(matrixOperationsDouble.calculateGauss(matrix35.doubleMyMatrixA, matrix35.doubleMyMatrixX, "double35Gauss"), "Double");
        resToSave.addResults(matrixOperationsFraction.calculateGauss(matrix35.fractionMyMatrixA, matrix35.fractionMyMatrixX, "fraction35Gauss"), "Fraction");
        resToSave.addResults(matrixLibrary.calculateGauss(matrix35.libraryMatrixA, matrix35.libraryMatrixX, "library35Gauss"), "Library");
        System.out.println("Policzono Gauss matrix35");
        matrix35 = null;

        matrix40 = new ReadMatrixData("500", 40).collectData();
        resToSave.addMatrixSize("matrix40");
        resToSave.addResults(matrixOperationsFloat.calculateGauss(matrix40.floatMyMatrixA, matrix40.floatMyMatrixX, "float40Gauss"), "Float");
        resToSave.addResults(matrixOperationsDouble.calculateGauss(matrix40.doubleMyMatrixA, matrix40.doubleMyMatrixX, "double40Gauss"), "Double");
        resToSave.addResults(matrixOperationsFraction.calculateGauss(matrix40.fractionMyMatrixA, matrix40.fractionMyMatrixX, "fraction40Gauss"), "Fraction");
        resToSave.addResults(matrixLibrary.calculateGauss(matrix40.libraryMatrixA, matrix40.libraryMatrixX, "library40Gauss"), "Library");
        System.out.println("Policzono Gauss matrix40");
        matrix40 = null;

        matrix45 = new ReadMatrixData("500", 45).collectData();
        resToSave.addMatrixSize("matrix45");
        resToSave.addResults(matrixOperationsFloat.calculateGauss(matrix45.floatMyMatrixA, matrix45.floatMyMatrixX, "float45Gauss"), "Float");
        resToSave.addResults(matrixOperationsDouble.calculateGauss(matrix45.doubleMyMatrixA, matrix45.doubleMyMatrixX, "double45Gauss"), "Double");
        resToSave.addResults(matrixOperationsFraction.calculateGauss(matrix45.fractionMyMatrixA, matrix45.fractionMyMatrixX, "fraction45Gauss"), "Fraction");
        resToSave.addResults(matrixLibrary.calculateGauss(matrix45.libraryMatrixA, matrix45.libraryMatrixX, "library45Gauss"), "Library");
        System.out.println("Policzono Gauss matrix45");
        matrix45 = null;

        matrix50 = new ReadMatrixData("500", 50).collectData();
        resToSave.addMatrixSize("matrix50");
        resToSave.addResults(matrixOperationsFloat.calculateGauss(matrix50.floatMyMatrixA, matrix50.floatMyMatrixX, "float50Gauss"), "Float");
        resToSave.addResults(matrixOperationsDouble.calculateGauss(matrix50.doubleMyMatrixA, matrix50.doubleMyMatrixX, "double50Gauss"), "Double");
        resToSave.addResults(matrixOperationsFraction.calculateGauss(matrix50.fractionMyMatrixA, matrix50.fractionMyMatrixX, "fraction50Gauss"), "Fraction");
        resToSave.addResults(matrixLibrary.calculateGauss(matrix50.libraryMatrixA, matrix50.libraryMatrixX, "library50Gauss"), "Library");
        System.out.println("Policzono Gauss matrix50");
        matrix50 = null;

        matrix100 = new ReadMatrixData("500", 100).collectData();
        resToSave.addMatrixSize("matrix100");
        resToSave.addResults(matrixOperationsFloat.calculateGauss(matrix100.floatMyMatrixA, matrix100.floatMyMatrixX, "float100Gauss"), "Float");
        resToSave.addResults(matrixOperationsDouble.calculateGauss(matrix100.doubleMyMatrixA, matrix100.doubleMyMatrixX, "double100Gauss"), "Double");
        resToSave.addResults(matrixLibrary.calculateGauss(matrix100.libraryMatrixA, matrix100.libraryMatrixX, "library100Gauss"), "Library");
        System.out.println("Policzono Gauss matrix100");
        matrix100 = null;

        matrix150 = new ReadMatrixData("500", 150).collectData();
        resToSave.addMatrixSize("matrix150");
        resToSave.addResults(matrixOperationsFloat.calculateGauss(matrix150.floatMyMatrixA, matrix150.floatMyMatrixX, "float150Gauss"), "Float");
        resToSave.addResults(matrixOperationsDouble.calculateGauss(matrix150.doubleMyMatrixA, matrix150.doubleMyMatrixX, "double150Gauss"), "Double");
        resToSave.addResults(matrixLibrary.calculateGauss(matrix150.libraryMatrixA, matrix150.libraryMatrixX, "library150Gauss"), "Library");
        System.out.println("Policzono Gauss matrix150");
        matrix150 = null;

        matrix200 = new ReadMatrixData("500", 200).collectData();
        resToSave.addMatrixSize("matrix200");
        resToSave.addResults(matrixOperationsFloat.calculateGauss(matrix200.floatMyMatrixA, matrix200.floatMyMatrixX, "float200Gauss"), "Float");
        resToSave.addResults(matrixOperationsDouble.calculateGauss(matrix200.doubleMyMatrixA, matrix200.doubleMyMatrixX, "double200Gauss"), "Double");
        resToSave.addResults(matrixLibrary.calculateGauss(matrix200.libraryMatrixA, matrix200.libraryMatrixX, "library200Gauss"), "Library");
        System.out.println("Policzono Gauss matrix200");
        matrix200 = null;

        matrix250 = new ReadMatrixData("500", 250).collectData();
        resToSave.addMatrixSize("matrix250");
        resToSave.addResults(matrixOperationsFloat.calculateGauss(matrix250.floatMyMatrixA, matrix250.floatMyMatrixX, "float250Gauss"), "Float");
        resToSave.addResults(matrixOperationsDouble.calculateGauss(matrix250.doubleMyMatrixA, matrix250.doubleMyMatrixX, "double250Gauss"), "Double");
        resToSave.addResults(matrixLibrary.calculateGauss(matrix250.libraryMatrixA, matrix250.libraryMatrixX, "library250Gauss"), "Library");
        System.out.println("Policzono Gauss matrix250");
        matrix250 = null;

        matrix300 = new ReadMatrixData("500", 300).collectData();
        resToSave.addMatrixSize("matrix300");
        resToSave.addResults(matrixOperationsFloat.calculateGauss(matrix300.floatMyMatrixA, matrix300.floatMyMatrixX, "float300Gauss"), "Float");
        resToSave.addResults(matrixOperationsDouble.calculateGauss(matrix300.doubleMyMatrixA, matrix300.doubleMyMatrixX, "double300Gauss"), "Double");
        resToSave.addResults(matrixLibrary.calculateGauss(matrix300.libraryMatrixA, matrix300.libraryMatrixX, "library300Gauss"), "Library");
        System.out.println("Policzono Gauss matrix300");
        matrix300 = null;

        matrix350 = new ReadMatrixData("500", 350).collectData();
        resToSave.addMatrixSize("matrix350");
        resToSave.addResults(matrixOperationsFloat.calculateGauss(matrix350.floatMyMatrixA, matrix350.floatMyMatrixX, "float350Gauss"), "Float");
        resToSave.addResults(matrixOperationsDouble.calculateGauss(matrix350.doubleMyMatrixA, matrix350.doubleMyMatrixX, "double350Gauss"), "Double");
        resToSave.addResults(matrixLibrary.calculateGauss(matrix350.libraryMatrixA, matrix350.libraryMatrixX, "library350Gauss"), "Library");
        System.out.println("Policzono Gauss matrix350");
        matrix350 = null;

        matrix400 = new ReadMatrixData("500", 400).collectData();
        resToSave.addMatrixSize("matrix400");
        resToSave.addResults(matrixOperationsFloat.calculateGauss(matrix400.floatMyMatrixA, matrix400.floatMyMatrixX, "float400Gauss"), "Float");
        resToSave.addResults(matrixOperationsDouble.calculateGauss(matrix400.doubleMyMatrixA, matrix400.doubleMyMatrixX, "double400Gauss"), "Double");
        resToSave.addResults(matrixLibrary.calculateGauss(matrix400.libraryMatrixA, matrix400.libraryMatrixX, "library400Gauss"), "Library");
        System.out.println("Policzono Gauss matrix400");
        matrix400 = null;

        matrix450 = new ReadMatrixData("500", 450).collectData();
        resToSave.addMatrixSize("matrix450");
        resToSave.addResults(matrixOperationsFloat.calculateGauss(matrix450.floatMyMatrixA, matrix450.floatMyMatrixX, "float450Gauss"), "Float");
        resToSave.addResults(matrixOperationsDouble.calculateGauss(matrix450.doubleMyMatrixA, matrix450.doubleMyMatrixX, "double450Gauss"), "Double");
        resToSave.addResults(matrixLibrary.calculateGauss(matrix450.libraryMatrixA, matrix450.libraryMatrixX, "library450Gauss"), "Library");
        System.out.println("Policzono Gauss matrix450");
        matrix450 = null;

        matrix500 = new ReadMatrixData("500", 500).collectData();
        resToSave.addMatrixSize("matrix500");
        resToSave.addResults(matrixOperationsFloat.calculateGauss(matrix500.floatMyMatrixA, matrix500.floatMyMatrixX, "float500Gauss"), "Float");
        resToSave.addResults(matrixOperationsDouble.calculateGauss(matrix500.doubleMyMatrixA, matrix500.doubleMyMatrixX, "double500Gauss"), "Double");
        resToSave.addResults(matrixLibrary.calculateGauss(matrix500.libraryMatrixA, matrix500.libraryMatrixX, "library500Gauss"), "Library");
        System.out.println("Policzono Gauss matrix500");
        matrix500 = null;


        resToSave.saveToFileResults();
    }
}
