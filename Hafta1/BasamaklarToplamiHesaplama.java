package Hafta1;

import java.util.Scanner;

public class BasamaklarToplamiHesaplama {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Lütfen Sayı giriniz: ");

        int num = input.nextInt();
        int adet = 0,toplam=0;

        while(num != 0)
        {
            toplam=(num%10)+toplam;
            num /= 10;
            ++adet;
        }

        System.out.println("Basamak Toplamı: " + toplam);
    }
}
