package Hafta2;

import java.util.Arrays;
import java.util.Scanner;

public class DizidekiElemanlariKucuktenBuyugeSiralama {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Sayı giriniz: ");
        int a = input.nextInt();

        int[] liste = new int[a];

        for (int i = 0; i < a; i++) {
            System.out.print((i + 1) + ". sayıyı giriniz: ");
            liste[i] = input.nextInt();
        }

        Arrays.sort(liste);
        System.out.println("Girilen sayıların küçükten büyüğe sıralanmış hali: " + Arrays.toString(liste));
    }
}
