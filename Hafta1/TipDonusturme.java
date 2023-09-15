package Hafta1;

import java.util.Scanner;

public class TipDonusturme {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Lütfen tam sayı giriniz:");
        int a = input.nextInt();

        System.out.print("Lütfen ondalıklı sayı giriniz(lütfen nokta yerine virgül kullanınız!): ");
        double b = input.nextDouble();
        int c = (int) b;
        double d = a;

        System.out.println("Verdiğiniz tam sayının ondalıklı sayı hali: " + d);
        System.out.println("Verdiğiniz ondalıklı sayının tam sayı hali: " + c);
    }
}