package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static Float potegowanie(Float a, Float b) {
        Float result = a;
        if (b == 0) return 1F;
        for (int i = 1; i < b; i++) {
            result = result * a;
        }
        return result;
    }

    static Float silnia(Float a) {
        float result = 1F;
        for (int i = 1; i <= a; i++) {
            result = result * i;
        }
        return result;
    }

    static List<Float> getCos(Float a) {
        boolean znak_cos = true;
        List<Float> lista = new ArrayList<>();
        for (int k = 0; k < 100; k += 2) {
            if (znak_cos) {
                lista.add((potegowanie(a, (float) k) / silnia((float) k)));
                znak_cos = false;
            } else {
                lista.add(-(potegowanie(a, (float) k) / silnia((float) k)));
                znak_cos = true;
            }
        }
        return lista;
    }

    static List<Float> getCos_prev(Float a) {
        List<Float> lista = new ArrayList<>();
        lista.add((potegowanie(a, (float) 0) / silnia((float) 0)));
        for (int k = 0; k < 100; k += 2) {
            lista.add(-1 * (lista.get(lista.size() - 1)) * (potegowanie(a, 2F) / (potegowanie((float) k, 2F) + (3 * k) + 2)));
        }
        return lista;
    }

    static List<Float> getArctan(Float a) {
        boolean znak_arctg = true;
        List<Float> lista = new ArrayList<>();
        for (int k = 1; k < 101; k += 2) {
            if (znak_arctg) {
                lista.add((potegowanie(a, (float) k) / k));
                znak_arctg = false;
            } else {
                lista.add(-(potegowanie(a, (float) k) / k));
                znak_arctg = true;
            }
        }
        return lista;
    }

    static List<Float> getArctan_prev(Float a) {
        List<Float> lista = new ArrayList<>();
        lista.add(a);
        for (int k = 1; k < 101; k += 2) {
            lista.add(-1 * ((lista.get(lista.size() - 1)) * ((k * potegowanie(a, 2F)) / (k + 2))));
        }
        return lista;
    }

    static List<Float> obliczanie_taylora(Float a) {
        List<Float> lista_cos = getCos(a);
        List<Float> lista_arctg = getArctan(a);
        List<Float> lista_cos_prev = getCos_prev(a);
        List<Float> lista_arctg_prev = getArctan_prev(a);
        float cos_l = 0;
        float arctg_l = 0;
        float cos_p = 0;
        float arctg_p = 0;
        float cos_l_prev = 0;
        float arctg_l_prev = 0;
        float cos_p_prev = 0;
        float arctg_p_prev = 0;
        for (int i = 0; i < lista_cos.size() - 1; i++) {
            cos_l += lista_cos.get(i);
            arctg_l += lista_arctg.get(i);
            cos_l_prev += lista_cos_prev.get(i);
            arctg_l_prev += lista_arctg_prev.get(i);
        }
        for (int i = lista_cos.size() - 1; i >= 0; i--) {
            cos_p += lista_cos.get(i);
            arctg_p += lista_arctg.get(i);
            cos_p_prev += lista_cos_prev.get(i);
            arctg_p_prev += lista_arctg_prev.get(i);
        }
//        System.out.println(lista_cos);
//        System.out.print("Taylor sumowany od lewej: ");
//        System.out.println(cos_l * arctg_l);
//        System.out.print("Taylor sumowany od prawej: ");
//        System.out.println(cos_p * arctg_p);
//        System.out.print("Taylor sumowany od lewej wyliczając elementy z poprzedniego elementu: ");
//        System.out.println(cos_l_prev * arctg_l_prev);
//        System.out.print("Taylor sumowany od prawej wyliczając elementy z poprzedniego elementu: ");
//        System.out.println(cos_p_prev * arctg_p_prev);
//        System.out.print("Taylor liczony za pomocą funkcji wbudowanych: ");
//        System.out.println(Math.cos(a) * Math.atan(a));
        List<Float> result = new ArrayList<>();
        result.add(cos_l * arctg_l);
        result.add(cos_p * arctg_p);
        result.add(cos_l_prev * arctg_l_prev);
        result.add(cos_p_prev * arctg_p_prev);
        result.add((float) (Math.cos(a) * Math.atan(a)));
        return result;
//        return Arrays.asList(cos_l * arctg_l, cos_p * arctg_p, cos_l_prev * arctg_l_prev, cos_p_prev * arctg_p_prev, Math.cos(a) * Math.atan(a));
//        return Arrays.asList(cos_l, cos_p, cos_l_prev, cos_p_prev, Math.cos(a));
//        return Arrays.asList(arctg_l, arctg_p, arctg_l_prev, arctg_p_prev, Math.atan(a));
    }


    public static void main(String[] args) {
//        obliczanie_taylora(0.5F);
        try {
            FileWriter myWriter = new FileWriter("test.csv");
            myWriter.write("Kat,Taylor_od_lewej,Taylor_od_prawej,Taylor_od_lewej_prev,Taylor_od_prawej_prev,Taylor_z_func_wbudowanych\n");
            for (float i = -0.8F; i < 0.8; i += 0.000001) {
                myWriter.write(i + "," + obliczanie_taylora(i).get(0) + "," + obliczanie_taylora(i).get(1) + "," + obliczanie_taylora(i).get(2) + "," + obliczanie_taylora(i).get(3) + "," + obliczanie_taylora(i).get(4) + "\n");
                System.out.println(i);
            }
            myWriter.close();
        } catch (IOException err) {
            err.printStackTrace();
        }
    }
}
