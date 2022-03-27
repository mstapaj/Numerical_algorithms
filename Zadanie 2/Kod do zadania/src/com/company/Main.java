package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        MojaMacierz<Float> temp = new MojaMacierz<>();
        MojaMacierz<Float> temp2 = new MojaMacierz<>();
        MojaMacierz<Float> temp3 = new MojaMacierz<>();
        MojaMacierz<Float> temp4 = new MojaMacierz<>();
        List<Float> row1= new ArrayList<>();
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
        Collections.addAll(row10, 1F,-2F,3F,-7F);
        Collections.addAll(row11, 3F,1F,4F,5F);
        Collections.addAll(row12, 2F,5F,1F,18F);
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
        System.out.println(adding_f(temp, temp2));
        System.out.println(multiply_f(temp, temp2));
        System.out.println(multiply_f(temp, temp3));


        List<Integer> toMat = new ArrayList<>();
        Collections.addAll(toMat, 2, 1, 3, 4, 1, 4, 6, 1, 4);
        MojaMacierz<Integer> tests = new MojaMacierz<>(3, 3, toMat);
        System.out.println(tests.getMatrix());

//        System.out.println(temp.adding(temp2));
//        System.out.println(temp.multiply(temp2));
//        System.out.println(temp.multiply(temp3));
//        System.out.println(temp4.gauss());
    }

    static List<List<Float>> adding_f(MojaMacierz<Float> m1, MojaMacierz<Float> m2) {
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

    static List<List<Float>> multiply_f(MojaMacierz<Float> m1, MojaMacierz<Float> m2) {
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

    static List<List<Double>> adding_d(MojaMacierz<Double> m1, MojaMacierz<Double> m2) {
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

    static List<List<Double>> multiply_d(MojaMacierz<Double> m1, MojaMacierz<Double> m2) {
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

//        public List<List<Float>> gauss() {
//            float[][] macWyn = new float [this.matrix.size()][this.matrix.size()];
//            float[] wynik = {0, 0, 0};
//            float[] wCopy = new float [wynik.length];
//            System.arraycopy(wynik, 0, wCopy, 0, wynik.length);
//            for (int i = 0; i < this.matrix.size()-1; i++) {
//                for (int j = i + 1; j <= this.matrix.size() - 1; j++) {
//                    for (int k = 0; k < this.matrix.size(); k++) {
//                        macWyn[j][k] = this.matrix.get(j).get(k) - (this.matrix.get(i).get(k) * (this.matrix.get(j).get(i) / this.matrix.get(i).get(i)));
//                    }
//
//                    wCopy[j] = wynik[j] - (wynik[i] * (this.matrix.get(j).get(i) / this.matrix.get(i).get(i)));
//
//                    for (int ii = 0; ii < macWyn.length; ii++) {
//                        for (int jj = 0; jj < macWyn.length; jj++) {
//                            this.matrix.get(ii).set(jj, macWyn[ii][jj]);
//                        }
//                        wynik[ii] = wCopy[ii];
//                    }
//                }
//            }
//            for (int j = 0; j < this.matrix.size(); j++) {
//                for (int k = 0; k < this.matrix.size(); k++) {
//                    System.out.print(this.matrix.get(j).get(k) + "\t");
//                }
//                System.out.println("\t" + wynik[j]);
//            }
//            return this.matrix;
//        }
    }
}
