package com.company;

import java.util.ArrayList;
import java.util.List;

public class MyMatrix<T> {
    private List<List<MyNumber<T>>> matrix;
//    private MyNumber<T>[][] tests;

    public MyMatrix() {
        this.matrix = new ArrayList<>();
    }

    public MyMatrix(List<List<MyNumber<T>>> new_matrix) {
        this.matrix = new_matrix;
    }

    public MyMatrix(int rows, int cols, List<MyNumber<T>> list_of_elem) {
        List<List<MyNumber<T>>> new_matrix = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            List<MyNumber<T>> new_row = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                new_row.add(list_of_elem.get((cols * i) + j));
            }
            new_matrix.add(new_row);
        }
        this.matrix = new_matrix;
    }

    public void setMatrix(List<List<MyNumber<T>>> matrix) {
        this.matrix = matrix;
    }

    public List<List<T>> getMatrix() {
        List<List<T>> res = new ArrayList<>();
        for (int i = 0; i < this.matrix.size(); i++) {
            List<T> temp = new ArrayList<>();
            for (int j = 0; j < this.matrix.get(i).size(); j++) {
                temp.add(this.matrix.get(i).get(j).getValue());
            }
            res.add(temp);
        }
        return res;
    }


    public void addingMatrix(MyMatrix<T> another_matrix) {
        for (int i = 0; i < this.matrix.size(); i++) {
            for (int j = 0; j < another_matrix.getMatrix().get(i).size(); j++) {
                this.matrix.get(i).get(j).add(another_matrix.getMatrix().get(i).get(j));
            }
        }
    }

    public void multiplyMatrix(MyMatrix<T> another_matrix) {
        List<List<MyNumber<T>>> new_matrix = new ArrayList<>(this.matrix);
        for (int i = 0; i < this.matrix.size(); i++) {
            List<MyNumber<T>> temp_row = new ArrayList<>();
            for (int j = 0; j < another_matrix.getMatrix().get(i).size(); j++) {
                MyNumber<T> summary = new_matrix.get(i).get(0);
                summary.mul(another_matrix.getMatrix().get(0).get(j));
                for (int k = 1; k < another_matrix.getMatrix().size(); k++) {
                    MyNumber<T> temp = new_matrix.get(i).get(k);
                    temp.mul(another_matrix.getMatrix().get(k).get(j));
                    summary.add(temp.getValue());
                }
                System.out.println(summary.getValue());
                temp_row.add(summary);
            }
            System.out.println(temp_row);
            this.matrix.set(i, temp_row);
        }
    }
}
