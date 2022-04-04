package com.company;

import java.math.BigInteger;
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


    public void addingMatrix(MyMatrix<T> another_matrix) {
        if (this.matrix.get(0).get(0) instanceof Double) {
            for (int i = 0; i < this.matrix.size(); i++) {
                for (int j = 0; j < another_matrix.getMatrix().get(i).size(); j++) {
                    this.matrix.get(i).set(j, (T) new Double(this.matrix.get(0).get(0).doubleValue() + another_matrix.getMatrix().get(i).get(j).doubleValue()));
                }
            }
        } else if (this.matrix.get(0).get(0) instanceof Float) {
            for (int i = 0; i < this.matrix.size(); i++) {
                for (int j = 0; j < another_matrix.getMatrix().get(i).size(); j++) {
                    this.matrix.get(i).set(j, (T) new Float(this.matrix.get(0).get(0).floatValue() + another_matrix.getMatrix().get(i).get(j).floatValue()));
                }
            }
        } else if (this.matrix.get(0).get(0) instanceof Fraction) {
            for (int i = 0; i < this.matrix.size(); i++) {
                for (int j = 0; j < another_matrix.getMatrix().get(i).size(); j++) {
                    this.matrix.get(i).set(j, (T) (((Fraction) this.matrix.get(0).get(0)).adding_frac((Fraction) another_matrix.getMatrix().get(i).get(j))));
                }
            }
        } else {
            throw new IllegalArgumentException("Type " + this.matrix.get(0).get(0).getClass() + " is not supported by this method");
        }
//        return this;
    }

    public void multiplyMatrix(MyMatrix<T> another_matrix) {
        if (this.matrix.get(0).get(0) instanceof Double) {
            for (int i = 0; i < this.matrix.size(); i++) {
                for (int j = 0; j < another_matrix.getMatrix().get(i).size(); j++) {
                    double summary = 0;
                    for (int k = 0; k < another_matrix.getMatrix().size(); k++) {
                        summary += new Double(this.matrix.get(i).get(k).doubleValue() * another_matrix.getMatrix().get(k).get(j).doubleValue());
                    }
                    this.matrix.get(i).set(j, (T) new Double(summary));
                }
            }
        } else if (this.matrix.get(0).get(0) instanceof Float) {
            for (int i = 0; i < this.matrix.size(); i++) {
                for (int j = 0; j < another_matrix.getMatrix().get(i).size(); j++) {
                    float summary = 0F;
                    for (int k = 0; k < another_matrix.getMatrix().size(); k++) {
                        summary += new Float(this.matrix.get(i).get(k).floatValue() * another_matrix.getMatrix().get(k).get(j).floatValue());
                    }
                    this.matrix.get(i).set(j, (T) new Float(summary));
                }
            }
        } else if (this.matrix.get(0).get(0) instanceof Fraction) {
            for (int i = 0; i < this.matrix.size(); i++) {
                System.out.println(i);
                for (int j = 0; j < another_matrix.getMatrix().get(i).size(); j++) {
                    Fraction summary = new Fraction(BigInteger.ZERO, BigInteger.ONE);
                    for (int k = 0; k < another_matrix.getMatrix().size(); k++) {
                        summary = summary.adding_frac((((Fraction) this.matrix.get(i).get(k)).multiply_frac((Fraction) another_matrix.getMatrix().get(k).get(j))));
                    }
//                    List<Fraction> temp=this.matrix.
                    this.matrix.get(i).set(j, (T) summary);
                }
            }
        } else {
            throw new IllegalArgumentException("Type " + this.matrix.get(0).get(0).getClass() + " is not supported by this method");
        }
    }
}
