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
    private String fileName;
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

    public ReadMatrixData(String fileName) {
        this.fileName = fileName;
    }

    private static <T extends MyNumber<T>> MyMatrix<T> readMatrixFromFile(String file, String type) {
        List<List<T>> toMat = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("data/" + file));
            scanner.useDelimiter(",");
            List<T> row = new ArrayList<>();
            while (true) {
                try {
                    scanner.useDelimiter(",");
                    String read = scanner.next();
                    if (Objects.equals(read, "&")) {
                        toMat.add(row);
                        row = new ArrayList<>();
                    } else {
                        if (Objects.equals(type, "double")) {
                            T temp = (T) new MyDouble(Double.parseDouble(read)).initialize();
                            row.add(temp);
                        } else if (Objects.equals(type, "float")) {
                            T temp = (T) new MyFloat(Float.parseFloat(read));
                            row.add(temp);
                        } else if (Objects.equals(type, "fraction")) {
//                            row.add((T) new Fraction(new BigInteger(read.split(";")[0]), new BigInteger(read.split(";")[1])));
                            T temp = (T) new MyFraction(new BigInteger(read.split(";")[0]), new BigInteger(read.split(";")[1]));
                            row.add(temp);
                        } else {
                            throw new IllegalArgumentException("Type " + type + " is not supported by this method");
                        }
                    }
                } catch (NumberFormatException | NoSuchElementException e) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new MyMatrix<>(toMat);
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
        this.floatMyMatrixA = readMatrixFromFile("floatMatrixA" + fileName + ".txt", "float");
        this.floatMyMatrixB = readMatrixFromFile("floatMatrixB" + fileName + ".txt", "float");
        this.floatMyMatrixC = readMatrixFromFile("floatMatrixC" + fileName + ".txt", "float");
        this.floatMyMatrixX = readMatrixFromFile("floatMatrixX" + fileName + ".txt", "float");
        this.floatMyMatrixGaussP = readMatrixFromFile("floatMatrixGauss" + fileName + ".txt", "float");
        this.floatMyMatrixGaussPG = readMatrixFromFile("floatMatrixGauss" + fileName + ".txt", "float");
        this.floatMyMatrixGaussFG = readMatrixFromFile("floatMatrixGauss" + fileName + ".txt", "float");
        this.doubleMyMatrixA = readMatrixFromFile("doubleMatrixA" + fileName + ".txt", "double");
        this.doubleMyMatrixB = readMatrixFromFile("doubleMatrixB" + fileName + ".txt", "double");
        this.doubleMyMatrixC = readMatrixFromFile("doubleMatrixC" + fileName + ".txt", "double");
        this.doubleMyMatrixX = readMatrixFromFile("doubleMatrixX" + fileName + ".txt", "double");
        this.doubleMyMatrixGaussP = readMatrixFromFile("doubleMatrixGauss" + fileName + ".txt", "double");
        this.doubleMyMatrixGaussPG = readMatrixFromFile("doubleMatrixGauss" + fileName + ".txt", "double");
        this.doubleMyMatrixGaussFG = readMatrixFromFile("doubleMatrixGauss" + fileName + ".txt", "double");
        this.fractionMyMatrixA = readMatrixFromFile("fractionMatrixA" + fileName + ".txt", "fraction");
        this.fractionMyMatrixB = readMatrixFromFile("fractionMatrixB" + fileName + ".txt", "fraction");
        this.fractionMyMatrixC = readMatrixFromFile("fractionMatrixC" + fileName + ".txt", "fraction");
        this.fractionMyMatrixX = readMatrixFromFile("fractionMatrixX" + fileName + ".txt", "fraction");
        this.fractionMyMatrixGaussP = readMatrixFromFile("fractionMatrixGauss" + fileName + ".txt", "fraction");
        this.fractionMyMatrixGaussPG = readMatrixFromFile("fractionMatrixGauss" + fileName + ".txt", "fraction");
        this.fractionMyMatrixGaussFG = readMatrixFromFile("fractionMatrixGauss" + fileName + ".txt", "fraction");
        this.libraryMatrixA = makeLibraryMatrix(readMatrixFromFile("doubleMatrixA" + fileName + ".txt", "double").getNumber());
        this.libraryMatrixB = makeLibraryMatrix(readMatrixFromFile("doubleMatrixB" + fileName + ".txt", "double").getNumber());
        this.libraryMatrixC = makeLibraryMatrix(readMatrixFromFile("doubleMatrixC" + fileName + ".txt", "double").getNumber());
        this.libraryMatrixX = makeLibraryMatrix(readMatrixFromFile("doubleMatrixX" + fileName + ".txt", "double").getNumber());
        this.libraryMatrixGauss = makeLibraryMatrix(readMatrixFromFile("doubleMatrixGauss" + fileName + ".txt", "double").getNumber());
        this.fractionMyMatrixA.shortenMatrix();
        this.fractionMyMatrixB.shortenMatrix();
        this.fractionMyMatrixC.shortenMatrix();
        this.fractionMyMatrixX.shortenMatrix();
        this.fractionMyMatrixGaussP.shortenMatrix();
        this.fractionMyMatrixGaussPG.shortenMatrix();
        this.fractionMyMatrixGaussFG.shortenMatrix();
        return this;
    }
}
