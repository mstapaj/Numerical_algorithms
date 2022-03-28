package com.company;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static List<List<Float>> adding_matrix_f(MojaMacierz<Float> m1, MojaMacierz<Float> m2) {
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

    static List<List<Float>> multiply_matrix_f(MojaMacierz<Float> m1, MojaMacierz<Float> m2) {
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

    static List<List<Double>> adding_matrix_d(MojaMacierz<Double> m1, MojaMacierz<Double> m2) {
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

    static List<List<Double>> multiply_matrix_d(MojaMacierz<Double> m1, MojaMacierz<Double> m2) {
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

    static List<List<Fraction>> adding_matrix_frac(MojaMacierz<Fraction> m1, MojaMacierz<Fraction> m2) {
        List<List<Fraction>> new_matrix = new ArrayList<>();
        if (m1.getMatrix().size() == m2.getMatrix().size()) {
            for (int i = 0; i < m1.getMatrix().size(); i++) {
                List<Fraction> row = new ArrayList<>();
                for (int j = 0; j < m2.getMatrix().get(i).size(); j++) {
                    row.add(adding_frac(m1.getMatrix().get(i).get(j), m2.getMatrix().get(i).get(j)));
                }
                new_matrix.add(row);
            }
        }
        return new_matrix;
    }

    static List<List<Fraction>> multiply_matrix_frac(MojaMacierz<Fraction> m1, MojaMacierz<Fraction> m2) {
        List<List<Fraction>> new_matrix = new ArrayList<>();
        for (int i = 0; i < m1.getMatrix().size(); i++) {
            List<Fraction> row = new ArrayList<>();
            for (int j = 0; j < m2.getMatrix().get(i).size(); j++) {
                Fraction summary = new Fraction(BigInteger.ZERO, BigInteger.ONE);
                for (int k = 0; k < m2.getMatrix().size(); k++) {
                    summary = adding_frac(summary, multiply_frac(m1.getMatrix().get(i).get(k), m2.getMatrix().get(k).get(j)));
                }
                row.add(summary);
            }
            new_matrix.add(row);
        }
        return new_matrix;
    }

    static class MojaMacierz<T> {
        private List<List<T>> matrix;

        public MojaMacierz() {
            this.matrix = new ArrayList<>();
        }

        public MojaMacierz(List<List<T>> new_matrix) {
            this.matrix = new_matrix;
        }

        public MojaMacierz(int rows, int cols, List<T> list_of_elem) {
            List<List<T>> new_matrix = new ArrayList<>();
            for (int i = 0; i < rows; i++) {
                List<T> new_row = new ArrayList<>();
                for (int j = 0; j < cols; j++) {
                    new_row.add(list_of_elem.get((cols * i) + j));
                }
                new_matrix.add(new_row);
            }
            this.matrix = new_matrix;
        }

        public void setMatrix(List<List<T>> matrix) {
            this.matrix = matrix;
        }

        public List<List<T>> getMatrix() {
            return matrix;
        }
    }


    public static BigInteger LCM(BigInteger a, BigInteger b) {
        if (a.signum() == 0 || b.signum() == 0) {
            return BigInteger.ZERO;
        }
        return a.divide(a.gcd(b)).multiply(b).abs();
    }

    public static Fraction adding_frac(Fraction a, Fraction b) {
        BigInteger lcm = LCM(a.getDenumerator(), b.getDenumerator());
        BigInteger first_mul = lcm.divide(a.getDenumerator());
        BigInteger sec_mul = lcm.divide(b.getDenumerator());
        BigInteger new_numerator = a.getNumerator().multiply(first_mul).add(b.getNumerator().multiply(sec_mul));
        BigInteger gcd = new_numerator.gcd(lcm);
        return new Fraction(new_numerator.divide(gcd), lcm.divide(gcd));
    }

    public static Fraction substract_frac(Fraction a, Fraction b) {
        BigInteger lcm = LCM(a.getDenumerator(), b.getDenumerator());
        BigInteger first_mul = lcm.divide(a.getDenumerator());
        BigInteger sec_mul = lcm.divide(b.getDenumerator());
        BigInteger new_numerator = a.getNumerator().multiply(first_mul).subtract(b.getNumerator().multiply(sec_mul));
        BigInteger gcd = new_numerator.gcd(lcm);
        return new Fraction(new_numerator.divide(gcd), lcm.divide(gcd));
    }

    public static Fraction multiply_frac(Fraction a, Fraction b) {
        BigInteger new_numerator = a.getNumerator().multiply(b.getNumerator());
        BigInteger new_denumerator = a.getDenumerator().multiply(b.getDenumerator());
        BigInteger gcd = new_numerator.gcd(new_denumerator);
        return new Fraction(new_numerator.divide(gcd), new_denumerator.divide(gcd));
    }

    public static Fraction divide_frac(Fraction a, Fraction b) {
        BigInteger new_numerator = a.getNumerator().multiply(b.getDenumerator());
        BigInteger new_denumerator = a.getDenumerator().multiply(b.getNumerator());
        BigInteger gcd = new_numerator.gcd(new_denumerator);
        return new Fraction(new_numerator.divide(gcd), new_denumerator.divide(gcd));
    }

    public static void main(String[] args) {
        MojaMacierz<Float> temp = new MojaMacierz<>();
        MojaMacierz<Float> temp2 = new MojaMacierz<>();
        MojaMacierz<Float> temp3 = new MojaMacierz<>();
        MojaMacierz<Float> temp4 = new MojaMacierz<>();
        List<Float> row1 = new ArrayList<>();
        List<Float> row2 = new ArrayList<>();
        List<Float> row3 = new ArrayList<>();
        List<Float> row4 = new ArrayList<>();
        List<Float> row5 = new ArrayList<>();
        List<Float> row6 = new ArrayList<>();
        List<Float> row7 = new ArrayList<>();
        List<Float> row8 = new ArrayList<>();
        List<Float> row9 = new ArrayList<>();
        List<Float> row10 = new ArrayList<>();
        List<Float> row11 = new ArrayList<>();
        List<Float> row12 = new ArrayList<>();
        Collections.addAll(row1, -1F, -2F, 3F);
        Collections.addAll(row2, 0F, 2F, -1F);
        Collections.addAll(row3, -1F, 3F, 0F);
        Collections.addAll(row4, 1F, 5F, 1F);
        Collections.addAll(row5, 2F, 1F, 2F);
        Collections.addAll(row6, 3F, 2F, 3F);
        Collections.addAll(row7, 1F);
        Collections.addAll(row8, 2F);
        Collections.addAll(row9, 3F);
        Collections.addAll(row10, 1F, -2F, 3F, -7F);
        Collections.addAll(row11, 3F, 1F, 4F, 5F);
        Collections.addAll(row12, 2F, 5F, 1F, 18F);
        List<List<Float>> rows = new ArrayList<>();
        List<List<Float>> rows2 = new ArrayList<>();
        List<List<Float>> rows3 = new ArrayList<>();
        List<List<Float>> rows4 = new ArrayList<>();
        Collections.addAll(rows, row1, row2, row3);
        temp.setMatrix(rows);
        Collections.addAll(rows2, row4, row5, row6);
        temp2.setMatrix(rows2);
        Collections.addAll(rows3, row7, row8, row9);
        temp3.setMatrix(rows3);
        Collections.addAll(rows4, row10, row11, row12);
        temp4.setMatrix(rows4);
//        System.out.println(adding_matrix_f(temp, temp2));
//        System.out.println(multiply_matrix_f(temp, temp2));
//        System.out.println(multiply_matrix_f(temp, temp3));
//
//
//        List<Integer> toMat = new ArrayList<>();
//        Collections.addAll(toMat, 2, 1, 3, 4, 1, 4, 6, 1, 4);
//        MojaMacierz<Integer> tests = new MojaMacierz<>(3, 3, toMat);
//        System.out.println(tests.getMatrix());
        Fraction first = new Fraction(BigInteger.ONE, BigInteger.valueOf(17));
        Fraction second = new Fraction(BigInteger.TWO, BigInteger.valueOf(6));
        adding_frac(first, second);
//        System.out.println(adding_frac(first, second).getNumerator());
//        System.out.println(adding_frac(first, second).getDenumerator());
//        System.out.println(substract_frac(first, second).getNumerator());
//        System.out.println(substract_frac(first, second).getDenumerator());
//        System.out.println(multiply_frac(first, second).getNumerator());
//        System.out.println(multiply_frac(first, second).getDenumerator());
//        System.out.println(divide_frac(first, second).getNumerator());
//        System.out.println(divide_frac(first, second).getDenumerator());

        List<Fraction> toMat = new ArrayList<>();
        Collections.addAll(toMat, new Fraction(BigInteger.ONE, BigInteger.valueOf(4)), new Fraction(BigInteger.valueOf(4), BigInteger.valueOf(5)), new Fraction(BigInteger.TEN, BigInteger.valueOf(13)), new Fraction(BigInteger.TWO, BigInteger.valueOf(5)));
        MojaMacierz<Fraction> tests = new MojaMacierz<>(2, 2, toMat);
        System.out.println(tests.getMatrix());
        List<List<Fraction>> res_add = adding_matrix_frac(tests, tests);
        List<List<Fraction>> res_mul = multiply_matrix_frac(tests, tests);

        for (int i = 0; i < res_add.size(); i++) {
            for (int j = 0; j < res_add.size(); j++) {
                System.out.println(res_add.get(i).get(j).getFraction());
            }
        }

        for (int i = 0; i < res_mul.size(); i++) {
            for (int j = 0; j < res_mul.size(); j++) {
                System.out.println(res_mul.get(i).get(j).getFraction());
            }
        }

    }
}
