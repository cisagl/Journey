package Hafta1;

import java.awt.*;
import java.util.Scanner;

public class EnBuyukveEnKucukSayiBulma {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Kaç tane sayı gireceksiniz?: ");
        int n = input.nextInt();

        int maxSayi = Integer.MIN_VALUE;
        int minSayi = Integer.MAX_VALUE;

        if (n <= 0){
            System.out.println("Hatalı bir tuşlama yaptınız, lütfen tekrar deneyiniz");
            return;
        }

        for (int i = 1; i <= n; i++){
            System.out.print(i + ". sayıyı giriniz: ");
            int a = input.nextInt();

            if (a < minSayi){
                minSayi = a;
            }
            if (a > maxSayi){
                maxSayi = a;
            }
        }

        System.out.println("En büyük sayı: " + maxSayi);
        System.out.println("En küçük sayı: " + minSayi);
    }
}
