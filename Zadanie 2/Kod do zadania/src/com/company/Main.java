package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {


    static class MojaMacierz {
        private List<List<Float>> matrix = new ArrayList<>();

        public void setMatrix(List<List<Float>> matrix) {
            this.matrix = matrix;
        }

        public List<List<Float>> getMatrix() {
            return matrix;
        }

        public List<List<Float>> adding(MojaMacierz another_matrix){
            List<List<Float>> new_matrix = new ArrayList<>();
            if (this.matrix.size()==another_matrix.getMatrix().size()){
                for (int i=0;i<this.matrix.size();i++){
                    List<Float> row = new ArrayList<>();
                    for (int j=0;j<another_matrix.getMatrix().get(i).size();j++){
                        row.add(this.matrix.get(i).get(j)+another_matrix.getMatrix().get(i).get(j));
                    }
                    new_matrix.add(row);
                }
            }
            return new_matrix;
        }
        public List<List<Float>> multiply(MojaMacierz another_matrix){
            List<List<Float>> new_matrix = new ArrayList<>();
//            if (this.matrix.size()==another_matrix.getMatrix().size()){
                for (int i=0;i<this.matrix.size();i++){
                    List<Float> row = new ArrayList<>();
                    for (int j=0;j<another_matrix.getMatrix().get(i).size();j++){
                        float summary= 0F;
                        for (int k=0;k<another_matrix.getMatrix().size();k++){
                            summary+=this.matrix.get(i).get(k)*another_matrix.getMatrix().get(k).get(j);
                        }
                        row.add(summary);
                    }
                    new_matrix.add(row);
                }
//            }
            return new_matrix;
        }
    }

    public static void main(String[] args) {
        MojaMacierz temp = new MojaMacierz();
        MojaMacierz temp2 = new MojaMacierz();
        MojaMacierz temp3 = new MojaMacierz();
        List<Float> row1 = new ArrayList<>();
        List<Float> row2 = new ArrayList<>();
        List<Float> row3 = new ArrayList<>();
        List<Float> row4 = new ArrayList<>();
        List<Float> row5 = new ArrayList<>();
        List<Float> row6 = new ArrayList<>();
        List<Float> row7 = new ArrayList<>();
        List<Float> row8 = new ArrayList<>();
        List<Float> row9 = new ArrayList<>();
        Collections.addAll(row1,-1F,-2F,3F);
        Collections.addAll(row2,0F,2F,-1F);
        Collections.addAll(row3,-1F,3F,0F);
        Collections.addAll(row4,1F,5F,1F);
        Collections.addAll(row5,2F,1F,2F);
        Collections.addAll(row6,3F,2F,3F);
        Collections.addAll(row7,1F);
        Collections.addAll(row8,2F);
        Collections.addAll(row9,3F);
        List<List<Float>> rows = new ArrayList<>();
        List<List<Float>> rows2 = new ArrayList<>();
        List<List<Float>> rows3 = new ArrayList<>();
        Collections.addAll(rows,row1,row2,row3);
        temp.setMatrix(rows);
        Collections.addAll(rows2,row4,row5,row6);
        temp2.setMatrix(rows2);
        Collections.addAll(rows3,row7,row8,row9);
        temp3.setMatrix(rows3);
        System.out.println(temp.adding(temp2));
        System.out.println(temp.multiply(temp2));
        System.out.println(temp.multiply(temp3));
    }
}
