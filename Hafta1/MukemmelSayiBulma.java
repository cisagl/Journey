package Hafta1;

import java.util.Scanner;

public class MukemmelSayiBulma {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Lütfen bir sayı giriniz: ");
        int sayi = input.nextInt();
        int total = 0;

        for (int i = 1; i <= sayi / 2; i++){
            if (sayi%i==0){
                total += i;
            }
        }
        
        if (total == sayi) {
            System.out.println(sayi + " mükemmel sayıdır");
        } else {
            System.out.println(sayi + " mükemmel sayı değildir");
        }
    }
}
