package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Random;

public class GenerateMatrix {

    public static void generate(int cols, int rows, String fileName, int min, int max) {
        try {
            FileWriter myWriterFraction = new FileWriter("fractionMatrix" + fileName + ".txt");
            FileWriter myWriterDouble = new FileWriter("doubleMatrix" + fileName + ".txt");
            FileWriter myWriterFloat = new FileWriter("floatMatrix" + fileName + ".txt");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    Random ran = new Random();
                    BigInteger num;
                    BigInteger denum;
                    if (max == 0 && min == 0) {
                        num = BigInteger.valueOf(ran.nextInt());
                        denum = BigInteger.valueOf(ran.nextInt());
                    } else {
                        num = BigInteger.valueOf(ran.nextInt(max - min) + min);
                        denum = BigInteger.valueOf(ran.nextInt(max - min) + min);
                    }
                    myWriterFloat.write((int) num.floatValue() / denum.floatValue() + ",");
                    myWriterDouble.write(num.doubleValue() / denum.doubleValue() + ",");
                    myWriterFraction.write(num + ";" + denum + ",");
                }
                myWriterFloat.write("&,");
                myWriterDouble.write("&,");
                myWriterFraction.write("&,");
            }
            myWriterFloat.close();
            myWriterDouble.close();
            myWriterFraction.close();
        } catch (IOException err) {
            err.printStackTrace();
        }
    }


    public static void main(String[] args) {
        generate(100, 100, "A", 0, 0);
        generate(100, 100, "B", 0, 0);
        generate(100, 100, "C", 0, 0);
        generate(1, 100, "X", 0, 0);
    }
}
