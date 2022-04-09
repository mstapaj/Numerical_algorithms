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
                        while (true) {
                            denum = BigInteger.valueOf(ran.nextInt());
                            if (denum.equals(BigInteger.ZERO)) {
                            } else break;
                        }
                    } else {
                        num = BigInteger.valueOf(ran.nextInt(max - min) + min);
                        while (true) {
                            denum = BigInteger.valueOf(ran.nextInt(max - min) + min);
                            ;
                            if (denum.equals(BigInteger.ZERO)) {
                            } else break;
                        }
                    }
                    myWriterFloat.write((num.floatValue() / denum.floatValue()) / 65536 + ",");
                    myWriterDouble.write((num.doubleValue() / denum.doubleValue()) / 65536 + ",");
                    myWriterFraction.write(num + ";" + (denum.multiply(BigInteger.valueOf(65536))) + ",");
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
        generate(10, 10, "A", -65536, 65535);
        generate(10, 10, "B", -65536, 65535);
        generate(10, 10, "C", -65536, 65535);
        generate(1, 10, "X", -65536, 65535);
        generate(11, 10, "Gauss", -65536, 65535);
    }
}
