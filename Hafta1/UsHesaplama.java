package Hafta1;

import java.util.Scanner;

public class UsHesaplama {
    public static void main(String[] args) {
        int n, k, total = 1;

        Scanner input = new Scanner(System.in);
        System.out.print("Lütfen üssü alınacak sayıyı giriniz: ");
        n = input.nextInt();

        System.out.print("Lütfen üs olacak sayıyı giriniz: ");
        k = input.nextInt();

        for (int i = 1; i <= k; i++) {
            total *= n;
        }
        System.out.print("Sonuç: " + total);
    }
}
