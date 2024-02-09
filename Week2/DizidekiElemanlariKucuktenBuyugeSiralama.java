package Hafta2;

import java.util.Arrays;
import java.util.Scanner;

public class DizidekiElemanlariKucuktenBuyugeSiralama {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Kullanıcıdan dizinin index sayısını alıyoruz
        System.out.print("Sayı giriniz: ");
        int index = input.nextInt();

        // Diziyi oluşturuyoruz
        int[] liste = new int[index];

        // Kullanıcının kaç sayı gireceğini bilmediğimizden döngü oluşturuyoruz
        for (int i = 0; i < index; i++) {
        // Kullanıcıdan tek tek sayıları alıyoruz
            System.out.print((i + 1) + ". sayıyı giriniz: ");
        // Aldığımız sayıları 0'dan index'e kadar topluyoruz
            liste[i] = input.nextInt();
        }

        // Bütün sayıları Arrays.sort() ile indexin içerisindeki sayıları küçükten büyüğe sıralıyoruz
        Arrays.sort(liste);
        // Arrays.toString() ile sıralamayı ekrana çıkarıyoruz
        System.out.println("Girilen sayıların küçükten büyüğe sıralanmış hali: " + Arrays.toString(liste));
    }
}
