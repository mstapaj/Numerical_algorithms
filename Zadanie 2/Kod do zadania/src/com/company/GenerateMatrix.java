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
        generate(10, 10, "A10", -65536, 65535);
        generate(10, 10, "B10", -65536, 65535);
        generate(10, 10, "C10", -65536, 65535);
        generate(1, 10, "X10", -65536, 65535);
        generate(11, 10, "Gauss10", -65536, 65535);

        generate(30, 30, "A30", -65536, 65535);
        generate(30, 30, "B30", -65536, 65535);
        generate(30, 30, "C30", -65536, 65535);
        generate(1, 30, "X30", -65536, 65535);
        generate(31, 30, "Gauss30", -65536, 65535);

        generate(50, 50, "A50", -65536, 65535);
        generate(50, 50, "B50", -65536, 65535);
        generate(50, 50, "C50", -65536, 65535);
        generate(1, 50, "X50", -65536, 65535);
        generate(51, 50, "Gauss50", -65536, 65535);

        generate(100, 100, "A100", -65536, 65535);
        generate(100, 100, "B100", -65536, 65535);
        generate(100, 100, "C100", -65536, 65535);
        generate(1, 100, "X100", -65536, 65535);
        generate(101, 100, "Gauss100", -65536, 65535);

        generate(300, 300, "A300", -65536, 65535);
        generate(300, 300, "B300", -65536, 65535);
        generate(300, 300, "C300", -65536, 65535);
        generate(1, 300, "X300", -65536, 65535);
        generate(301, 300, "Gauss300", -65536, 65535);

        generate(500, 500, "A500", -65536, 65535);
        generate(500, 500, "B500", -65536, 65535);
        generate(500, 500, "C500", -65536, 65535);
        generate(1, 500, "X500", -65536, 65535);
        generate(501, 500, "Gauss500", -65536, 65535);
    }
}
