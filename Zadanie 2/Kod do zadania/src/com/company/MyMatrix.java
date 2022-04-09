package com.company;

import java.util.ArrayList;
import java.util.List;

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

    public void shortenMatrix() {
        for (int i = 0; i < this.matrix.size(); i++) {
            for (int j = 0; j < this.matrix.get(i).size(); j++) {
                this.matrix.get(i).get(j).shorten();
            }
        }
    }

    public MyMatrix<T> addingMatrix(MyMatrix<T> another_matrix) {
        int rows = this.matrix.size();
        int columns = another_matrix.getMatrix().get(0).size();
        List<T> matrixElements = new ArrayList<>();
        for (int i = 0; i < this.matrix.size(); i++) {
            for (int j = 0; j < another_matrix.getMatrix().get(i).size(); j++) {
                T newElem = this.matrix.get(i).get(j).initialize();
                newElem.add(another_matrix.getMatrix().get(i).get(j));
                matrixElements.add(newElem);
            }
        }
        return new MyMatrix<>(rows, columns, matrixElements);
    }

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

//    public List<MyNumber<T>> gaussMatrixG() {
//        List<MyNumber<T>> result = new ArrayList<>();
//        for (int k = 0; k < this.matrix.size(); k++) {
//            for (int i = k + 1; i < this.matrix.size(); i++) {
//                MyNumber<T> temp = this.matrix.get(i).get(k).return_new();
//                temp.div(this.matrix.get(k).get(k).getValue());
//                for (int j = k + 1; j < this.matrix.get(i).size(); j++) {   // jak nie będzie działać to zmień na get(k)
//                    MyNumber<T> temp2 = this.matrix.get(k).get(j).return_new();
//                    temp2.mul(temp.getValue());
//                    this.matrix.get(i).get(j).sub(temp2.getValue());
//                }
//                this.matrix.get(i).get(k).setZero();
//            }
//            this.shortenMatrix();
//        }
//        for (int i = 0; i < this.matrix.size(); i++) {
//            result.add(this.matrix.get(0).get(0).initialize());
//        }
//        for (int i = this.matrix.size() - 1; i >= 0; i--) {
//            result.set(i, this.matrix.get(i).get(this.matrix.size()));
//            for (int j = i + 1; j < this.matrix.size(); j++) {
//                MyNumber<T> temp = this.matrix.get(i).get(j).return_new();
//                temp.mul(result.get(j).getValue());
//                result.get(i).sub(temp.getValue());
//            }
//            MyNumber<T> temp2 = result.get(i);
//            temp2.div(this.matrix.get(i).get(i).getValue());
//            result.set(i, temp2);
//        }
//        return result;
//    }
//
//    public List<MyNumber<T>> gaussMatrixPG() {
//        List<MyNumber<T>> result = new ArrayList<>();
//        for (int k = 0; k < this.matrix.size(); k++) {
//            for (int i = k + 1; i < this.matrix.size(); i++) {
//                MyNumber<T> temp = this.matrix.get(i).get(k).return_new();
//                temp.div(this.matrix.get(k).get(k).getValue());
//                for (int j = k + 1; j < this.matrix.get(i).size(); j++) {   // jak nie będzie działać to zmień na get(k)
//                    MyNumber<T> temp2 = this.matrix.get(k).get(j).return_new();
//                    temp2.mul(temp.getValue());
//                    this.matrix.get(i).get(j).sub(temp2.getValue());
//                }
//                this.matrix.get(i).get(k).setZero();
//            }
//        }
//        for (int i = 0; i < this.matrix.size(); i++) {
//            result.add(this.matrix.get(0).get(0).initialize());
//        }
//        for (int i = this.matrix.size() - 1; i >= 0; i--) {
//            result.set(i, this.matrix.get(i).get(this.matrix.size()));
//            for (int j = i + 1; j < this.matrix.size(); j++) {
//                MyNumber<T> temp = this.matrix.get(i).get(j).return_new();
//                temp.mul(result.get(j).getValue());
//                result.get(i).sub(temp.getValue());
//            }
//            MyNumber<T> temp2 = result.get(i);
//            temp2.div(this.matrix.get(i).get(i).getValue());
//            result.set(i, temp2);
//        }
//        return result;
//    }

    public MyMatrix<T> multiplyMatrix(MyMatrix<T> another_matrix) {
        int rows = this.matrix.size();
        int columns = another_matrix.getMatrix().get(0).size();
        List<T> matrixElements = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
//            System.out.println(i);
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
        return new MyMatrix<>(columns, rows, matrixElements);
    }
}
