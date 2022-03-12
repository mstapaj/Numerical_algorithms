package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static double potegowanie(double a, double b) {
        double result = a;
        if (b == 0) return 1;
        for (int i = 1; i < b; i++) {
            result = result * a;
        }
        return result;
    }

    static double silnia(double a) {
        double result = 1;
        for (int i = 1; i <= a; i++) {
            result = result * i;
        }
        return result;
    }

    static List<Double> getCos(double a) {
        boolean znak_cos = true;
        List<Double> lista = new ArrayList<>();
        for (int k = 0; k < 10000; k+=2) {
            if (znak_cos) {
                lista.add((potegowanie(a, k) / silnia(k)));
                znak_cos = false;
            } else {
                lista.add(-(potegowanie(a, k) / silnia(k)));
                znak_cos = true;
            }
        }
        return lista;
    }

    static List<Double> getCos_prev(double a) {
        List<Double> lista = new ArrayList<>();
        lista.add((potegowanie(a, 1) / silnia(1)));
        for (int k = 1; k < 10000; k+=2) {
            lista.add(-1*(lista.get(lista.size()-1)*((potegowanie(a,2))/k))*((potegowanie(a,2))/(k+1)));
        }
        return lista;
    }

    static List<Double> getArctan(double a) {
        boolean znak_arctg = true;
        List<Double> lista = new ArrayList<>();
        for (int k = 1; k < 10000; k+=2) {
            if (znak_arctg) {
                lista.add((potegowanie(a, k) / k));
                znak_arctg = false;
            } else {
                lista.add(-(potegowanie(a, k) / k));
                znak_arctg = true;
            }
        }
        return lista;
    }

    static List<Double> getArctan_prev(double a) {
        List<Double> lista = new ArrayList<>();
        lista.add(a);
        for (int k = 1; k < 10000; k+=2) {
//            System.out.println(((k*potegowanie(a,2))/(k+2)));
//            System.out.println(potegowanie(((k*potegowanie(a,2))/(k+2)),2));
//            System.out.println((((k+1)*potegowanie(a,2))/(k+3)));
//            double temp=-1*((lista.get(lista.size()-1))*((k*potegowanie(a,2))/(k+2)));
//            System.out.println(temp*(((3)*potegowanie(a,2))/(5)));
//            System.out.println(k);
            lista.add(-1*((lista.get(lista.size()-1))*((k*potegowanie(a,2))/(k+2))));
        }
        return lista;
    }

    static void obliczanie_taylora(double a){
        List<Double> lista_cos=getCos(a);
        List<Double> lista_arctg=getArctan(a);
        List<Double> lista_cos_prev=getCos_prev(a);
        List<Double> lista_arctg_prev=getArctan_prev(a);
        double cos_l=0;
        double arctg_l=0;
        double cos_p=0;
        double arctg_p=0;
        double cos_l_prev=0;
        double arctg_l_prev=0;
        for (int i=0;i<lista_cos.size()-1;i++){
            cos_l+=lista_cos.get(i);
            arctg_l+=lista_arctg.get(i);
            cos_l_prev+=lista_cos_prev.get(i);
            arctg_l_prev+=lista_arctg_prev.get(i);
        }
        for (int i=lista_cos.size()-1;i>=0;i--){
            cos_p+=lista_cos.get(i);
            arctg_p+=lista_arctg.get(i);
        }
        System.out.print("Taylor sumowany od lewej: ");
        System.out.println(cos_l*arctg_l);
        System.out.print("Taylor sumowany od prawej: ");
        System.out.println(cos_p*arctg_p);
        System.out.print("Taylor liczony za pomocą funkcji wbudowanych: ");
        System.out.println(Math.cos(a)*Math.atan(a));
        System.out.print("Taylor sumowany od lewej wyliczając elementy z poprzedniego elementu: ");
        System.out.println(cos_l_prev*arctg_l_prev);

        System.out.println(cos_l);
        System.out.println(cos_l_prev);
        System.out.println(Math.cos(a));

        System.out.println(arctg_l);
        System.out.println(arctg_l_prev);
        System.out.println(Math.atan(a));
//        System.out.println(lista_cos);
//        System.out.println(lista_cos_prev);
//
//        System.out.println(lista_arctg);
//        System.out.println(lista_arctg_prev);
    }


    public static void main(String[] args) {
        obliczanie_taylora(0.4);
    }
}


