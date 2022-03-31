package com.company;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static List<List<Float>> adding_matrix_f(MyMatrix<Float> m1, MyMatrix<Float> m2) {
        List<List<Float>> new_matrix = new ArrayList<>();
        if (m1.getMatrix().size() == m2.getMatrix().size()) {
            for (int i = 0; i < m1.getMatrix().size(); i++) {
                List<Float> row = new ArrayList<>();
                for (int j = 0; j < m2.getMatrix().get(i).size(); j++) {
                    row.add(m1.getMatrix().get(i).get(j) + m2.getMatrix().get(i).get(j));
                }
                new_matrix.add(row);
            }
        }
        return new_matrix;
    }

    static List<List<Float>> multiply_matrix_f(MyMatrix<Float> m1, MyMatrix<Float> m2) {
        List<List<Float>> new_matrix = new ArrayList<>();
        for (int i = 0; i < m1.getMatrix().size(); i++) {
            List<Float> row = new ArrayList<>();
            for (int j = 0; j < m2.getMatrix().get(i).size(); j++) {
                float summary = 0F;
                for (int k = 0; k < m2.getMatrix().size(); k++) {
                    summary += m1.getMatrix().get(i).get(k) * m2.getMatrix().get(k).get(j);
                }
                row.add(summary);
            }
            new_matrix.add(row);
        }
        return new_matrix;
    }

    static List<List<Double>> adding_matrix_d(MyMatrix<Double> m1, MyMatrix<Double> m2) {
        List<List<Double>> new_matrix = new ArrayList<>();
        if (m1.getMatrix().size() == m2.getMatrix().size()) {
            for (int i = 0; i < m1.getMatrix().size(); i++) {
                List<Double> row = new ArrayList<>();
                for (int j = 0; j < m2.getMatrix().get(i).size(); j++) {
                    row.add(m1.getMatrix().get(i).get(j) + m2.getMatrix().get(i).get(j));
                }
                new_matrix.add(row);
            }
        }
        return new_matrix;
    }

    static List<List<Double>> multiply_matrix_d(MyMatrix<Double> m1, MyMatrix<Double> m2) {
        List<List<Double>> new_matrix = new ArrayList<>();
        for (int i = 0; i < m1.getMatrix().size(); i++) {
            List<Double> row = new ArrayList<>();
            for (int j = 0; j < m2.getMatrix().get(i).size(); j++) {
                double summary = 0F;
                for (int k = 0; k < m2.getMatrix().size(); k++) {
                    summary += m1.getMatrix().get(i).get(k) * m2.getMatrix().get(k).get(j);
                }
                row.add(summary);
            }
            new_matrix.add(row);
        }
        return new_matrix;
    }
//
//    static List<List<Fraction>> adding_matrix_frac(MyMatrix<Fraction> m1, MyMatrix<Fraction> m2) {
//        List<List<Fraction>> new_matrix = new ArrayList<>();
//        if (m1.getMatrix().size() == m2.getMatrix().size()) {
//            for (int i = 0; i < m1.getMatrix().size(); i++) {
//                List<Fraction> row = new ArrayList<>();
//                for (int j = 0; j < m2.getMatrix().get(i).size(); j++) {
//                    row.add(adding_frac(m1.getMatrix().get(i).get(j), m2.getMatrix().get(i).get(j)));
//                }
//                new_matrix.add(row);
//            }
//        }
//        return new_matrix;
//    }
//
//    static List<List<Fraction>> multiply_matrix_frac(MyMatrix<Fraction> m1, MyMatrix<Fraction> m2) {
//        List<List<Fraction>> new_matrix = new ArrayList<>();
//        for (int i = 0; i < m1.getMatrix().size(); i++) {
//            List<Fraction> row = new ArrayList<>();
//            for (int j = 0; j < m2.getMatrix().get(i).size(); j++) {
//                Fraction summary = new Fraction(BigInteger.ZERO, BigInteger.ONE);
//                for (int k = 0; k < m2.getMatrix().size(); k++) {
//                    summary = adding_frac(summary, multiply_frac(m1.getMatrix().get(i).get(k), m2.getMatrix().get(k).get(j)));
//                }
//                row.add(summary);
//            }
//            new_matrix.add(row);
//        }
//        return new_matrix;
//    }


    public static BigInteger LCM(BigInteger a, BigInteger b) {
        if (a.signum() == 0 || b.signum() == 0) {
            return BigInteger.ZERO;
        }
        return a.divide(a.gcd(b)).multiply(b).abs();
    }

    public static void print_fraction_matrix(List<List<Fraction>> matrix) {
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.size(); j++) {
                System.out.println(matrix.get(i).get(j).getFraction());
            }
        }
    }

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
                    if (Objects.equals(read, "endline")) {
                        toMat.add(row);
                        row = new ArrayList<>();
                    } else {
                        if (Objects.equals(type, "double")) {
                            row.add((T) new Double(read));
                        } else if (Objects.equals(type, "float")) {
                            row.add((T) new Float(read));
                        } else if (Objects.equals(type, "fraction")) {
                            row.add((T) new Fraction(new BigInteger(read.split(";")[0]), new BigInteger(read.split(";")[1])));
                        } else {
                            throw new IllegalArgumentException("Type " + type + " is not supported by this method");
                        }

                    }
                } catch (NumberFormatException e) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new MyMatrix<>(toMat);
    }

    public static void main(String[] args) {
//        MyMatrix<Float> temp = new MyMatrix<>();
//        MyMatrix<Float> temp2 = new MyMatrix<>();
//        MyMatrix<Float> temp3 = new MyMatrix<>();
//        MyMatrix<Float> temp4 = new MyMatrix<>();
//        List<Float> row1 = new ArrayList<>();
//        List<Float> row2 = new ArrayList<>();
//        List<Float> row3 = new ArrayList<>();
//        List<Float> row4 = new ArrayList<>();
//        List<Float> row5 = new ArrayList<>();
//        List<Float> row6 = new ArrayList<>();
//        List<Float> row7 = new ArrayList<>();
//        List<Float> row8 = new ArrayList<>();
//        List<Float> row9 = new ArrayList<>();
//        List<Float> row10 = new ArrayList<>();
//        List<Float> row11 = new ArrayList<>();
//        List<Float> row12 = new ArrayList<>();
//        Collections.addAll(row1, -1F, -2F, 3F);
//        Collections.addAll(row2, 0F, 2F, -1F);
//        Collections.addAll(row3, -1F, 3F, 0F);
//        Collections.addAll(row4, 1F, 5F, 1F);
//        Collections.addAll(row5, 2F, 1F, 2F);
//        Collections.addAll(row6, 3F, 2F, 3F);
//        Collections.addAll(row7, 1F);
//        Collections.addAll(row8, 2F);
//        Collections.addAll(row9, 3F);
//        Collections.addAll(row10, 1F, -2F, 3F, -7F);
//        Collections.addAll(row11, 3F, 1F, 4F, 5F);
//        Collections.addAll(row12, 2F, 5F, 1F, 18F);
//        List<List<Float>> rows = new ArrayList<>();
//        List<List<Float>> rows2 = new ArrayList<>();
//        List<List<Float>> rows3 = new ArrayList<>();
//        List<List<Float>> rows4 = new ArrayList<>();
//        Collections.addAll(rows, row1, row2, row3);
//        temp.setMatrix(rows);
//        Collections.addAll(rows2, row4, row5, row6);
//        temp2.setMatrix(rows2);
//        Collections.addAll(rows3, row7, row8, row9);
//        temp3.setMatrix(rows3);
//        Collections.addAll(rows4, row10, row11, row12);
//        temp4.setMatrix(rows4);
//        System.out.println(adding_matrix_f(temp, temp2));
//        System.out.println(multiply_matrix_f(temp, temp2));
//        System.out.println(multiply_matrix_f(temp, temp3));
//
//
//        List<Integer> toMat = new ArrayList<>();
//        Collections.addAll(toMat, 2, 1, 3, 4, 1, 4, 6, 1, 4);
//        MyMatrix<Integer> tests = new MyMatrix<>(3, 3, toMat);
//        System.out.println(tests.getMatrix());
//        Fraction first = new Fraction(BigInteger.ONE, BigInteger.valueOf(17));
//        Fraction second = new Fraction(BigInteger.TWO, BigInteger.valueOf(6));
//        adding_frac(first, second);
//        System.out.println(adding_frac(first, second).getNumerator());
//        System.out.println(adding_frac(first, second).getDenumerator());
//        System.out.println(substract_frac(first, second).getNumerator());
//        System.out.println(substract_frac(first, second).getDenumerator());
//        System.out.println(multiply_frac(first, second).getNumerator());
//        System.out.println(multiply_frac(first, second).getDenumerator());
//        System.out.println(divide_frac(first, second).getNumerator());
//        System.out.println(divide_frac(first, second).getDenumerator());

//        List<Fraction> toMat = new ArrayList<>();
//        Collections.addAll(toMat, new Fraction(BigInteger.ONE, BigInteger.valueOf(4)), new Fraction(BigInteger.valueOf(4), BigInteger.valueOf(5)), new Fraction(BigInteger.TEN, BigInteger.valueOf(13)), new Fraction(BigInteger.TWO, BigInteger.valueOf(5)));
//        MyMatrix<Fraction> tests = new MyMatrix<>(2, 2, toMat);
//        System.out.println(tests.getMatrix());
//        List<List<Fraction>> res_add = adding_matrix_frac(tests, tests);
//        List<List<Fraction>> res_mul = multiply_matrix_frac(tests, tests);

//        print_fraction_matrix(res_add);
//        print_fraction_matrix(res_mul);

//        List<Fraction> toMat = new ArrayList<>();
//        MyMatrix<Fraction> tests = new MyMatrix<>(generate(3000, 3000));
//        List<Fraction> toMat2 = new ArrayList<>();
//        MyMatrix<Double> tests2 = new MyMatrix<>(makeDoubleMatrix(generate(10, 10)));
//        System.out.println(tests2.getMatrix());
//        System.out.println(tests.getMatrix());
//        print_fraction_matrix(tests.getMatrix());
//        List<List<Fraction>> res_add = adding_matrix_frac(tests, tests);
//        List<List<Fraction>> res_mul = multiply_matrix_frac(tests, tests);
//        print_fraction_matrix(res_add);
//        print_fraction_matrix(res_mul);


        List<List<Double>> toMat = new ArrayList<>();
        try {
            String file = "doubleMatrix.txt";
            Scanner scanner = new Scanner(new File(file));
            scanner.useDelimiter(",");
            List<Double> row = new ArrayList<>();
            while (true) {
                try {
                    scanner.useDelimiter(",");
                    String read = scanner.next();
                    if (Objects.equals(read, "endline")) {
                        toMat.add(row);
                        row = new ArrayList<>();
                    } else {
                        row.add(Double.valueOf(read));
                    }
                } catch (NumberFormatException e) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        MyMatrix<Double> mat = new MyMatrix<>(toMat);
        System.out.println(mat.getMatrix());
        System.out.println(mat.addingMatrix(mat).getMatrix());

        MyMatrix<Fraction> matFrac = readMatrixFromFile("fractionMatrix.txt", "fraction");
        print_fraction_matrix(matFrac.getMatrix());
    }
}
