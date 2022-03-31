package com.company;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.*;

public class Main {


    public static BigInteger LCM(BigInteger a, BigInteger b) {
        if (a.signum() == 0 || b.signum() == 0) {
            return BigInteger.ZERO;
        }
        return a.divide(a.gcd(b)).multiply(b).abs();
    }

    public static void print_fraction_matrix(List<List<Fraction>> matrix) {
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.size(); j++) {
                System.out.print(matrix.get(i).get(j).getFraction() + " ");
            }
            System.out.println();
        }
    }


    public static <T extends Number> MyMatrix<T> readMatrixFromFile(String file, String type) {
        List<List<T>> toMat = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(file));
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
                            row.add((T) new Double(read));
                        } else if (Objects.equals(type, "float")) {
                            row.add((T) new Float(read));
                        } else if (Objects.equals(type, "fraction")) {
                            System.out.println(read);
                            row.add((T) new Fraction(new BigInteger(read.split(";")[0]), new BigInteger(read.split(";")[1])));
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

    public static void main(String[] args) {

        MyMatrix<Double> mat = readMatrixFromFile("doubleMatrixA.txt", "double");
        List<Float> listToMat = new ArrayList<>();
        Collections.addAll(listToMat, 2F, 5F, 1F, -2F);
        MyMatrix<Float> matToTest = new MyMatrix<>(2, 2, listToMat);
        List<Float> listToMat2 = new ArrayList<>();
        Collections.addAll(listToMat2, 3F, -1F, 7F, 4F);
        MyMatrix<Float> matToTest2 = new MyMatrix<>(2, 2, listToMat2);

        System.out.println(mat.addingMatrix(mat).getMatrix());
        System.out.println(matToTest.multiplyMatrix(matToTest2).getMatrix());


        List<Fraction> toMat = new ArrayList<>();
        Collections.addAll(toMat, new Fraction(BigInteger.ONE, BigInteger.valueOf(4)), new Fraction(BigInteger.valueOf(4), BigInteger.valueOf(5)), new Fraction(BigInteger.TEN, BigInteger.valueOf(13)), new Fraction(BigInteger.TWO, BigInteger.valueOf(5)));
        MyMatrix<Fraction> tests = new MyMatrix<>(2, 2, toMat);
        System.out.println(tests.getMatrix());
        print_fraction_matrix(tests.getMatrix());
        print_fraction_matrix(tests.addingMatrix(tests).getMatrix());
        print_fraction_matrix(tests.multiplyMatrix(tests).getMatrix());


//        System.out.println(mat.getMatrix());
//        System.out.println(mat.addingMatrix(mat).getMatrix());
//        System.out.println(mat.multiplyMatrix(mat).getMatrix());

//        MyMatrix<Fraction> matFrac = readMatrixFromFile("fractionMatrixA.txt", "fraction");
//        print_fraction_matrix(matFrac.getMatrix());
//        System.out.println(matFrac.getMatrix());
//        print_fraction_matrix(matFrac.getMatrix());
//        System.out.println(mat.getMatrix());
    }
}
