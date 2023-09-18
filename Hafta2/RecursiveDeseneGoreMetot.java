package Hafta2;

import java.util.Scanner;

public class RecursiveDeseneGoreMetot {

    public static void islemYap(int sayi, int tempSayi, boolean azalt) {
        System.out.println(tempSayi);

        if (azalt) {
            tempSayi -= 5;
            if (tempSayi <= 0) {
                islemYap(sayi, tempSayi + 5, false);
            } else {
                islemYap(sayi, tempSayi, true);
            }
        } else {
            tempSayi += 5;
            if (tempSayi <= sayi) {
                islemYap(sayi, tempSayi, false);
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Lütfen bir sayı giriniz: ");
        int sayi = input.nextInt();

        if (sayi <= 0) {
            System.out.println("Hatalı giriş yaptınız");
        } else {
            islemYap(sayi, sayi, true);
        }
    }
}