package Hafta1;

import java.util.Scanner;

public class AritmetikIslemveIslemOnceligi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Lütfen 1. sayıyı giriniz:");
        int sayi1 = input.nextInt();

        System.out.print("Lütfen bir sayı giriniz:");
        int sayi2 = input.nextInt();

        System.out.print("Lütfen bir sayı giriniz:");
        int sayi3 = input.nextInt();

        int sonuc = sayi1+sayi2*sayi3-sayi2;

        System.out.println("Verdiğiniz sayılar ile yapılan işlem: 1. Sayı + 2. Sayı * 3. Sayı - 2. Sayı");
        System.out.println("Sonuç: " + sonuc);
    }
}