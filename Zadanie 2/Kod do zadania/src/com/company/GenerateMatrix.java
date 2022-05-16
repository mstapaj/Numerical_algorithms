package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Random;

public class GenerateMatrix {

    public static void generate(int cols, int rows, String fileName, int min, int max) {
        try {
            FileWriter myWriterFraction = new FileWriter("data/fractionMatrix" + fileName + ".txt");
            FileWriter myWriterDouble = new FileWriter("data/doubleMatrix" + fileName + ".txt");
            FileWriter myWriterFloat = new FileWriter("data/floatMatrix" + fileName + ".txt");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    Random ran = new Random();
                    BigInteger num;
                    BigInteger denum;
                    if (max == 0 && min == 0) {
                        num = BigInteger.valueOf(ran.nextInt());
                        do {
                            denum = BigInteger.valueOf(ran.nextInt());
                        } while (denum.equals(BigInteger.ZERO));
                    } else {
                        num = BigInteger.valueOf(ran.nextInt((max - min) + 1) + min);
                        do {
                            denum = BigInteger.valueOf(ran.nextInt((max - min) + 1) + min);
                        } while (denum.equals(BigInteger.ZERO));
                    }
                    myWriterFloat.write((num.floatValue() / denum.floatValue()) / 65536 + ",");
                    myWriterDouble.write((num.doubleValue() / denum.doubleValue()) / 65536 + ",");
                    myWriterFraction.write(num + ";" + (denum.multiply(BigInteger.valueOf(65536))) + ",");
                }
            }
            myWriterFloat.close();
            myWriterDouble.close();
            myWriterFraction.close();
        } catch (IOException err) {
            err.printStackTrace();
        }
    }

    public static void generateABCX(int size, int min, int max) {
        generate(size, size, "A" + size, min, max);
        generate(size, size, "B" + size, min, max);
        generate(size, size, "C" + size, min, max);
        generate(1, size, "X" + size, min, max);
    }


    public static void main(String[] args) {
        generateABCX(500, -65536, 65535);
    }
}
