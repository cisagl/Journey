package Hafta2;

import java.util.Arrays;

public class DizidekiTekrarlananElemanlar {
    public static void main(String[] args) {

        int[] liste = {4, 4, 8, 8, 16, 16, 3, 7, 5, 7, 7, 7, 9, 80, 76, 76, 35};
        System.out.println(Arrays.toString(liste));

        for (int i = 0; i < liste.length; i++) {
            int sayac = 0;


            if (liste[i] != -1) {
                for (int j = 0; j < liste.length; j++) {
                    if (liste[i] == liste[j]) {
                        sayac++;

                        if (i != j) {
                            liste[j] = -1;
                        }
                    }
                }
                if (sayac >= 2) {
                    System.out.println(liste[i] + " sayısı " + sayac + " kere tekrar edilmiştir.");
                }
            }
        }
    }
}
