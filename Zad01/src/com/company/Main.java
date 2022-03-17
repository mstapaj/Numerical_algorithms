package com.company;

import java.io.FileWriter;
import java.io.IOException;
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

    static List<Float> getCos(Float a, int prec) {
        boolean znak_cos = true;
        List<Float> lista = new ArrayList<>();
        for (int k = 0; k < prec * 2; k += 2) {
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

    static List<Float> getCos_prev(Float a, int prec) {
        List<Float> lista = new ArrayList<>();
        lista.add(1F);
        for (int k = 0; k < prec * 2; k += 2) {
            lista.add(-1 * (lista.get(lista.size() - 1)) * (potegowanie(a, 2F) / (potegowanie((float) k, 2F) + (3 * k) + 2)));
        }
        return lista;
    }

    static List<Float> getArctan(Float a, int prec) {
        boolean znak_arctg = true;
        List<Float> lista = new ArrayList<>();
        for (int k = 1; k < (prec + 1) * 2; k += 2) {
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

    static List<Float> getArctan_prev(Float a, int prec) {
        List<Float> lista = new ArrayList<>();
        lista.add(a);
        for (int k = 1; k < (prec + 1) * 2; k += 2) {
            lista.add(-1 * ((lista.get(lista.size() - 1)) * ((k * potegowanie(a, 2F)) / (k + 2))));
        }
        return lista;
    }

    static List<Float> obliczanie_taylora(Float a, int prec, int mode) {
        List<Float> lista_cos = getCos(a, prec);
        List<Float> lista_arctg = getArctan(a, prec);
        List<Float> lista_cos_prev = getCos_prev(a, prec);
        List<Float> lista_arctg_prev = getArctan_prev(a, prec);
        float cos_l = 0;
        float arctg_l = 0;
        float cos_p = 0;
        float arctg_p = 0;
        float cos_l_prev = 0;
        float arctg_l_prev = 0;
        float cos_p_prev = 0;
        float arctg_p_prev = 0;
        List<Float> result = new ArrayList<>();
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
        double built_in_func = Math.cos(a) * Math.atan(a);
        if (mode == 0) {
            // Wyświetlanie list
            System.out.println(lista_cos);
            System.out.println(lista_cos_prev);
            System.out.println(lista_arctg);
            System.out.println(lista_arctg_prev);
            // Wyświetlanie dla pojedynczych liczb
            System.out.print("Taylor sumowany od lewej: ");
            System.out.println(cos_l * arctg_l);
            System.out.print("Taylor sumowany od prawej: ");
            System.out.println(cos_p * arctg_p);
            System.out.print("Taylor sumowany od lewej wyliczając elementy z poprzedniego elementu: ");
            System.out.println(cos_l_prev * arctg_l_prev);
            System.out.print("Taylor sumowany od prawej wyliczając elementy z poprzedniego elementu: ");
            System.out.println(cos_p_prev * arctg_p_prev);
            System.out.print("Taylor liczony za pomocą funkcji wbudowanych: ");
            System.out.println(built_in_func);
        } else if (mode == 1) {
            result.add(cos_l * arctg_l);
            result.add(cos_p * arctg_p);
            result.add(cos_l_prev * arctg_l_prev);
            result.add(cos_p_prev * arctg_p_prev);
            result.add((float) built_in_func);
        } else {
            System.out.println("Zły tryb!\n Prawidlowe tryby to 0 do wyświetlania i 1 do zapisu do pliku");
        }
        return result;
    }

    static void zapis_plik_kat(int prec) {
        try {
            FileWriter myWriter = new FileWriter("test.csv");
            myWriter.write("Kat,Taylor_od_lewej,Taylor_od_prawej,Taylor_od_lewej_prev,Taylor_od_prawej_prev,Taylor_z_func_wbudowanych\n");
            for (float i = 0; i < 0.85; i += 0.0000008) {
                myWriter.write(i + "," + obliczanie_taylora(i, prec, 1).get(0) + "," + obliczanie_taylora(i, prec, 1).get(1) + "," + obliczanie_taylora(i, prec, 1).get(2) + "," + obliczanie_taylora(i, prec, 1).get(3) + "," + obliczanie_taylora(i, prec, 1).get(4) + "\n");
                System.out.println(i);
            }
            myWriter.close();
        } catch (IOException err) {
            err.printStackTrace();
        }
    }

    static void zapis_plik_precyzja(float kat) {
        try {
            FileWriter myWriter = new FileWriter("test2.csv");
            myWriter.write("Precyzja,Taylor_od_lewej,Taylor_od_prawej,Taylor_od_lewej_prev,Taylor_od_prawej_prev,Taylor_z_func_wbudowanych\n");
            for (int i = 0; i < 20; i += 1) {
                myWriter.write(i + "," + obliczanie_taylora(kat, i, 1).get(0) + "," + obliczanie_taylora(kat, i, 1).get(1) + "," + obliczanie_taylora(kat, i, 1).get(2) + "," + obliczanie_taylora(kat, i, 1).get(3) + "," + obliczanie_taylora(kat, i, 1).get(4) + "\n");
                System.out.println(i);
            }
            myWriter.close();
        } catch (IOException err) {
            err.printStackTrace();
        }
    }


    public static void main(String[] args) {
//        obliczanie_taylora(0.8F, 3, 0);
        zapis_plik_kat(50);
//        zapis_plik_precyzja(0.8F);
    }
}
