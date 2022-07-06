package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ResultToSave {
    private String resTimes;
    private String resDiff;

    public ResultToSave() {
        this.resDiff = "";
        this.resTimes = "";
    }

    public void addMatrixSize(String matrixSize) {
        this.resDiff = this.resDiff + matrixSize + "\n";
        this.resTimes = this.resTimes + matrixSize + "\n";
    }

    public void addResults(List<String> res, String type) {
        this.resDiff = this.resDiff + type + res.get(0) + "\n";
        this.resTimes = this.resTimes + type + res.get(1) + "\n";
    }

    public void saveToFileResults() {
        try {
            FileWriter fileWriter = new FileWriter("resultsDiff.txt");
            fileWriter.write(this.resDiff);
            fileWriter.close();
        } catch (IOException err) {
            err.printStackTrace();
        }
        try {
            FileWriter fileWriter = new FileWriter("resultsTimes.txt");
            fileWriter.write(this.resTimes);
            fileWriter.close();
        } catch (IOException err) {
            err.printStackTrace();
        }
    }
}
