package com.company;

import com.company.types.MyDouble;
import com.company.types.MyFloat;
import com.company.types.MyFraction;
import org.ejml.simple.SimpleMatrix;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.*;

public class ReadMatrixData {
    private final String fileName;
    private final int size;
    public MyMatrix<MyFloat> floatMyMatrixA;
    public MyMatrix<MyFloat> floatMyMatrixB;
    public MyMatrix<MyFloat> floatMyMatrixC;
    public MyMatrix<MyFloat> floatMyMatrixX;
    public MyMatrix<MyFloat> floatMyMatrixGaussP;
    public MyMatrix<MyFloat> floatMyMatrixGaussPG;
    public MyMatrix<MyFloat> floatMyMatrixGaussFG;
    public MyMatrix<MyDouble> doubleMyMatrixA;
    public MyMatrix<MyDouble> doubleMyMatrixB;
    public MyMatrix<MyDouble> doubleMyMatrixC;
    public MyMatrix<MyDouble> doubleMyMatrixX;
    public MyMatrix<MyDouble> doubleMyMatrixGaussP;
    public MyMatrix<MyDouble> doubleMyMatrixGaussPG;
    public MyMatrix<MyDouble> doubleMyMatrixGaussFG;
    public MyMatrix<MyFraction> fractionMyMatrixA;
    public MyMatrix<MyFraction> fractionMyMatrixB;
    public MyMatrix<MyFraction> fractionMyMatrixC;
    public MyMatrix<MyFraction> fractionMyMatrixX;
    public MyMatrix<MyFraction> fractionMyMatrixGaussP;
    public MyMatrix<MyFraction> fractionMyMatrixGaussPG;
    public MyMatrix<MyFraction> fractionMyMatrixGaussFG;
    public SimpleMatrix libraryMatrixA;
    public SimpleMatrix libraryMatrixB;
    public SimpleMatrix libraryMatrixC;
    public SimpleMatrix libraryMatrixX;
    public SimpleMatrix libraryMatrixGauss;

    public ReadMatrixData(String fileName, int size) {
        this.fileName = fileName;
        this.size = size;
    }

    private static <T extends MyNumber<T>> MyMatrix<T> readMatrixFromFile(String file, String type, int size, boolean vec) {
        List<T> toMat = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("data/" + file));
            scanner.useDelimiter(",");
            for (int i = 0; i < size * size; i++) {
                try {
                    scanner.useDelimiter(",");
                    String read = scanner.next();
                    if (Objects.equals(type, "double")) {
                        T temp = (T) new MyDouble(Double.parseDouble(read)).initialize();
                        toMat.add(temp);
                    } else if (Objects.equals(type, "float")) {
                        T temp = (T) new MyFloat(Float.parseFloat(read));
                        toMat.add(temp);
                    } else if (Objects.equals(type, "fraction")) {
                        T temp = (T) new MyFraction(new BigInteger(read.split(";")[0]), new BigInteger(read.split(";")[1]));
                        toMat.add(temp);
                    } else {
                        throw new IllegalArgumentException("Type " + type + " is not supported by this method");
                    }
                } catch (NumberFormatException | NoSuchElementException e) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (vec) {
            return new MyMatrix<>(size, 1, toMat);
        } else {
            return new MyMatrix<>(size, size, toMat);
        }

    }

    private static SimpleMatrix makeLibraryMatrix(List<List<Number>> list) {
        double[][] resArray = new double[list.size()][list.get(0).size()];
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(0).size(); j++) {
                resArray[i][j] = list.get(i).get(j).doubleValue();
            }
        }
        return new SimpleMatrix(resArray);
    }

    public ReadMatrixData collectData() {
        this.floatMyMatrixA = readMatrixFromFile("floatMatrixA" + fileName + ".txt", "float", this.size, false);
        this.floatMyMatrixB = readMatrixFromFile("floatMatrixB" + fileName + ".txt", "float", this.size, false);
        this.floatMyMatrixC = readMatrixFromFile("floatMatrixC" + fileName + ".txt", "float", this.size, false);
        this.floatMyMatrixX = readMatrixFromFile("floatMatrixX" + fileName + ".txt", "float", this.size, true);
        this.doubleMyMatrixA = readMatrixFromFile("doubleMatrixA" + fileName + ".txt", "double", this.size, false);
        this.doubleMyMatrixB = readMatrixFromFile("doubleMatrixB" + fileName + ".txt", "double", this.size, false);
        this.doubleMyMatrixC = readMatrixFromFile("doubleMatrixC" + fileName + ".txt", "double", this.size, false);
        this.doubleMyMatrixX = readMatrixFromFile("doubleMatrixX" + fileName + ".txt", "double", this.size, true);
        this.fractionMyMatrixA = readMatrixFromFile("fractionMatrixA" + fileName + ".txt", "fraction", this.size, false);
        this.fractionMyMatrixB = readMatrixFromFile("fractionMatrixB" + fileName + ".txt", "fraction", this.size, false);
        this.fractionMyMatrixC = readMatrixFromFile("fractionMatrixC" + fileName + ".txt", "fraction", this.size, false);
        this.fractionMyMatrixX = readMatrixFromFile("fractionMatrixX" + fileName + ".txt", "fraction", this.size, true);
        this.libraryMatrixA = makeLibraryMatrix(readMatrixFromFile("doubleMatrixA" + fileName + ".txt", "double", this.size, false).getNumber());
        this.libraryMatrixB = makeLibraryMatrix(readMatrixFromFile("doubleMatrixB" + fileName + ".txt", "double", this.size, false).getNumber());
        this.libraryMatrixC = makeLibraryMatrix(readMatrixFromFile("doubleMatrixC" + fileName + ".txt", "double", this.size, false).getNumber());
        this.libraryMatrixX = makeLibraryMatrix(readMatrixFromFile("doubleMatrixX" + fileName + ".txt", "double", this.size, true).getNumber());
        this.fractionMyMatrixA = this.fractionMyMatrixA.shortenMatrix();
        this.fractionMyMatrixB = this.fractionMyMatrixB.shortenMatrix();
        this.fractionMyMatrixC = this.fractionMyMatrixC.shortenMatrix();
        this.fractionMyMatrixX = this.fractionMyMatrixX.shortenMatrix();
        return this;
    }
}
