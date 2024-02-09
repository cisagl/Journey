package Hafta1;

import java.util.Scanner;

public class FibonacciSerisi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Lütfen sayı giriniz: ");
        int sayi = input.nextInt();

        int fib1 = 0;
        int fib2 = 1;

        System.out.print(fib1 + ", " + fib2);

        for (int i = 2; i < sayi; i++){
            int sonrakiFib = fib1 + fib2;
            System.out.print(", " + sonrakiFib);
            fib1 = fib2;
            fib2 = sonrakiFib;
        }
    }
}
