package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyMatrix<T extends MyNumber<T>> {
    public List<List<T>> matrix;

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
        List<List<T>> res = new ArrayList<>();
        for (int i = 0; i < this.matrix.size(); i++) {
            List<T> temp = new ArrayList<>(this.matrix.get(i));
            res.add(temp);
        }
        return res;
    }

    public List<List<Number>> getNumber() {
        List<List<Number>> res = new ArrayList<>();
        for (int i = 0; i < this.matrix.size(); i++) {
            List<Number> temp = new ArrayList<>();
            for (int j = 0; j < this.matrix.get(i).size(); j++) {
                temp.add(this.matrix.get(i).get(j).getNumber());
            }
            res.add(temp);
        }
        return res;
    }

    public void printNumber() {
        for (int i = 0; i < this.matrix.size(); i++) {
            for (int j = 0; j < this.matrix.get(i).size(); j++) {
                System.out.println(this.matrix.get(i).get(j).getNumber());
            }
        }
    }

    public MyMatrix<T> shortenMatrix() {
        int rows = this.matrix.size();
        int columns = this.matrix.get(0).size();
        List<T> matrixElements = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrixElements.add(this.matrix.get(i).get(j).shorten());
            }
        }
        return new MyMatrix<>(rows, columns, matrixElements);
    }

    public MyMatrix<T> addingMatrix(MyMatrix<T> another_matrix) {
        int rows = this.matrix.size();
        int columns = another_matrix.getMatrix().get(0).size();
        List<T> matrixElements = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                T newElem = this.matrix.get(i).get(j).initialize();
                newElem.add(another_matrix.getMatrix().get(i).get(j));
                matrixElements.add(newElem);
            }
        }
        return new MyMatrix<>(rows, columns, matrixElements);
    }

    public MyMatrix<T> multiplyMatrix(MyMatrix<T> another_matrix) {
        int rows = this.matrix.size();
        int columns = another_matrix.getMatrix().get(0).size();
        List<T> matrixElements = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int k = 0; k < columns; k++) {
                T sum = another_matrix.getMatrix().get(0).get(0).initialize_zero();
                for (int j = 0; j < rows; j++) {
                    T firstNumber = this.matrix.get(i).get(j).initialize();
                    T secondNumber = another_matrix.matrix.get(j).get(k).initialize();
                    firstNumber.mul(secondNumber);
                    sum.add(firstNumber);
                }
                matrixElements.add(sum);
            }
        }
        return new MyMatrix<>(rows, columns, matrixElements);
    }

    public List<T> gaussMatrixG() {
        List<T> result = new ArrayList<>();
        int rows = this.matrix.size();
        int columns = this.matrix.get(0).size();
        for (int k = 0; k < rows; k++) {
            result.add(this.matrix.get(0).get(0).initialize());
            for (int i = k + 1; i < rows; i++) {
                T temp = this.matrix.get(i).get(k).initialize();
                temp.div(this.matrix.get(k).get(k));
                for (int j = k + 1; j < columns; j++) {
                    T temp2 = this.matrix.get(k).get(j).initialize();
                    temp2.mul(temp);
                    this.matrix.get(i).get(j).sub(temp2);
                    this.matrix.get(i).set(j, this.matrix.get(i).get(j).shorten());
                }
                this.matrix.get(i).set(k, this.matrix.get(0).get(0).initialize_zero());
            }
        }
        for (int i = rows - 1; i >= 0; i--) {
            result.set(i, this.matrix.get(i).get(rows));
            for (int j = i + 1; j < rows; j++) {
                T temp = this.matrix.get(i).get(j).initialize();
                temp.mul(result.get(j));
                result.get(i).sub(temp);
            }
            T temp2 = result.get(i);
            temp2.div(this.matrix.get(i).get(i));
            result.set(i, temp2);
        }
        return result;
    }

    public List<T> gaussMatrixPG() {
        List<T> result = new ArrayList<>();
        int rows = this.matrix.size();
        int columns = this.matrix.get(0).size();
        for (int k = 0; k < rows; k++) {
            result.add(this.matrix.get(0).get(0).initialize());
            int i_max = k;
            T v_max = this.matrix.get(i_max).get(k).initialize();
            for (int i = k + 1; i < rows; i++) {
                if (this.matrix.get(i).get(k).absolute().compare(v_max) == 1) {
                    v_max = this.matrix.get(i).get(k).initialize();
                    i_max = i;
                }
            }
            if (i_max != k) {
                Collections.swap(this.matrix, k, i_max);
            }
            for (int i = k + 1; i < rows; i++) {
                T temp = this.matrix.get(i).get(k).initialize();
                temp.div(this.matrix.get(k).get(k));
                for (int j = k + 1; j < columns; j++) {
                    T temp2 = this.matrix.get(k).get(j).initialize();
                    temp2.mul(temp);
                    this.matrix.get(i).get(j).sub(temp2);
                }
                this.matrix.get(i).set(k, this.matrix.get(0).get(0).initialize_zero());
            }
            this.matrix = this.shortenMatrix().getMatrix();
        }
        for (int i = rows - 1; i >= 0; i--) {
            result.set(i, this.matrix.get(i).get(rows));
            for (int j = i + 1; j < rows; j++) {
                T temp = this.matrix.get(i).get(j).initialize();
                temp.mul(result.get(j));
                result.get(i).sub(temp);
            }
            T temp2 = result.get(i);
            temp2.div(this.matrix.get(i).get(i));
            result.set(i, temp2);
        }
        return result;
    }

    public List<T> gaussMatrixFG() {
        List<T> result = new ArrayList<>();
        Integer[] switchCols = new Integer[this.matrix.get(0).size() - 1];
        int rows = this.matrix.size();
        int columns = this.matrix.get(0).size();
        for (int k = 0; k < rows; k++) {
            result.add(this.matrix.get(0).get(0).initialize());
            int i_max = k;
            T v_max = this.matrix.get(i_max).get(k).initialize();
            for (int i = k + 1; i < rows; i++) {
                if (this.matrix.get(i).get(k).absolute().compare(v_max) == 1) {
                    v_max = this.matrix.get(i).get(k).initialize();
                    i_max = i;
                }
            }
            if (i_max != k) {
                Collections.swap(this.matrix, k, i_max);
            }
            int i_max2 = k;
            T v_max2 = this.matrix.get(i_max2).get(k).initialize();
            for (int i = k + 1; i < rows; i++) {
                if (this.matrix.get(k).get(i).absolute().compare(v_max2) == 1) {
                    v_max2 = this.matrix.get(k).get(i).initialize();
                    i_max2 = i;
                }
            }
            if (i_max2 != k) {
                for (int j = 0; j < rows; j++) {
                    T temp = this.matrix.get(j).get(i_max2);
                    this.matrix.get(j).set(i_max2, this.matrix.get(j).get(k));
                    this.matrix.get(j).set(k, temp);
                }
            }
            switchCols[k] = i_max2;
            for (int i = k + 1; i < rows; i++) {
                T temp = this.matrix.get(i).get(k).initialize();
                temp.div(this.matrix.get(k).get(k));
                for (int j = k + 1; j < columns; j++) {
                    T temp2 = this.matrix.get(k).get(j).initialize();
                    temp2.mul(temp);
                    this.matrix.get(i).get(j).sub(temp2);
                }
                this.matrix.get(i).set(k, this.matrix.get(0).get(0).initialize_zero());
            }
            this.matrix = this.shortenMatrix().getMatrix();
        }
        for (int i = rows - 1; i >= 0; i--) {
            result.set(i, this.matrix.get(i).get(rows));
            for (int j = i + 1; j < rows; j++) {
                T temp = this.matrix.get(i).get(j).initialize();
                temp.mul(result.get(j));
                result.get(i).sub(temp);
            }
            T temp2 = result.get(i);
            temp2.div(this.matrix.get(i).get(i));
            result.set(i, temp2);
        }
        for (int i = switchCols.length - 1; i >= 0; i--) {
            if (i != switchCols[i]) {
                T temp = result.get(i);
                result.set(i, result.get(switchCols[i]));
                result.set(switchCols[i], temp);
            }
        }
        return result;
    }
}
