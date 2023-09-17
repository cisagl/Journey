package Hafta2;

import java.util.Scanner;

public class PolindromSayi {

    static boolean isPolindrom(int sayi) {
        int geciciSayi = sayi, tersSayi = 0, sonBasamak;
        while (geciciSayi != 0) {
            sonBasamak = geciciSayi % 10;
            tersSayi = (tersSayi * 10) + sonBasamak;
            geciciSayi /= 10;
        }
        return sayi == tersSayi;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Lütfen Polindrom olup olmadığını kontrol etmek istediğiniz sayıyı giriniz: ");
        int x = input.nextInt();

        boolean sonuc = isPolindrom(x);

        if (sonuc)
            System.out.println(x + " Polindrom bir sayıdır.");
        else
            System.out.println(x + " Polindrom bir sayı değildir.");
    }
}
