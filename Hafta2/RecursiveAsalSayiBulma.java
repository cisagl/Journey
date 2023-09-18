package Hafta2;

import java.util.Scanner;

public class RecursiveAsalSayiBulma {
    static boolean asalSayi(int sayi1, int sayi2) {
        if (sayi2 >= sayi1)
            return true;
        if (sayi1%sayi2 == 0)
            return false;
        return asalSayi(sayi1, sayi2 + 1);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Bir sayı giriniz: ");
        int n = scan.nextInt();

        if ( n <= 1){
            System.out.println(n + " asal bir sayı değildir");
        } else if (asalSayi(n, 2)){
            System.out.println(n + " asal bir sayıdır");
        } else {
            System.out.println(n + " asal bir sayı değildir");
        }
    }
}