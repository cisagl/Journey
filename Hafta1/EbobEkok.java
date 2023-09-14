package Hafta1;

import java.util.Scanner;

public class EbobEkok {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Bir sayı giriniz: ");
        int a = input.nextInt();

        System.out.print("Bir sayı giriniz: ");
        int b = input.nextInt();

        int ebob = 1;
        int ekok;
        int i = 1;
        while (i <= a && i <= b) {
            if (a % i == 0 && b % i == 0) {

                ebob = i;
            }
            i++;
        }

        ekok = (a * b) / ebob;

        System.out.println(ebob);
        System.out.println(ekok);
    }
}