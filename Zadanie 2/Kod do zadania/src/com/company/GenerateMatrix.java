package com.company;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerateMatrix {

    public static List<List<Fraction>> generate(int cols, int rows) {
        List<List<Fraction>> result = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            List<Fraction> row = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                Random ran = new Random();
                row.add(new Fraction(BigInteger.valueOf(ran.nextInt()), BigInteger.valueOf(ran.nextInt())));
            }
            result.add(row);
        }
        return result;
    }

    public static List<List<Float>> makeFloatMatrix(List<List<Fraction>> matrixFraction) {
        List<List<Float>> result = new ArrayList<>();
        for (int i = 0; i < matrixFraction.size(); i++) {
            List<Float> row = new ArrayList<>();
            for (int j = 0; j < matrixFraction.get(i).size(); j++) {
                row.add(matrixFraction.get(i).get(j).getNumerator().floatValue() / matrixFraction.get(i).get(j).getDenumerator().floatValue());
            }
            result.add(row);
        }
        return result;
    }

    public static List<List<Double>> makeDoubleMatrix(List<List<Fraction>> matrixFraction) {
        List<List<Double>> result = new ArrayList<>();
        for (int i = 0; i < matrixFraction.size(); i++) {
            List<Double> row = new ArrayList<>();
            for (int j = 0; j < matrixFraction.get(i).size(); j++) {
                row.add(matrixFraction.get(i).get(j).getNumerator().doubleValue() / matrixFraction.get(i).get(j).getDenumerator().doubleValue());
            }
            result.add(row);
        }
        return result;
    }

//    public static List<List<Double>> saveMatrixToFile(List<List<Fraction>> matrixFraction) {
//        List<List<Double>> result = new ArrayList<>();
//        for (int i = 0; i < matrixFraction.size(); i++) {
//            List<Double> row = new ArrayList<>();
//            for (int j = 0; j < matrixFraction.get(i).size(); j++) {
//                row.add(matrixFraction.get(i).get(j).getNumerator().doubleValue()/matrixFraction.get(i).get(j).getDenumerator().doubleValue());
//            }
//            result.add(row);
//        }
//        return result;
//    }

    public static void main(String[] args) {

    }
}
