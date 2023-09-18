package Hafta2;

import java.util.Scanner;

public class RecursiveileUsBulma {
    static int usHesap(int taban, int us) {
        if (taban == 0 || us == 0) {
            return 1;
        } else {
            return taban * usHesap(taban, us - 1);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Lütfen üssü alınacak sayıyı giriniz: ");
        int n = scan.nextInt();
        System.out.print("Lütfen üs olacak sayıyı giriniz: ");
        int k = scan.nextInt();
        System.out.println(n + " üssü " + k + " = " + usHesap(n, k));
    }
}
