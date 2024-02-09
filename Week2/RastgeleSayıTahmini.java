package Hafta2;

import java.util.Scanner;

public class RastgeleSayıTahmini {
    public static void main(String[] args) {
        int random = (int) (Math.random() * 101);
        Scanner input = new Scanner(System.in);

        int hak = 4;
        int i = 0;

        while (hak >= i) {

            System.out.println("----------------------------------");
            System.out.print("Bir sayı giriniz: ");
            int sayi = input.nextInt();

            if (sayi == random) {
                System.out.println("Tebrikler bildiniz");
                break;
            }
            if (sayi > random) {
                System.out.println("Daha düşük bir sayı giriniz: ");
            } else  {
                System.out.println("Daha yüksek bir sayı giriniz: ");
            }

            if (hak == 0){
                System.out.println("Bilemediniz!");
            } else {
                System.out.println(hak +" hakkınız kaldı");
            }
            hak--;
        }
    }
}