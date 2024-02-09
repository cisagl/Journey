package Hafta1;

import java.util.Scanner;

public class UsHesaplama {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Lütfen üssü alınacak sayıyı giriniz:");
        int a = input.nextInt();

        System.out.print("Lütfen üs olacak sayıyı giriniz:");
        int b = input.nextInt();
//Her çarpmada elde edeceğimiz sonucu bir değişkene atayalım
        int usCarpimi = 1;
//Döngü oluşturarak üs olacak sayı kadar dönmesini sağlayalım
        for (int j = 1; j <= b; j++) {
//Kullanıcıdan aldığımız üssü alınacak sayıyı, değişken ile çarpalım
            usCarpimi *= a;
        }
        System.out.println(usCarpimi);
    }
}