package com.company;

import java.util.ArrayList;
import java.util.List;

public class MyMatrix<T extends Number> {
    private List<List<T>> matrix;

    public MyMatrix() {
        this.matrix = new ArrayList<>();
    }

    public MyMatrix(List<List<T>> new_matrix) {
        this.matrix = new_matrix;
    }

    public MyMatrix(int rows, int cols, List<T> list_of_elem) {
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


    public MyMatrix<T> addingMatrix(MyMatrix<T> another_matrix) {
        List<List<T>> new_matrix = new ArrayList<>();
        if (this.matrix.size() == another_matrix.getMatrix().size()) {
            for (int i = 0; i < this.matrix.size(); i++) {
                List<T> row = new ArrayList<>();
                for (int j = 0; j < another_matrix.getMatrix().get(i).size(); j++) {
                    if (this.matrix.get(i).get(j) instanceof Double) {
                        row.add((T) new Double(this.matrix.get(i).get(j).doubleValue() + another_matrix.getMatrix().get(i).get(j).doubleValue()));
                    } else if (this.matrix.get(i).get(j) instanceof Float) {
                        row.add((T) new Float(this.matrix.get(i).get(j).floatValue() + another_matrix.getMatrix().get(i).get(j).floatValue()));
                    } else if (this.matrix.get(i).get(j) instanceof Fraction) {
                        row.add((T) (((Fraction) this.matrix.get(i).get(j)).adding_frac((Fraction) another_matrix.getMatrix().get(i).get(j))));
                    } else {
                        throw new IllegalArgumentException("Type " + this.matrix.get(i).get(j).getClass() + " is not supported by this method");
                    }
                }
                new_matrix.add(row);
            }
        }
        return new MyMatrix<T>(new_matrix);
    }
}