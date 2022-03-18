package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static Float power(Float a, Float b) {
        Float result = a;
        if (b == 0) return 1F;
        for (int i = 1; i < b; i++) {
            result = result * a;
        }
        return result;
    }

    static Float factorial(Float a) {
        float result = 1F;
        for (int i = 1; i <= a; i++) {
            result = result * i;
        }
        return result;
    }

    // Funkcja częściowo zapożyczona z internetu - http://www.java2s.com/example/java-utility-method/epsilon-index-0.html
    static boolean check_precision_of(float a, float b) {
        return (a - b) < 1.0E-6F && (a - b) > 0 - 1.0E-6F;
    }

    static List<Float> getCos(Float a, int prec) {
        boolean sign_cos = true;
        List<Float> list = new ArrayList<>();
        for (int k = 0; k < prec * 2; k += 2) {
            if (sign_cos) {
                list.add((power(a, (float) k) / factorial((float) k)));
                sign_cos = false;
            } else {
                list.add(-(power(a, (float) k) / factorial((float) k)));
                sign_cos = true;
            }
        }
        return list;
    }

    static List<Float> getCos_prev(Float a, int prec) {
        List<Float> list = new ArrayList<>();
        list.add(1F);
        for (int k = 0; k < prec * 2; k += 2) {
            list.add(-1 * (list.get(list.size() - 1)) * (power(a, 2F) / (power((float) k, 2F) + (3 * k) + 2)));
        }
        return list;
    }

    static List<Float> getArctan(Float a, int prec) {
        boolean sign_arctg = true;
        List<Float> list = new ArrayList<>();
        for (int k = 1; k < (prec + 1) * 2; k += 2) {
            if (sign_arctg) {
                list.add((power(a, (float) k) / k));
                sign_arctg = false;
            } else {
                list.add(-(power(a, (float) k) / k));
                sign_arctg = true;
            }
        }
        return list;
    }

    static List<Float> getArctan_prev(Float a, int prec) {
        List<Float> list = new ArrayList<>();
        list.add(a);
        for (int k = 1; k < (prec + 1) * 2; k += 2) {
            list.add(-1 * ((list.get(list.size() - 1)) * ((k * power(a, 2F)) / (k + 2))));
        }
        return list;
    }

    static List<Float> taylor_series(Float a, int prec, int mode) {
        List<Float> list_cos = getCos(a, prec);
        List<Float> list_arctg = getArctan(a, prec);
        List<Float> list_cos_prev = getCos_prev(a, prec);
        List<Float> list_arctg_prev = getArctan_prev(a, prec);
        float cos_l = 0;
        float arctg_l = 0;
        float cos_p = 0;
        float arctg_p = 0;
        float cos_l_prev = 0;
        float arctg_l_prev = 0;
        float cos_p_prev = 0;
        float arctg_p_prev = 0;
        List<Float> result = new ArrayList<>();
        for (int i = 0; i < list_cos.size() - 1; i++) {
            cos_l += list_cos.get(i);
            arctg_l += list_arctg.get(i);
            cos_l_prev += list_cos_prev.get(i);
            arctg_l_prev += list_arctg_prev.get(i);
        }
        for (int i = list_cos.size() - 1; i >= 0; i--) {
            cos_p += list_cos.get(i);
            arctg_p += list_arctg.get(i);
            cos_p_prev += list_cos_prev.get(i);
            arctg_p_prev += list_arctg_prev.get(i);
        }
        double built_in_func = Math.cos(a) * Math.atan(a);
        if (mode == 0) {
            // Wyświetlanie list
            System.out.println(list_cos);
            System.out.println(list_cos_prev);
            System.out.println(list_arctg);
            System.out.println(list_arctg_prev);
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

    static void save_to_file_by_angle(int prec) {
        try {
            FileWriter myWriter = new FileWriter("test.csv");
            myWriter.write("Kat,Taylor_od_lewej,Taylor_od_prawej,Taylor_od_lewej_prev,Taylor_od_prawej_prev,Taylor_z_func_wbudowanych\n");
            for (float i = 0; i < 0.85; i += 0.0000008) {
                List<Float> list = taylor_series(i, prec, 1);
                myWriter.write(i + "," + list.get(0) + "," + list.get(1) + "," + list.get(2) + "," + list.get(3) + "," + list.get(4) + "\n");
                System.out.println(i);
            }
            myWriter.close();
        } catch (IOException err) {
            err.printStackTrace();
        }
    }

    static void save_to_file_by_precision(float angle) {
        try {
            FileWriter myWriter = new FileWriter("test2.csv");
            myWriter.write("Precyzja,Taylor_od_lewej,Taylor_od_prawej,Taylor_od_lewej_prev,Taylor_od_prawej_prev,Taylor_z_func_wbudowanych\n");
            for (int i = 0; i < 20; i += 1) {
                List<Float> list = taylor_series(angle, i, 1);
                myWriter.write(i + "," + list.get(0) + "," + list.get(1) + "," + list.get(2) + "," + list.get(3) + "," + list.get(4) + "\n");
                System.out.println(i);
            }
            myWriter.close();
        } catch (IOException err) {
            err.printStackTrace();
        }
    }

    static void save_to_file_how_many_elem() {
        try {
            FileWriter myWriter = new FileWriter("test3.csv");
            myWriter.write("Kat,Taylor_od_lewej,Taylor_od_prawej,Taylor_od_lewej_prev,Taylor_od_prawej_prev\n");
            int[] list = new int[4];
            for (float i = 0; i < 0.85; i += 0.0000008) {
                list[0] = 0;
                list[1] = 0;
                list[2] = 0;
                list[3] = 0;
                for (int j = 1; true; j += 1) {
                    List<Float> results = taylor_series(i, j, 1);
                    if (list[0] == 0 && check_precision_of(results.get(0), results.get(4))) {
                        list[0] = j;
                    }
                    if (list[1] == 0 && check_precision_of(results.get(1), results.get(4))) {
                        list[1] = j;
                    }
                    if (list[2] == 0 && check_precision_of(results.get(2), results.get(4))) {
                        list[2] = j;
                    }
                    if (list[3] == 0 && check_precision_of(results.get(3), results.get(4))) {
                        list[3] = j;
                    }
                    if (list[0] != 0 && list[1] != 0 && list[2] != 0 && list[3] != 0) {
                        myWriter.write(i + "," + list[0] + "," + list[1] + "," + list[2] + "," + list[3] + "\n");
                        System.out.println(i);
                        break;
                    }
                }
            }
            myWriter.close();
        } catch (IOException err) {
            err.printStackTrace();
        }
    }


    public static void main(String[] args) {
        taylor_series(0.2F, 3, 0);
        save_to_file_by_angle(50);
        save_to_file_by_precision(0.8F);
        save_to_file_how_many_elem();
    }
}
