package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Random;

public class GenerateMatrix {

    public static void generate(int cols, int rows) {
        try {
            FileWriter myWriterFraction = new FileWriter("fractionMatrix.txt");
            FileWriter myWriterDouble = new FileWriter("doubleMatrix.txt");
            FileWriter myWriterFloat = new FileWriter("floatMatrix.txt");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    Random ran = new Random();
                    BigInteger num = BigInteger.valueOf(ran.nextInt());
                    BigInteger denum = BigInteger.valueOf(ran.nextInt());
                    myWriterFloat.write((int) num.floatValue() / denum.floatValue() + ",");
                    myWriterDouble.write(num.doubleValue() / denum.doubleValue() + ",");
                    myWriterFraction.write(num + ";" + denum + ",");
                }
                myWriterFloat.write("endline,\n");
                myWriterDouble.write("endline,\n");
                myWriterFraction.write("endline,\n");
            }
//            myWriterFloat.write("/");
//            myWriterDouble.write("/");
//            myWriterFraction.write("/");
            myWriterFloat.close();
            myWriterDouble.close();
            myWriterFraction.close();
        } catch (IOException err) {
            err.printStackTrace();
        }
    }


    public static void main(String[] args) {
        generate(3, 3);
    }
}
