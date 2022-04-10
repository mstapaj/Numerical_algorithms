package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class MyMatrix<T extends MyNumber<T>> {
    public List<List<T>> matrix;
//    private MyNumber<T>[][] tests;

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

    public List<T> gaussMatrixG() {
        List<T> result = new ArrayList<>();
        int columns = this.matrix.size();
        int rows = this.matrix.get(0).size();
        for (int k = 0; k < columns; k++) {
//            System.out.println(k);
            for (int i = k + 1; i < columns; i++) {
                T temp = this.matrix.get(i).get(k).initialize();
                temp.div(this.matrix.get(k).get(k));
                for (int j = k + 1; j < rows; j++) {   // jak nie będzie działać to zmień na get(k)
                    T temp2 = this.matrix.get(k).get(j).initialize();
                    temp2.mul(temp);
                    this.matrix.get(i).get(j).sub(temp2);
                }
                this.matrix.get(i).set(k, this.matrix.get(0).get(0).initialize_zero());
            }
            this.matrix = this.shortenMatrix().getMatrix();
        }
        for (int i = 0; i < columns; i++) {
            result.add(this.matrix.get(0).get(0).initialize());
        }
        for (int i = columns - 1; i >= 0; i--) {
//            System.out.println(i);
            result.set(i, this.matrix.get(i).get(columns));
            for (int j = i + 1; j < columns; j++) {
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
        int columns = this.matrix.size();
        int rows = this.matrix.get(0).size();
        for (int k = 0; k < columns; k++) {
//            System.out.println(k);
            int i_max = k;
            T v_max = this.matrix.get(i_max).get(k).initialize();
            for (int i = k + 1; i < columns; i++) {
                if (this.matrix.get(i).get(k).absolute().compare(v_max) == -1) {
                    v_max = this.matrix.get(i).get(k).initialize();
                    i_max = i;
                }
            }
            if (i_max != k) {
                Collections.swap(this.matrix, k, i_max);
            }
            for (int i = k + 1; i < columns; i++) {
                T temp = this.matrix.get(i).get(k).initialize();
                temp.div(this.matrix.get(k).get(k));
                for (int j = k + 1; j < rows; j++) {   // jak nie będzie działać to zmień na get(k)
                    T temp2 = this.matrix.get(k).get(j).initialize();
                    temp2.mul(temp);
                    this.matrix.get(i).get(j).sub(temp2);
                }
                this.matrix.get(i).set(k, this.matrix.get(0).get(0).initialize_zero());
            }
            this.matrix = this.shortenMatrix().getMatrix();
        }
        for (int i = 0; i < columns; i++) {
            result.add(this.matrix.get(0).get(0).initialize());
        }
        for (int i = columns - 1; i >= 0; i--) {
//            System.out.println(i);
            result.set(i, this.matrix.get(i).get(columns));
            for (int j = i + 1; j < columns; j++) {
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
        List<T> result2 = new ArrayList<>();
        int columns = this.matrix.size();
        int rows = this.matrix.get(0).size();
        List<Integer> range = new ArrayList<>(IntStream.rangeClosed(0, columns - 1).boxed().toList());
        for (int k = 0; k < columns; k++) {
            int i_max = k;
            T v_max = this.matrix.get(i_max).get(k).initialize();
            int i_max2 = k;
            T v_max2 = this.matrix.get(i_max2).get(k).initialize();
            for (int i = k + 1; i < columns; i++) {
                if (this.matrix.get(i).get(k).absolute().compare(v_max) == -1) {
                    v_max = this.matrix.get(i).get(k).initialize();
                    i_max = i;
                }
            }

            for (int i = k + 1; i < columns; i++) {
                if (this.matrix.get(k).get(i).absolute().compare(v_max2) == -1) {
                    v_max2 = this.matrix.get(k).get(i).initialize();
                    i_max2 = i;
                }
            }
            if (i_max != k) {
                Collections.swap(this.matrix, k, i_max);
            }
            if (i_max2 != k) {
                for (int j = 0; j < columns; j++) {
                    T temp = this.matrix.get(j).get(i_max2).initialize();
                    this.matrix.get(j).set(i_max2, this.matrix.get(j).get(k));
                    this.matrix.get(j).set(k, temp);
                }
                Collections.swap(range, i_max2, k);
            }
            for (int i = k + 1; i < columns; i++) {
                T temp = this.matrix.get(i).get(k).initialize();
                temp.div(this.matrix.get(k).get(k));
                for (int j = k + 1; j < rows; j++) {   // jak nie będzie działać to zmień na get(k)
                    T temp2 = this.matrix.get(k).get(j).initialize();
                    temp2.mul(temp);
                    this.matrix.get(i).get(j).sub(temp2);
                }
                this.matrix.get(i).set(k, this.matrix.get(0).get(0).initialize_zero());
            }
            this.matrix = this.shortenMatrix().getMatrix();
        }
        for (int i = 0; i < columns; i++) {
            result.add(this.matrix.get(0).get(0).initialize());
        }
        for (int i = columns - 1; i >= 0; i--) {
//            System.out.println(i);
            result.set(i, this.matrix.get(i).get(columns));
            for (int j = i + 1; j < columns; j++) {
                T temp = this.matrix.get(i).get(j).initialize();
                temp.mul(result.get(j));
                result.get(i).sub(temp);
            }
            T temp2 = result.get(i);
            temp2.div(this.matrix.get(i).get(i));
            result.set(i, temp2);
        }
        for (int i = 0; i < range.size(); i++) {
            result2.add(result.get(range.get(i)));
        }
        return result2;
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

    // Inne mnożenie

    //    public void multiplyMatrix(MyMatrix<T> another_matrix) {
////        List<List<MyNumber<T>>> new_mat= new ArrayList<>();
//        int rows1 = this.matrix.size();
//        int columns1 = another_matrix.getMatrix().get(0).size();
//        int rows2 = another_matrix.getMatrix().size();
//        for (int i = 0; i < rows1; i++) {
//            List<T> temp_row = new ArrayList<>();
//            for (int j = 0; j < columns1; j++) {
//                T summary = this.matrix.get(0).get(0).initialize_zero();
//                for (int k = 0; k < rows2; k++) {
//                    MyNumber<T> temp = this.matrix.get(i).get(k).initialize();
//                    temp.mul(another_matrix.getMatrix().get(k).get(j));
//                    summary.add(temp.getValue());
//                }
//                temp_row.add(summary);
//            }
//            this.matrix.set(i, temp_row);
//        }
//    }

}
