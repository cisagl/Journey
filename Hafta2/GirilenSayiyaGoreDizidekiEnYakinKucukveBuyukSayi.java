package Hafta2;

import java.util.Scanner;

public class GirilenSayiyaGoreDizidekiEnYakinKucukveBuyukSayi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] list = {56, 34, 1, 8, 101, -2, -33};
        System.out.print("Sayı giriniz: ");
        int sayi =input.nextInt();

        int min = list[0];
        for (int i : list) {
            if (i < min) {
                min = i;
            }
        }

        int max = list[0];
        for (int i : list) {
            if (i > max) {
                max = i;
            }
        }

        int kucukYakin = min;
        for (int i : list) {
            if (i < sayi && i > kucukYakin) {
                kucukYakin = i;
            }
        }

        int buyukYakin = max;
        for (int i : list) {
            if (i > sayi && i < buyukYakin) {
                buyukYakin = i;
            }
        }

        System.out.println("Girilen sayıdan küçük en yakın sayı: " + kucukYakin);
        System.out.println("Girilen sayıdan büyük en yakın sayı: " + buyukYakin);
    }
}
